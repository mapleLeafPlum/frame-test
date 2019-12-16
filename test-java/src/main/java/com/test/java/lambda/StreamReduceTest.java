package com.test.java.lambda;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 2019/1/20 cx
 */
public class StreamReduceTest {
    public static void main(String[] args) {
        reduceThreeParam();


    }

    public static void reduceThreeParam(){
        //accumulator不写入list,不需要线程同步,初始值使用普通的list
        List<Integer> list = new ArrayList<>();
        AtomicInteger accumulateCount = new AtomicInteger(0);
        AtomicInteger combineCount = new AtomicInteger(0);

        List<Integer> data = new ArrayList<>();
        for(int i=0;i<100;i++){
            data.add( i );
        }
        List<Integer> reduceResult= data.stream().parallel()
                .reduce(list, (i, j) -> {
                    accumulateCount.incrementAndGet();
                    System.out.println("i="+i+",j="+j);
                    //不改变初始的i,而是返回一个新的i
                    ArrayList<Integer> newI = new ArrayList<>(i);
                    newI.add(j);
                    return newI;
                }, (i, j) -> {
                    combineCount.incrementAndGet();
                    System.out.println(String.format("i==j: %s, thread name:%s,i=%s,j=%s", i == j, Thread.currentThread().getName(),i,j));
                    ArrayList<Integer> newI = new ArrayList<>(i);
                    newI.addAll(j);
                    return newI;
                });
        System.out.println("---------------------------------------");
        System.out.println("reduce result size: "+reduceResult.size());
        System.out.println("reduce result : "+reduceResult);
        System.out.println("accumulateCount: "+accumulateCount.get());
        System.out.println("combineCount: "+combineCount.get());
    }

    public static void reduceThreeParam1(){
        //accumulator不写入list,不需要线程同步,初始值使用普通的list
        List<Integer> list = new ArrayList<>();
        AtomicInteger accumulateCount = new AtomicInteger(0);
        AtomicInteger combineCount = new AtomicInteger(0);

        List<Integer> data = new ArrayList<>();
        for(int i=0;i<1000;i++){
            data.add( i );
        }
       // List<Integer> reduceResult=
        Integer reduceResult=  data.stream().parallel()
                .reduce(10,(i,j)->i+j,(x,y)->x+y);
        Integer reduceResult1=  data.stream().parallel()
                .reduce(10,(i,j)->i+j);
        System.out.println("---------------------------------------");
       // System.out.println("reduce result size: "+reduceResult.size());
        System.out.println("reduce result : "+reduceResult);
        System.out.println("reduce result : "+reduceResult1);
        System.out.println("accumulateCount: "+accumulateCount.get());
        System.out.println("combineCount: "+combineCount.get());
    }
}
