package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String outFileName = reader.readLine();
        String inFileName1 = reader.readLine();
        String inFileName2 = reader.readLine();
        reader.close();
        FileOutputStream outFile = new FileOutputStream(outFileName,true);
        FileInputStream inFile1 = new FileInputStream(inFileName1);
        FileInputStream inFile2 = new FileInputStream(inFileName2);

        while (inFile1.available() > 0){
            outFile.write(inFile1.read());
        }
        while (inFile2.available() > 0){
            outFile.write(inFile2.read());
        }
        outFile.flush();
        outFile.close();
        inFile1.close();
        inFile2.close();

    }
}
