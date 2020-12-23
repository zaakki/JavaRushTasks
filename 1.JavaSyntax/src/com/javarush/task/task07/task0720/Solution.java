package com.javarush.task.task07.task0720;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Перестановочка подоспела
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < n; i++)
            list.add(i, reader.readLine());
        int count = 0;
       while (count < m){
           list.add(list.get(0));
           list.remove(list.get(0));
           count++;
       }    
        
        for(String s : list){
            System.out.println(s);
        }

        //напишите тут ваш код
    }
}
