package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.*;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        StorageStrategy strategy = new HashMapStorageStrategy();
        testStrategy(strategy, 10000);
        StorageStrategy ourStrategy = new OurHashMapStorageStrategy();
        testStrategy(ourStrategy,10000);
        StorageStrategy fileStrategy = new FileStorageStrategy();
        //testStrategy(fileStrategy, 500);
        StorageStrategy biMapStrategy = new OurHashBiMapStorageStrategy();
        testStrategy(biMapStrategy,10000);
        StorageStrategy hashBiMapStrategy = new HashBiMapStorageStrategy();
        testStrategy(hashBiMapStrategy,10000);
        StorageStrategy dualBidiMapStrategy = new DualHashBidiMapStorageStrategy();
        testStrategy(dualBidiMapStrategy,10000);

    }

    ////Метод будет возвращать множество строк, которое соответствует переданному множеству идентификаторов.
    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> sets = new HashSet<>();
        for (String s : strings
        ) {
            sets.add(shortener.getId(s));
        }
        return sets;
    }

    //Метод будет возвращать множество строк, которое соответствует переданному множеству идентификаторов.
    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> stringSet = new HashSet<>();
        for (Long k : keys
        ) {
            stringSet.add(shortener.getString(k));
        }
        return stringSet;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        //6.2.3.1. Выводить имя класса стратегии. Имя не должно включать имя пакета.
        Helper.printMessage(strategy.getClass().getSimpleName());

        Set<String> stringSet = new HashSet<>();
        Long[] elements = new Long[(int) elementsNumber];

        //6.2.3.2. Генерировать тестовое множество строк, используя Helper и заданное количество элементов elementsNumber.
        for (int i = 0; i < elementsNumber; i++) {
            stringSet.add(Helper.generateRandomString());
        }
        //6.2.3.3. Создавать объект типа Shortener, используя переданную стратегию.
        Shortener shortener = new Shortener(strategy);
        //6.2.3.4. Замерять и выводить время необходимое для отработки метода getIds для заданной стратегии
        Date startDateTime = new Date();
        Set<Long> ids = getIds(shortener, stringSet);
        Date finishDateTime = new Date();

        long delta = finishDateTime.getTime() - startDateTime.getTime();
        Helper.printMessage("Time for create ids " + Long.toString(delta) + "ms");

        //6.2.3.5. Замерять и выводить время необходимое для отработки метода getStrings для заданной стратегии
        startDateTime = new Date();
        Set<String> strings = getStrings(shortener, ids);
        finishDateTime = new Date();

        delta = finishDateTime.getTime() - startDateTime.getTime();
        Helper.printMessage("Time for create strings " + Long.toString(delta) + "ms");

        //6.2.3.6. Сравнивать одинаковое ли содержимое множества строк
        if (stringSet.equals(strings)) {
            Helper.printMessage("Тест пройден.");
        } else {
            Helper.printMessage("Тест не пройден.");
        }


    }

    @Test
    public void testGetIds() {
        Set<String> stringSet = new HashSet<>();
        stringSet.add("32");
        stringSet.add("Hello ");
        stringSet.add("my");
        stringSet.add("name is");
        stringSet.add("32");
        HashMapStorageStrategy hashMapStorageStrategy = new HashMapStorageStrategy();
        Shortener shortener = new Shortener(hashMapStorageStrategy);
        System.out.println(getIds(shortener, stringSet));
    }
}
