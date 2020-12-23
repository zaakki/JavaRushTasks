package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.ResourceBundle;

class LoginCommand implements Command{
    //1. В LoginCommand добавь поле private ResourceBundle validCreditCards.
    //При объявлении инициализируй это поле данными из файла verifiedCards.properties.
    //Почитай в инете, как это делается для ResourceBundle.
    //Важно: путь к ресурсу verifiedCards.properties строй динамически,
    // для этого используй у класса CashMachine метод getPackage()
    //2. Замени хардкоженные данные кредитной карточки и пина на проверку наличия данных
    // в ресурсе verifiedCards.properties.
   private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+".verifiedCards");
   private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + ".login_en");

    //. Реализуй следующую логику для команды LoginCommand:
    //4.1. Пока пользователь не введет валидные номер карты и пин - выполнять следующие действия:
    //4.2. Запросить у пользователя 2 числа - номер кредитной карты, состоящий из 12 цифр, и пин - состоящий из 4 цифр.
    //4.3. Вывести юзеру сообщение о невалидных данных, если они такими являются.
    //4.4. Если данные валидны, то проверить их на соответствие захардкоженным (123456789012 и 1234).
    //4.5. Если данные в п. 4.4. идентифицированы, то сообщить, что верификация прошла успешно.
    //4.6. Если данные в п. 4.4. НЕ идентифицированы, то вернуться к п.4.1.
    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        while (true){
            ConsoleHelper.writeMessage(res.getString("specify.data"));
            String num = ConsoleHelper.readString();
            String pin = ConsoleHelper.readString();
            if(validCreditCards.containsKey(num)){
                if(validCreditCards.getString(num).equals(pin)){
                    ConsoleHelper.writeMessage(String.format(res.getString("success.format"), num));
                }else {
                    ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"),num));
                    ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                    continue;
                }
            } else {
                ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), num));
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
                continue;
            }
            break;
        }
    }
}
