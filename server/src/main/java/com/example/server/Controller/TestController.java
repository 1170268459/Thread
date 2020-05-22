package com.example.server.Controller;

import com.example.server.model.Feedback;
import com.example.server.service.TestService;
import com.example.server.service.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class TestController {
    @Autowired
    TestService testService;

    @Autowired
    ThreadService threadService;
    private static int m=0;

    public static AtomicInteger ato=new AtomicInteger(0);

   /* @PostMapping("/thread")
    public String create(Integer s){

        ato.incrementAndGet();
        if (ato.get()==5){
            String model = testService.Producer();
            System.out.println(model);
            ato.set(m);
            String consumer = testService.Consumer();
            System.out.println(consumer);
            return consumer;
        }else{
            return "被控制";
        }
    }*/



    @PostMapping("/thread")
    @ResponseBody
    public Feedback test(String a) throws InterruptedException, ExecutionException {
        System.out.println("进去");
        int i = ato.get();
        Feedback feedback =  threadService.ConsumerFuture(ato.get());
        System.out.println("================");
        if(i == 5){
            synchronized (this){
                ato.set(0);
                notifyAll();
                System.out.println("========iiii========");
                return feedback;
            }
        }
        ato.incrementAndGet();
        synchronized (this){
            wait();
        }
        System.out.println("========iiii========");
        return feedback;

    }
}
