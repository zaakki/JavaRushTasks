package com.javarush.task.task06.task0614;
import java.util.ArrayList;
/* 
Статические коты
*/

public class Cat {
    //напишите тут ваш код
    public static ArrayList<Cat> cats = new ArrayList<>();

    public Cat() {
    }

    public static void main(String[] args) {
        //напишите тут ваш код
        Cat[] cat = new Cat[10];
        for (int i = 0; i < cat.length; i++){
            cat[i] = new Cat();
        cats.add(cat[i]);    
         
         }
         printCats();
    }

    public static void printCats() {
        //напишите тут ваш код
        for(int i = 0; i < 10;i++)
         System.out.println(cats.get(i));
    }
}
