package com.xxc.client.thread;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MyThreadPool {
    private List<Runnable> tasks= Collections.synchronizedList(new LinkedList<>());

    private int num;

    private int corePoolSize;

    private int maxSize;

    private int workSize;

    public MyThreadPool(int corePoolSize, int maxSize, int workSize) {
        this.corePoolSize = corePoolSize;
        this.maxSize = maxSize;
        this.workSize = workSize;
    }

    public void submit(Runnable runnable){
        if (tasks.size()>=workSize){
            System.out.println("任务被丢弃");
        }else{
            tasks.add(runnable);
            execTask(runnable);
        }

    }

    private void execTask(Runnable runnable){
        if (num<corePoolSize){
            new MyWorker("核心线程被执行"+num,tasks).start();
        }
    }
}
