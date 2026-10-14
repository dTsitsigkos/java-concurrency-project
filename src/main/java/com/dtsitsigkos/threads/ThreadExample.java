package com.dtsitsigkos.threads;

class MyThread extends Thread{

    @Override 
    public void run(){
        for (int i = 1 ; i <= 5 ; i ++){
            System.out.println(Thread.currentThread().getName() + " printing:" + i);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
            }   
        }
    }
}


public class ThreadExample {
    public static void main (String[] args){
        System.out.println("Extending the Thread Class");

        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();


        thread1.start();
        thread2.start();
    }
}
