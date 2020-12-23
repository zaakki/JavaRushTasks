package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
       
    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here

        Arrays.sort(array);
        int median = 0;
        if(array.length%2 == 1)
            median = array[array.length/2];
        else
            median = (array[array.length/2] + array[array.length/2-1])/2;
        System.out.println(median);
        int finalMedian = median;
        System.out.println("final median is " + finalMedian);
        int finalMedian1 = median;
        Comparator<Integer> compareByMedian = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {

                return Math.abs(finalMedian -o1) - Math.abs(finalMedian - o2);
            }
        };
        Arrays.sort(array,compareByMedian);

        return array;
    }

}
