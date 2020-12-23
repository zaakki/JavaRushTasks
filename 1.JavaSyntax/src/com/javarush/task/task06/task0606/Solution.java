package com.javarush.task.task06.task0606;
import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bufferedReader.readLine());
        int sum=0;
        
       while (num  > 0){
            sum = num%10;
            if (sum%2 == 0)
                even++;
            else 
                odd++;
            num = num/10;
       }
       System.out.println("Even: " + even + " Odd: " + odd);
    }
}
