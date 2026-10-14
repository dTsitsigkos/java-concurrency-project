package com.dtsitsigkos.Synchronization;

class Counter{
    private int count = 0;

    public synchronized void increment(){
        count++;
    }

    public synchronized int getCount(){
        return this.count;
    }

}


public class SynchronizedMethodExample {
    
    public static void main(String[] args){
        System.out.println("Synchronized example");
        
        Counter counter = new Counter();


        //Runnable using lambda expression- modern java
        // Runnable task = ()->{
        //     for (int i = 0 ; i < 100 ; i ++){
        //         counter.increment();
        //     }
        // };

        // Thread thread1 = new Thread(task);
        // Thread thread2 = new Thread(task);


        //Thread using lambda expression modern java
        Thread thread1 = new Thread(() -> {
            for (int i = 0 ; i < 100 ; i ++){
                counter.increment();
            }
        });

        Thread thread2 = new Thread( ()->{
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
            System.out.println(Thread.currentThread().getName() + " " + e.getMessage() );
        }
        

        System.out.println("Final count = " + counter.getCount());

    }
}
