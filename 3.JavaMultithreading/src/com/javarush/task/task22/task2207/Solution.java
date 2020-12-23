package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        fileName = reader.readLine();
//        fileName = "Testdoc";
        reader.close();
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        while (br.ready()){
            sb.append(br.readLine()+" ");
        }
        br.close();
        String[] strArr = sb.toString().split(" ");
         for (int i = 0; i < strArr.length ; i++) {
            for (int j =i+ 1; j < strArr.length - 1;j++) {
                StringBuilder str = new StringBuilder(strArr[j]);
//                System.out.println("word is " + strArr[i]);
//                System.out.println("Str is "+ str);
                if(str.reverse().toString().equals(strArr[i]) && !strArr[i].equals("")) {
//                    System.out.println("Match");
//                    System.out.println(strArr[i] + " " + str.reverse());
                    Pair p = new Pair();
                    p.first = strArr[i];
                    p.second = strArr[j];
                    result.add(p);
                    strArr[i] = "";
                    strArr[j] = "";
                }
            }
        }

        System.out.println("++++++++++++++++++++++");
        for (Pair p :result
             ) {
            System.out.println(p.toString());
        }
//

        }

    public static class Pair {
        String first;
        String second;
        public Pair(){}

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
