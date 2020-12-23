package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/*
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream fis = new FileInputStream(reader.readLine());
        reader.close();
        load(fis);
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
       
        Properties p = new Properties();
        p.putAll(properties);
        p.store(outputStream, "my prop");


    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties p = new Properties();
        p.load(inputStream);
        properties.putAll((Map)p);
    }

    public static void main(String[] args) {

    }
}
