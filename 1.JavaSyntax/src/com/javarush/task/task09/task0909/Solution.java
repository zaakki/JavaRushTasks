package com.javarush.task.task09.task0909;

/* 
Исключение при работе с массивами
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        try{

        int[] m = new int[2];
        m[8] = 5;
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getClass().getName().substring(10) + " has been caught.");
        }

        //напишите тут ваш код
    }
}
