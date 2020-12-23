package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line = "";//резервируем строку для записи из файла
        String[] splitLine = new String[2];//так как мы знаем что будет 2 параметра Фамилия и Оплата то резервируем 2 места
        List<String> listName = new ArrayList<>();//резервируем место под наш будущий список имен
        List<Double> listSalary = new ArrayList<>();//резервируем место под наш будущий список зп
        Map<String, Double> employeeMap = new TreeMap<>();//так как сотрудник уникален создаем мапу с параметрами Фамилия и зп
        while (br.ready()){
            line = br.readLine(); //записываем все считаное в нашу строку
            try{
                splitLine = line.split(" ",2);//делим строку на 2 по пробелу, для выделения фамилии и зп
                listName.add(splitLine[0]);//добавляем в наш список фамилий, сотрудника
                listSalary.add(Double.parseDouble(splitLine[1]));//добавляем в наш список зп, зп нового сотрудника
            } catch (Exception e){

            }
        }
        br.close();
        //Теперь надо  посчитать все оплату для сотрудника.
        if(listName.size() == listSalary.size()) {// проверяем что бы наши списки были одинаковые
            for (int i = 0; i < listName.size() - 1; i++) {
                for (int j = i + 1; j < listName.size(); j++) {
                    //Проверяем есть ли выплаты сотруднику более чем 1 раз
                    if (listName.get(i).equals(listName.get(j))) {
                        listSalary.set(i, listSalary.get(i) + listSalary.get(j));//суммируем выплаты
                        listSalary.remove(j);//удаляем информацию о доп выплате
                        listName.remove(j);//удаляем дублирование фамилии
                    }
                }
            }
        }
        for (int i = 0; i <listName.size() ; i++) {
            employeeMap.put(listName.get(i),listSalary.get(i));//записываем данные в нашу карту
        }
        double maxSalary = Double.MIN_VALUE;//создаем переменную для сравнения
        for (Map.Entry<String, Double> map :employeeMap.entrySet()
             ) {
            if(map.getValue()>maxSalary)
                maxSalary = map.getValue();//присваиваем ранее созданой переменной значение переменной нашей картый
        }
        for (Map.Entry<String, Double> map: employeeMap.entrySet()
             ) {
            if(map.getValue()==maxSalary){
                System.out.println(map.getKey());//выписываем фамилию сотрудника(ов) с максимальной зп
            }
        }

    }
}
