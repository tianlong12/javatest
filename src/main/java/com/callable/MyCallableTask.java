package com.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class MyCallableTask implements Callable<Integer> {

    public Integer call() throws Exception {
        System.out.println("线程在进行计算");
        Thread.sleep(3000);
        int sum = 0;
        for(int i=0;i<100;i++)
            sum += i;
        return sum;
    }
//除了利用线程池启动，也可以利用Futuretask运行
    public static void main(String[] args) {
        Callable<Integer> mycallabletask = new MyCallableTask();
        FutureTask<Integer> futuretask= new FutureTask<Integer>(mycallabletask);
        new Thread(futuretask).start();
    }
}
