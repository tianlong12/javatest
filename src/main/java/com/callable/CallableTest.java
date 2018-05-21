package com.callable;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class TaskWithResult implements Callable<String> {
    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "result of TaskWithResult " + id;
    }
}

/*
运行Callable任务可以拿到一个Future对象，Future 表示异步计算的结果。它提供了检查计算是否完成的方法，以等待计算的完成，并获取计算的结果。
计算完成后只能使用 get 方法来获取结果，如果线程没有执行完，Future.get()方法可能会阻塞当前线程的执行；
如果线程出现异常，Future.get()会throws InterruptedException或者ExecutionException；
如果线程已经取消，会跑出CancellationException。取消由cancel 方法来执行。isDone确定任务是正常完成还是被取消了。
一旦计算完成，就不能再取消计算。如果为了可取消性而使用 Future 但又不提供可用的结果，则可以声明Future<?> 形式类型、并返回 null 作为底层任务的结果。
Future接口的定义如下：
Future模式
        Future模式在请求发生时，会先产生一个Future凭证给发出请求的客户，它的作用就像是Proxy物件，同时，由一个新的执行线程持续进行目标物件的生成（Thread-Per-Message），真正的目标物件生成之后，将之设定至Future之中，而当客户端真正需要目标物件时，目标物件也已经准备好，可以让客户提取使用。
        结合JDK的Future来看，就是你run线程后，你可以把线程的返回值赋给Future并返回一个Future对象。这时你可以立即拿到这个对象，然后进行下面的逻辑。但是如果你要get这个Future中的线程结果，就会被阻塞直到线程结束。
        就相当于现在的期房，你把手续和钱都交上去了，就可以马上拿到合同，但只有合同没有房子。这个时候你已经是有房一族了，你可以先去买家电买装修（走下面的其他逻辑）。但是你要把家电和装修放进去，就必须等到房子完工（阻塞）。

*/

public class CallableTest {
    public static void main(String[] args) throws InterruptedException,
            ExecutionException {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<Future<String>>();    //Future 相当于是用来存放Executor执行的结果的一种容器
        for (int i = 0; i < 10; i++) {
            results.add(exec.submit(new TaskWithResult(i)));
        }
        for (Future<String> fs : results) {
            if (fs.isDone()) {
                System.out.println(fs.get());
            } else {
                System.out.println("Future result is not yet complete");
            }
        }
        exec.shutdown();
    }
}