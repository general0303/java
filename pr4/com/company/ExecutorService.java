package com.company;

public class ExecutorService {
    public int count = 0;
    public int size;

    ExecutorService(int size){
        this.size = size;
    }

    public void submit(Runnable runnable){
        if (count < size){
            count++;
            Thread thread = new Thread(runnable);
            thread.start();
        }
    }
}
