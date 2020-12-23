package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        List<Character> list = new ArrayList<>();
        FileInputStream fis = new FileInputStream(args[0]);
        while(fis.available() > 0){
            list.add((char)fis.read());
        }
        fis.close();
        Collections.sort(list);
        int count;
        TreeMap<Character,Integer> map = new TreeMap<>();
        for(int i = 0; i < list.size(); i++){
            count = 0;
            for (int j = list.size()-1; j >= 0; j--){
                if(list.get(i) == list.get(j)){
                    count++;
                }

            }
            map.put(list.get(i), count);
        }
        for (Map.Entry<Character,Integer> m: map.entrySet()
             ) {
            System.out.println(m.getKey() + " " + m.getValue());
        }

    }
}
