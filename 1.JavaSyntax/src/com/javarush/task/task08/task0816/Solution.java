package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static Map<String, Date> createMap() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();
        map.put("Сталлоне", dateFormat.parse("MAY 1 2012"));
        map.put("Вин Дизель", dateFormat.parse("AUGUST 4 1990"));
        map.put("Йохансон", dateFormat.parse("SEPTEMBER 16 1994"));
        map.put("Скай", dateFormat.parse("JUNE 28 1998"));
        map.put("Тарковский", dateFormat.parse("DECEMBER 31 2005"));
        map.put("Клаус", dateFormat.parse("JANUARY 7 2006"));
        map.put("Коженюк", dateFormat.parse("APRIL 2 2006"));
        map.put("Нургаран", dateFormat.parse("MAY 4 2006"));
        map.put("Адамс", dateFormat.parse("MAY 25 2004"));
        map.put("Хайзенбер", dateFormat.parse("JULY 18 2006"));

        //напишите тут ваш код
        return map;
    }

    public static void removeAllSummerPeople(Map<String, Date> map) {
        //напишите тут ваш код
        Iterator<Map.Entry<String, Date>> itr = map.entrySet().iterator();
        
        while(itr.hasNext()){
            Map.Entry<String, Date> pair = itr.next();
            if(pair.getValue().toString().contains("Aug") || 
                pair.getValue().toString().contains("Jul") ||
                pair.getValue().toString().contains("Jun")){
                    itr.remove();
                }
        }
        

    }

    public static void main(String[] args) {

    }
}
