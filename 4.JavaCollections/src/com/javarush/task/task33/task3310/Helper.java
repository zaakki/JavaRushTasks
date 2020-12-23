package com.javarush.task.task33.task3310;

import org.junit.Test;

import java.math.BigInteger;
import java.security.SecureRandom;

public class Helper {


    public static String generateRandomString(){
        return new BigInteger(130,new SecureRandom()).toString(36);
    }
    public static void printMessage(String message){
        System.out.println(message);
    }
    @Test
    public void testRandomString(){
        System.out.println(generateRandomString());
    }

}

