package com.javarush.task.task13.task1318;

/* 
Чтение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InputStream inputStream = null;
        BufferedInputStream buffer = null;

        inputStream = new FileInputStream(reader.readLine());
        buffer = new BufferedInputStream (inputStream);
        try{
            while (buffer.available() > 0){
                char c = (char) buffer.read();
                System.out.print(c);
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            inputStream.close();
            buffer.close();
            reader.close();
        }
        
    }
}