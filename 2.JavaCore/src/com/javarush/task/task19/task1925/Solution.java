package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String inputFileName = args[0];
        String outputFileName = args[1];
        String line = "";
        BufferedReader fr = new BufferedReader(new FileReader(inputFileName));
        BufferedWriter fw = new BufferedWriter(new FileWriter(outputFileName));
        String newLine = "";
        while (fr.ready()){
            line  = fr.readLine();
            String[] splitLine = line.split(" ");
            for (String str : splitLine
                 ) {
                if(str.length() > 6){
                    newLine = newLine + str + ",";
                }

            }
        }
        String str = "";
        str = newLine.substring(0,newLine.lastIndexOf(','));
        fw.write(str);
        fr.close();
        fw.close();

    }
}
