package com.company;

import java.util.ArrayList;

public class Set<T> {
    ArrayList<T> arrayList;
    public int size = 0;

    Set(){
        arrayList = new ArrayList<>();
    }

    synchronized public boolean add(T element) {
        if (arrayList.contains(element))
            return false;
        else arrayList.add(element);
        size++;
        return true;
    }

    public int getSize(){
        return this.size;
    }
}
