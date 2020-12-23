package com.javarush.task.task06.task0602;

/* 
Пустые кошки, пустые псы
*/

public class Cat {
    public static void main(String[] args) {
     
    }
    
  

    //напишите тут ваш код
    protected void finalize(){
        System.out.println("A Cat was destroyed");
    }
    public Cat(){
        
    }

}

class Dog {
    //напишите тут ваш код
    public Dog(){
        
    }
    protected void finalize(){
        System.out.println("A Dog was destroyed");
    }
}
