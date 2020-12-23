package com.javarush.task.task05.task0529;
import java.io.*;

/* 
Консоль-копилка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int res = 0;
        
        while(true){
            int number;
            String s = bufferedReader.readLine();
            if(s.equals("сумма")){
                System.out.println(res);
                break;
            }else{
                number = Integer.parseInt(s);
                res = res + number;
            } 
            
            
        }
    }
}
