package com.company;

import java.util.concurrent.Semaphore;

public class List<T> {

    private ListNode<T> head = null;
    private ListNode<T> tail = null;
    private int size = 0;

    private static final Semaphore semaphore = new Semaphore(1);

    public boolean add(T node){
        try {
            semaphore.acquire();
            if (head == null) {
                head = new ListNode<T>();
                tail = new ListNode<T>();
                head.info = node;
                head.next = tail;
                tail.next = head;
            } else {
                ListNode<T> next = new ListNode<T>();
                next.info = node;
                next.next = tail;
                head.next = next;
            }

            size++;
        } catch (Exception e) {
            e.printStackTrace();
            semaphore.release();
            return false;
        }
        semaphore.release();
        return true;
    }

    public int getSize(){
        return  size;
    }

    public void print(){
        if (head != null){
            ListNode<T> node = head.next;
            while (node.next != null){
                System.out.println(node.info);
                node = node.next;
            }
        }
    }
}
