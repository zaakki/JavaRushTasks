package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String path = args[0];
        File file = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(file));
        StringBuilder line = new StringBuilder();
        while (br.ready()){
            line.append(br.readLine());

        }
        String text = line.toString();
        text = text.replaceAll("\\W","");

        br.close();
        TreeSet<Character> set = new TreeSet<>();

        char[] chars = text.toLowerCase().toCharArray();
        for (Character c: chars
             ) {
            set.add(c);
        }
        set.stream()
                .filter(Character::isLetter)
                .limit(5)
                .forEach(System.out::print);

    }
}
