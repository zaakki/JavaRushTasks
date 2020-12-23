package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);
    static {
        threads.add(new TestThread1());
        threads.add(new TestThread2());
        threads.add(new TestThread3());
        threads.add(new TestThread4());
        threads.add(new TestThread5());

    }


    public static void main(String[] args) throws InterruptedException {

        for (Thread t:threads
             ) {
            t.start();
        }

    }
    public static class TestThread1 extends  Thread{
        public void run(){
                while(true){

                }

        }
    }
    public static class TestThread2 extends Thread{
        public void run(){
           if(currentThread().isInterrupted()){
               try {
                   throw  new InterruptedException();
               } catch (InterruptedException e) {
                   System.out.println("InterruptedException");
               }
           }
        }
    }
    public static class TestThread3 extends Thread{
        public void run(){
            while (true) {
                try {
                    System.out.println("Ура");
                    Thread.sleep(500);
                } catch (InterruptedException e) {

                }
            }
        }
    }
    public static class TestThread4 extends Thread implements Message{
        private boolean isAlive=false;
        public void run(){
            while (!isAlive){

            }
        }
        @Override
        public void showWarning() {
            isAlive = true;
        }
    }
    public static class TestThread5 extends Thread{
        public void run(){
            int res=0;
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String text;
                while (!(text=reader.readLine()).equals("N")){
                    res = res + Integer.parseInt(text);
                }
                System.out.println(res);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NumberFormatException e){
                System.out.println(res);
            }
        }
    }
}
