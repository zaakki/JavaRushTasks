package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.ResourceBundle;

class WithdrawCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + ".withdraw_en");
     //1. Реализуй следующий алгоритм для команды WithdrawCommand:
     //1.1. Считать код валюты (метод уже есть).
     //1.2. Получить манипулятор для этой валюты.
     //1.3. Пока пользователь не введет корректные данные выполнять:
     //1.3.1. Попросить ввести сумму.
     //1.3.2. Если введены некорректные данные, то сообщить об этом пользователю и вернуться к п. 1.3.
     //1.3.3. Проверить, достаточно ли средств на счету.
     //Для этого в манипуляторе создай метод boolean isAmountAvailable(int expectedAmount), который вернет true, если денег достаточно для выдачи.
     //Если недостаточно, то вернуться к п. 1.3.

    ///before=Withdrawing...
    //success.format=%d %s was withdrawn successfully
    //specify.amount=Please specify integer amount for withdrawing.
    //specify.not.empty.amount=Please specify valid positive integer amount for withdrawing.
    //not.enough.money=Not enough money on your account, please try again
    //exact.amount.not.available=Exact amount is not available
    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        ConsoleHelper.writeMessage("Choose your currency code");
        String code = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);
        //
        int sum;
        while (true){
            ConsoleHelper.writeMessage(res.getString("specify.amount"));
            String ans = ConsoleHelper.readString();
            try {
                sum = Integer.parseInt(ans);
            }catch (NumberFormatException e){
                ConsoleHelper.writeMessage("Incorrect value");
                continue;
            }
            if(sum <= 0 ){
                ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
                continue;
            }
            if(!currencyManipulator.isAmountAvailable(sum)) {
                ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                continue;
            }
            try {
                currencyManipulator.withdrawAmount(sum);
            }catch (NotEnoughMoneyException e){
                ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
                continue;
            }
            ConsoleHelper.writeMessage(String.format(res.getString("success.format"), sum, code));
            break;

        }

    }
}
