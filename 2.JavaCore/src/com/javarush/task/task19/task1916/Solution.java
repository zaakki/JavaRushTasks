package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1;
        String fileName2;
        fileName1 = reader.readLine();
        fileName2 = reader.readLine();
//        fileName1 = "G:\\User\\zaki\\DownLoad\\Testdoc.txt";
//        fileName2 = "G:\\User\\zaki\\DownLoad\\Testdoc21.txt";
        reader.close();
//        FileReader file1 = new FileReader(fileName1);
//        FileReader file2 = new FileReader(fileName2);
        BufferedReader br1 = new BufferedReader(new FileReader(fileName1));
        BufferedReader br2 = new BufferedReader(new FileReader(fileName2));
        List<String> listLinesFile1 = new ArrayList<>();
        List<String> listLinesFile2 = new ArrayList<>();
        while (br1.ready()){
            listLinesFile1.add(br1.readLine());
        }
        br1.close();
        while (br2.ready()){
            listLinesFile2.add(br2.readLine());
        }
        br2.close();
//        for (String s: listLinesFile1
//             ) {
//            System.out.println(s);
//        }
//        System.out.println("-------------------------");
//        for(String s2 : listLinesFile2){
//            System.out.println(s2);
//        }
//        System.out.println("+++++++++++++++++++++++++++++");

//

        while (listLinesFile1.size() > 0 && listLinesFile2.size() > 0){
            if(listLinesFile1.get(0).equals(listLinesFile2.get(0))){
                lines.add(new LineItem(Type.SAME, listLinesFile1.get(0)));
                listLinesFile1.remove(0);
                listLinesFile2.remove(0);
            } else if(listLinesFile1.get(1).equals(listLinesFile2.get(0))){
                lines.add(new LineItem(Type.REMOVED, listLinesFile1.get(0)));
                listLinesFile1.remove(0);
            } else {
                lines.add(new LineItem(Type.ADDED, listLinesFile2.get(0)));
                listLinesFile2.remove(0);
            }
        }
        if(listLinesFile1.size() > 0){
            lines.add(new LineItem(Type.REMOVED, listLinesFile1.get(0)));
            listLinesFile1.remove(0);
        }
        if(listLinesFile2.size() > 0){
            lines.add(new LineItem(Type.ADDED, listLinesFile2.get(0)));
            listLinesFile2.remove(0);
        }

//        for (LineItem li :lines
//             ) {
//            System.out.println(li.toString());
//        }


    }



    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
