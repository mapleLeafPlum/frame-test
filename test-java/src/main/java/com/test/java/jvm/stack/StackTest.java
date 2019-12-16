package com.test.java.jvm.stack;

public class StackTest {

    private int count = 0;

    public void testStack(int a, int b){
        int c =5;
        long d=47777777777777777L;
        count++;
        testStack(a,b);
    };

    public void test(){
        try {
            testStack(10,20);
        } catch (Throwable e) {
            System.out.println(e);
            System.out.println("stack height:"+count);
        }
    }

    public static void main(String[] args) {
        new StackTest().test();
    }
}
