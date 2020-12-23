package com.javarush.task.task04.task0427;
import java.util.Scanner;
/* 
Описываем числа
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        String s = String.valueOf(a);
        if (a % 2 == 0 && a > 0 && a < 1000){
            if (s.length() == 1)
                System.out.println("четное однозначное число");
            else if (s.length() == 2)
                System.out.println("четное двузначное число");
            else if (s.length() == 3)
                System.out.println("четное трехзначное число");
            else;
        } else if (a % 2 != 0 && a > 0 && a < 1000){
            if (s.length() == 1)
                System.out.println("нечетное однозначное число");
            else if (s.length() == 2)
                System.out.println("нечетное двузначное число");
            else if (s.length() == 3)
                System.out.println("нечетное трехзначное число");
            else;
        }else;

    }
}
