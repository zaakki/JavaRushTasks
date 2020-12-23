package com.javarush.task.task04.task0434;

/* 
Таблица умножения
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        int a = 1;
        int mult = 1;
        while (a <= 10 ){
            int b = 1;
            while(b <= 10)
            {
                mult = a * b;
                System.out.print(mult+" ");
                b++;
            }System.out.println();
            a++;
        }

    }
}
