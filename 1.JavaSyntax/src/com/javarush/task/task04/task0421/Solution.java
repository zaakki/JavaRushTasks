package com.javarush.task.task04.task0421;
import java.util.Scanner;
/* 
Настя или Настя?
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        if(s1.equals(s2))
            System.out.println("Имена идентичны");
        else if (s1.length() == s2.length())
            System.out.println("Длины имен равны");
     

    }
}
