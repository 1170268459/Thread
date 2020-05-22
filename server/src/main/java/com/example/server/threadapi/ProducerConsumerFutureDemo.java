package com.example.server.threadapi;


import com.example.server.model.Feedback;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerConsumerFutureDemo {

    private final  static ExecutorService service= Executors.newCachedThreadPool();


    public static void main(String[] args) throws InterruptedException {
        Random random=new Random();

        ProducerConsmerFutureQueue<Feedback> queue=new ProducerConsmerFutureQueue<>();
        ProducerFuture producer=new ProducerFuture(queue);
        Consumer consumer=new Consumer(queue);


        System.out.println("开始生产");
        service.submit(producer);

        System.out.println("开始消费");
        service.submit(consumer);
        service.shutdown();

      /*  Future<Integer> f=service.submit(new MyCall(2,5));
        //判断是否已经完成
        boolean done = f.isDone();
        System.out.println("第一次判断是否完成任务："+done);
        //
        boolean cancelled = f.isCancelled();
        System.out.println("第一次判断任务是否取消："+cancelled);
        Integer b = f.get();
        System.out.println("任务的允许结果："+b);
        boolean fDone = f.isDone();
        System.out.println("第二次判断任务是否完成："+fDone);

        boolean cancelled1 = f.isCancelled();
        System.out.println("第二次判断任务是否取消："+cancelled1);*/


    }

}
