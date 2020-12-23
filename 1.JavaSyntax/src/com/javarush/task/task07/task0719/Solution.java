package com.javarush.task.task07.task0719;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Вывести числа в обратном порядке
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < 10; i++)
            list.add(i, Integer.parseInt(reader.readLine()));
        for(int i = list.size()-1; i >= 0; i--)
            System.out.println(list.get(i));

        //напишите тут ваш код
    }
}
