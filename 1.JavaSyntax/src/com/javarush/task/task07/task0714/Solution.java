package com.javarush.task.task07.task0714;
import java.util.ArrayList;
import java.io.*;

/* 
Слова в обратном порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        
        for(int i = 0; i < 5; i++)
            list.add(i, reader.readLine());
        list.remove(2);
        for(int i = list.size() - 1; i >= 0; i--)
            System.out.println(list.get(i));
    }
}
