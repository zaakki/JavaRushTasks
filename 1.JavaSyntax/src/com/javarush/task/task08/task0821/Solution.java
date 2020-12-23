package com.javarush.task.task08.task0821;

import java.util.Map;
import java.util.HashMap;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleMap();
        printPeopleMap(map);
    }

    public static Map<String, String> createPeopleMap() {
        //напишите тут ваш код
        Map<String, String> people = new HashMap<>();
        people.put("Monky","Luffy");
        people.put("Roronoa", "Zoro");
        people.put("Vinsmoke", "Sanji");
        people.put("Niko", "Robin");
        people.put("Niko", "Olivia");
        people.put("Baskin", "Robin");
        people.put("Serni", "Robin");
        people.put("Gordeev", "Giorgii");
        people.put("Monty", "Pyton");
        people.put("Gref", "Mudak");


        return people;

        
    }

    public static void printPeopleMap(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
