package com.javarush.task.task15.task1522;

public class LazyInitializedSingleton {
    private static LazyInitializedSingleton instance;//field solo object

    private LazyInitializedSingleton(){}//private base constructor for close public access and block create new object

    public static LazyInitializedSingleton getInstance(){ // method for create/return Object
        if(instance == null){//if instance null?
            instance = new LazyInitializedSingleton();//create new Object
        }
        return instance; // return early created object
    }
}
