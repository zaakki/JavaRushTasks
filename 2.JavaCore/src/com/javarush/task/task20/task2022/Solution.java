package com.javarush.task.task20.task2022;

import java.io.*;

/*
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
    String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.stream = new FileOutputStream(fileName);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.stream =  new FileOutputStream(fileName, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws Exception {
        Solution sol = new Solution("testex.txt");
        sol.writeObject("lakaka");

        FileOutputStream fos = new FileOutputStream("testex.txt");
        ObjectOutputStream oos  = new ObjectOutputStream(fos);

        oos.writeObject(sol);
        oos.close();
        sol.close();

        FileInputStream fis = new FileInputStream("testex.txt");
        ObjectInputStream ois  = new ObjectInputStream(fis);
        Solution sol2;
        sol2 = (Solution) ois.readObject();
        ois.close();
        fis.close();
        sol2.close();
        System.out.println(sol);
        System.out.println(sol2);

    }
}
