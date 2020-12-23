package com.javarush.task.task38.task3803;

/* 
Runtime исключения (unchecked exception)
*/

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        Object x = new Integer(5);
        System.out.println((String)x);

    }

    public void methodThrowsNullPointerException() {
        ((Object) null).toString();
    }

    public static void main(String[] args) {
        VeryComplexClass veryComplexClass = new VeryComplexClass();
        veryComplexClass.methodThrowsNullPointerException();
    }
}
