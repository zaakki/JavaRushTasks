package com.javarush.task.task28.task2803;

import java.util.concurrent.ThreadLocalRandom;

/*
ThreadLocalRandom
*/
public class Solution {
    public static int getRandomIntegerBetweenNumbers(int from, int to) {
       int random = ThreadLocalRandom.current().nextInt(from, to);
        return random;
    }

    public static double getRandomDouble() {
        return ThreadLocalRandom.current().nextDouble();
    }

    public static long getRandomLongBetween0AndN(long n) {
        return ThreadLocalRandom.current().nextLong(n);
    }

    public static void main(String[] args) {
      int f = Solution.getRandomIntegerBetweenNumbers(1,5);
        System.out.println(f);
        double d = Solution.getRandomDouble();
        long l = Solution.getRandomLongBetween0AndN(10423);
        System.out.println(d);
        System.out.println(l);
    }
}
