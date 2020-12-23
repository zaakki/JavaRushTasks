package com.javarush.task.task04.task0412;
import java.io.*;

/* 
Положительное и отрицательное число
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String a = bufferedReader.readLine();
        int f = Integer.parseInt(a);
        if (f > 0)
            System.out.println(2*f);
        if (f < 0)
            System.out.println(f+1);
        if (f == 0 )
            System.out.println(0);

    }

}