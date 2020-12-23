package com.javarush.task.task08.task0822;

import java.io.IOException;
import java.util.List;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/* 
Минимальное из N чисел
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        List<Integer> integerList = getIntegerList();
        System.out.println(getMinimum(integerList));
    }

    public static int getMinimum(List<Integer> array) {
        // Найти минимум тут
        return Collections.min(array);
    }

    public static List<Integer> getIntegerList() throws IOException {
        // Создать и заполнить список тут
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(reader.readLine());
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < size; i++)
            list.add(Integer.parseInt(reader.readLine()));
        return list;
    }
}
