package com.javarush.task.task35.task3509;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/*
Collections & Generics
*/
public class Solution {
//Реализуй вспомогательныe методы в классе Solution,
// которые должны создавать соответствующую коллекцию и помещать туда переданные объекты.
//Методы newArrayList, newHashSet параметризируй типом T.
//Метод newHashMap параметризируй типами К(ключ) и V(значение).
// Аргументы метода newHashMap должны принимать списки, в которых содержатся наследники типов K и V.
//Возвращаемые коллекции должны быть такого же типа, что и переданные в метод объекты.
//
//Подсказка: в методе newHashMap нужно проверить чтобы списки ключей и значений совпадали по размерам,
// в противном случае кинь IllegalArgumentException.
    public static void main(String[] args) {
    }

    public static <T>ArrayList<T> newArrayList(T... elements) {
        //напишите тут ваш код
        ArrayList list = new ArrayList();
        for (T e: elements
             ) {
            list.add(e);
        }
        return list;
    }

    public static <T>HashSet<T> newHashSet(T... elements) {
        //напишите тут ваш код
        HashSet set = new HashSet();
        for (T e: elements
             ) {
            set.add(e);
        }
        return set;
    }

    public static <K,V>HashMap<K,V> newHashMap(List<? extends K> keys, List<? extends V> values) {
        //напишите тут ваш код
        HashMap<K,V> map = new HashMap<>();
        if(keys.size() == values.size()){
            for (int i = 0; i < keys.size() ; i++) {
                map.put(keys.get(i),values.get(i));
            }
        }else
            throw  new IllegalArgumentException();

        return map;
    }
}
