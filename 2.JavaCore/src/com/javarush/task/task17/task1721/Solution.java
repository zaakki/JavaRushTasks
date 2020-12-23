package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        //String fileName2 = reader.readLine();
        //reader.close();
        BufferedReader file1 = new BufferedReader(new FileReader(new File(fileName)));
       // BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = file1.readLine()) != null){
            allLines.add(s);
        }
        String fileName2 = reader.readLine();
        reader.close();
        BufferedReader file2 = new BufferedReader(new FileReader(new File(fileName2)));
        String se;
        while ((se = file2.readLine()) != null){
            forRemoveLines.add(se);
        }

        for (String s2: allLines
             ) {
            System.out.println(s2);
        }
        for(String s1: forRemoveLines){
            System.out.println(s1);
        }
        Solution solution = new Solution();
        solution.joinData();


    }

    public void joinData() throws CorruptedDataException {

        if(allLines.containsAll(forRemoveLines)){
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }

    }
}
