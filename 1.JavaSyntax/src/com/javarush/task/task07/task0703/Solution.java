package com.javarush.task.task07.task0703;
import java.io.*;
/* 
Общение одиноких массивов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] sArray = new String[10];
        int[] intArray = new int[10];
        for(int i = 0; i < 10; i++ ){
            sArray[i] = reader.readLine();
            intArray[i] = sArray[i].length();
            System.out.println(intArray[i]);            
        }
    }
}
