package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        //System.out.println(string);
        String[] s = string.split("\\b");
        String f = "";
       for(int i = 0; i < s.length; i++){
           String tmp1 = s[i].substring(0, 1).toUpperCase();
           String tmp2 = s[i].substring(1, s[i].length());
           s[i] = tmp1 + tmp2;
           f = f + s[i] + " ";
       }
       string = f;
       System.out.println(string);
       

        //напишите тут ваш код
    }
}
