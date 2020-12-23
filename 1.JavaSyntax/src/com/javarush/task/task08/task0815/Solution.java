package com.javarush.task.task08.task0815;

import java.util.Map;
import java.util.HashMap;


/* 
Перепись населения
*/

public class Solution {
    public static Map<String, String> createMap() {
        //напишите тут ваш код
        Map<String, String> familyMap = new HashMap<>();
        String[] name = {"Валерий", "Валерий", "Петр", "Светалана",
                "Тимофей", "Надежда", "Андрей", "Прокофья", "Артем", "Полина"};

        String[] familyName = {"Лапухович", "Лапуховна", "Лапухов", "Сизифор", "Сизиф",
                "Хаустовер", "Хаустовы", "Хаус", "Хауст", "Дмитров"};
        for (int  i = 0;  i < 10 ;  i++) {
            familyMap.put(familyName[i], name[i]);
            }
        return familyMap;
    }

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
        //напишите тут ваш код
        int countFirstName = 0;
        for(Map.Entry<String, String> entry : map.entrySet()){
            if(entry.getValue().equals(name))
                countFirstName++;
        }
        return countFirstName;
    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        //напишите тут ваш код
        int countLastName = 0;
        for(Map.Entry<String, String> entry : map.entrySet()){
            if(entry.getKey().equals(lastName))
                countLastName++;
        }
        return countLastName;
    }

    public static void main(String[] args) {

    }
}
