package com.test.flink.one.count;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.util.Collector;

public class FlinkTest {
    public static void main(String[] args) throws Exception {

        FlatMapFunction<String,String> function=(a,b)->{
            String c="";
            for(String key:a.split(" ")){
                c=c+"-"+key;
            }
            b.collect(c);
        };
        Collector<String> out= null;
        function.flatMap("bac game abc name age age",out);
    }
}
