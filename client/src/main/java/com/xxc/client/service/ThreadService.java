package com.xxc.client.service;

import com.xxc.client.feign.ServerClient;
import com.xxc.client.thread.MyTask;
import com.xxc.client.thread.MyThreadPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThreadService {

    private ServerClient serverClient;

    public ThreadService(ServerClient serverClient) {
        this.serverClient = serverClient;
    }

    public String ThreadStart(){
        MyThreadPool threadPool=new MyThreadPool(5,10,10);
        for (int i = 0; i <5 ; i++) {
            MyTask myTask=new MyTask(serverClient);
            threadPool.submit(myTask);

        }
        return "执行";
    }

}
