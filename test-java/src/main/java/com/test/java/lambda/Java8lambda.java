package com.test.java.lambda;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 2019/1/11
 */
public class Java8lambda {
    public static void main(String[] args) {
        List languages = Arrays.asList( "Java", "Scala", "C++", "Haskell", "Lisp" );
        System.out.println(Integer.toHexString( 20 ));

        System.out.println(Integer.toString( 15 ,2));
        System.out.println(Integer.toBinaryString( 15 ));
        System.out.println(Integer.toString( 15 ,8));
        System.out.println(Integer.toOctalString( 15 ));
        System.out.println(Integer.toString( 15 ,16));
        System.out.println(Integer.toHexString( 15 ));
        System.out.println("---------------------");
        System.out.println(Integer.parseInt( "1111",2 ));
        System.out.println(Integer.parseInt( "17",8 ));
        System.out.println(Integer.parseInt( "15",10 ));
        System.out.println(Integer.parseInt( "f",16 ));
        System.out.println("---------------------");
        System.out.println(Integer.bitCount( 15));
        System.out.println("reverse---------------------");
        System.out.println(Integer.reverse( 15));


        System.out.println("---------------------");
        //System.out.println( "Languages which starts with J :" );
        // filter( languages, (str) -> str.startsWith( "J" ) );

        //System.out.println( "Languages which ends with a " );
        // filter( languages, (str) -> str.endsWith( "a" ) );

       /* System.out.println( "Print all languages :" );
        filter( languages, (str) -> true );

        System.out.println( "Print no language : " );
        filter( languages, (str) -> false );*/

        // System.out.println( "Print language whose length greater than 4:" );
        // filter( languages, (str) -> str.length() > 4 );

        Predicate<String> startsWithJ = (n) -> n.startsWith( "J" );
        Predicate<String> fourLetterLong = (n) -> n.length() == 4;

        List<Integer> costBeforeTax = Arrays.asList( 100, 200, 500, 300, 400 );
        Object sum=costBeforeTax.stream().reduce( (a,b)->a+b ).get();
        Object sum1=costBeforeTax.stream().reduce( Integer::sum).get();
        Object sum2=costBeforeTax.stream().reduce( (a,b)->a<b?b:a).get();
        System.out.println("sum:"+sum+",sum1:"+sum1+",sum2:"+sum2);

        Object max=costBeforeTax.stream().reduce( Integer::max ).get();
        System.out.println("max:"+max);

        Object min=costBeforeTax.stream().reduce( Integer::min ).get();
        System.out.println("min:"+min);

        Integer abc=costBeforeTax.stream().reduce(100,(x,y)->x+y);
        System.out.println("abc:"+abc);

        Integer safds=costBeforeTax.stream().reduce(100,Integer::sum,(x,y)->y+x);
        System.out.println("safds:"+safds);
    }

    //Even better
    public static void filter(List names, Predicate condition) {
        names.stream().filter( (name) -> (condition.test( name )) )
                .forEach( (name) -> {
                    System.out.println( name + " " );
                } );
    }
}
