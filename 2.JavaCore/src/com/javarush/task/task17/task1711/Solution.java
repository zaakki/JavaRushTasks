package com.javarush.task.task17.task1711;

import org.w3c.dom.ls.LSOutput;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        SimpleDateFormat inDate = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat outDate = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        String name;
        int id;
        Date bd;
        Person p;
        Sex sex;

        switch (args[0]){
            case  "-c":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i = i + 3) {
                        name = args[i];
                        sex = (args[i+1].equals("м")? Sex.MALE: Sex.FEMALE);
                        bd = inDate.parse(args[i+2]);
                        if (sex == Sex.MALE) {
                            p = Person.createMale(name, bd);
                        } else  {
                            p = Person.createFemale(name, bd);
                        }
                        allPeople.add(p);
                        System.out.println(allPeople.indexOf(p));
                        }
                    break;
                }
            case "-u":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i = i + 4) {
                        id = Integer.parseInt(args[i]);
                        name = args[i+1];
                        sex = (args[i+2].equals("м")? Sex.MALE: Sex.FEMALE);
                        bd = inDate.parse(args[i+3]);
                        allPeople.get(id).setName(name);
                        allPeople.get(id).setBirthDate(bd);
                        allPeople.get(id).setSex(sex);
                    }
                    break;
                }
            case "-d":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        id = Integer.parseInt(args[i]);
                        allPeople.get(id).setName(null);
                        allPeople.get(id).setSex(null);
                        allPeople.get(id).setBirthDate(null);
                    }
                    break;
                }
            case "-i":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        id = Integer.parseInt(args[i]);
                        if (allPeople.get(id).getSex().equals(Sex.MALE)) {
                            System.out.println(allPeople.get(id).getName() + " м " + outDate.format(allPeople.get(id).getBirthDate()));
                        } else if (allPeople.get(id).getSex().equals(Sex.FEMALE))
                            System.out.println(allPeople.get(id).getName() + " ж " + outDate.format(allPeople.get(id).getBirthDate()));
                    }
                    break;
                }
        }
    }
}
