package com.test.flink.one.functions;


import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple1;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;

public class KeyByFunTest {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.createLocalEnvironment();
        env.fromElements(
                Tuple1.of("flink flink streaming")
                , Tuple1.of("spark streaming")
                , Tuple1.of("hadoop hdfs flink spark"))
               /* .flatMap(new FlatMapFunction<Tuple1<String>, Tuple1<String>>() {
                    @Override
                    public void flatMap(Tuple1<String> value, Collector<Tuple1<String>> out) throws Exception {
                        for (String item : value.f0.split(" ")) {
                            out.collect(Tuple1.of(item));
                        }
                    }
                })*/
                .flatMap(new FlatMapFunction<Tuple1<String>, Tuple2<String, Long>>() {
                    @Override
                    public void flatMap(Tuple1<String> value, Collector<Tuple2<String, Long>> out) throws Exception {
                        for (String item : value.f0.split(" ")) {
                            out.collect(Tuple2.of(item, 1L));
                        }
                    }
                })
                .keyBy(0)
                .print();

        env.execute("filter test");
    }
}
