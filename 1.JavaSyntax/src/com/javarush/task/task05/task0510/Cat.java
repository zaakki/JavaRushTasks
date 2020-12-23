package com.javarush.task.task05.task0510;

/* 
Кошкоинициация
*/

public class Cat {
    //напишите тут ваш код
    String name, address, color;
    int age, weight;
    public void initialize(String name){
        this.name = name;
        weight = 5;
        age = 3;
        color = "black";
        address = null;
    }
    public void initialize(String name, int weight, int age){
        this.name = name;
        this.weight = weight;
        this.age = age;
        color = "black";
        address = null;
    }
    public void initialize(String name, int age){
        this.name = name;
        this.age = age;
        weight = 5;
        color = "black";
        address = null;
    }
    public void initialize(int weight, String color){
        this.weight = weight;
        this.color = color;
        name = null;
        address = null;
        age = 5;
    }
    public void initialize(int weight, String color, String address){
        this.weight = weight;
        this.color = color;
        this.address = address;
        name = null;
        age = 5;
    }

    public static void main(String[] args) {

    }
}
