package com.javarush.task.task03.task0314;

/* 
Таблица умножения
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int count = 1;
        while (count < 11){
            for(int i = 0; i < 10; i++)
            {
                System.out.print(arr1[i]*count + " ");
            }
            count++;
            System.out.println();
        }

    }
}
