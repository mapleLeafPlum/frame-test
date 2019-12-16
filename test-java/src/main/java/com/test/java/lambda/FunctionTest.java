package com.test.java.lambda;

import java.util.function.*;

/**
 * 2019/1/18 cx
 */
public class FunctionTest {
    public static void main(String[] args) {
        System.out.println( "----------------Function----------------------");
        Function<Integer,Integer> apply=e->e*2;
        Function<Integer,Integer> other=e->e+2;
        System.out.println( apply.apply( 10 ));
        System.out.println( apply.andThen( other ).apply( 10 ));
        System.out.println( apply.compose( other ).apply( 10 ));
        System.out.println( Function.identity().apply( 10 ));

        /*20
        22
        24*/

        System.out.println( "-----------------BiFunction---------------------");
        BiFunction<String,String,String> biFunction=(a,b)->a+";"+b;
        Function<String,String> biFunction1=(b)->b+" and fuck";
        System.out.println(biFunction.apply( "my name ","is docker" ));
        System.out.println(biFunction.andThen( biFunction1 ).apply( "my name","is docker" ));

        /*
        10
        my name ;is docker
        my name;is dockerand fuck*/

        System.out.println( "------------------IntFunction--------------------");
        IntFunction<Integer> intFunction=e->e*10;
        IntFunction<String> intFunction1=e->(e*10)+":100";
        System.out.println(intFunction.apply( 10 ));
        System.out.println(intFunction1.apply( 10 ));

       /* 100
        100:100*/

        System.out.println( "----------------DoubleFunction----------------------");
        DoubleFunction<Integer> doubleFunction=e->(int)(e*10);
        DoubleFunction<String> doubleFunction1=e->(e*10)+":100";
        System.out.println(doubleFunction.apply( 10.23 ));
        System.out.println(doubleFunction1.apply( 12.32 ));

       /* 102
        123.2:100*/

        System.out.println( "-----------------LongFunction---------------------");
        LongFunction<Integer> longFunction= e->(int)(e*10);
        LongFunction<String> longFunction1=e->(e*10)+":100";
        System.out.println(longFunction.apply( 100L ));
        System.out.println(longFunction1.apply( 100L ));

        /*1000
        1000:100*/

        System.out.println( "-----------------ToDoubleFunction---------------------");
        ToDoubleFunction<Integer> toDoubleFunction= e->(int)(e*10);
        ToDoubleFunction<String> toDoubleFunction1=e->Double.parseDouble(e+"100");
        System.out.println(toDoubleFunction.applyAsDouble( 100 ));
        System.out.println(toDoubleFunction1.applyAsDouble( "100" ));

       /* 1000.0
        100100.0*/

        System.out.println( "-----------------ToDoubleFunction---------------------");
        ToDoubleBiFunction<Integer,String> toDoubleBiFunction=(a,b)-> Double.parseDouble( (a+b) );
        ToDoubleBiFunction<String,String> toDoubleBiFunction1=(a,b)-> Double.parseDouble(a+b);
        System.out.println(toDoubleBiFunction.applyAsDouble( 100,"100"));
        System.out.println(toDoubleBiFunction1.applyAsDouble( "100","100" ));

       /* 100100.0
        100100.0*/

    }


}
