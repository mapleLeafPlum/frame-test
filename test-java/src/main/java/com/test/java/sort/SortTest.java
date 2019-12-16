package com.test.java.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortTest {
    public static void main(String[] args) {
        List<Person> personList=new ArrayList<>();
        personList.add(new Person(13,"abc"));
        personList.add(new Person(3,"abc"));
        personList.add(new Person(5,"abc"));
        personList.add(new Person(23,"abc"));
        personList.add(new Person(7,"abc"));

        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o2.getAge()-o1.getAge();
            }
        });
        System.out.println(personList.toString());

    }
}
