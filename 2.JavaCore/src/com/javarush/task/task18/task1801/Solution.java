package com.javarush.task.task18.task1801;

/* 
Максимальный байт
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        FileInputStream inputStream = new FileInputStream(s);
        int maxByte = Integer.MIN_VALUE;
        while (inputStream.available() > 0){
            int data = inputStream.read();
            if(data > maxByte)
                maxByte=data;
        }
        inputStream.close();
        System.out.println(maxByte);
    }
}
