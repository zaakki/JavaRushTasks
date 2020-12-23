package com.javarush.task.task38.task3804;

/* 
Фабрика исключений
*/

public class Solution {
    public static Class getFactoryClass() {
        return ExceptionFactory.class;
    }

    public static void main(String[] args) {
        Throwable throwable = ExceptionFactory.getFactoryClass(ApplicationExceptionMessage.UNHANDLED_EXCEPTION);
        System.out.println(throwable.toString());
        throwable = ExceptionFactory.getFactoryClass(DatabaseExceptionMessage.NO_RESULT_DUE_TO_TIMEOUT);
        System.out.println(throwable.toString());
        throwable = ExceptionFactory.getFactoryClass(UserExceptionMessage.USER_DOES_NOT_EXIST);
        System.out.println(throwable.toString());
    }
}