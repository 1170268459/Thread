package com.example.server.threadapi;

import com.example.server.model.Feedback;


import java.util.Date;
import java.util.concurrent.Callable;

public class ProducerFuture implements Callable<Feedback> {

    private ProducerConsmerFutureQueue<Feedback> queue;

    public ProducerFuture(ProducerConsmerFutureQueue<Feedback> queue) {
        this.queue = queue;
    }

    @Override
    public Feedback call() throws Exception {
        Feedback feedback=new Feedback();
        for (int i = 0; i <5 ; i++) {
            feedback.setTs_diff(new Date());
            feedback.setTec_ts(new Date());
            feedback.setResp_te(new Date());
            queue.put(feedback);
        }
        return feedback;
    }
}
