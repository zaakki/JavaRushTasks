package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        fileName = reader.readLine();
//        fileName = "G:\\User\\zaki\\DownLoad\\TestHtml.html";
        reader.close();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String text = "";
        String tag = args[0];
        while (br.ready()){
            text = text + br.readLine();
        }
        br.close();
        String reg2 = "<"+tag+"|</"+tag+">";
        Pattern p2;
        p2 = Pattern.compile("<"+tag+"|</"+tag+">");
        Matcher m2 = p2.matcher(text);
        List<Integer> listEnd = new ArrayList<>();
        List<Integer> listStart = new ArrayList<>();
        List<String> listLine  = new ArrayList<>();

       while(m2.find()) {
           if (m2.group().equals("</" + tag + ">")) {
               listEnd.add(m2.start());
           } else {
               listStart.add(m2.start());
           }

           if (listStart.size() == listEnd.size() && listStart.size() > 0) {
               while (listStart.size() != 0) {
                   listLine.add(text.substring(listStart.get(0), listEnd.get(listEnd.size()-1)+2+tag.length()+1));
                   listStart.remove(0);
                   listEnd.remove(listEnd.size() - 1);
               }
           }
       }
        for (int i = 0; i <listLine.size() ; i++) {
            System.out.println(listLine.get(i).replaceAll("\n",""));
        }
    }
}
