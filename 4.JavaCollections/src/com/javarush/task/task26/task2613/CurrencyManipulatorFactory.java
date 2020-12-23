package com.javarush.task.task26.task2613;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

abstract public class CurrencyManipulatorFactory {
    //2. Валют может быть несколько, поэтому нам понадобится фабрика, которая будет создавать и хранить манипуляторы.
//Создай класс CurrencyManipulatorFactory со статическим методом getManipulatorByCurrencyCode(String currencyCode).
//В этом методе будем создавать нужный манипулятор, если он еще не существует, либо возвращать ранее созданный.
//Регистр при поиске манипулятора валюты не должен учитываться.
//Подумай, где лучше хранить все манипуляторы? Маленькая подсказка, поле должно называться map.
//
//Сделайте так, чтобы невозможно было создавать объекты CurrencyManipulatorFactory класса.
    private static Map<String, CurrencyManipulator> map = new TreeMap<>();

    private CurrencyManipulatorFactory() {
    }

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {
        currencyCode = currencyCode.toUpperCase();
        if (!map.containsKey(currencyCode))
            map.put(currencyCode, new CurrencyManipulator(currencyCode));

        return map.get(currencyCode);
    }

    //2.1. В классе CurrencyManipulatorFactory создай статический метод getAllCurrencyManipulators(),
    // который вернет Collection всех манипуляторов.
    //У тебя все манипуляторы хранятся в карте, не так ли? Если нет, то отрефактори.
    public static Collection<CurrencyManipulator> getAllCurrencyManipulators() {
        return map.values();
    }
}
