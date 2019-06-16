package com.webxiaohua.design.providor;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProvidorConsumerPattern {

    public static void main(String[] args){
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(100);
        Producer producer = new Producer(queue);
        Consumer consumer1 = new Consumer(queue);
        Consumer consumer2 = new Consumer(queue);
        System.out.println("Start...");
        new Thread(producer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();
        System.out.println("End...");
    }

}
