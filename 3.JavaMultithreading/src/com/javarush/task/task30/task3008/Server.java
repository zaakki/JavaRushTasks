package com.javarush.task.task30.task3008;
//основной класс сервера.

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class Server {
    private static  Map<String, Connection> connectionMap = new ConcurrentHashMap<>();


    public static void sendBroadcastMessage(Message message){
        for (ConcurrentHashMap.Entry<String, Connection> conMap : connectionMap.entrySet()
             ) {
            try{
                conMap.getValue().send(message);
            } catch (IOException e) {
                System.out.println("Cannot send message");
            }
        }
    }


    public static void main(String[] args) throws IOException {
        int port = ConsoleHelper.readInt();
        ServerSocket ss = null;
        try {
            ss = new ServerSocket(port);
            System.out.println("Server has started");
            Socket socket = null;
            while (true) {
                try {

                    socket = ss.accept();
                    Handler handler = new Handler(socket);
                    handler.start();

                } catch (IOException e) {
                    socket.close();
                    ss.close();
                    System.out.println(e.getMessage());
                    break;
                }
            }

        } catch (IOException e){
            ss.close();
        }

    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {

            connection.send(new Message(MessageType.NAME_REQUEST));
            Message answer = connection.receive();

           if((answer.getType() != MessageType.USER_NAME) || answer.getData().isEmpty() || connectionMap.containsKey(answer.getData())) {
               return serverHandshake(connection);
           } else {
               connection.send(new Message(MessageType.NAME_ACCEPTED));
               connectionMap.put(answer.getData(), connection);
               return answer.getData();
           }

        }

        private void notifyUsers(Connection connection, String userName) throws IOException{
            for (ConcurrentHashMap.Entry<String, Connection> conMap: connectionMap.entrySet()
                 ) {
                Message message = new Message(MessageType.USER_ADDED, conMap.getKey());
                if(!conMap.getKey().equals(userName)){
                    connection.send(message);
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT) {
                    Message newMessage = new Message(MessageType.TEXT, userName + ": " + message.getData());
                    sendBroadcastMessage(newMessage);
                } else {
                    ConsoleHelper.writeMessage("Error text format");
                }

            }
        }

        @Override
        public void run() {
            try {
                System.out.println(socket.getRemoteSocketAddress());
                Connection connection = new Connection(socket);
               String userName = serverHandshake(connection);
               sendBroadcastMessage(new Message(MessageType.USER_ADDED,userName));
               notifyUsers(connection,userName);
               serverMainLoop(connection,userName);
               connectionMap.keySet().remove(userName);
               sendBroadcastMessage(new Message(MessageType.USER_REMOVED,userName));
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом.");
            } catch (ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом.");
            }


        }
    }
}
