package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new List<>();
        Thread one = new Thread(()->{
            for (int i = 0; i <10; i++){
                list.add(1);
            }
        });
        Thread two = new Thread(()->{
            for (int i = 0; i <10; i++){
                list.add(2);
            }
        });
        one.start();
        two.start();
        Thread.sleep(300);
        System.out.println(list.getSize());
        Set<Integer> set = new Set<>();
        one = new Thread(()->{
            for (int i = 0; i <10; i++){
                set.add(i);
            }
        });
        two = new Thread(()->{
            for (int i = 0; i <10; i++){
                set.add(i);
            }
        });
        one.start();
        two.start();
        Thread.sleep(300);
        System.out.println(set.getSize());
    }
}
