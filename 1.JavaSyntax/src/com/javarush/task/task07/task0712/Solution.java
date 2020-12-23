package com.javarush.task.task07.task0712;
import java.io.*;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        for(int i = 0; i < 10; i++)
            list.add(i, reader.readLine());
        for (int i = 0; i < 10; i++) {
            if (max >= list.get(i).length()) {
                max = list.get(i).length();
            }
        }
        for(int i = 0; i < 10; i++){
            if (min <= list.get(i).length()) {
                min = list.get(i).length();
            }
        }
        for (int i = 0; i < 10; i++) {
            if (list.get(i).length() == max || list.get(i).length() == min) {
                System.out.println(list.get(i));
                break;
            } 
        }    
    }
}
