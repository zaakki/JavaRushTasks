package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = new File("D:\\Users\\zaki\\Downloads\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2002\\input.txt");
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MM yyyy");
            User user1 = new User();
            user1.setFirstName("Giorgii");
            user1.setLastName("Gordeev");
            user1.setBirthDate(simpleDateFormat.parse("25 04 1990"));
            user1.setMale(true);
            user1.setCountry(User.Country.RUSSIA);
            javaRush.users.add(user1);
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            if(javaRush.equals(loadedObject)){
                System.out.println("Yes");
            }
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter pw = new PrintWriter(outputStream);
            SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss.SSS z yyyy", Locale.ENGLISH);

            for(User user:users){
                pw.println(user.getFirstName());
//                System.out.println(user.getFirstName());
                pw.println(user.getLastName());
//                System.out.println(user.getLastName());
                pw.println(dateFormat.format(user.getBirthDate()));
//                System.out.println(dateFormat.format(user.getBirthDate()));
                pw.println(user.isMale());
//                System.out.println(user.isMale());
                pw.println(user.getCountry());
//                System.out.println(user.getCountry());
            }
            pw.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss.SSS z yyyy",Locale.ENGLISH);
//            System.out.println("---------------");
            String firstName;
            while ((firstName=br.readLine()) != null){
                User user = new User();
                user.setFirstName(firstName);
//                System.out.println(user.getFirstName());
                user.setLastName(br.readLine());
//                System.out.println(user.getLastName());
                user.setBirthDate(dateFormat.parse(br.readLine()));
//                System.out.println(dateFormat.format(user.getBirthDate()));
                user.setMale(Boolean.parseBoolean(br.readLine()));
//                System.out.println(user.isMale());
                user.setCountry(User.Country.valueOf(br.readLine()));
//                System.out.println(user.getCountry());
                users.add(user);
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
