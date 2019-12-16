package com.test.java.lambda;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * 2019/1/20 cx
 */
public class CollectorTest {
    public static void main(String[] args) {

        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            data.add( i / 10 );
        }
        System.out.println( "---------toList--------------" );
        List<Integer> toList = data.stream().collect( Collectors.toList() );
        System.out.println( toList );
        System.out.println( "---------joining--------------" );
        String joining = data.stream().map( x -> x + "" ).collect( Collectors.joining() );
        System.out.println( joining );
        System.out.println( "---------joining--------------" );
        String join = data.stream().map( x -> x + "" ).collect( Collectors.joining( "," ) );
        System.out.println( join );
        System.out.println( "---------collectingAndThen--------------" );
        String collectingAndThen = data.stream().map( x -> x + "" ).collect( Collectors.collectingAndThen( Collectors.joining(), x -> x + " end" ) );
        System.out.println( collectingAndThen );
        System.out.println( "---------joining--------------" );
        String joining1 = data.stream().map( x -> x + "" ).collect( Collectors.joining( ",", "start", "end" ) );
        System.out.println( joining1 );
        System.out.println( "---------mapping--------------" );
        String joining2 = data.stream().collect( Collectors.mapping( x -> x + "", Collectors.joining() ) );
        System.out.println( joining2 );
        System.out.println( "---------toSet--------------" );
        Set<Integer> toSet = data.stream().collect( Collectors.toSet() );
        System.out.println( toSet );
        System.out.println( "---------toCollection--------------" );
        ArrayList<Integer> arrayList = data.stream().collect( Collectors.toCollection( ArrayList::new ) );
        System.out.println( arrayList );

        System.out.println( "---------toCollection--------------" );
        TreeSet<Integer> TreeSet = data.stream().collect( Collectors.toCollection( TreeSet::new ) );
        System.out.println( TreeSet );


        System.out.println( "---------toCollection--------------" );
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Person p = new Person();
            p.setAge( i / 10 );
            p.setName( "小名-" + i );
            p.setNo( "no" + i );
            p.setPrice( i * 1.1 );
            p.setGroup( "g-"+(i / 10) );
            personList.add( p );
        }

        Integer result = data.stream().collect( Collectors.reducing(100, (x, y) -> x + y ) );
        System.out.println( result );

        Integer result1 = data.stream().collect( Collectors.reducing((x, y) -> x + y )).get();
        System.out.println( result1 );

        Integer result2 = data.stream().collect( Collectors.reducing(100,x->x,(x, y) -> x + y ));
        System.out.println( result2 );

        System.out.println( "---------summingInt--------------" );

        int summing = personList.stream().collect(Collectors.summingInt(Person::getAge));
        System.out.println( summing );
        Person maxBy = personList.stream().collect(Collectors.maxBy(Comparator.comparingInt(Person::getAge))).get();
        System.out.println( maxBy );
        Person minBy = personList.stream().collect(Collectors.minBy(Comparator.comparingInt(Person::getAge))).get();
        System.out.println( minBy );
        double summing2 = personList.stream().collect(Collectors.averagingInt( Person::getAge));
        System.out.println( summing2 );
        long counting=personList.stream().collect(Collectors.counting());
        System.out.println( counting );
        System.out.println( "---------toMap--------------" );
        Map<String,String> toMap=personList.stream().collect( Collectors.toMap(Person::getNo,Person::getGroup));
        System.out.println( toMap.size()+","+toMap );
        Map<String,String> toMap2=personList.stream().collect( Collectors.toMap(Person::getNo,Person::getGroup,(x,y)->x+y));
        System.out.println( toMap2.size()+","+toMap2 );
        Map<String,String> toMap1=personList.stream().collect( Collectors.toMap(Person::getNo,Person::getGroup,(x,y)->x,HashMap::new));
        System.out.println( toMap1.size()+","+toMap1 );

        System.out.println( "---------groupingBy--------------" );

        Map<String,List<Person>> groupingBy=personList.stream().collect( Collectors.groupingBy(Person::getGroup));
        System.out.println(groupingBy);
        groupingBy.forEach( (key,val)-> System.out.println(key+"="+val));
        System.out.println( "---------groupingBy--------------" );
        Map<String,List<Person>> groupingByConcurrent=personList.stream().collect( Collectors.groupingByConcurrent(Person::getGroup));
        groupingByConcurrent.forEach( (key,val)-> System.out.println(key+"="+val));
    }

}
