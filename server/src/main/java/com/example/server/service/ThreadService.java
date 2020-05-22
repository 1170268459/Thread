package com.example.server.service;

import com.example.server.model.Feedback;
import com.example.server.threadapi.Consumer;
import com.example.server.threadapi.ProducerConsmerFutureQueue;
import com.example.server.threadapi.ProducerFuture;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Service
public class ThreadService {
    private final  static ExecutorService service= Executors.newCachedThreadPool();

    private ProducerConsmerFutureQueue<Feedback> queue=new ProducerConsmerFutureQueue<>();

    public String ProducerFuter(){
        ProducerFuture producer=new ProducerFuture(queue);
        System.out.println("开始生产");
        service.submit(producer);
        return "生产生产";

    }

    public Feedback ConsumerFuture( int ato) throws ExecutionException, InterruptedException {
        Consumer consumer=new Consumer(queue);
        Future<Feedback> submit = service.submit(consumer);
        Feedback feedback = submit.get();
        System.out.println("开始消费");
        if (ato==5){
            service.shutdown();
        }
        return feedback;

    }
}
