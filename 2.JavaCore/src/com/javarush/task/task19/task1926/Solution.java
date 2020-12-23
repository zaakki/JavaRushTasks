package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        fileName = reader.readLine();
//        fileName = "G:\\User\\zaki\\DownLoad\\Testdoc.txt";
        reader.close();
        BufferedReader fr = new BufferedReader(new FileReader(fileName));
        String line = "";

        while (fr.ready()){
            line = fr.readLine();
            StringBuilder sb = new StringBuilder();
            sb.append(line);
            System.out.println(sb.reverse());
        }
        fr.close();
        //sb = sb.reverse();

    }
}
