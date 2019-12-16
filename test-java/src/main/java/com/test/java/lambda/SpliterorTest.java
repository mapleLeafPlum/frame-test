package com.test.java.lambda;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

/**
 * 2019/1/18 cx
 */
public class SpliterorTest {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>(  );
        for(int i=0;i<10000000;i++){
            list.add( "stream-"+i );
        }
        LocalDateTime start=LocalDateTime.now();
       /* list.forEach( e->{
            System.out.println("thread:"+Thread.currentThread()+",result:"+e);
        } );*/
        LocalDateTime middle=LocalDateTime.now();

        Spliterator<String> split= list.spliterator();
        System.out.println(split.characteristics());
        System.out.println(split.estimateSize());

      /*  split.forEachRemaining( e-> {
            System.out.println("thread:"+Thread.currentThread()+",result:"+e);
        } );*/
        LocalDateTime end=LocalDateTime.now();
        System.out.println("a:"+start);
        System.out.println("b:"+middle);
        System.out.println("c:"+end);
    }
}
