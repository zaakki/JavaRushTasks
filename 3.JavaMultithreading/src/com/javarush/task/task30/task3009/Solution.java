package com.javarush.task.task30.task3009;

/* 
Палиндром?
*/

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        System.out.println(getRadix("112"));        //expected output: [3, 27, 13, 15]
        System.out.println(getRadix("123"));        //expected output: [6]
        System.out.println(getRadix("5321"));       //expected output: []
        System.out.println(getRadix("1A"));         //expected output: []
    }
    private static Set<Integer>  getRadix(String number){
        Set<Integer> result = new HashSet<>();
        try{
            for (int i = 2; i < 37 ; i++) {

                String s = Integer.toString(Integer.parseInt(number),i);

                if(s.equals(new StringBuilder(s).reverse().toString())){
                    result.add(i);
                }
            }
        } catch (NumberFormatException e){}
        return result;
    }
}