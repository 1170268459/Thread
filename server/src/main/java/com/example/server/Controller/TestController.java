package com.example.server.Controller;

import com.example.server.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class TestController {
    @Autowired
    TestService testService;

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
    public String test(String a) throws InterruptedException {
        int i = ato.get();
        if(i == 5){
            synchronized (this){
                ato.set(0);
                notifyAll();
                String model = testService.Producer();
                System.out.println(model);
                String consumer = testService.Consumer();
                System.out.println(consumer);
                return consumer;

            }

        }
        ato.incrementAndGet();
        synchronized (this){
            wait();
        }
        return a;
    }
}
