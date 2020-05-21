package com.xxc.client.thread;

import com.xxc.client.feign.ServerClient;

public class test {
    public ServerClient serverClient;

    public ServerClient getServerClient() {
        return serverClient;
    }

    public void setServerClient(ServerClient serverClient) {
        this.serverClient = serverClient;
    }

    public static void main(String[] args) {
        test test=new test();
        test.tests();

    }
    public void  tests(){
        MyThreadPool pool=new MyThreadPool(2,4,20);
        for (int i = 0; i <100 ; i++) {
            //3.创建任务对象，并提交线程池

            MyTask myTask=new MyTask(serverClient);
            serverClient.create(1);
            pool.submit(myTask);
        }
    }
}
