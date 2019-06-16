package com.webxiaohua.design.providor;

import java.util.concurrent.BlockingQueue;

/**
 * 消费者
 */
public class Consumer implements Runnable{
    private final BlockingQueue<Integer> queue;
    public Consumer(BlockingQueue _queue){
        this.queue = _queue;
    }
    private void consume(Integer n){
        System.out.println("Thread:"+Thread.currentThread().getId()+" consume:"+n);
    }

    @Override
    public void run() {
        try{
            while(true){
                Thread.sleep(2000);
                consume(queue.take());
            }
        }catch(InterruptedException ex){
            System.out.println("Consumer InterruptedException : "+ex.getMessage());
        }
    }
}
