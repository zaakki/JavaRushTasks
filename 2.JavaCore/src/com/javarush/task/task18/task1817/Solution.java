package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[0]);
        BufferedInputStream bis = new BufferedInputStream(fis);
        int symCount = 0;
        int spaceCount = 0;
        int i;
        while (( i = bis.read()) != -1){
            symCount++;
            if(String.valueOf((char)i).matches(" "))
                spaceCount++;
        }
        fis.close();
        bis.close();
//        System.out.println(symCount);
//        System.out.println(spaceCount);
        float res = 100*((float)spaceCount/symCount);
        System.out.printf("%.2f",res);
    }
}
