package com.javarush.task.task19.task1908;

/* 
Выделяем числа
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
        String[] text = new String[1024];
        BufferedWriter bw = new BufferedWriter(new FileWriter(outputFileName));
        while (br.ready()){
            text = br.readLine().split(" ");

            for (int i = 0; i < text.length ; i++) {
                if(text[i].matches("\\b\\d+\\b"))
                    //System.out.print(text[i] + " ");
                    bw.write(text[i]+" ");
            }

        }
        bw.close();
        br.close();
    }
}
