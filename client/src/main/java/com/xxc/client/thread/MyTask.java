package com.xxc.client.thread;

import com.xxc.client.feign.ServerClient;
import lombok.SneakyThrows;

public class MyTask implements Runnable {

    private ServerClient serverClient;

    public MyTask(ServerClient serverClient) {
        this.serverClient = serverClient;
    }

    @SneakyThrows
    @Override
    public void run() {
        String s = serverClient.create(1);
        System.out.println(s);
    }

}
