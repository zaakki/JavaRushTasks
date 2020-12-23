package com.javarush.task.task04.task0422;
import java.util.Scanner;
/* 
18+
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        int age = sc.nextInt();
        if (age < 18)
            System.out.println("Подрасти еще");
        

    }
}
