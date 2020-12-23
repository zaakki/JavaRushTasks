package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();

        reader.close();

        FileInputStream file1 = new FileInputStream(fileName1);
        FileInputStream file2 = new FileInputStream(fileName2);

        byte[] buff = new byte[file1.available()];
        while (file1.available() > 0){
            file1.read(buff);
        }
        FileOutputStream outFile = new FileOutputStream(fileName1);
        while (file2.available() > 0){
            outFile.write(file2.read());
        }
        outFile.write(buff);
        outFile.flush();
        file1.close();
        file2.close();
        outFile.close();



    }
}
