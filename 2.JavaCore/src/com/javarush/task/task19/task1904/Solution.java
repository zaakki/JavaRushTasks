package com.javarush.task.task19.task1904;

/* 
И еще один адаптер
*/

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException, ParseException {
    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;
        public PersonScannerAdapter(Scanner fileScanner){
            this.fileScanner = fileScanner;
        }
        @Override
        public Person read() throws IOException, ParseException {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd M yyyy");
            String[] personArray = fileScanner.nextLine().split(" ");
            String firstName = personArray[1], middleName = personArray[2];
            String lastName =personArray[0];
            String stringBd = personArray[3] + " " + personArray[4] + " " + personArray[5];
            Date bd = dateFormat.parse(stringBd);

            Person person = new Person(firstName, middleName, lastName,bd);
            return person;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();

        }
    }
}
