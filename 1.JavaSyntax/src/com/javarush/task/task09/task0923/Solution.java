package com.javarush.task.task09.task0923;
import java.io.*;
import java.util.*;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        
         for (int i = 0; i <s.length() ; i++) {
           if (isVowel(s.toCharArray()[i])) {
               list1.add(String.valueOf(s.toCharArray()[i]));
           } else if (s.toCharArray()[i] == ' '){

           }  else {
               list2.add(String.valueOf(s.toCharArray()[i]));
           }
           }
        for (String vowel : list1
             ) {
            System.out.print(vowel + " ");
        }

        System.out.println();
        for (String vowel : list2
                ) {
            System.out.print(vowel + " ");
        }
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам
        for (char d : vowels) {  // ищем среди массива гласных
            if (c == d) {
                return true;
            }
        }
        return false;
    }
}