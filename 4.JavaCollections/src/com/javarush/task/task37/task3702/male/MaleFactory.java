package com.javarush.task.task37.task3702.male;

import com.javarush.task.task37.task3702.AbstractFactory;
import com.javarush.task.task37.task3702.Human;

//Создай публичный класс MaleFactory в пакете male с публичным методом getPerson,
// который принимает один параметр int age (возраст) и возвращает нужный объект одного из классов, реализующих интерфейс Human.
//
//2. Логика метода getPerson: используя константу MAX_AGE определи, какой класс соответствует переданному возрасту.
//Например, age=4 соответствует мальчику (KidBoy), age=15 - подростку (TeenBoy), остальной возраст - взрослому мужчине.
//
//3. В методе main класса Solution создай фабрику и вызови у нее метод getPerson три раза с такими параметрами: 99, 4, 15.
//
//Выведи результат в консоль.
//Вывод должен быть следующий:
//Man{}
//KidBoy{}
//TeenBoy{}
//
//Молодец, Фабрика готова! Это паттерн Factory Method.
public class MaleFactory implements AbstractFactory {

    public Human getPerson(int age){
        Human o;
        if(age <= KidBoy.MAX_AGE)
           o = new KidBoy();
        else if(age > KidBoy.MAX_AGE && age <= TeenBoy.MAX_AGE)
            o = new TeenBoy();
        else
            o = new Man();
        return o;
    }

}
