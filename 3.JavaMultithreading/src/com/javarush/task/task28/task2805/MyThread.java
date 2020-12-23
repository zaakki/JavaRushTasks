package com.javarush.task.task28.task2805;

//Иметь возможность быть созданным используя любой конструктор супер-класса (Alt+Insert).
//2. Приоритет у трэдов должен проставляться циклично от минимального значения до максимального значения.
//3. если у трэда установлена трэд-группа(ThreadGroup), то приоритет трэда
// не может быть больше максимального приоритета его трэд-группы.
public class MyThread extends Thread {
    private static int priorityCount = Thread.MIN_PRIORITY;
    {
        if(priorityCount > Thread.MAX_PRIORITY) priorityCount = Thread.MIN_PRIORITY;
        setPriority(priorityCount++);
    }
    public MyThread() {
    }

    public MyThread(Runnable target) {
        super(target);
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
    }

    public MyThread(String name) {
        super(name);
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
    }

}
