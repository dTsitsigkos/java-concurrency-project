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
