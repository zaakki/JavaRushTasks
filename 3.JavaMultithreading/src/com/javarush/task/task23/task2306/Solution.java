package com.javarush.task.task23.task2306;

/* 
Inner 2
Требования:
1. Класс SuperUser должен быть приватным.
2. Класс SuperUser должен содержать метод getDescription.
3. Метод getDescription в классе SuperUser должен быть публичным.
4. Метод getDescription в классе SuperUser должен возвращать строку учитывающую имя, страну и город пользователя форматированную согласно условию задачи.
5. Метод getTrickyUser должен возвращать объект типа SuperUser.
*/
public class Solution {
    private String country;
    private String city;

    public Solution(String country, String city) {
        this.country = country;
        this.city = city;
    }

    /*т.к. модификатор иннер класса private, то чтобы вызвать метод getDescription из другого внешнего класса,
    нужно обернуть его вызов в какой-то public метод*/
    public String getUserDescription(String name) {
        return getTrickyUser(name).getDescription();
    }

    public SuperUser getTrickyUser(String name) {
        return new SuperUser(name);
    }

    private class SuperUser {
        private String name;

        //доступ к этому методу возможен только внутри класса Solution, т.к. модификатор иннер класса private
        public SuperUser(String name) {
            this.name = name;
        }

        //доступ к этому методу возможен только внутри класса Solution, т.к. модификатор иннер класса private
        //My name is George. I'm from Seattle in the United States.
        public String getDescription() {
            Solution sol = new Solution(country,city);
            return String.format("My name is %s. I'm from %s in %s.", this.name,sol.city, sol.country);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution("the United States", "Seattle");
        //внутри класса Solution (а сейчас мы внутри) к методу getDescription можно обращаться обоими способами
        System.out.println(solution.getTrickyUser("George").getDescription());
        //а из любого другого внешнего класса только так:
        System.out.println(solution.getUserDescription("George"));
    }
}
