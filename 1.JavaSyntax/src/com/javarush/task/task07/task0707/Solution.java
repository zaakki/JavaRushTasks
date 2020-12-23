package com.javarush.task.task07.task0707;
import java.util.ArrayList;

/* 
Что за список такой?
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<>();
        list.add(0, "Как прекрасен этот мир");
        list.add(1, "Посмотри");
        list.add(2, "Как ужасен этот цвет");
        list.add(3, "Погляди");
        list.add(4, "Это Java код");
        System.out.println(list.size());
        for(int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));
    }
}
