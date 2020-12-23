package com.javarush.task.task08.task0818;

import java.util.Map;
import java.util.HashMap;

/* 
Только для богачей
*/

public class Solution {
    public static Map<String, Integer> createMap() {
        //напишите тут ваш код
        Map<String, Integer> map = new HashMap<>();
        map.put("Luffy", 1500000);
        map.put("Zoro", 320000);
        map.put("Sanji", 330000);
        map.put("Nami", 66000);
        map.put("Usopp", 200000);
        map.put("Chopper", 100);
        map.put("Robin", 130000);
        map.put("Franky", 94000);
        map.put("Brook", 83000);
        map.put("Zaki", 450);
        
        return map;
    }

    public static void removeItemFromMap(Map<String, Integer> map) {
        //напишите тут ваш код
        Map<String, Integer> copy = new HashMap<>(map);
        for(Map.Entry<String, Integer> pair : copy.entrySet()){
            if(pair.getValue() < 500){
                map.remove(pair.getKey());
            }
            
        }
    }

    public static void main(String[] args) {

    }
}