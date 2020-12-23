package com.javarush.task.task04.task0429;
import java.util.Scanner;
/* 
Положительные и отрицательные числа
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int countPlus = 0;
        int countMinus = 0;
        int[] arr = {a, b, c};
        for(int i = 0; i < arr.length; i++ ){
            if(arr[i] > 0)
                countPlus++;
            else if (arr[i] < 0)
                countMinus++;
            else;
        }
        System.out.println("количество отрицательных чисел: " + countMinus);
        System.out.println("количество положительных чисел: " + countPlus);

    }
}
