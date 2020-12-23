package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* 
Формируем WHERE
name=Ivanov, country=Ukraine, city=Kiev, age=null}
name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'


*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> testedMap = new HashMap<>();
        testedMap.put("name",null);
        testedMap.put("country", null);
        testedMap.put("city",null);
        testedMap.put("age",null);

        System.out.println(getQuery(testedMap));

    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        String s ;
        if(params.values().stream().allMatch(Objects::isNull))
           s = "";
        else {
            for (Map.Entry<String, String> m : params.entrySet()
            ) {
                if (m.getValue() != null)
                    sb.append(m.getKey()).append(" = '").append(m.getValue()).append("' and ");
            }
            sb.delete(sb.length()-5,sb.length());
            s = sb.toString();
        }
        return s;
    }
}
