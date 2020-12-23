package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        if(string == null){
            throw new TooShortStringException();
        }
        else {
            char[] str = string.toCharArray();
            int count = 0;
            int endString = 0;
            for (int i = 0; i < str.length; i++) {
                if (str[i] == ' ') {
                    count++;

                }
            }
            if (count < 4)
                throw new TooShortStringException();
            else{
                StringBuilder sb = new StringBuilder();
                String[] strings = string.split(" ");
                sb.append(strings[1]).append(" ").append(strings[2]).append(" ").append(strings[3]).append(" ").
                append(strings[4]);
                String resString = String.valueOf(sb);


            return resString;
            }
        }
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
