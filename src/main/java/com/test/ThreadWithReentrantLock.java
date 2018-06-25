package com.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadWithReentrantLock implements Runnable {

    public static ReentrantLock lock = new ReentrantLock();

    private int i=0;

    public void run() {
        System.out.println(Thread.currentThread().getId()+":begin...");
        try{
            if(lock.tryLock())
            {
                System.out.println(Thread.currentThread().getId() + ":get lock successfully...");
            } else {
                System.out.println(Thread.currentThread().getId() + ":get lock failed...");
                lock.lockInterruptibly();
            }

            lock.lock();
            i++;
            System.out.println(Thread.currentThread().getId() +":i is " + i);
            Thread.sleep(3000);

        } catch(Exception e){
            System.out.println(e.getMessage());
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        ThreadWithReentrantLock  thread = new ThreadWithReentrantLock ();
        for(int i=0; i<6; i++){
            executorService.submit(thread);
        }
    }

}
