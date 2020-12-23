package com.javarush.task.task07.task0723;

/* 
Обратный отсчёт
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 30; i >= 0;) {
            System.out.println(i);

            //напишите тут ваш код
            Thread.sleep(100);
            i--;
        }

        System.out.println("Бум!");
    }
}
