package com.javarush.task.task09.task0921;
import java.io.*;
import java.util.*;

/* 
Метод в try..catch
*/

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < list.size() + 1; i++){
            try{
                list.add(Integer.parseInt(reader.readLine()));
            }catch (Exception e){
                for(Integer num : list){
                    System.out.println(num);
                }
            }
        }
    }
}
