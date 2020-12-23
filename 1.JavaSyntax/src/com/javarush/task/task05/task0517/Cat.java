package com.javarush.task.task05.task0517;

/* 
Конструируем котиков
*/

public class Cat {
    //напишите тут ваш код
    String name, color, address;
    int weight, age;
    
    private static int cAge = 3, cWeight = 5;
    private static String cColor = "black";
    
    
    public Cat(String name){
        this.name = name;
        age = cAge;
        weight = cWeight;
        color = cColor;
        address = null;
    }
    public Cat(String name, int weight, int age){
        this.name = name;
        this.weight = weight;
        this.age = age;
        address = null;
        color = cColor;
    }
    public Cat(String name, int age){
        this.name = name;
        this.age = age;
        weight = cWeight;
        address = null;
        color = cColor;
    }
    public Cat(int weight, String color){
        this.weight = weight;
        this.color = color;
        age = cAge;
        name = null;
        address = null;
    }
    public Cat(int weight, String color, String address){
        age = cAge;
        this.color = color;
        this.address = address;
        this.weight = weight;
        name = null;
    }

    public static void main(String[] args) {

    }
}
