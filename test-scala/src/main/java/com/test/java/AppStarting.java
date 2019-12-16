package com.test.java;

import java.util.ArrayList;
import java.util.List;

public class AppStarting {
    public static void main(String[] args) {
        List<Integer> arr=new ArrayList<>();
        arr.add(234);
        arr.add(123);
        arr.add(343);
        arr.stream().filter(x->x%2==0).map(x->x+2);

    }
}
