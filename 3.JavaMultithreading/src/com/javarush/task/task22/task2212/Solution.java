package com.javarush.task.task22.task2212;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if(telNumber == null)
            return false;
        if(telNumber.contains("\\D"))
            return false;
        else {
            Pattern p = Pattern.compile("^((\\+\\d{12})|(\\+\\d{2}\\(\\d{3}\\)\\d{7})|(\\(\\d{3}\\)\\d{7})|(" +
                    "\\+\\d{8}(-\\d{2}){2})|(\\d{6}-\\d{4})|(\\d{10}))");
            Matcher m = p.matcher(telNumber);

            if (m.find())
                return true;
            else
                return false;
        }
    }

    public static void main(String[] args) {
        //+380501234567 - true
        //+38(050)1234567 - true
        //+38050123-45-67 - true
        //050123-4567 - true
        //+38)050(1234567 - false
        //+38(050)1-23-45-6-7 - false
        //050ххх4567 - false
        //050123456 - false
        //(0)501234567 - false

        String[] s = {"+72(965)1225673","+380501234567", "+38050123-45-67", "050123-4567",
                    "+38)050(1234567","+38(050)1-23-45-6-7", "050ххх4567", "050123456", "(0)501234567",""};
        for (int i = 0; i < s.length ; i++) {
            System.out.println(checkTelNumber(s[i]));
        }

    }
}
