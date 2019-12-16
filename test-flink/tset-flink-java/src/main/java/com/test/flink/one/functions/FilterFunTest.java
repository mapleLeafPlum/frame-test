package com.test.flink.one.functions;


import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple1;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;

public class FilterFunTest {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.createLocalEnvironment();
        env.fromElements(
                Tuple1.of("flink jobmanger taskmanager")
                , Tuple1.of("spark streaming")
                , Tuple1.of("hadoop hdfs flink spark"))
                .flatMap(new FlatMapFunction<Tuple1<String>, String>() {
                   @Override
                    public void flatMap(Tuple1<String> value, Collector<String> out) throws Exception {
                        for (String item : value.f0.split(" ")) {
                            out.collect(item);
                        }
                    }
                })
                .filter(new FilterFunction<String>() {
                    @Override
                    public boolean filter(String value) throws Exception {
                        return !value.equals("spark");
                    }
                })
                .print();

        env.execute("filter test");
    }
    /*
     3> hadoop
     1> flink
     2> streaming
     1> jobmanger
     3> hdfs
     1> taskmanager
     3> flink
     */
}
