package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Минимаксы в массивах
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int maximum = Integer.MIN_VALUE;
        int minimum = Integer.MAX_VALUE;

        //напишите тут ваш код 
        int[] arr = new int[20];
        for(int i = 0; i < arr.length; i++)
            arr[i] = Integer.parseInt(reader.readLine());
        for (int i = 0; i < arr.length; i++){
            if(maximum < arr[i])
                maximum = arr[i];
        }
        for (int i = 0; i < arr.length; i++){
            if(minimum > arr[i])
                minimum = arr[i];
        }

        System.out.print(maximum + " " + minimum);
    }
}
