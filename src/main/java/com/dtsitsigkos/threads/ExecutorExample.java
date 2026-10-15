package com.dtsitsigkos.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {
    public static void main(String[] args){
        ExecutorService executor =  Executors.newFixedThreadPool(2);

        Runnable task = () -> {
            for (int i = 0 ; i <= 5 ; i ++){
                System.out.println(Thread.currentThread().getName() + " printing: " + i);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted: " + e.getMessage());
                }
            }
        };

        executor.submit(task);
        executor.submit(task);

        executor.shutdown();
    }
}


// class CounterLock{

//     private final ReentrantLock lock = new ReentrantLock();
//     private int counter = 0;

//     public void increment(){

//         lock.lock();

//         try {
//             counter++;
//         } finally {
//             lock.unlock();
//         }
//     }

//     public int getCounter(){

//         lock.lock();

//         try {
//             return this.counter;
//         } finally {
//             lock.unlock();
//         }
//     }
// }

// public class ExecutorExample {
//     public static void main(String[] args){
//         System.out.println("Executor Example");

//         CounterLock counter = new CounterLock();
//         ExecutorService executor =  Executors.newFixedThreadPool(2);


//         Runnable task = () -> {
//             for (int i = 0; i < 100; i ++){
//                 counter.increment();
//             }
//         };

//         executor.submit(task);
//         executor.submit(task);

//         executor.shutdown();

//         try {
//             if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
//                 System.out.println("Tasks did not finish in time.");
//             }
//         } catch (InterruptedException e) {
//             Thread.currentThread().interrupt();
//         }
//         System.out.println("Final Counter: " + counter.getCounter());
//     }
// }

