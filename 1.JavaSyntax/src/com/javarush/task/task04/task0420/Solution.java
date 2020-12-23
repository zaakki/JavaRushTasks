package com.javarush.task.task04.task0420;
import java.util.Scanner;
/* 
Сортировка трех чисел
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        int number1 = sc.nextInt();
        int number2 = sc.nextInt();
        int number3 = sc.nextInt();
        if (number1 >= number2 && number1 >= number3)
        {
            if (number3 >= number2)
                System.out.println(number1 + " " + number3 + " " + number2);
            else
                System.out.println(number1 + " " + number2 + " " + number3);
        }else if (number2 >= number1 && number2 >= number3)
        {
            if (number3 >= number1)
                System.out.println(number2 + " " + number3 + " " + number1);
            else
                System.out.println(number2 + " " + number1 + " " + number3);
        }else if(number3 >= number2 && number3 >= number1)
            {
                if (number2 >= number1)
                    System.out.println(number3 + " " + number2 + " " + number1);
                else
                    System.out.println(number3 + " " + number1 + " " + number2);
            }else;
        

    }

}
