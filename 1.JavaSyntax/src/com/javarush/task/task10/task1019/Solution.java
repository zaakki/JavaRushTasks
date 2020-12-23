package com.javarush.task.task10.task1019;
import java.util.*;
import java.io.*;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();
        while (true) {
            String s = reader.readLine();
            int id;
            if (s.isEmpty())
                break;
            else {
                id = Integer.parseInt(s);
            }
            String name = reader.readLine();
            map.put(name, id);
        }
        for (Map.Entry<String, Integer> entry:map.entrySet()
                ) {
            System.out.println(entry.getValue() + " " + entry.getKey());

        }
    }
}
