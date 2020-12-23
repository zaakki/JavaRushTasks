package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/*
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    List<Entry<String>> list = new ArrayList<>();
    Entry<String> root;

    public CustomTree(){
        this.root = new Entry<>("0");
        list.add(root);
    }

    @Override
    public boolean add(String s) {
        Entry<String> child = new Entry<>(s);

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).availableToAddLeftChildren){
                list.get(i).leftChild = child;
                list.get(i).availableToAddLeftChildren = false;
                child.parent = list.get(i);
                break;
            }
            if(list.get(i).availableToAddRightChildren){
                list.get(i).rightChild = child;
                list.get(i).availableToAddRightChildren = false;
                child.parent = list.get(i);
                break;
            }
        }
        list.add(child);
        return true;
    }
    public boolean remove(Object o){
        if(o instanceof String){
            for (int i = 0; i < list.size() ; i++) {
                if(list.get(i).elementName.equals(o)){
                    removeAssist(i);
                    return true;
                }

            }

        } else
            throw new UnsupportedOperationException();

        return false;
    }

    private void removeAssist(int i){
        Entry removedElement = list.get(i);
        String nameParent = getParent(list.get(i).elementName);
        Entry elementParent = get(nameParent);
        if(elementParent.rightChild != null){
            if(elementParent.rightChild.equals( removedElement)){
                elementParent.rightChild = null;
                elementParent.availableToAddRightChildren = true;
            }
        }
        if(elementParent.leftChild != null){
            if(elementParent.leftChild.equals(removedElement)){
                elementParent.leftChild = null;
                elementParent.availableToAddLeftChildren = true;
            }
        }
        if(removedElement.leftChild != null){
            remove(removedElement.leftChild.elementName);
        }
        if(removedElement.rightChild != null){
            remove(removedElement.rightChild.elementName);
        }
        list.remove(i);
    }

    private Entry get(String s){
        for (int i = 0; i < list.size() ; i++) {
            if(list.get(i).elementName.equals(s))
                return list.get(i);

        }
        return null;

    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return list.size() -1 ;
    }

    public String getParent(String s) {

        for (Entry<String> stringEntry : list) {
            if (stringEntry.elementName.equals(s)) return stringEntry.parent.elementName;
        }
        return null;

    }


    static class Entry<T> implements Serializable {

        String elementName;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {

            this.elementName = elementName;
            this.availableToAddLeftChildren = true;
            this.availableToAddRightChildren = true;
        }

        public boolean isAvailableToAddChildren() {
            return this.availableToAddLeftChildren || this.availableToAddRightChildren;
        }
    }
}
