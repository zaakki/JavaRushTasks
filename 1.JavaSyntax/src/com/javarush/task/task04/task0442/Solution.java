package com.javarush.task.task04.task0442;
import java.io.*;

/* 
Суммирование
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        while(true){
            int num = Integer.parseInt(bufferedReader.readLine());
            
            if(num == -1 ){
                sum--;
            System.out.println(sum);
                break ;
            }
            else 
                sum+=num;
        } 
        

    }
}
