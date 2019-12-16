package com.test.java.lambda;

import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

/**
 * 2019/1/18 cx
 */
public class OperationTest {
    public static void main(String[] args) {
        System.out.println("-------------UnaryOperator--------------------");

        UnaryOperator<String> unaryOperator=e->e+"100";
        System.out.println(unaryOperator.apply( "10" ));
        System.out.println(UnaryOperator.identity().apply( "100" ));

        System.out.println("------------BinaryOperator---------------------");

        BinaryOperator<String> binaryOperator=(a,b)->a+b+"100";
        System.out.println(binaryOperator.apply( "10","10" ));

        Comparator<Integer> comparator=(a,b)->a>b?0:1;
        System.out.println(comparator.compare( 12,11 ));

        System.out.println(BinaryOperator.maxBy(comparator).apply( 12,20 ));
        System.out.println(BinaryOperator.minBy(comparator).apply( 12,20 ));

    }
}
