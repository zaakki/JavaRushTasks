package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream mathOutputStream = new PrintStream(outputStream);
        System.setOut(mathOutputStream);
        testString.printSomething();
        String result = outputStream.toString().trim();
//
        System.setOut(consoleStream);

        int answer = 0;

        String[] strArray = new String[result.length()];
        strArray = result.split(" ");

        if(strArray[1].equals("+")){
             answer = Integer.parseInt(strArray[0]) + Integer.parseInt(strArray[2]);

        } else if(strArray[1].equals("-")){
            answer = Integer.parseInt(strArray[0]) - Integer.parseInt(strArray[2]);

        } else if(strArray[1].equals("*")){
            answer = Integer.parseInt(strArray[0]) * Integer.parseInt(strArray[2]);

        }
        result = result.concat(" ").concat(String.valueOf(answer));
        System.out.print(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

