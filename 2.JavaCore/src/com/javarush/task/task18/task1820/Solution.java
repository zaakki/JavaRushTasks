package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bis = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine())));
        FileOutputStream fos = new FileOutputStream(reader.readLine());
        String text= "";
        String[] line;

        while (bis.ready()){
            text = text + bis.readLine();
            line = text.split(" ");
            for (int i = 0; i < line.length; i++){
                fos.write(convert(line[i]).getBytes() );
            }
        }
        fos.flush();
        reader.close();
        bis.close();
        fos.close();
    }
    public static String convert (String s){
        double f = Double.parseDouble(s);
        if(f >= 0){
            if(f - (int)f >= 0.5){
                f = (int)f + 1;
            } else if(f - (int)f < 0.5){
                f = (int)f;
            }
        } else if(f < 0){
            if(f - (int)f >= -0.5){
                f = (int)f;
            }else if(f - (int)f < -0.5){
                f = (int)f - 1;
            }
        }
        int inter = (int) f;
        return String.valueOf(inter) + " ";
    }
}
