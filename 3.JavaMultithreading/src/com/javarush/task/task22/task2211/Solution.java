package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String inputFileName = args[0];
        String outputFileName = args[1];
        Charset window = Charset.forName("Windows-1251");
        Charset utf = Charset.forName("UTF-8");
        byte[] buffer = new byte[1000];
        InputStream inputStream = new FileInputStream(inputFileName);
        OutputStream outputStream = new FileOutputStream(outputFileName);
        inputStream.read(buffer);
        String s = new String(buffer,window);
        buffer = s.getBytes(utf);
        outputStream.write(buffer);
        inputStream.close();
        outputStream.close();
    }
}
