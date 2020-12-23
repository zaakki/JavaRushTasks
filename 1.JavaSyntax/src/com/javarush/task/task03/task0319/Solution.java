package com.javarush.task.task03.task0319;
import java.io.*;
/* 
Предсказание на будущее
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
         InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String name = bufferedReader.readLine();
        String sAge1 = bufferedReader.readLine();
        String sAge2 = bufferedReader.readLine();
        int nAge1 = Integer.parseInt(sAge1);
        int nAge2 = Integer.parseInt(sAge2);
        System.out.println(name + " получает " + nAge1 + " через " + nAge2 + " лет.");

    }
}
