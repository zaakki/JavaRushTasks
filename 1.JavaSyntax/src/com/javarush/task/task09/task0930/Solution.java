package com.javarush.task.task09.task0930;


import java.io.*;
import java.util.*;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) {
                break;
            }
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
         sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        // напишите тут ваш код
        boolean isSort = false;
      
        //String temp;
        while (!isSort){
            isSort = true;
            for(int i = 0; i< array.length-1;i++){
                for (int j = i+1; j<array.length;j++) {
                    if (!isNumber(array[i]) && !isNumber(array[j])) {
                        if (isGreaterThan(array[i], array[j])) {
                            isSort = false;
                            String temp;
                            temp = array[i];
                            array[i] = array[j];
                            array[j] = temp;
                        }

                    } else if (!isNumber(array[i]) && isNumber(array[j])) {
                        while (!isNumber(array[j])) {
                            j++;
                        }
                    }
                     else if (isNumber(array[i]) && isNumber(array[j])) {

                        if (Integer.parseInt(array[i]) < Integer.parseInt(array[j])) {

                            isSort = false;
                            String tmp;
                            tmp = array[i];
                            array[i] = array[j];
                            array[j] = tmp;
                        }

                    } else if (isNumber(array[i]) && !isNumber(array[j])) {

                        while (isNumber(array[j])) {
                            j++;
                        }
                    }
                }
            }
        }
    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) {
            return false;
        }

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // Строка содержит '-'
                    || (!Character.isDigit(c) && c != '-') // или не цифра и не начинается с '-'
                    || (chars.length == 1 && c == '-')) // или одиночный '-'
            {
                return false;
            }
        }
        return true;
    }
}
