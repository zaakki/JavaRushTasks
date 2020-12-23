package com.javarush.task.task26.task2612;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* 
Весь мир играет комедию
*/
public class Solution {
    private Lock lock = new ReentrantLock();

    public void someMethod() {
        // Implement the logic here. Use the lock field
        try{
            if(lock.tryLock()) {
                actionIfLockIsFree();
            } else if (!lock.tryLock()){
                actionIfLockIsBusy();
            }
        }finally {
             if(lock.tryLock())
            lock.unlock();
        }
        
    
    }

    public void actionIfLockIsFree() {
    }

    public void actionIfLockIsBusy() {
    }
}