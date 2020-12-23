package com.javarush.task.task37.task3711;

public class Computer {
    //1) Создай класс Computer в котором создай и инициализируй поля типов CPU, Memory и HardDrive.
    //2) В классе Computer реализуй метод void run(), в котором вызови необходимые методы у объектов CPU, Memory и HardDrive.
    //3) Удали содержимое метода main класса Solution, после чего добавь туда создание нового компьютера и его запуск.
    private CPU cpu = new CPU();
    private Memory memory = new Memory();
    private HardDrive hardDrive = new HardDrive();

    public void run(){
        cpu.calculate();
        memory.allocate();
        hardDrive.storeData();
    }
}
