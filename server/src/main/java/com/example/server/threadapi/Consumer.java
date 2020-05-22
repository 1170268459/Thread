package com.example.server.threadapi;

import com.example.server.model.Feedback;


import java.util.concurrent.Callable;

public class Consumer implements Callable<Feedback> {
    private ProducerConsmerFutureQueue<Feedback> queue;

    public Consumer(ProducerConsmerFutureQueue<Feedback> queue) {
        this.queue = queue;
    }

    @Override
    public Feedback call() throws Exception {
        Feedback user=null;
        user = queue.get();
        return user;
    }
}
