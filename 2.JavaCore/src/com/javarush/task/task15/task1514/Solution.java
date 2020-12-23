package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();
    static
    {
        labels.put(3.14, "Pi");
        labels.put(2.72, "Exp");
        labels.put(1.61, "Fib");
        labels.put(0.662, "Laplas");
        labels.put(0.57, "Eiler-Maskeroni");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
