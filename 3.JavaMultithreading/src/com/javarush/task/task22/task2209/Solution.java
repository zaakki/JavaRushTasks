package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //...
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        fileName = reader.readLine();
//        fileName = "Testdoc";
        reader.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        String words = "";
        while (fileReader.ready()){
            words = words + fileReader.readLine();
        }
        fileReader.close();


        StringBuilder result = getLine(words);
        System.out.println(result.toString());
    }


    public static StringBuilder getLine(String... words) {
        if (words == null || words.length == 0) {
            return new StringBuilder();
        }else {
            StringBuilder word = new StringBuilder();
            for (String s : words
            ) {
                word.append(s).append(" ");
            }
            String[] wordArray = word.toString().split(" ");
            word.delete(0, word.length());
            List<String> list = new ArrayList<>();
            for (int i = 0; i < wordArray.length; i++) {
                if (!wordArray[i].equals(" "))
                    list.add(wordArray[i]);
            }
            Collections.shuffle(list);
            int count = 0;
            int size = list.size();
            for (int i = 0; i < size-1; ) {
                for (int j = i + 1; j < list.size(); j++) {
                    count++;

                    if (list.get(i).substring(list.get(i).length() - 1).
                            equalsIgnoreCase(list.get(j).substring(0, 1))) {

                        String temp = list.get(i + 1);
                        list.set(i + 1, list.get(j));
                        list.set(j, temp);
                        i++;
                        count = 0;
                    } else if(count > list.size()){
                        Collections.shuffle(list);
                        i=0;
                    }
                }
            }
            for (int i = 0; i < size ; i++) {
                word.append(list.get(i)).append(" ");
            }
            word.delete(word.length()-1,word.length());
            return word;
        }

    }

}

