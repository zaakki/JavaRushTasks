package com.javarush.task.task08.task0814;

import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static Set<Integer> createSet() {
        // напишите тут ваш код
        Set<Integer> setInt = new HashSet<>();
        for(int i = 0; i < 20; i++){
            setInt.add(i);
        }
        return setInt;
    }

    public static Set<Integer> removeAllNumbersGreaterThan10(Set<Integer> set) {
        // напишите тут ваш код
        Iterator<Integer> itr = set.iterator();
        while(itr.hasNext()){
            Integer num = itr.next();
            if(num > 10)
                itr.remove();
            
        }return set;

    }

    public static void main(String[] args) {

    }
}
