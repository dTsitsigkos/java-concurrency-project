package com.dtsitsigkos.threads;

import java.util.concurrent.locks.ReentrantLock;


//Simple implemantation
// class MyThread extends Thread{

//     @Override 
//     public void run(){
//         for (int i = 1 ; i <= 5 ; i ++){
//             System.out.println(Thread.currentThread().getName() + " printing:" + i);

//             try {
//                 Thread.sleep(500);
//             } catch (InterruptedException e) {
//                 System.out.println("Thread interrupted: " + e.getMessage());
//             }   
//         }
//     }
// }


// public class ThreadExample {
//     public static void main (String[] args){
//         System.out.println("Extending the Thread Class");

//         MyThread thread1 = new MyThread();
//         MyThread thread2 = new MyThread();


//         thread1.start();
//         thread2.start();

//         try {
//             thread1.join();
//             thread2.join();
//         } catch (InterruptedException e) {
//             Thread.currentThread().interrupt();
//             return;
//         }
//     }
// }


//Implementation with locks
class CounterLock{
    private int counter = 0;
    private final ReentrantLock lock = new ReentrantLock();

    public void increment(){
        lock.lock();

        try {
            counter ++;
        } finally {
            lock.unlock();
        }
    }

    public int getCounter(){
        lock.lock();

        try {
            return this.counter;
        } finally {
            lock.unlock();
        }
    }
}



class MyThread extends Thread{
    private final CounterLock counter;
    
    public MyThread(CounterLock counter){
        this.counter = counter;
    }

    @Override 
    public void run(){
        for (int i = 0 ; i < 100 ; i ++){
            counter.increment();
        }    
    }
}


public class ThreadExample {
    public static void main (String[] args){
        System.out.println("Extending the Thread Class");
        CounterLock counter =  new CounterLock();

        MyThread thread1 = new MyThread(counter);
        MyThread thread2 = new MyThread(counter);


        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }

        System.out.println("Final counter: " + counter.getCounter());
    }
}
