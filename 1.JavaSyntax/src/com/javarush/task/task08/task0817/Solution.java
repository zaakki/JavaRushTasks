package com.javarush.task.task08.task0817;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static Map<String, String> createMap() {
        //напишите тут ваш код
         Map<String, String> map = new HashMap<>();
        map.put("Monky", "Luffy");
        map.put("Roronoa", "Zoro");
        map.put("Vinsmoke", "Sanji");
        map.put("Nico", "Robin");
        map.put("Gol", "Rodger");
        map.put("Portgas", "Ace");
        map.put("Unnamed", "Zoro");
        map.put("Baskin", "Robin");
        map.put("Marshall", "Teach");
        map.put("Gordeev", "Giorgii");
        

        return map;
    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        //напишите тут ваш код
        List<String> list = new ArrayList<>(map.values());
        for(int i = 0; i < list.size(); i++){
            for(int j = i + 1; j < list.size(); j++){
                if(list.get(i).equals(list.get(j))){
                    removeItemFromMapByValue(map, list.get(i));
                }
            }
        }

    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {

    }
}
