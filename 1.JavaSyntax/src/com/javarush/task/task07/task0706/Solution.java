package com.javarush.task.task07.task0706;
import java.io.*;

import java.io.IOException;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int sum1 = 0;
        int sum2 = 0;
        int[] arr = new int[15];
        for(int i = 0; i < arr.length; i++)
            arr[i] = Integer.parseInt(reader.readLine());
        for(int i = 1; i < arr.length; i+=2)
            sum1 = sum1 + arr[i];
        for(int i = 0; i < arr.length; i+=2)
            sum2 = sum2 + arr[i];
        if (sum2 > sum1)
           System.out.println("В домах с четными номерами проживает больше жителей.");
        else if(sum1 > sum2)
           System.out.println("В домах с нечетными номерами проживает больше жителей.");
    }
}
