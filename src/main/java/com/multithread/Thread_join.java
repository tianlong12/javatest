package com.multithread;
//本类主要说明join的用法
public class Thread_join extends Thread{
    private String name;
    public Thread_join(String name) {
        super(name);
        this.name=name;
    }
    public void run() {
        System.out.println(Thread.currentThread().getName() + " 线程运行开始!");
        for (int i = 0; i < 5; i++) {
            System.out.println("子线程"+name + "运行 : " + i);
            try {
                sleep((int) Math.random() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " 线程运行结束!");
    }
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+"主线程运行开始!");
        Thread_join mTh1=new Thread_join("A");
        Thread_join mTh2=new Thread_join("B");
        mTh1.start();
        mTh2.start();
        System.out.println(Thread.currentThread().getName()+ "主线程运行结束!");
        //没有加join时，主线程会先结束，子线程后结束，加入join，主线程会等待子线程结束之后再继续执行。
        /*System.out.println(Thread.currentThread().getName()+"主线程运行开始!");
        Thread_join mTh1=new Thread_join("A");
        Thread_join mTh2=new Thread_join("B");
        mTh1.start();
        mTh2.start();
        try {
            mTh1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            mTh2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+ "主线程运行结束!");
*/
    }
}


