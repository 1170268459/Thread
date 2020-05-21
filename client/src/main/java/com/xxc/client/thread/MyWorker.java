package com.xxc.client.thread;

import java.util.List;

public class MyWorker extends Thread {
    private String name;
    private List<Runnable> tasks;

    public MyWorker( String name,  List<Runnable> tasks) {
        super(name);
        this.tasks = tasks;
    }

    //利用构造方法，给变量赋值
    @Override
    public void run() {
        //判断集合中是否有任务，只要有就一直执行
        while (tasks.size()>0){
            Runnable remove = tasks.remove(0);
            remove.run();

        }
    }
}
