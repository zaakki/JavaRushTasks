package com.javarush.task.task18.task1803;

/* 
Самые частые байты
*/

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int count;
        String s = reader.readLine();
        reader.close();
        FileInputStream file = new FileInputStream(s);
        while (file.available() > 0){
           int data = file.read();
           list.add(data);
        }
        file.close();
        for (int i = 0; i <list.size() ; i++) {
            count = 0;
            for (int j = list.size() - 1; j >= 0 ; j--) {
                if(list.get(i) == list.get(j))
                    count++;
                map.put(list.get(i),count);
            }

        }
        for (Map.Entry<Integer, Integer> m :map.entrySet()
             ) {
            if(m.getValue() > 2 ){
                System.out.print(m.getKey() + " ");
            }
        }
    }
}
