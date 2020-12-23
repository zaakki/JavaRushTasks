package com.javarush.task.task07.task0717;
import java.io.*;
import java.util.ArrayList;

/* 
Удваиваем слова
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        // Считать строки с консоли и объявить ArrayList list тут
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10 ; i++)
            list.add(i, reader.readLine());

        ArrayList<String> result = doubleValues(list);


        // Вывести на экран result
    }

    public static ArrayList<String> doubleValues(ArrayList<String> strings) {
        //напишите тут ваш код
        for (int i = 0; i < strings.size();i++ ) {
            if (strings.get(i).contains("р") && !strings.get(i).contains("л")) {
                strings.remove(i);
            }
            if (strings.get(i).contains("л") && !strings.get(i).contains("р")){
                strings.add(i, strings.get(i));
                i++;
            }
        }
        return strings;
    }
}
