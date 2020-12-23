package com.javarush.task.task18.task1804;

/* 
Самые редкие байты
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        reader.close();
        FileInputStream file = new FileInputStream(s);
        List<Integer> list = new ArrayList<>();
        while (file.available() > 0){
            list.add(file.read());
        }
        file.close();
        int count;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < list.size();i++){
            count = 0;
            for (int j = list.size() -1; j >=0 ; j--) {
                if(list.get(i)==list.get(j)){
                    count++;
                    map.put(list.get(i), count);
                }
            }
        }
        for(Map.Entry<Integer, Integer> m : map.entrySet()){
            if(m.getValue() == 1){
                System.out.print(m.getKey() + " ");
            }
        }
    }
}
