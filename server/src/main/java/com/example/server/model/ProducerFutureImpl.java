package com.example.server.model;

import com.example.server.service.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class ProducerFutureImpl implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
     ThreadService threadService;;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
         threadService.ProducerFuter();
    }
}
