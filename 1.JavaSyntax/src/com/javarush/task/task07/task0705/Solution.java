package com.javarush.task.task07.task0705;
import java.io.*;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] bigArray = new int[20];
        int[] littleArray1 = new int[10];
        int[] littleArray2 = new int[10];
        for(int i = 0; i < bigArray.length; i++)
            bigArray[i] = Integer.parseInt(reader.readLine());
        for(int i = 0; i < 10; i++)
            littleArray1[i] = bigArray[i];
        for(int i = 0; i < 10; i++){
            littleArray2[i] = bigArray[i+10];
            System.out.println(littleArray2[i]);
        }
    }
}
