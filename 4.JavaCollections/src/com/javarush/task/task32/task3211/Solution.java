package com.javarush.task.task32.task3211;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* 
Целостность информации
*/
//1. Класс Solution должен содержать метод compareMD5(ByteArrayOutputStream byteArrayOutputStream, String md5).
//2. Метод compareMD5(ByteArrayOutputStream byteArrayOutputStream, String md5) должен использовать MessageDigest.
//3. Метод compareMD5(ByteArrayOutputStream byteArrayOutputStream, String md5) должен возвращать результат сравнения
// вычисленного MD5 хеша для byteArrayOutputStream с переданным параметром md5.
//4. Класс Solution должен содержать метод main.
public class Solution {
    public static void main(String... args) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(new String("test string"));
        oos.flush();
        System.out.println(compareMD5(bos, "5a47d12a2e3f9fecf2d9ba1fd98152eb")); //true

    }

    public static boolean compareMD5(ByteArrayOutputStream byteArrayOutputStream, String md5) throws Exception {
        MessageDigest md = null;
        byte[] digest = new byte[0];
        try{
            md = MessageDigest.getInstance("MD5");
            md.reset();
            md.update(byteArrayOutputStream.toByteArray());
            digest = md.digest();
        } catch (NoSuchAlgorithmException e){
            e.getStackTrace();
        }
        BigInteger bigInt = new BigInteger(1,digest);
        String md5Hex = bigInt.toString(16);
        while ( md5Hex.length() < 32){
            md5Hex = "0" + md5Hex;
        }
        return md5Hex.equals(md5);
    }
}
