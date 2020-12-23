package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/* 
Факториал
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        //add your code here
        int count = 0;
        BigInteger factorial = BigInteger.valueOf(0);
        while (count <= n){

            if(count == 0) {
                factorial = BigInteger.valueOf(1);
                count++;
            } else{
                factorial = factorial.multiply(BigInteger.valueOf(count));
                count++;
            }
        }
        String result = String.valueOf(factorial);

        return result;
    }
}
