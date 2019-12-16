package com.test.flink.one.functions;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.functions.ReduceFunction;
import org.apache.flink.api.java.tuple.Tuple1;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;

public class FlatmapFunTest {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.createLocalEnvironment();


        ReduceFunction<Tuple2<String, Long>> reduce = new ReduceFunction<Tuple2<String, Long>>() {
            @Override
            public Tuple2<String, Long> reduce(Tuple2<String, Long> value1, Tuple2<String, Long> value2) throws Exception {
                return Tuple2.of(value1.f0, value1.f1);
            }
        };

        env.fromElements(Tuple1.of("flink jobmanger taskmanager")
                , Tuple1.of("spark streaming")
                , Tuple1.of("hadoop hdfs flink spark"))
                .flatMap(new FlatMapFunction<Tuple1<String>, Tuple2<String, Long>>() {
                    @Override
                    public void flatMap(Tuple1<String> value, Collector<Tuple2<String, Long>> out) throws Exception {
                        for (String item : value.f0.split(" ")) {
                            out.collect(Tuple2.of(item, 1L));
                        }
                    }
                })
                .print();

        env.execute("Flatmap");
    }

    /*
    5> (flink,1)
    6> (spark,1)
    7> (hadoop,1)
    6> (streaming,1)
    5> (jobmanger,1)
    7> (hdfs,1)
    5> (taskmanager,1)
    7> (flink,1)
    7> (spark,1)
    */
}
