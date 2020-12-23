package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputFileName = reader.readLine();
        String outputFileName = reader.readLine();
        reader.close();
        FileReader inputFile = new FileReader(inputFileName);
        FileWriter outputFile = new FileWriter(outputFileName);
        while (inputFile.ready()){
            int data = inputFile.read();
            int writeData = inputFile.read();
            outputFile.write(writeData);
        }
        inputFile.close();
        outputFile.close();
    }
}
