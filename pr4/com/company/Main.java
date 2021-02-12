package com.company;

public class Main {

    public static void main(String[] args) {
	    ExecutorService service = new ExecutorService(2);
	    Runnable run1 = () -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("one");
        };
        Runnable run2 = () -> System.out.println("two");
        Runnable run3 = () -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("three");
        };
        service.submit(run1);
        service.submit(run2);
        service.submit(run3);
    }
}
