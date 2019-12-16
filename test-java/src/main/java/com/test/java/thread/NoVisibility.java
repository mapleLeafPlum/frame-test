package com.test.java.thread;

import java.time.LocalDateTime;

/**
 * 2019/1/28 cx
 */
public class NoVisibility {
    static boolean isRunning = true;
    static LocalDateTime now;

    public static void main(String[] args) throws InterruptedException {
        now = LocalDateTime.now();
        Thread runningT = getRunningThread();

        runningT.start();

        Thread.sleep( 5000 );

        isRunning = false;//注意： main Thread 执行到此,预期runningThread 应该结束
        System.out.println( "------------------" + now.toString() );

    }

    public static Thread getRunningThread() {
        return new Thread( () -> {
            while (isRunning) {
                System.out.println( "runing...." + LocalDateTime.now().toString() );
            }
        }, "RunningThread" );
    }
}
