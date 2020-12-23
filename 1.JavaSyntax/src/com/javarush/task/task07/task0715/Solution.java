package com.javarush.task.task07.task0715;
import java.util.ArrayList;

/* 
Продолжаем мыть раму
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<>();
        String[] arr = {"мама", "именно", "мыла", "именно", "раму", "именно"};
        for(int i = 0; i < arr.length; i++) list.add(arr[i]);
        for(int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));
    }
}
