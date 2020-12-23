package com.javarush.task.task08.task0812;

import java.io.IOException;
import java.util.*;
import java.io.*;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 10; i++)
            list.add(i, Integer.parseInt(reader.readLine()));
        int count = 1;
        int tmp = 1;
        
        for (int i = 0; i < list.size() - 1;i++) {
            if (list.get(i).equals(list.get(i + 1))){
               tmp++;
              if (tmp > count) {
                  count = tmp;
                  } 
                
            } else {
                tmp = 1;
                }
        }
        System.out.println(count);
        

    }
}