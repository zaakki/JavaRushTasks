package com.javarush.task.task08.task0820;

import java.util.HashSet;
import java.util.Set;

/* 
Множество всех животных
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);
        printPets(pets);

        removeCats(pets, cats);
        printPets(pets);
    }

    public static Set<Cat> createCats() {
        Set<Cat> cat = new HashSet<Cat>();

        //напишите тут ваш код
        cat.add(new Cat());
        cat.add(new Cat());
        cat.add(new Cat());
        cat.add(new Cat());

        return cat;
    }

    public static Set<Dog> createDogs() {
        //напишите тут ваш код
        Set<Dog> dog = new HashSet<Dog>();
        
        dog.add(new Dog());
        dog.add(new Dog());
        dog.add(new Dog());
        
        return dog;
    }

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs) {
        //напишите тут ваш код
        Set<Object> pet = new HashSet<>();
        pet.addAll(cats);
        pet.addAll(dogs);
        return pet;
    }

    public static void removeCats(Set<Object> pets, Set<Cat> cats) {
        //напишите тут ваш код
        if(pets.containsAll(cats))
            pets.removeAll(cats);
    }

    public static void printPets(Set<Object> pets) {
        //напишите тут ваш код
        for(Object p : pets){
            System.out.println(p);
        }
    }

    //напишите тут ваш код
    public static class Cat{}
    public static class Dog{}
}
