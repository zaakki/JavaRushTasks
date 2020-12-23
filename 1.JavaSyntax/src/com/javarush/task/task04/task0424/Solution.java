package com.javarush.task.task04.task0424;
import java.util.Scanner;
/* 
Три числа
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        if(a == b && b != c)
                System.out.print(3);
        else  if(a == c && c != b)
            System.out.println(2);
        else if (b == c && c != a)
            System.out.println(1);
        else ;

    }
}
