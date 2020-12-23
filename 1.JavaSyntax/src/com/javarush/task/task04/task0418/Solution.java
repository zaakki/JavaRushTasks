package com.javarush.task.task04.task0418;
import java.util.Scanner;
/* 
Минимум двух чисел
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        if (a <= b)
            System.out.println(a);
        else 
            System.out.println(b);

    }
}