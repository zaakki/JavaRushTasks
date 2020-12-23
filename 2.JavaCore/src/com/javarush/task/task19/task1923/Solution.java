package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        String inputFileName = args[0];
        String outputFileName = args[1];
        BufferedReader br = new BufferedReader(new FileReader(inputFileName));
        BufferedWriter bw = new BufferedWriter(new FileWriter(outputFileName));
        String line = "";
        while (br.ready()){
            line = br.readLine();
            String[] splitLine = line.split(" ");
            Pattern p;
            Matcher m;
            p = Pattern.compile("\\d");
            for (String s :splitLine
                 ) {
                m = p.matcher(s);
                if(m.find()){
                    bw.write(s +" ");
                }
            }
        }
        br.close();
        bw.close();
    }
}
