package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // Напишите тут ваши переменные и конструкторы
        private String name;
        private String parent;
        private boolean sex;
        private int age;
        private String job;
        private String address;
        
        public Human(){
            
        }
        public Human(String name, String parent, boolean sex, int age,
        String job, String address){
            this.name = name;
            this.parent = parent;
            this.sex = sex;
            this.age = age;
            this.job = job;
            this.address = address;
            
        }
        public Human(String name, boolean sex, int age){
            this.name = name;
            this.sex = sex;
            this.age =age;
        }
        public Human(String name, String parent, boolean sex, int age){
            this.name = name;
            this.parent = parent;
            this.sex = sex;
            this.age = age;
        }
        public Human(String name, String parent, boolean sex, int age, String address ){
            this.name = name;
            this.parent = parent;
            this.sex = sex;
            this.age = age;
            this.address = address;
        }
        public Human(String name, String parent, int age, boolean sex, String job){
            this.name = name;
            this.parent = parent;
            this.age = age;
            this.sex = sex;
            this.job = job;
        }
        public Human(String name, boolean sex, int age, String address){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.address = address;
        }
        public Human(String name, int age, boolean sex, String job){
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.job = job;
        }
        public Human(String name, int age){
            this.name = name;
            this.age = age;
        }
        public Human(String name, String parent, int age){
            this.name = name;
            this.parent = parent;
            this.age = age;
        }
    }
}
