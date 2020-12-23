package com.javarush.task.task04.task0432;
import java.io.*;
/* 
Хорошего много не бывает
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        int n = Integer.parseInt(bufferedReader.readLine());
        while (n > 0){
            System.out.println(s);
            n--;
        }
    }
}
