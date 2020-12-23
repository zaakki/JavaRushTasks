package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        FileInputStream file = new FileInputStream(s);
        reader.close();
        List<Character> list = new ArrayList<>();
        int count=0;
        while (file.available() > 0){
            list.add((char)file.read());
        }
        file.close();
        for(int i = 0; i < list.size();i++){
            if(list.get(i).equals(',')){
                count++;
            }
        }
        System.out.println(count);
    }
}
