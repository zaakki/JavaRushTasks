package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
       long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000 ; i++) {
            ByteArrayOutputStream password = getPassword();
            System.out.println(password.toString());
        }

        long timeSpent = System.currentTimeMillis() - startTime;
        System.out.println("программа выполнялась " + timeSpent + " миллисекунд");
        long usedBytes = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("Памяти затрачено " +usedBytes/1048576 + " MB");
    }

    public static ByteArrayOutputStream getPassword() {
        boolean isNumber = false;
        boolean isUpperCase = false;
        boolean isLowerCase = false;
        int rnd;
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i < 9;i++) {
            rnd = (int)(Math.random() * 3);
            if(rnd == 0){
               sb.append(getNumber());
                isNumber = true;

            } if(rnd == 1){
                sb.append(getUpperCase());
                isUpperCase = true;
            } if(rnd == 2) {
                sb.append(getLowerCase());
                isLowerCase = true;
            }

        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            baos.write(sb.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(isLowerCase && isNumber && isUpperCase){
             return baos;
        }else {
            return getPassword();
        }
    }

    public static char getNumber() {
        return (char) ((Math.random() * 10) + 48);
    }

    public static char getUpperCase() {
        return (char) ((Math.random() * 26) + 65);
    }

    public static char getLowerCase() {
        return (char) ((Math.random() * 26) + 97);
    }
}