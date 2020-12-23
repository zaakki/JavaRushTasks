package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.command.CommandExecutor;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.Locale;

public class CashMachine {
    public final static String RESOURCE_PATH =CashMachine.class.getPackage().getName() + ".resources.";
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);


//Метод main класса CashMachine должен считывать с консоли код валюты,
// потом считывать номинал и количество банкнот, а потом добавлять их в манипулятор.
        try {
            Operation operation;
            CommandExecutor.execute(Operation.LOGIN);
            do {
                operation = ConsoleHelper.askOperation();
                CommandExecutor.execute(operation);
            } while (operation != Operation.EXIT);
        } catch (InterruptOperationException e) {
        }
        ConsoleHelper.printExitMessage();


    }
}
// Давай запустим прогу и пополним счет на EUR 100 2 и USD 20 6, и посмотрим на INFO.
//Ничего не понятно, т.к. создались 2 манипулятора: первый для EUR, второй для USD.
//Давай улучшим логику InfoCommand. Надо вывести баланс по каждому манипулятору.
