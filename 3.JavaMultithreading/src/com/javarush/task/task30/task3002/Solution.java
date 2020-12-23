package com.javarush.task.task30.task3002;

/* 
Осваиваем методы класса Integer
*/
public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s) {
        //напишите тут ваш код
        int radix;
        String str = "";
        if(s.startsWith("0b")){
            str += s.substring(2);
            radix = 2;
        }else if(s.startsWith("0x")){
            str += s.substring(2);
            radix = 16;
        } else if(s.startsWith("0")) {
            str += s;
            radix = 8;
        } else {
            str += s;
            radix = 10;
        }


        return String.valueOf(Integer.parseInt(str,radix));
    }
}
