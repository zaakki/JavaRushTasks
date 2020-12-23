package com.javarush.task.task35.task3512;

public class Generator<T> {
    //. Класс Generator должен иметь поле типа Class, которое параметризовано типом Т.
    //3. Класс Generator должен иметь конструктор, который инициализирует поле типа Class.
    //4. Метод newInstance в классе Generator должен создавать и возвращать объект типа Т.
    private Class<T> clazz;

    public Generator(Class<T> clazz) {
        this.clazz = clazz;
    }

    T newInstance() throws IllegalAccessException, InstantiationException {

        return (T) clazz.newInstance();
    }
}
