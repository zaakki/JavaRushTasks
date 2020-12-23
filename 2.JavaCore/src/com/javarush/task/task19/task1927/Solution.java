package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream advertisingStream = new PrintStream(outputStream);
        String advertising = "JavaRush - курсы Java онлайн";
        System.setOut(advertisingStream);
        testString.printSomething();
        String result = outputStream.toString();
        System.setOut(consoleStream);
        List<String> listAd = new ArrayList<>();
        String[] splitResult = result.split("\n");
        int count = 0;
        for (String str: splitResult
             ) {
            System.out.println(str);
            count++;
            if(count%2 == 0){
                System.out.println(advertising);
            }
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
