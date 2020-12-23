package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.*;

public class CurrencyManipulator {
    //Класс должен содержать:
    //1.1 String currencyCode - код валюты, например, USD. Состоит из трех букв.
    //1.2 Map<Integer, Integer> denominations - это Map<номинал, количество>.
    //Чтобы можно было посмотреть, к какой валюте относится манипулятор, добавим геттер для currencyCode.
    //Очевидно, что манипулятор никак не может функционировать без названия валюты,
    // поэтому добавим конструктор с этим параметром и проинициализируем currencyCode.
    private String currencyCode;
    private Map<Integer, Integer> denominations = new TreeMap<>();

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }
    //. В классе CurrencyManipulator создай метод void addAmount(int denomination, int count),
    // который добавит введенные номинал и количество банкнот.

    public void addAmount(int denomination, int count) {
        if (denominations.containsKey(denomination))
            denominations.put(denomination, denominations.get(denomination) + count);
        else
            denominations.put(denomination, count);
    }

    //.В предыдущем таске мы реализовали основную логику операции DEPOSIT.
    //Но посмотреть результат так и не удалось.
    //Поэтому создай в манипуляторе метод int getTotalAmount(), который посчитает общую сумму денег для выбранной валюты.
    public int getTotalAmount() {
        int sum = 0;
        for (Map.Entry<Integer, Integer> pair : denominations.entrySet()) {
            sum += pair.getKey() * pair.getValue();
        }
        return sum;
    }
    //Запустим прогу и сразу первой операцией попросим INFO. Ничего не вывело? Непорядок.
    //Добавь в манипулятор метод boolean hasMoney(), который будет показывать, добавлены ли какие-то банкноты или нет.

    public boolean hasMoney() {
        return denominations.size() != 0;
    }

    public boolean isAmountAvailable(int expectedAmount) {
        return expectedAmount <= getTotalAmount();
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException {
        int sum = expectedAmount;
        HashMap<Integer, Integer> temp = new HashMap<>(denominations);
        ArrayList<Integer> banknotes = getBanknotesList(temp);

        TreeMap<Integer, Integer> res = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        sum = getSum(sum, temp, banknotes, res);
        if (sum > 0)
            throw new NotEnoughMoneyException();
        else {
            for (Map.Entry<Integer, Integer> pair : res.entrySet()) {
                ConsoleHelper.writeMessage("\t" + pair.getKey() + " - " + pair.getValue());
                denominations.clear();
                denominations.putAll(temp);
                ConsoleHelper.writeMessage("Transaction was successful");
            }
        }
        return res;
    }

    private int getSum(int sum, HashMap<Integer, Integer> temp, ArrayList<Integer> banknotes, TreeMap<Integer, Integer> res) {
        for (Integer aList : banknotes) {
            int key = aList;
            int value = temp.get(key);
            while (true) {
                if (sum < key || value <= 0) {
                    temp.put(key, value);
                    break;
                }
                sum -= key;
                value--;
                if (res.containsKey(key)) {
                    res.put(key, res.get(key) + 1);
                } else res.put(key, 1);
            }
        }
        return sum;
    }

    private ArrayList<Integer> getBanknotesList(HashMap<Integer, Integer> temp) {
        ArrayList<Integer> banknotes = new ArrayList<>();
        for (Map.Entry<Integer, Integer> pair : temp.entrySet()) {
            banknotes.add(pair.getKey());
        }
        Collections.sort(banknotes);
        Collections.reverse(banknotes);
        return banknotes;
    }
}

