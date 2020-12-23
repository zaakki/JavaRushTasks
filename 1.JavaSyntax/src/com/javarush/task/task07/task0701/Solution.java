package com.javarush.task.task07.task0701;

import java.io.IOException;
import java.io.*;

/* 
Массивный максимум
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] array = initializeArray();
        int max = max(array);
        System.out.println(max);
    }

    public static int[] initializeArray() throws IOException {
        // создай и заполни массив
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[20];
        for(int i = 0; i < 20; i++)
            arr[i] = Integer.parseInt(reader.readLine());
        return arr;
    }

    public static int max(int[] array) {
        // найди максимальное значение
       
        int max = array[0];
        for(int i = 0; i < 20;i++){
            if (array[i] > max)
            max = array[i];
        }
        return max;
    }
}
