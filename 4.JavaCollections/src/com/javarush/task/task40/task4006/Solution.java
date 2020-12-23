package com.javarush.task.task40.task4006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URL;

/* 
Отправка GET-запроса через сокет
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        getSite(new URL("http://javarush.ru/social.html"));
    }

    public static void getSite(URL url) {
        try {
            Socket connect  = new Socket(url.getHost(), url.getDefaultPort());

            String request = "GET " + url.getFile() + " HTTP/1.1\r\n";
            request += "Host: " + url.getHost() + "\r\n\r\n";
            OutputStream os = connect.getOutputStream();
            os.write(request.getBytes());
            os.flush();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connect.getInputStream()));
            String responseLine;

            while ((responseLine = bufferedReader.readLine()) != null) {
                System.out.println(responseLine);
            }
            bufferedReader.close();
            os.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}