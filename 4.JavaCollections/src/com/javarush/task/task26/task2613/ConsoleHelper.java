package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

public class ConsoleHelper {

    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + ".common_en");
    //1. Создай в ConsoleHelper два статических метода:
    //1.1 writeMessage(String message), который будет писать в консоль наше сообщение.
    //1.2 String readString(), который будет считывать с консоли строку и возвращать ее.
    //Если возникнет какое-то исключение при работе с консолью, то перехватим его и не будем обрабатывать.
    //Кстати, создадим только один экземпляр BufferedReader-а, в статическом поле bis.
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
    public static void writeMessage(String message){
        System.out.println(message);
    }
    public static String readString() throws InterruptOperationException {
        String input = "";
        try {
            input = bis.readLine();
            if(input.equalsIgnoreCase("exit")) {
                throw new InterruptOperationException();
            }
        } catch (IOException e) {
        }
        return input;
    }
    //2. Чтобы считать код валюты, добавим статический метод String askCurrencyCode() в ConsoleHelper.
    //Этот метод должен предлагать пользователю ввести код валюты, проверять, что код содержит 3 символа.
    //Если данные некорректны, то сообщить об этом пользователю и повторить.
    //Если данные валидны, то перевести код в верхний регистр и вернуть.
    public static String askCurrencyCode() throws InterruptOperationException {
        writeMessage(res.getString("choose.currency.code"));
        String code = readString();
        while (code.length() != 3){
           writeMessage("Your code must be 3 character, please repeat");
            code = readString();
        }
        code = code.toUpperCase();
        return code;
    }
    //3. Чтобы считать номинал и количество банкнот,
    // добавим статический метод String[] getValidTwoDigits(String currencyCode) в ConsoleHelper.
    //Этот метод должен предлагать пользователю ввести два целых положительных числа.
    //Первое число - номинал, второе - количество банкнот.
    //Никаких валидаторов на номинал нет. Т.е. 1200 - это нормальный номинал.
    //Если данные некорректны, то сообщить об этом пользователю и повторить.
    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        writeMessage(res.getString("choose.denomination.and.count.format"));
        String[] input;
        //Убедись, что метод getValidTwoDigits(String currencyCode) считывает с консоли два положительных числа
        // (одна строка разделена пробелом),
        // если данные не корректны метод должен сообщить об этом пользователю (вывести сообщение в консоль) и повторить.
        while (true){
            input = readString().split(" ");
            if(input.length != 2) {
                writeMessage(res.getString("invalid.data"));
                continue;
            }
            int denomination = 0;
            int banknotes = 0;
            try {
                denomination = Integer.parseInt(input[0]);
                banknotes = Integer.parseInt(input[1]);
            } catch (Exception e){
                writeMessage("Error, please repeat again");
                continue;
            }
            if(denomination <=0 || banknotes<=0){
                writeMessage("Error, please repeat again");
                continue;
            }
            break;
        }
        return input;
    }
// В классе ConsoleHelper реализуй логику статического метода Operation askOperation().
//Спросить у пользователя операцию.
//Если пользователь вводит 1, то выбирается команда INFO, 2 - DEPOSIT, 3 - WITHDRAW, 4 - EXIT;
//Используйте метод, описанный в п.1.
//Обработай исключение - запроси данные об операции повторно.
    public static Operation askOperation() throws InterruptOperationException{
        do {
            writeMessage(res.getString("choose.operation"));
            printOperationList();
            String operation;
            try {
                operation = readString();
                return Operation.getAllowableOperationByOrdinal(Integer.parseInt(operation));
            }catch (Exception e){
                writeMessage("Incorrect entry, please repeat");
               continue;
            }
        } while (true);
    }

    private static void printOperationList() {
        writeMessage(res.getString("operation.INFO") + " - 1");
        writeMessage(res.getString("operation.DEPOSIT") + " - 2");
        writeMessage(res.getString("operation.WITHDRAW") + " - 3");
        writeMessage(res.getString("operation.EXIT") + " - 4");
    }
    public static void printExitMessage(){
        writeMessage(res.getString("the.end"));
    }

}
