package com.javarush.task.task07.task0708;
import java.io.*;
import java.util.ArrayList;

/* 
Самая длинная строка
*/

public class Solution {
    private static ArrayList<String> strings;

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        strings = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int min = Integer.MIN_VALUE;
        for(int i = 0; i < 5; i++)
            strings.add(i, reader.readLine());
        for(int i = 0; i < 5; i++){
            if(min < strings.get(i).length())
                min = strings.get(i).length();
        }
        for(int i = 0; i < 5; i++){
            if(min == strings.get(i).length())
                System.out.println(strings.get(i));
        }
    }
}
