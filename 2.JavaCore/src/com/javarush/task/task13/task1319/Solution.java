package com.javarush.task.task13.task1319;

/* 
Писатель в файл с консоли
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;
//        List<String> list = new ArrayList<>();
//        while (!(s = reader.readLine()).isEmpty()){
//            list.add(s);
//        }
//        for (String s1:list
//             ) {
//            System.out.println(s1);
//        }
        BufferedWriter writter = new BufferedWriter(new FileWriter(reader.readLine()));
        String line;
        while (!(line = reader.readLine()).equals("exit")){
            writter.write(line + "\r\n");
            writter.flush();

        }
       // writter.flush();
        writter.write("exit");
        writter.close();
        reader.close();
//        String[] s2 = (String[]) list.toArray();
//        for(int i = 0; i < s2.length; i++){
//            System.out.print(s2[i] + "\t");
//        }
//        BufferedWriter writer = new BufferedWriter(new FileWriter(s));
//            String line;
//            while (!(line = reader.readLine()).equals("exit")){
//                writer.write(line + "\n");
//
//            }
//            writer.write("exit");
//            writer.close();
//            reader.close();

        }

}
