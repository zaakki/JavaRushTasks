package com.javarush.task.task09.task0922;
import java.io.*;
import java.util.*;
import java.text.*;

/* 
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy", Locale.ENGLISH);
       
        Date date = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(s);
        System.out.println( dateFormat.format(date).toUpperCase());
    }
}
