package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException{
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine())));
        List<Integer> list = new ArrayList<>();
        try{
            String text;
            while ((text=br.readLine()) != null){
                if(Integer.parseInt(text) % 2 ==0)
                    list.add(Integer.parseInt(text));
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            reader.close();
            br.close();
        }
        int d = list.size()/2;
        while (d > 0){
            for(int i = 0; i < list.size()-d;i++){
                int j = i;
                while ((j >= 0) && (list.get(j)> list.get(j+d))){
                    int tmp = list.get(j);
                    list.set(j, list.get(j+d));
                    list.set(j+d, tmp);
                    j--;
                }
            }
            d = d/2;
        }
        for (Integer iList: list
             ) {
            System.out.println(iList);
        }
    }
}
