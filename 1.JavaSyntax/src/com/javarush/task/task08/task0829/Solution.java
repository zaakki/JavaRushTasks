package com.javarush.task.task08.task0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/* 
Модернизация ПО
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> map = new HashMap<>();

        while (true) {
            String s1 = reader.readLine();
            if(s1.isEmpty())
                break;
            String s2 = reader.readLine();

            map.put(s1, s2);
        }
        String str = reader.readLine();
        System.out.println(map.get(str));
    }
}
