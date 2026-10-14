package com.dtsitsigkos.Synchronization;

import java.util.concurrent.locks.ReentrantLock;


class CounterLock{
    private int count = 0;
    private final ReentrantLock lock = new ReentrantLock();

    public void increment(){
        lock.lock();

        try {
            count++;
        } finally {
            lock.unlock();
        }
    }


    public int getCount(){
        lock.lock();

        try {
            return this.count;
        } finally {
            lock.unlock();
        }
    }

}

public class ReentrantLockExample {

    public static void main (String[] args){

        CounterLock counter = new CounterLock();

        Thread thread1 = new Thread(() -> {
            for (int i = 0 ; i < 100 ; i ++){
                counter.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0 ; i < 100 ; i ++){
                counter.increment();
            }
        });



        // Runnable task = () -> {
        //     for (int i = 0 ; i < 100; i ++){
        //         counter.increment();
        //     }
        // };

        // Thread thread1 = new Thread(task);
        // Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " " + e.getMessage());
        }

        System.out.println("Final count: " + counter.getCount());
    }

}
