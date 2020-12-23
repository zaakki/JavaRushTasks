package com.javarush.task.task05.task0527;

/* 
Том и Джерри
*/

public class Solution {
    public static void main(String[] args) {
        Mouse jerryMouse = new Mouse("Jerry", 12, 5);

        //напишите тут ваш код
        Cat tomCat = new Cat("Tom", 16, "Blue");
        Dog dogSpike = new Dog("Spike", 20, "Grey");
        
    }

    public static class Mouse {
        String name;
        int height;
        int tail;

        public Mouse(String name, int height, int tail) {
            this.name = name;
            this.height = height;
            this.tail = tail;
        }
    }

    //напишите тут ваш код
    public static class Cat {
        String name, color;
        int age;
        
        public Cat(String name, int age, String color){
            this.name = name;
            this.age = age;
            this.color = color;
        }
    }
    
    public static class Dog {
        String name, color;
        int height;
        
        public Dog (String name, int height, String color){
            this.name = name;
            this.height = height;
            this.color = color;
        }
    }
    
}
