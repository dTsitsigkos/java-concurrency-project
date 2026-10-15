package com.dtsitsigkos.threads;
// class Task{
//     private String taskName;

//     public Task(String taskName){
//         this.taskName = taskName;
//     }

//     public void printTaskName(){
//         System.out.println("Task: " + taskName);
//     }

//     public String getTaskname(){
//         return this.taskName;
//     }
// }

// class MyRunnable extends Task implements Runnable{
    
//     public MyRunnable(String taskName){
//         super(taskName);
//     }

//     @Override 
//     public void run(){

//         for (int i = 1; i <= 5 ; i++){
//             System.out.println(Thread.currentThread().getName() + " printing: " + i + " Task: " + getTaskname());

//             try {
//                 Thread.sleep(500);
//             } catch (InterruptedException e) {
//                 System.out.println("Thread interrupted: " + e.getMessage() + " Problem in Task: " + getTaskname() );
//             }
//         }
//     }
// }

// public class RunnableExample {
//     public static void main(String[] args){
//          System.out.println("Implements Runnable interface");

//         Thread thread1 = new Thread (new MyRunnable("Dowloading"));
//         Thread thread2 = new Thread (new MyRunnable("Uploading"));

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


//// Simple example without using inheritance from another class
class MyRunnable implements Runnable{
    @Override 
    public void run(){

        for (int i = 1; i <= 5 ; i++){
            System.out.println(Thread.currentThread().getName() + " printing: " + i);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
            }
        }
    }
}

public class RunnableExample {
    public static void main(String[] args){
         System.out.println("Implements Runnable interface");

        Thread thread1 = new Thread (new MyRunnable());
        Thread thread2 = new Thread (new MyRunnable());

        thread1.start();
        thread2.start();


        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
    }
}




//// Simple example without using inheritance by with locks

// class CounterLock{
//     private int counter = 0;
//     private final ReentrantLock lock = new ReentrantLock();

//     public void increment (){
        
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

// class MyRunnable implements Runnable{
//     private final CounterLock counter;

//     public MyRunnable(CounterLock counter){
//         this.counter =  counter;
//     }
    
//     @Override 
//     public void run(){

//         for (int i = 0 ; i < 100 ; i ++){
//             counter.increment();
//         }
//     }
// }

// public class RunnableExample {
//     public static void main(String[] args){
//         System.out.println("Implements Runnable interface");

//         CounterLock counter = new CounterLock();


//         Thread thread1 = new Thread (new MyRunnable(counter));
//         Thread thread2 = new Thread (new MyRunnable(counter));

//         thread1.start();
//         thread2.start();

//         try {
//             thread1.join();
//             thread2.join();
//         } catch (InterruptedException e) {
//             Thread.currentThread().interrupt();
//             return;
//         }

//         System.out.println("Final counter:" + counter.getCounter());
//     }
//}

