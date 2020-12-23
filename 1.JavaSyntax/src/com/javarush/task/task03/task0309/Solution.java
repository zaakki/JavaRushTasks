package com.javarush.task.task03.task0309;

/* 
Сумма 5 чисел
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        int[] arr1 = {1, 2, 3, 4, 5};
        int sum = 0;
        for(int i = 0; i < 5; i++){
            sum = sum + arr1[i];
            System.out.println(sum);
        }

    }
}
