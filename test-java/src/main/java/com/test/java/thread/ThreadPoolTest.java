package com.test.java.thread;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 2019/1/17 cx
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        try {
            taskPool();
            System.out.println("-----------------");
            taskNoPool();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void taskPool() throws InterruptedException {
        AtomicLong al = new AtomicLong(0l);
        Long s1 = System.currentTimeMillis();
        ThreadPoolExecutor pool = new ThreadPoolExecutor(5,
                10,
                100,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque(20000));

        for(int i=0;i<20000;i++){
            pool.execute(()->{
                try {
                    al.incrementAndGet();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } );
        }
        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.HOURS);
        System.out.println("耗时："+(System.currentTimeMillis()-s1));
        System.out.println("AtomicLong="+al.get());
    }

    public static void taskNoPool() throws InterruptedException {
        AtomicLong al = new AtomicLong(0l);
        Long s1 = System.currentTimeMillis();
        for(int i=0;i<20000;i++){
            Thread t = new Thread(()->{
                try {
                    al.incrementAndGet();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            t.start();
        }
        while(true){
            if(al.get()==20000){
                System.out.println("耗时："+(System.currentTimeMillis()-s1));
                System.out.println("AtomicLong="+al.get());
                break;
            }
            Thread.sleep(1);
        }
    }
}
