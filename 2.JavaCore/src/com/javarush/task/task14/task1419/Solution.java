package com.javarush.task.task14.task1419;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {//1
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }
        try{//2
            throw new CancellationException();
        } catch (Exception e2){
            exceptions.add(e2);
        }
        try {//3
            throw new IllegalStateException();
        } catch (Exception e3){
            exceptions.add(e3);
        }
        try {//4
            throw new NullPointerException();
        } catch (Exception e4){
            exceptions.add(e4);
        }
        try {//5
            throw  new NumberFormatException();
        } catch (Exception e5){
            exceptions.add(e5);
        }
        try {//6
            throw new ArrayIndexOutOfBoundsException();
        } catch (Exception e6){
            exceptions.add(e6);
        }
        try{//7
            throw new ArrayStoreException();
        }catch (Exception e7){
            exceptions.add(e7);
        }
        try {//8
            throw new RuntimeException();
        } catch (Exception e8){
            exceptions.add(e8);
        }
        try {//9
            throw new ClassCastException();
        } catch (Exception e9){
            exceptions.add(e9);
        }
        try{//10
            throw new IndexOutOfBoundsException();
        } catch (Exception e10){
            exceptions.add(e10);
        }

        //напишите тут ваш код
        //
    }
}
