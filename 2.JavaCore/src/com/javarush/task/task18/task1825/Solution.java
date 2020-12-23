package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = "";
        List<String> listOfName =  new ArrayList<>();
        while (!(fileName=reader.readLine()).equals("end")){
            listOfName.add(fileName);
        }
        reader.close();
        String outFile = listOfName.get(0).substring(0, listOfName.get(0).lastIndexOf("."));
        FileOutputStream fos = new FileOutputStream(outFile);
        Collections.sort(listOfName);

        for (int i = 0; i <listOfName.size() ; i++) {
            //FileInputStream fis = new FileInputStream(listOfName.get(i));
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(listOfName.get(i)));
            while (bis.available() > 0){
                fos.write(bis.read());
            }
            bis.close();
        }
        fos.close();
    }
}
