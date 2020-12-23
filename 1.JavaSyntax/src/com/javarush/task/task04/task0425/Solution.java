package com.javarush.task.task04.task0425;
import java.util.Scanner;
/* 
Цель установлена!
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        if (a > 0 && b > 0)
            System.out.println(1);
        else if (a < 0 && b > 0)
            System.out.println(2);
        else if (a < 0 && b < 0)
            System.out.println(3);
        else if (a > 0 && b < 0)
            System.out.println(4);
            else;

    }
}
