package com.dtsitsigkos.threads;


//More complicated example that uses inheritance from another class
class Task{
    private String taskName;

    public Task(String taskName){
        this.taskName = taskName;
    }

    public void printTaskName(){
        System.out.println("Task: " + taskName);
    }

    public String getTaskname(){
        return this.taskName;
    }
}

class MyRunnable extends Task implements Runnable{
    
    public MyRunnable(String taskName){
        super(taskName);
    }

    @Override 
    public void run(){

        for (int i = 1; i <= 5 ; i++){
            System.out.println(Thread.currentThread().getName() + " printing: " + i + " Task: " + getTaskname());

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage() + " Problem in Task: " + getTaskname() );
            }
        }
    }
}

public class RunnableExample {
    public static void main(String[] args){
         System.out.println("Implements Runnable interface");

        Thread thread1 = new Thread (new MyRunnable("Dowloading"));
        Thread thread2 = new Thread (new MyRunnable("Uploading"));

        thread1.start();
        thread2.start();
    }
}


//// Simple example without using inheritance from another class
// class MyRunnable implements Runnable{
//     @Override 
//     public void run(){

//         for (int i = 1; i <= 5 ; i++){
//             System.out.println(Thread.currentThread().getName() + " printing: " + i);

//             try {
//                 Thread.sleep(500);
//             } catch (InterruptedException e) {
//                 System.out.println("Thread interrupted: " + e.getMessage());
//             }
//         }
//     }
// }

// public class RunnableExample {
//     public static void main(String[] args){
//          System.out.println("Implements Runnable interface");

//         Thread thread1 = new Thread (new MyRunnable());
//         Thread thread2 = new Thread (new MyRunnable());

//         thread1.start();
//         thread2.start();
//     }
// }

