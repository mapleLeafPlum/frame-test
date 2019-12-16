package com.test.java.lambda;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.ObjLongConsumer;

/**
 * 2019/1/18 cx
 */
public class ConsumerTest {
    public static void main(String[] args) {
        System.out.println("----------Consumer-----------");
        Consumer<String> consumer=e-> System.out.println("fuck:"+e);
        Consumer<String> consumer1=e-> System.out.println(" fuck:"+e);
        consumer.andThen( consumer1 ).accept( "100" ) ;

        System.out.println("----------BiConsumer-----------");
        BiConsumer<String,Integer> biConsumer= (a,b)-> System.out.println(b+",fuck:"+a);
        BiConsumer<String,Integer> biConsumer1=(a,b)-> System.out.println(b+",fuck:"+a);
        biConsumer.andThen( biConsumer1 ).accept( "100",10 ) ;

        System.out.println("----------ObjLongConsumer-----------");
        ObjLongConsumer<Long> objLongConsumer=(a,b)-> System.out.println(a+","+b);
        objLongConsumer.accept( 1l,2 );
    }
}
