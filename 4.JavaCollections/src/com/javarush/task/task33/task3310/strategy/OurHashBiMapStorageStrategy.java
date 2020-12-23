package com.javarush.task.task33.task3310.strategy;

import java.util.HashMap;

public class OurHashBiMapStorageStrategy implements StorageStrategy {
    //Добавь в него два поля HashMap<Long, String> k2v и HashMap<String, Long> v2k.
    HashMap<Long,String> k2v = new HashMap<>();
    HashMap<String, Long> v2k = new HashMap<>();

    //3. Метод containsKey должен проверять содержится ли полученный параметр в k2v.
    //4. Метод containsValue должен проверять содержится ли полученный параметр в v2k.
    //5. Метод put должен добавлять пару (key, value) в k2v и пару (value, key) в v2k.
    //6. Метод getValue должен возвращать значение полученное из k2v.
    //7. Метод getKey должен возвращать значение полученное из v2k.
    @Override
    public boolean containsKey(Long key) {
        return k2v.containsKey(key);
    }

    @Override
    public boolean containsValue(String value) {
        return v2k.containsKey(value);
    }

    @Override
    public void put(Long key, String value) {
        k2v.put(key,value);
        v2k.put(value,key);
    }

    @Override
    public Long getKey(String value) {
        return v2k.get(value);
    }

    @Override
    public String getValue(Long key) {
        return k2v.get(key);
    }
}
