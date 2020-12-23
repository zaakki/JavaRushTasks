package com.javarush.task.task06.task0613;

/* 
Кот и статика
*/

public class Solution {
    public static void main(String[] args) {
        // Создай 10 котов
        Cat[] cat = new Cat[10];
        for(int i = 0; i < 10; i++)
          cat[i] = new Cat();
           
        System.out.println(Cat.catCount);

        // Выведи значение переменной catCount
    }

    public static class Cat {
        // Создай статическую переменную catCount
        public static int catCount = 0;
        
        public Cat(){
            catCount++;
        }

        // Создай конструктор
    }
}
