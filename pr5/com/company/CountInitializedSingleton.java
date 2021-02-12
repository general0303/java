package com.company;

public class CountInitializedSingleton {
    private static int count;
    private static CountInitializedSingleton instance;
    private CountInitializedSingleton(){}
    public static CountInitializedSingleton getInstance(){
        if(count == 0){
             instance = new CountInitializedSingleton();
             count ++;
        }
        return instance;
    }
}
