package com.javarush.task.task04.task0415;
import java.util.Scanner;

/* 
Правило треугольника
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        if (((a + b) > c ) && ((b + c) > a) && ((c + a) > b))
            System.out.println("Треугольник существует.");
        else 
            System.out.println("Треугольник не существует.");

    }
}