package com.javarush.task.task09.task0908;

/* 
Исключение при работе со строками
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        try{

        String s = null;
        String m = s.toLowerCase();
        }catch(NullPointerException e){
            System.out.println(e.getClass().getName().substring(10) + " has been caught.");
        }

        //напишите тут ваш код
    }
}
