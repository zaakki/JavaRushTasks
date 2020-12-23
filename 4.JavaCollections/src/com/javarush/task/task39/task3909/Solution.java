package com.javarush.task.task39.task3909;

/* 
Одно изменение
*/
public class Solution {
    public static void main(String[] args) {
        String s1 = "Hellow";
        String s2 = "hello";
        System.out.println(isOneEditAway(s1, s2));
    }

    public static boolean isOneEditAway(String first, String second) {
        if (first.equals(second))
            return true;
        if ((first.length() - second.length()) > Math.abs(1))
            return false;
        int delta = Math.abs(first.length() - second.length());
        StringBuffer s1 = (first.length() >= second.length()) ? new StringBuffer(first) : new StringBuffer(second);
        StringBuffer s2 = (first.length() < second.length()) ? new StringBuffer(first) : new StringBuffer(second);
        for (int i = 0; i < s2.length(); i++) {

            if (s1.charAt(i) != s2.charAt(i)) {

                if (delta != 0) {
                    s1.deleteCharAt(i);
                } else {
                    s1.deleteCharAt(i);
                    s2.deleteCharAt(i);
                }

                break;
            }
        }

        if (s1.length() != s2.length()) s1.deleteCharAt(s1.length() - 1);

        return s1.toString().equals(s2.toString());

    }
}
