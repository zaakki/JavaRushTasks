package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        FileInputStream fileName1 = new FileInputStream(file1);
        FileOutputStream fileName2 = new FileOutputStream(file2);
        byte[] buffer = new byte[fileName1.available()];//создаем массив размерностью количества байт первого файла
        while (fileName1.available() > 0){
           fileName1.read(buffer);
            for(int i = buffer.length -1; i >=0; i--) {
                fileName2.write(buffer[i]);
            }
        }
        fileName1.close();
        fileName2.close();

    }
}
