package com.javarush.task.task15.task1529;

/* 
Осваивание статического блока
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {

    }

    static {
        //add your code here - добавьте код тут
        reset();

    }

    public static CanFly result;

    public static void reset(){
        //add your code here - добавьте код тут
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String text;

            while ((text = reader.readLine()) != "") {
                if (text.equals("helicopter")) {
                    result = new Helicopter();
                    System.out.println(result);
                } else if (text.equals("plane")) {
                    result = new Plane(Integer.parseInt(reader.readLine()));
                    System.out.println(result);
                } else
                    reader.close();
            }

        } catch (IOException e){
            //e.printStackTrace();
        }





    }
}
