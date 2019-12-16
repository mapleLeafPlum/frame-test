package com.test.java.lambda;

import java.util.Arrays;
import java.util.function.Supplier;

/**
 * 2019/1/18 cx
 */
public class SupplierTest {
    public static void main(String[] args) {
        Supplier<String> supplier=()->"fuck";
        System.out.println(supplier.get());


        String[] strs = { "aaa", "bbb", "ccc" };
        Arrays.stream(strs).map(str -> str.split("")).forEach(System.out::println);// Ljava.lang.String;@53d8d10a
        Arrays.stream(strs).map(str -> str.split("")).flatMap(Arrays::stream).forEach(System.out::println);// aaabbbccc
        Arrays.stream(strs).map(str -> str.split("")).flatMap(str -> Arrays.stream(str)).forEach(System.out::println);// aaabbbccc

    }
}
