package com.javarush.task.task32.task3208;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/* 
RMI-2
*/
public class Solution {
    public static Registry registry;

    // Pretend we're starting an RMI client as the CLIENT_THREAD thread
    public static Thread CLIENT_THREAD = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                for (String bindingName : registry.list()) {
                    Animal service = (Animal) registry.lookup(bindingName);
                    service.printName();
                    service.speak();
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (NotBoundException e) {
                e.printStackTrace();
            }
        }
    });
//Реализуй логику метода run в SERVER_THREAD. В нем будет имитироваться серверная часть:
//1) Инициализируй поле registry, которое будет принимать и обрабатывать запросы на 2099 порту.
//2) Создай два объекта - Cat и Dog.
//3) Используй класс UnicastRemoteObject, чтобы создать Remote объекты для созданных Cat и Dog.
//Remote объекты будут в состоянии принимать обращения к своим методам используя выбранный порт (2099).
//4) Для Cat и Dog добавь в registry связь уникального текстового ключа и Remote объекта. Текстовый ключ придумай сам.
//5) При возникновении любого исключения выведи его стек-трейс в поток System.err.
//Метод main не участвует в тестировании.
    // Pretend we're starting an RMI server as the SERVER_THREAD thread
    public static Thread SERVER_THREAD = new Thread(new Runnable() {
        @Override
        public void run() {
            //напишите тут ваш код
            Remote stub = null;
            final String BINDING_dog = "server.dog";
            final String BINDING_cat = "server.cat";
            try {
                registry = LocateRegistry.createRegistry(2099);
                final Cat cat = new Cat("Laska");
                final Dog dog = new Dog("Rex");


                Remote stubCat = UnicastRemoteObject.exportObject(cat,0);
                Remote stubDog = UnicastRemoteObject.exportObject(dog,0);
                registry.bind(BINDING_cat,stubCat);
                registry.bind(BINDING_dog, stubDog);
                Thread.sleep(2000);

            } catch (RemoteException | AlreadyBoundException | InterruptedException e) {
               e.printStackTrace(System.err);
            }
        }
    });

    public static void main(String[] args) throws InterruptedException {
        // Starting an RMI server thread
        SERVER_THREAD.start();
        Thread.sleep(1000);
        // Start the client
        CLIENT_THREAD.start();
    }
}