package com.test.flink.one.functions;

import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.tuple.Tuple1;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class MapFunTest {
    public static void main(String[] args) throws Exception {
        //获取环境变量
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.fromElements(
                Tuple1.of("haddop"),
                Tuple1.of("spark"),
                Tuple1.of("flink"))
                //.map(value -> "I like " + value.f0)
                .map(new MapFunction<Tuple1<String>, String>() {
                    @Override
                    public String map(Tuple1<String> value) throws Exception {
                        return "I like "+value.f0;
                    }
                })
                .print();


        env.execute("map test");
    }

/*
7> I like haddop
8> I like spark
1> I like flink

*/


}
