package com.example.server.service;

import com.example.server.model.Feedback;
import com.example.server.threadapi.ProducerAndConsumer;
import com.example.server.threadapi.ProducerConsmerFutureQueue;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class TestService {

   private ProducerAndConsumer producerAndConsumer;


    public TestService(ProducerAndConsumer producerAndConsumer) {
        this.producerAndConsumer = producerAndConsumer;
    }

    public String Producer(){
        return producerAndConsumer.ThreadTest();
    }

    public String Consumer(){
        return  producerAndConsumer.ConsumerTest();
    }

}
