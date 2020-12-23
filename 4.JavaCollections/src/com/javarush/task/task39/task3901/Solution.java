package com.javarush.task.task39.task3901;

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Уникальные подстроки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter your string: ");
        String s = bufferedReader.readLine();
       
        System.out.println("The longest unique substring length is: \n" + lengthOfLongestUniqueSubstring(s));
    }

    public static int lengthOfLongestUniqueSubstring(String s) {
        int res = 0;
        if(s == null || s.isEmpty())
            return 0;

        int start = 0;
        char[] c = s.toCharArray();
        if (c.length == 1)
            res = 1;

        for (int i = 0; i <c.length ; i++) {
            int length = 0;
            StringBuilder sb =new StringBuilder();
            for (int j = i; j < c.length; j++){
              if(!sb.toString().contains(String.valueOf(c[j])))
                  sb.append(c[j]);
              else {
                  length = sb.length();
                  if(res < length)
                      res = length;
                  sb.delete(start,length);
                  length = 0;
                  sb.append(c[j]);
              }
              if(j == c.length-1 && res < sb.length())
                  res = sb.length();
           }
        }

        return res;
    }
    @Test
    public void test1(){
        Assert.assertEquals(Solution.lengthOfLongestUniqueSubstring(null), 0);
        Assert.assertEquals(Solution.lengthOfLongestUniqueSubstring(""), 0);
        Assert.assertEquals(Solution.lengthOfLongestUniqueSubstring("q"), 1);
        Assert.assertEquals(Solution.lengthOfLongestUniqueSubstring("a123bcbcqwe"), 6);
        Assert.assertEquals(Solution.lengthOfLongestUniqueSubstring("ttttwt"), 2);
        Assert.assertEquals(Solution.lengthOfLongestUniqueSubstring("abcdeaouiz"), 9);
        Assert.assertEquals(Solution.lengthOfLongestUniqueSubstring("еееееее"), 1);
    }
}
