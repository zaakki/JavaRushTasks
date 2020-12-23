package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("file");
        words.add("view");
        words.add("V");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        fileName = reader.readLine();
//        fileName = "G:\\User\\zaki\\DownLoad\\Testdoc.txt";
        reader.close();
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        String line = "";

        while ((line = br.readLine()) != null) {
            int count = 0;
            for (String word:words
            ) {
                Pattern p = Pattern.compile("\\b"+word+"\\b");
                Matcher m = p.matcher(line);
                while (m.find()){
                    count++;
                }
            }
            if(count == 2)
                System.out.println(line);
        }
        br.close();
    }
}
