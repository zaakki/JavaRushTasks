package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputFileName;
        String outputFileName;
        inputFileName = reader.readLine();
        outputFileName = reader.readLine();
        reader.close();
//        inputFileName = "G:\\User\\zaki\\DownLoad\\Testdoc.txt";
//        outputFileName = "G:\\User\\zaki\\DownLoad\\Testdoc21.txt";
        BufferedReader br = new BufferedReader(new FileReader(inputFileName));
        BufferedWriter bw = new BufferedWriter(new FileWriter(outputFileName));
        String text = "";
        while (br.ready()){
            text = text +br.readLine().replaceAll("\\p{Punct}","");
        }
//        System.out.println(text);
        bw.write(text);
        bw.close();
        br.close();
    }
}
