package com.javarush.task.task05.task0502;                                                  
                                                  
/*                                                   
Реализовать метод fight                                                  
*/                                                  
                                                  
public class Cat {                                                  
    public int age;                                                  
    public int weight;                                                  
    public int strength;                                                  
                                                  
    public Cat() {                                                  
    }                                                  
                                                      
                                              
                                                         
                                                          
                                                  
                                  
    public boolean fight(Cat anotherCat) {                                                  
        //напишите тут ваш код                                                  
        int count = 0;                                                  
        if (anotherCat.age < this.age)                                                  
           count++;                                                  
        else if (this.age < anotherCat.age)                                                  
            count--;                                                  
        else count = count;                                                  
        if (anotherCat.weight < this.weight)                                                  
            count++;                                                  
        else if(this.weight < anotherCat.weight)                                                   
            count--;                                                  
        else count=count;                                                  
        if(anotherCat.strength < this.strength)                                                  
            count++;                                                  
        else if(this.strength < anotherCat.strength)                                                  
            count--;                                                  
        else count=count;                                                  
        if(count > 0 )                                                  
           return true;                                                  
        else                                                  
          return false;                                                  
                                                  
                                                          
                                                      
                                                         
    }                                                  
                                                  
    public static void main(String[] args) {                                                  
                                                          
                                                  
    }                                                  
}