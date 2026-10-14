package com.dtsitsigkos.Synchronization;


class CounterBlock{
    private int count = 0;
    private final Object lock = new Object();

    public void increment(){
        synchronized (lock){
            count++;
        }
    }

    public int getCount(){
        synchronized(lock){
            return this.count;
        }
    }

}


public class SynchronizedBlockExample {
    public static void main(String[] args){
         System.out.println("Synchronized Block example");

        CounterBlock counter = new CounterBlock();

        // Runnable task = ()->{
        //     for (int i = 0; i < 100 ; i ++){
        //         counter.increment();
        //     }
        // };

        // Thread thread1 = new Thread(task);
        // Thread thread2 = new Thread(task);

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

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " " + e.getMessage());
        }

        System.out.println("Final Count: " + counter.getCount());

    }
}
