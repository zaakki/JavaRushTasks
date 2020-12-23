package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class AmigoSet<E> extends AbstractSet implements Serializable, Cloneable, Set {
    private static final Object PRESENT = new Object();
    private transient HashMap<E, Object> map;

    public AmigoSet() {
        map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        int capacity = Math.max(16, (int) Math.floor(collection.size() / .75f) + 1);
        map = new HashMap<>(capacity);

        this.addAll(collection);
    }

    @Override
    public boolean add(Object o) {
        return  map.put((E) o, PRESENT) == null;
    }

    @Override
    public Iterator iterator() {
        return map.keySet().iterator();
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    public void clear() {
        map.clear();
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o) == null;
    }

    @Override
    public int size() {
        return map.size();
    }

    public Object clone() {

        try {
            AmigoSet<E> object = new AmigoSet<>();
            object.map = (HashMap<E, Object>) map.clone();
            return object;

        } catch (Exception e) {
            throw new InternalError();
        }

    }

    private void writeObject(ObjectOutputStream outputStream) throws IOException {
        outputStream.defaultWriteObject();
        outputStream.writeInt(HashMapReflectionHelper.callHiddenMethod(map, "capacity"));
        outputStream.writeFloat(HashMapReflectionHelper.callHiddenMethod(map, "loadFactor"));
        outputStream.writeInt(map.size());
        for (E e : map.keySet()) {
            outputStream.writeObject(e);
        }
    }

    private void readObject(ObjectInputStream inputStream) throws IOException, ClassNotFoundException {
        inputStream.defaultReadObject();
        int capacity = inputStream.readInt();
        float loadFactor = inputStream.readFloat();
        int size = inputStream.readInt();

        map = new HashMap<>(capacity, loadFactor);

        for (int i = 0; i < size; i++) {
            E e = (E) inputStream.readObject();
            map.put(e, PRESENT);
        }
    }
}
