package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.Operation;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.Map;
import java.util.TreeMap;

public class CommandExecutor {
    //Создай ему статическую карту Map<Operation, Command> allKnownCommandsMap,
    // которую проинициализируй всеми известными нам операциями и командами.
    private static final Map<Operation, Command> allKnownCommandsMap;

    static {
        allKnownCommandsMap = new TreeMap<>();
        allKnownCommandsMap.put(Operation.INFO, new InfoCommand());
        allKnownCommandsMap.put(Operation.DEPOSIT, new DepositCommand());
        allKnownCommandsMap.put(Operation.WITHDRAW, new WithdrawCommand());
        allKnownCommandsMap.put(Operation.EXIT, new ExitCommand());
        allKnownCommandsMap.put(Operation.LOGIN, new LoginCommand());
    }

    //4.1 Создай метод public static final void execute(Operation operation),
    // который будет дергать метод execute у нужной команды.
    //Реализуй эту логику.
    //4.2. Расставь правильно модификаторы доступа учитывая, что единственная точка входа - это метод execute.
    //
    //Проверяем, чтоб структура соответствовала тестам на сервере.
    //Логику будем переносить в следующем таске.
    private CommandExecutor() {

    }

    public static final void execute(Operation operation) throws InterruptOperationException {
        allKnownCommandsMap.get(operation).execute();
    }
}
