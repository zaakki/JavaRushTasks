package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        FileInputStream file = new FileInputStream(args[0]);
        BufferedInputStream bis = new BufferedInputStream(file);
        int i;
        int count = 0;
        while ((i=bis.read()) != -1){
            if(String.valueOf((char)i).matches("[a-zA-Z]*"))
                count++;
        }
        file.close();
        bis.close();
        System.out.println(count);

    }
}
