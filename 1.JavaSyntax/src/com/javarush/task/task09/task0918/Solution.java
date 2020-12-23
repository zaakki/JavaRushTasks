package com.javarush.task.task09.task0918;
import java.io.IOException;
import java.io.FileNotFoundException;

/* 
Все свои, даже исключения
*/

public class Solution {
    public static void main(String[] args) {
    }

    static class MyException extends NullPointerException {
    }

    static class MyException2 extends IndexOutOfBoundsException {
    }

    static class MyException3 extends IOException {
    }

    static class MyException4 extends FileNotFoundException {
    }
}

