package com.javarush.task.task18.task1805;

/* 
Сортировка байт
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        Collections.sort(list);
        for(int i = 0; i < list.size()-1;i++){
            if(list.get(i) == list.get(i+1)){
                list.remove(i);
                i--;
            }
        }
        for (Integer num: list
             ) {
            System.out.print(num + " ");
        }
    }
}
