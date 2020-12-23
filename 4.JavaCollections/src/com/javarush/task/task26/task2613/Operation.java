package com.javarush.task.task26.task2613;

public enum Operation {
    LOGIN,INFO, DEPOSIT, WITHDRAW,EXIT;
    //Итак, назовем эту операцию LOGIN и сделаем для нее команду.
    //1. Добавь в операции LOGIN с ординал = 0
    //2. Запрети пользователю выбирать эту операцию из списка.
    //В единственном методе для поиска операций запрети доступ по ординал - бросим IllegalArgumentException.


    //1. В энум Operation добавь статический метод Operation getAllowableOperationByOrdinal(Integer i)
    //Должен возвращать элемент энума: для 1 - INFO, 2 - DEPOSIT, 3 - WITHDRAW, 4 - EXIT;
    //На некорректные данные бросать IllegalArgumentException.
    public static Operation getAllowableOperationByOrdinal(Integer i){

        switch (i){
            case 1:
                return INFO;
            case 2:
                return DEPOSIT;
            case 3:
                return WITHDRAW;
            case 4:
                return EXIT;
            case 0:
            default: throw new IllegalArgumentException();
        }
    }
}
