package com.test.java.lambda;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 2019/1/18 cx
 */
public class StreamTest {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>(  );
        for(int i=0;i<1000;i++){
            list.add( i );
        }

        System.out.println("---------filter---------------");
        list.stream().filter( e->e%10==0 ).forEach( System.out::println );
        System.out.println("---------map---------------");
        Stream<String> integerStream=list.stream().map( e->e+"-100");
        integerStream.forEach( System.out::println );
        System.out.println("---------mapToInt---------------");
        list.stream().mapToInt( e->e).forEach( System.out::println );
        System.out.println("---------flatMap---------------");
        List<String> other=Arrays.asList( new String[]{"zxabcd","efgh","ight","cdaf","dfd","afdaf"} );
        String result=other.stream().map( x->x.split( "" ) )
                .flatMap( e-> Arrays.stream(e) )
                .distinct()
                .sorted()
                .peek( System.out::println )
                .skip( 2 )
                .limit( 4 )
                .reduce( (x,y)->x+y ).get();
        System.out.println(result);
        System.out.println("---------toArray---------------");
        List<String> intMpa=Arrays.asList( new String[]{"123","456","789","123","456","789"} );
        Object[] obj= intMpa.stream().toArray();
        for (Object o : obj) {
            System.out.println(o);
        }
        String[] arr=intMpa.stream().toArray(String[]::new);
        for (String s : arr) {
            System.out.println(s);
        }
        System.out.println("---------reduce---------------");
        System.out.println(intMpa.stream().reduce( (x,y)->x+y ).get());
        System.out.println(intMpa.stream().reduce("name", (x,y)->x+y+"," ));
        System.out.println(intMpa.stream().reduce("abc-", (x,y)->x+y+"," ,(a,b)->"-"+a+b));
        //String result=other.stream().map( x->x.split( "" ) ).flatMapToInt( e-> Arrays.stream(e) ).reduce( (x,y)->x+y ).get();
       // System.out.println(result);
        System.out.println("---------generate---------------");

       // Stream.generate( ()->"name" ).forEach( System.out::println );
        System.out.println("---------of---------------");
        Stream.of(arr ).forEach( System.out::println );
        Stream.of("dsf","sdfasd").forEach( System.out::println );

        Stream.of("dsf","sdfasd").forEach( System.out::println );
        System.out.println("---------reduce---------------");
        reduceThreeParam();
    }

    public static void reduceThreeParam(){
        //accumulator不写入list,不需要线程同步,初始值使用普通的list
        List<Integer> list = new ArrayList<>();
        AtomicInteger accumulateCount = new AtomicInteger(0);
        AtomicInteger combineCount = new AtomicInteger(0);

        List<Integer> data = new ArrayList<>();
        for(int i=0;i<1000;i++){
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
}
