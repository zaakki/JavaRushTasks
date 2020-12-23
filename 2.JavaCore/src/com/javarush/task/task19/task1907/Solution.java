package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String[] text = new String[1024];
        int count = 0;
        while (br.ready()){
          text = br.readLine().split("[\\W0-9]");
            for (int i = 0; i <text.length ; i++) {
                if (text[i].equals("world"))
                    count++;
            }
        }
        br.close();


        System.out.println(count);
    }
}
