package com.test.java.lambda;

import java.util.function.Predicate;

/**
 * 2019/1/18 cx
 */
public class PredicateTest {
    public static void main(String[] args) {
        System.out.println("-------------------------------");
        Predicate<Integer> predicate=a->a>0;
        Predicate<Integer> predicate1=a->a>10;
        System.out.println(predicate.test( 10 ));
        System.out.println(predicate.negate( ).test( 10 ));
        System.out.println(predicate.and(predicate1 ).test( 9 ));
        System.out.println(predicate.or(predicate1 ).test( 9 ));

        System.out.println(Predicate.isEqual( 10 ).test( 9 ));

        System.out.println("-------------------------------");


        System.out.println("-------------------------------");


        System.out.println("-------------------------------");


        System.out.println("-------------------------------");


        System.out.println("-------------------------------");


        System.out.println("-------------------------------");


        System.out.println("-------------------------------");
    }
}
