package com.javarush.task.task04.task0423;
import java.util.Scanner;
/* 
Фейс-контроль
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        int age = sc.nextInt();
        if (age > 20)
            System.out.println("И 18-ти достаточно");

    }
}
