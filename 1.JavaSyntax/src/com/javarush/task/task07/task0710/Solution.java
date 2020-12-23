package com.javarush.task.task07.task0710;
import java.util.ArrayList;
import java.io.*;
/* 
В начало списка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        ArrayList<String> list = new ArrayList<>();
        
        for(int i = 0; i < 10; i++)
            list.add("");
        for(int i = 10 - 1; i >= 0 ;i--)
            list.set(i, reader.readLine());
        for(int i = 0; i < 10; i++)
            System.out.println(list.get(i));
        
        
    }
}
