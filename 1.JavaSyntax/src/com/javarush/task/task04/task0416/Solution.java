package com.javarush.task.task04.task0416;
import java.io.*;

/* 
Переходим дорогу вслепую
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        double t = Double.parseDouble(s);
        if (t % 5 >= 0 && t % 5 < 3)
            System.out.println("зеленый");
        else if (t % 5 >= 3 && t % 5 < 4)
            System.out.println("желтый");
        else    
            System.out.println("красный");
        
    }
}