package com.javarush.task.task05.task0507;
import java.io.*;

/* 
Среднее арифметическое
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        double res = 0.0;
        double count = 0.0;
        while (true){
            
            int number = Integer.parseInt(bufferedReader.readLine());
            if (number == -1 )
            {
                res = res/count;
                System.out.println(res);
                break;
            }else{
                count++;
                res = res + number;
                
                
            }
                
        }
    }
}

