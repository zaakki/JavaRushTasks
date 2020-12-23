package com.javarush.task.task18.task1802;

/* 
Минимальный байт
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        int min = Integer.MAX_VALUE;
        FileInputStream file = new FileInputStream(s);
        while (file.available() > 0){
            int data = file.read();
            if(data < min)
                min = data;
        }
        file.close();
        reader.close();
        System.out.println(min);
    }
}
