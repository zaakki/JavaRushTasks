package com.javarush.task.task20.task2001;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Читаем и пишем в файл: Human
*/
public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = new File("D:\\Users\\zaki\\Downloads\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2001\\inputFile.txt");
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov", new Asset("home", 999_999.99), new Asset("car", 2999.99));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            if(ivanov.hashCode() == somePerson.hashCode())
                System.out.println("All good");

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            //System.out.println("I'm here for save");
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
            String isNamed = name != null ? "yes" : "no";
            bw.write(isNamed+"\n");
            bw.write(this.name+"\n");
            String haveAsset = assets.size() > 0 ? "yes" : "no";
            bw.write(haveAsset+"\n");
            if(haveAsset.equals("yes")){
                for (Asset a: assets
                     ) {
                    bw.write(a.getName()+"\n");
                    bw.write(a.getPrice()+"\n");
                }
            }
            bw.flush();

        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            // System.out.println("i'm here for load");
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            while (br.ready()) {
                String isNamed = br.readLine();
                if (isNamed.equals("yes")) {
                    this.name = br.readLine();
                }
                String haveAsset = br.readLine();
                if (haveAsset.equals("yes")) {
                    while (br.ready())
                        this.assets.add(new Asset(br.readLine(), Double.parseDouble(br.readLine())));
                }
            }
        }
    }
}
