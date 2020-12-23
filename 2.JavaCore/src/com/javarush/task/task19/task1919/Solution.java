package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        List<String> listName = new ArrayList<>();
        List<Double> listSalary = new ArrayList<>();
        String[] splitLine = new String[2];
        String line = "";
        while (br.ready()){
            line = br.readLine();
            try{
                splitLine = line.split("\\s",2);
                listName.add(splitLine[0]);
                listSalary.add(Double.parseDouble(splitLine[1]));
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        br.close();
        if(listName.size() == listSalary.size()){
            for (int i = 0; i <listName.size()-1 ; i++) {
                for (int j = i+1; j <listName.size() ; j++) {
                    if(listName.get(i).equals(listName.get(j))){
                        listSalary.set(i, listSalary.get(i) + listSalary.get(j));
                        listName.remove(j);
                        listSalary.remove(j);
                    }
                }
            }
        }
        Map<String,Double> employeeMap = new TreeMap<>();
        for (int i = 0; i <listName.size() ; i++) {
            employeeMap.put(listName.get(i),listSalary.get(i));
        }
        for (Map.Entry<String, Double> map : employeeMap.entrySet()
             ) {
            System.out.println(map.getKey() + " "+ map.getValue());
        }


    }
}
