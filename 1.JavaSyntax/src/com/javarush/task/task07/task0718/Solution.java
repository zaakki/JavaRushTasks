package com.javarush.task.task07.task0718;
import java.io.*;
import java.util.ArrayList;
import java.io.IOException;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
          BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < 10; i++)
            list.add(i, reader.readLine());
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).length() <= list.get(i + 1).length()) {
            } else {
                count = list.indexOf(list.get(i+1));
                System.out.println(count);
                break;
            }
        }
       
    }
}

