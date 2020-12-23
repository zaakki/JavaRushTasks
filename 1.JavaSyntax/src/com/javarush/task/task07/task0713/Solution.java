package com.javarush.task.task07.task0713;
import java.io.*;

import java.util.ArrayList;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        ArrayList<Integer> list3 = new ArrayList<Integer>();
        ArrayList<Integer> list4 = new ArrayList<Integer>();
        
        for(int i = 0; i < 20; i++)
            list1.add(i, Integer.parseInt(reader.readLine()));
        for(int i = 0; i < 20; i++){
            Integer x = list1.get(i);
            if (x % 3 == 0)
                list2.add(x);
            if (x % 2 == 0)
                list3.add(x);
            if (x % 3 != 0 && x % 2 != 0)
                list4.add(x);
        }
        printList(list2);
        printList(list3);
        printList(list4);
            
    }

    public static void printList(ArrayList<Integer> list) {
        //напишите тут ваш код
        for(int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));
    }
}
