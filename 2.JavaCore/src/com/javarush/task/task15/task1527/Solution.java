package com.javarush.task.task15.task1527;

/* 
Парсер реквестов
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args)throws IOException {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        s = reader.readLine();
        if(s.contains("?")) {
            s = s.substring(s.indexOf("?"));
            s = s.substring(1);
            String[] s2 = s.split("[&]");
            for (int i = 0; i < s2.length; i++) {
                if (s2[i].contains("=")) {
                    s2[i] = s2[i].substring(0, s2[i].indexOf("="));
                }
                System.out.print(s2[i] + " ");
            }
            System.out.println();
            String[] s3 = s.split("[&]");
            for (int i = 0; i < s3.length; i++) {
                if (s3[i].contains("obj")) {
                    s3[i] = s3[i].substring(s3[i].indexOf("=") + 1);
                   // if (s3[i].contains(".")) {
                        try {
                            alert(Double.parseDouble(s3[i]));
                        } catch (Exception e){
                            //e.printStackTrace();
                            alert(s3[i]);
                        }
                   // } else
                       // alert(s3[i]);
                }
            }
        }
    }


    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
