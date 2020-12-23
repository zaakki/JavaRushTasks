package com.javarush.task.task07.task0709;
import java.util.ArrayList;
import java.io.*;

/* 
Выражаемся покороче
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        int max = Integer.MAX_VALUE;
        for(int i = 0; i < 5; i++)
            list.add(i, reader.readLine());
        for(int i = 0; i < 5;i++){
            if(max >= list.get(i).length()){
                max = list.get(i).length(); 
            }
        }
    
        for(int i = 0; i < 5; i++){
        if(max == list.get(i).length())
         System.out.println(list.get(i));
        }
    }
   
}
