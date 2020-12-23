package com.javarush.task.task27.task2710;

public class MailServer implements Runnable {
    private Mail mail;

    public MailServer(Mail mail) {
        this.mail = mail;
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        //сделайте что-то тут - do something here
        synchronized (mail) {
            try {
                while (mail.getText() == null) {
                   mail.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mail.notify();
            String name = Thread.currentThread().getName();
            long endTime = System.currentTimeMillis();
            System.out.format("%s MailServer received: [%s] in %d ms after start", name, mail.getText(), (endTime - startTime));
        }
    }
}
