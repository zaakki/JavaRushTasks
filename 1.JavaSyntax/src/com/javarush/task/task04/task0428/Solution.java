package com.javarush.task.task04.task0428;
import java.util.Scanner;
/* 
Положительное число
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int count = 0;
        int[] arr = {a,b,c};
        for(int i = 0; i < arr.length; i++ ){
            if(arr[i] > 0)
            count++;
        }System.out.println(count);

    }
}
