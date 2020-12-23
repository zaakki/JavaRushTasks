package com.javarush.task.task17.task1710;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws IOException, ParseException {
        //start here - начни тут
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MMM-yyyy",Locale.ENGLISH);
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String s = reader.readLine();
//        args = s.split(" ");
        int id;
        if(args[0].equals("-c")){
            Date bd = dateFormat.parse(args[3]);
            if(args[2].equals("м")) {
                allPeople.add(Person.createMale(args[1], bd));
                System.out.println(allPeople.size() - 1);
            }else if(args[2].equals("ж")) {
                allPeople.add(Person.createFemale(args[1] ,bd));
                System.out.println(allPeople.size() - 1);
            }
        } else if (args[0].equals("-u")){
            id = Integer.parseInt(args[1]);
            Date bd = dateFormat.parse(args[4]);
            allPeople.get(id).setName(args[2]);
            allPeople.get(id).setBirthDate(bd);
            allPeople.get(id).setSex(args[3].equals("м")? Sex.MALE:Sex.FEMALE);

        } else if(args[0].equals("-d")){
            id = Integer.parseInt(args[1]);
           allPeople.get(id).setSex(null);
           allPeople.get(id).setName(null);
           allPeople.get(id).setBirthDate(null);
        }else if(args[0].equals("-i")){
            id = Integer.parseInt(args[1]);
            if(allPeople.get(id).getSex().equals(Sex.MALE)){
                System.out.println(allPeople.get(id).getName() + " " +
                        "м"+ " " +
                        dateFormat1.format(allPeople.get(id).getBirthDate()));
            } else if(allPeople.get(id).getSex().equals(Sex.FEMALE)) {
                System.out.println(allPeople.get(id).getName() + " " +
                        "ж" + " " +
                        dateFormat1.format(allPeople.get(id).getBirthDate()));
            }

        }
//        for (Person p : allPeople
//             ) {
//            System.out.println(p.getName() + " " + p.getSex() + " " + dateFormat1.format(p.getBirthDate()));
//        }

    }
}
