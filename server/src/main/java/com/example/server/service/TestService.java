package com.example.server.service;

import com.example.server.threadapi.ProducerAndConsumer;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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
