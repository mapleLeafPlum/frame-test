package com.test.java;

import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * 2019/1/24 cx
 */
public class JVMTest {
    public static void main(String[] args) {
        softReference();
    }

    public static void softReference(){
        Object obj=new Object();
        String str="hello";
        obj=null;//断开连接
        SoftReference<Object> ref=new SoftReference<>(obj);//软引用
        try{
            for(int x=0;x<Integer.MAX_VALUE;x++){
                str+=str+x;
                str.intern();
                System.out.println(str);
            }
        }catch(Throwable e){

        }
        System.out.println(ref.get());
    }

    public static void wakHashMap(String[]args){
        String key=new String("hi");
        String value=new String("hello");
        Map<String,String> map=new WeakHashMap<String,String>();
        map.put(key,value);
        System.out.println(map.get(key));
        key=null;
        System.out.println(map);
        System.gc();
        System.out.println(map);
    }

}
