package com.webxiaohua.design.providor;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * 生产者
 */
public class Producer implements Runnable{
    private final BlockingQueue<Integer> queue;
    public Producer(BlockingQueue _queue){
        this.queue = _queue;
    }

    private int produce(){
        int n = new Random().nextInt(10000);
        System.out.println("Thread:"+Thread.currentThread().getId()+" produce:"+n);
        return n;
    }

    @Override
    public void run() {
        try{
            while(true){
                Thread.sleep(1000);
                queue.put(produce());
            }
        }catch(InterruptedException ex){
            System.out.println("Producer InterruptedException : "+ex.getMessage());
        }
    }
}
