package com.company;

public enum Singleton {
    INSTANCE;
    public Singleton getInstance() {
        return INSTANCE;
    }
}
