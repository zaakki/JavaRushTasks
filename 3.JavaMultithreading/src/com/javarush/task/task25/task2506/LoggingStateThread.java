package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    private Thread target;
    public LoggingStateThread(Thread thread){
        this.target = thread;

    }

    @Override
    public void run() {
        super.run();
        String stateName = "";
        do{
            if(!stateName.equals(target.getState().toString())) {
                stateName = target.getState().toString();
                System.out.println(stateName);
            }
        }while (target.getState() != State.TERMINATED);


    }
}
