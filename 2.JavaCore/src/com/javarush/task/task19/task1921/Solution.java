package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        String fileName = args[0];
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        List<String> listName = new ArrayList<>();
        List<String> listBd = new ArrayList<>();
        String line = "";
        String lineName = "", lineBD = "" ;
        String[] dayOfBd = new String[3];
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd M yyyy", Locale.ENGLISH);
        Date d = new Date();
        while (br.ready()){
            try {
                line = br.readLine();
                lineName = line.replaceAll("\\d", "");
                lineName = lineName.trim();
                lineBD = line.replaceAll("\\D+\\s", "");
//                System.out.println(lineName);
                dayOfBd = lineBD.split(" ");
                d = dateFormat.parse(dayOfBd[0]+" "+dayOfBd[1]+" "+dayOfBd[2]);
                PEOPLE.add(new Person(lineName, d));
            } catch (Exception e){

            }
        }
        br.close();
//        for (Person p :PEOPLE
//             ) {
//            System.out.println(p.getName() + p.getBirthDate());
//        }

    }
}
