package com.javarush.task.task07.task0724;
import java.util.ArrayList;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
     ArrayList<Human> list = new ArrayList<>();
        Human grandPa1 = new Human("Федор", true, 62);
        Human grandPa2 = new Human("Виталий", true, 58);
        Human grandMa1 = new Human("Таисия", false, 59);
        Human grandMa2 = new Human("София", false, 53);

        Human father = new Human("Петр", true, 35, grandPa1, grandMa1);
        Human mother = new Human("Виктория", false, 30, grandPa2, grandMa2);

        Human son1 = new Human("Дмитрий", true, 12, father, mother);
        Human dougther  = new Human("Аня", false, 10, father, mother);
        Human son2 = new Human("Валерий", true, 2, father, mother);

        list.add(grandPa1);
        list.add(grandMa1);
        list.add(grandPa2);
        list.add(grandMa2);
        list.add(father);
        list.add(mother);
        list.add(son1);
        list.add(dougther);
        list.add(son2);

        for (Human s: list) {
            System.out.println(s);
        }

    }

    public static class Human {
        // напишите тут ваш код
        String name;
        int age;
        boolean sex;
        Human father;
        Human mother;

        public Human(String name, int age, boolean sex){
            this.name = name;
            this.age = age;
            this.sex = sex;
        }
        public Human(String name, boolean sex, int age){
            this.name = name;
            this.age = age;
            this.sex = sex;
        }
        public Human (String name, int age, boolean sex, Human father, Human mother){
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.father = father;
            this.mother = mother;
        }
        public Human(String name, boolean sex, int age, Human father, Human mother){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null) {
                text += ", отец: " + this.father.name;
            }

            if (this.mother != null) {
                text += ", мать: " + this.mother.name;
            }

            return text;
        }
    }
}