package com.javarush.task.task03.task0312;

/* 
Конвертируем время
*/

public class Solution {
    //напишите тут ваш код

    public static void main(String[] args) {
        //напишите тут ваш код
        System.out.println(convertToSeconds(15));
        System.out.println(convertToSeconds(3));

    }
    public static int convertToSeconds(int hour){
        return hour*3600;
    }
}
