package com.javarush.task.task16.task1630;

import java.io.*;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут
    //"G:\\User\\zaki\\DownLoad\\Textdoc.txt";
    //"G:\\User\\zaki\\DownLoad\\Testdoc.txt";
    static
    {

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();

        } catch (Exception e){
            System.out.println("errror");
        }
    }


    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        //add your code here - добавьте код тут
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут
    public static class ReadFileThread extends  Thread implements ReadFileInterface{
        private String fileContent = "";
        private String fullFileName;
        @Override
        public void run(){
            try {
                BufferedReader rd = new BufferedReader(new FileReader(new File(fullFileName)));
                String line;
                while (rd.ready()){
                    this.fileContent = this.fileContent + rd.readLine() + " ";
                }
                rd.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("run err");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("run err2");
            }

        }
        @Override
        public void setFileName(String fullFileName) {
            this.fullFileName = fullFileName;
        }

        @Override
        public String getFileContent() {

            return this.fileContent;
        }
    }
}
