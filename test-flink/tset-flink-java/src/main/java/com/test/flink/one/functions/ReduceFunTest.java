package com.test.flink.one.functions;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.functions.ReduceFunction;
import org.apache.flink.api.java.tuple.Tuple1;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;

public class ReduceFunTest {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.createLocalEnvironment();


        ReduceFunction<Tuple2<String, Long>> reduce = new ReduceFunction<Tuple2<String, Long>>() {
            @Override
            public Tuple2<String, Long> reduce(Tuple2<String, Long> value1, Tuple2<String, Long> value2) throws Exception {
                return Tuple2.of(value1.f0, value1.f1);
            }
        };

        env.fromElements(Tuple1.of("flink jobmanger taskmanager flink flink streaming spark streaming hadoop hdfs flink spark"))
                .flatMap(new FlatMapFunction<Tuple1<String>, Tuple2<String, Long>>() {
                    @Override
                    public void flatMap(Tuple1<String> value, Collector<Tuple2<String, Long>> out) throws Exception {
                        for (String item : value.f0.split(" ")) {
                            out.collect(Tuple2.of(item, 1L));
                        }
                    }
                }).keyBy(0)
                .reduce(new ReduceFunction<Tuple2<String, Long>>() {
                    @Override
                    public Tuple2<String, Long> reduce(Tuple2<String, Long> value1, Tuple2<String, Long> value2) throws Exception {
                        return Tuple2.of(value1.f0, value1.f1 + value2.f1);
                    }
                })
                .print();

        env.execute("Flatmap");
    }
    /*
    8> (hadoop,1)
    5> (hdfs,1)
    1> (spark,1)
    2> (streaming,1)
    7> (flink,1)
    1> (spark,2)
    2> (jobmanger,1)
    7> (flink,2)
    2> (taskmanager,1)
    */
}
