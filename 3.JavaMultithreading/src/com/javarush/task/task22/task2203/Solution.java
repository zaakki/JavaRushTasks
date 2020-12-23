package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if(string == null)
            throw new TooShortStringException();
        else {
            char[] chars = string.toCharArray();
            int count = 0;
            for (int i = 0; i < chars.length ; i++) {
                if(chars[i] == '\t')
                    count++;
            }
            if(count < 2)
                throw new TooShortStringException();
            else {
                StringBuilder sb = new StringBuilder();
                String[] str = string.split("\t");
                sb.append(str[1]);
                String resString = sb.toString();
                return resString;
            }

        }

    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
