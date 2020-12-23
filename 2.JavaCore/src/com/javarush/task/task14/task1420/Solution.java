package com.javarush.task.task14.task1420;
import java.io.*;
/* 
НОД
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        if( (a <= 0) || b <= 0)
            throw new Exception();

        while (b != 0){
            int temp = a%b;
            a = b;
            b = temp;
        }
        System.out.println(a);
       
    }
}
