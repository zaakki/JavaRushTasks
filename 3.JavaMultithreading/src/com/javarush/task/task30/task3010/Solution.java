package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        try {
            if(args[0].replaceAll("\\w","").matches("\\W")){
                System.out.println("incorrect");
            }


            for (int i = 2; i < 37 ; i++) {
                try {


                    new BigInteger(args[0].toLowerCase(), i);
                    System.out.println(i);
                    break;
                }catch (Exception e){

                }
            }

        } catch (Exception e){
          
        }
    }
}