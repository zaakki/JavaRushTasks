package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {
    private final static int ORDER_CREATING_INTERVAL = 100;
    private final static LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();
    public static void main(String[] args) {

        Cook cook = new Cook("zaki");
        cook.setQueue(orderQueue);
        cook.setQueue(orderQueue);
        Cook cook2 = new Cook("Zero");


        Waiter waiter = new Waiter();
        cook.addObserver(waiter);
        cook2.addObserver(waiter);

        List<Tablet> tablets = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Tablet tablet = new Tablet(i);
            tablet.setOrderQueue(orderQueue);
            tablets.add(tablet);

        }

        Thread cookThread1 = new Thread(cook.toString());
        Thread cookThread2 = new Thread(cook2.toString());
        cookThread1.start();
        cookThread2.start();

        Thread th = new Thread(new RandomOrderGeneratorTask(tablets,ORDER_CREATING_INTERVAL));
        th.start();

        try{
            Thread.sleep(1000);
        } catch (InterruptedException e){

        }
        th.interrupt();
        cookThread1.interrupt();
        cookThread2.interrupt();

        DirectorTablet dt = new DirectorTablet();
        dt.printAdvertisementProfit();
        dt.printCookWorkloading();
        dt.printActiveVideoSet();
        dt.printArchivedVideoSet();

    }
}
