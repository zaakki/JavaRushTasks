package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {
    }

    public static String[] getTokens(String query, String delimiter) {
        StringTokenizer tokenizer = new StringTokenizer(query,delimiter);
        List<String> words = new ArrayList<>();
        while (tokenizer.hasMoreTokens()){
           String token = tokenizer.nextToken();
           words.add(token);

        }
        String[] res = new String[words.size()];
        for (int i = 0; i < words.size() ; i++) {
            res[i] = words.get(i);
        }

        return res;
    }
}
