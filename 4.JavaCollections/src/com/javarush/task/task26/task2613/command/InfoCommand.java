package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;

import java.util.ResourceBundle;

class InfoCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + ".info_en");

    //2.2. В InfoCommand в цикле выведите [код валюты - общая сумма денег для выбранной валюты].
    //Запустим прогу и пополним счет на EUR 100 2 и USD 20 6, и посмотрим на INFO.
    //
    //Все работает правильно?
    //EUR - 200
    //USD - 120
    //Отлично!
    // В InfoCommand используй метод п.3. и выведите фразу "No money available.", если нет денег в банкомате.
    @Override
    public void execute() {
        boolean money = false;
        ConsoleHelper.writeMessage(res.getString("before"));
        for (CurrencyManipulator manipulator : CurrencyManipulatorFactory.getAllCurrencyManipulators()) {
            if (manipulator.hasMoney()) {
                if (manipulator.getTotalAmount() > 0) {
                    ConsoleHelper.writeMessage(manipulator.getCurrencyCode() + " - " + manipulator.getTotalAmount());
                    money = true;
                }
            }
        }
        if (!money) {
            ConsoleHelper.writeMessage(res.getString("no.money"));
        }
    }
}
