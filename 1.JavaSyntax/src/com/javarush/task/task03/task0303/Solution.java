package com.javarush.task.task03.task0303;

/* 
Обмен валют
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        System.out.println(convertEurToUsd(15, 1.5));
        System.out.println(convertEurToUsd(1500, 0.98));

    }

    public static double convertEurToUsd(int eur, double course) {
        //напишите тут ваш код
        return (double)eur*course;

    }
}
