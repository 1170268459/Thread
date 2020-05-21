package com.example.server.threadapi;

import com.example.server.model.Feedback;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


@Component
public class ProducerAndConsumer {
    private static Integer count = 0;
    private static final Integer FULL = 10;
    private static String LOCK = "lock";

    public String ThreadTest(){
       Producer producer=new Producer();
        producer.run();
        return "生产者开始生产";
    }

    public String  ConsumerTest(){
        Consumer consumer=new Consumer();
        consumer.run();
        return "消费者开始消费";
    }


    class Producer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                Feedback feedback=new Feedback();
                feedback.setTec_ts(new Date());
                feedback.setTs_diff(new Date());
                feedback.setTs_diff(new Date());



                try {
                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (LOCK) {
                    while (count == FULL) {
                        try {
                            LOCK.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    System.out.println(Thread.currentThread().getName() + "生产者生产，目前总共有" + count);
                    LOCK.notifyAll();
                }
            }
        }
    }

    class Consumer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (LOCK) {
                    while (count == 0) {
                        try {
                            LOCK.wait();
                        } catch (Exception e) {
                        }
                    }
                    count--;
                    System.out.println(Thread.currentThread().getName() + "消费者消费，目前总共有" + count);
                    LOCK.notifyAll();
                }
            }
        }
    }

}
