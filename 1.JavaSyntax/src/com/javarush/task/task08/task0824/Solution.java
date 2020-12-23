package com.javarush.task.task08.task0824;
import java.util.*;
/* 
Собираем семейство
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human child1 = new Human("Mike", 3, true, new ArrayList<>());
        Human child2 = new Human("Sophia", 7, false, new ArrayList<>());
        Human child3 = new Human("Joseph", 2, true, new ArrayList<>());
        
        Human dad = new Human("Silver", 35,true, new ArrayList<>(Arrays.asList(child1, 
                                                                child2, child3)));
        Human mother = new Human("Stacy", 30, false, new ArrayList<>(Arrays.asList(child1,
                                                                child2, child3)));
                                                                
        Human grandPa = new Human("Rodger", 63, true, new ArrayList<>(Arrays.asList(dad)));
        Human grandMa = new Human("Rosa", 60, false, new ArrayList<>(Arrays.asList(dad)));
        Human grandPa2 = new Human("Dragon", 61, true, new ArrayList<>(Arrays.asList(mother)));
        Human grandMa2 = new Human("Michel", 59, false, new ArrayList<>(Arrays.asList(mother)));
        ArrayList<Human> humans = new ArrayList<>();
        humans.add(grandPa);
        humans.add(grandMa);
        humans.add(grandPa2);
        humans.add(grandMa2);
        humans.add(dad);
        humans.add(mother);
        humans.add(child1);
        humans.add(child2);
        humans.add(child3);
        
         for (Human h : humans
             ) {
            System.out.println(h);
        }
    }

    public static class Human {
        //напишите тут ваш код
        String name;
        int age;
        boolean sex;
        ArrayList<Human> children;
        
        Human(String name, int age, boolean sex, ArrayList<Human> children){
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.children = children;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}
