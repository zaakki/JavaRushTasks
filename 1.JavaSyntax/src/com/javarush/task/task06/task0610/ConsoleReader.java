package com.javarush.task.task06.task0610;
import java.io.*;

/* 
Класс ConsoleReader
*/

public class ConsoleReader {
    public static String readString() throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //напишите тут ваш код
        String s1 = bufferedReader.readLine();
        return s1;

    }

    public static int readInt() throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        return n;

    }

    public static double readDouble() throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        double d = Double.parseDouble(bufferedReader.readLine());
        return d;

    }

    public static boolean readBoolean() throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = bufferedReader.readLine();
        if (s1.equals("true"))
            return true;
        else if (s1.equals("false"))
            return false;
        return false;

    }

    public static void main(String[] args) throws Exception {

    }
}
