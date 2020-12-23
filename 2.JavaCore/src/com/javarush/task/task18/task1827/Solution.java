package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        //String fileName = "G:\\User\\zaki\\DownLoad\\Testdoc.txt";
        reader.close();
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName,true));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        List<Integer> idList = new ArrayList<>();
        if(args.length > 0 && args[0].equals("-c")){
            String productName = args[1], price = args[2], quantity = args[3];
            while (br.ready()){
                idList.add(Integer.parseInt(br.readLine().substring(0,8).trim()));
            }

        br.close();
        String id = String.valueOf(Collections.max(idList)+1);
        bw.write(String.format("%n%-8s%-30s%-8s%-4s",id,productName,price,quantity));
        bw.close();
        }
    }
}
