package com.dtsitsigkos.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureExample {

    // public static void main( String[] args){

    //     ExecutorService executor = Executors.newSingleThreadExecutor();

    //     Callable<String> task = () -> {
    //         Thread.sleep(2000);
    //         return "Task completed";
    //     };

    //     Future<String> future = executor.submit(task);

    //     System.out.println("Doing other work...");

    //     String result = null;
    //     try {
    //         result = future.get();
    //     } catch (InterruptedException ex) {
    //         System.getLogger(FutureExample.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
    //     } catch (ExecutionException ex) {
    //         System.getLogger(FutureExample.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
    //     }

    //     System.out.println(result);

    //     executor.shutdown();
    // }

    public static void main( String[] args){

        ExecutorService executor = Executors.newFixedThreadPool(2);

        int[] nums1 = {1,2,3};
        int[] nums2 = {10,20,30};

        Callable<Integer> task1 = () -> {
            int sum = 0;

            for (int num: nums1){
                sum += num;
            }

            return sum;
        };


        Callable<Integer> task2 = () ->{
            int sum = 0;

            for (int num: nums2){
                sum += num;
            }

            return sum;
        };

        Future<Integer> future1 = executor.submit(task1);
        Future<Integer> future2 = executor.submit(task2);

        System.out.println("Doing other work...");

        //String result = null;
        try {
            //result = future.get();

            int result1 = future1.get();
            int result2 = future2.get();

            System.out.println("Sum 1: " + result1);
            System.out.println("Sum 2: " + result2);
            System.out.println("Total: " + (result1 + result2));
        } catch (InterruptedException ex) {
            System.getLogger(FutureExample.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (ExecutionException ex) {
            System.getLogger(FutureExample.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } finally{
            executor.shutdown();
        }
        
    }

}
