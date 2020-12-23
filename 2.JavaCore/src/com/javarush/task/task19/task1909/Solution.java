package com.javarush.task.task19.task1909;

/* 
Замена знаков
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
        String text;
        while (br.ready()){
            text = br.readLine().replaceAll("\\.","!");
            bw.write(text + "\n");
        }
        bw.close();
        br.close();
    }
}
