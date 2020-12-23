package com.javarush.task.task27.task2709;

public class TransferObject {
    private int value;
    protected volatile boolean isValuePresent = false; //use this variable

    public synchronized int get() {

            while (!isValuePresent) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            isValuePresent = false;
            notify();
            System.out.println("Got: " + value);
            return value;

    }

    public synchronized void put(int value) {

            while (isValuePresent){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            isValuePresent = true;
            notify();
            this.value = value;
            System.out.println("Put: " + value);
        
    }
}
