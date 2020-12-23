package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Числа по возрастанию
*/

public class Solution {
    public static void sort(int[] arr){
    for(int i = arr.length - 1; i > 0; i--)
        for(int j = 0; j < i; j++){
            if (arr[j] > arr[j+1]){
                int tmp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = tmp;
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[5];
        for(int i = 0; i < 5; i++)
            arr[i] = Integer.parseInt(reader.readLine());
        sort(arr);
        for (int i = 0; i < 5; i++)
            System.out.println(arr[i]);
        
            
        

        //напишите тут ваш код
    }
}
