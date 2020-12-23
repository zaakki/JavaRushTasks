package com.javarush.task.task04.task0419;
import java.util.Scanner;
/* 
Максимум четырех чисел
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        
        if (a >= b && c >= d){
            if (a >= c )
                System.out.println(a);
            else 
                System.out.println(c);
        } else if (a <= b && c <= d){
            if (b >= d)
                System.out.println(b);
            else
                System.out.println(d);
        } else if (a <= b && c >= d){
            if (b >= c)
                System.out.println(b);
            else    
                System.out.println(c);
        } else if (a >= b && c <= d){
            if (a >= d)
                System.out.println(a);
            else 
                System.out.println(d);
        }else
            System.out.println(a);
            

    }
}
