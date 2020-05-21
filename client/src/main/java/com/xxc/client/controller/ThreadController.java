package com.xxc.client.controller;

import com.xxc.client.feign.ServerClient;
import com.xxc.client.service.ThreadService;
import com.xxc.client.thread.MyThreadPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.StringReader;

@RestController
public class ThreadController {
    @Autowired
    ServerClient serverClient;
    @Autowired
    ThreadService threadService;

    @GetMapping("/test")
    public String  Test(){
        String s = serverClient.create(1);
        System.out.println(s);

        /* new test().run();
        System.out.println("finished!");
        return "tre";*/
        return s;
    }
    @GetMapping("/one")
    public String One(){
        String s = threadService.ThreadStart();
        System.out.println(s);
        return "chengd";
    }

}
