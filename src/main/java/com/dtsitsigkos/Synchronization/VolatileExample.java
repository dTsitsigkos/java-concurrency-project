package com.dtsitsigkos.Synchronization;

public class VolatileExample {
    private volatile boolean flag = false;
    

    public void writer(){
        flag = true;
    }

    public void reader(){
        if (flag){
            System.out.println("Flag is true");
        }
    }

    public static void main(String[] args){
        VolatileExample example = new VolatileExample();

        Thread writer = new Thread(()->example.writer());
        Thread reader = new Thread(()->example.reader());

        writer.start();
        reader.start();

    }

}
