package com.test.flink.one.functions;

import org.apache.flink.api.common.functions.*;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.api.java.tuple.Tuple1;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.assigners.ProcessingTimeSessionWindows;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.api.windowing.triggers.CountTrigger;
import org.apache.flink.util.Collector;

public class StreamJavaTest {
    public static void main(String[] args) throws Exception {
        filter();
    }

    public static void filter() throws Exception {
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
                .filter((FilterFunction<String>) value -> !value.equals("spark"))
                .print();

        env.execute("filter test");
    }

    public static void flatmap() throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.createLocalEnvironment();
        env.fromElements(Tuple1.of("flink jobmanger taskmanager")
                , Tuple1.of("spark streaming")
                , Tuple1.of("hadoop hdfs flink spark"))
                .flatMap((FlatMapFunction<Tuple1<String>, Tuple2<String, Long>>) (value, out) -> {
                    for (String item : value.f0.split(" ")) {
                        out.collect(Tuple2.of(item, 1L));
                    }
                })
                .print();

        env.execute("Flatmap");
    }

    public static void join() throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.createLocalEnvironment();

        env.fromElements(
                Tuple2.of("hadoop", 1)
                , Tuple2.of("spark", 1)
                , Tuple2.of("flink", 1)
                , Tuple2.of("storm", 1))
                .join(env.fromElements(
                        Tuple2.of("hadoop", 2)
                        , Tuple2.of("spark", 2)
                        , Tuple2.of("flink", 2)
                        , Tuple2.of("storm", 2)
                        , Tuple2.of("storm1", 2)
                ))
                .where((KeySelector<Tuple2<String, Integer>, String>) value -> value.f0)
                .equalTo((KeySelector<Tuple2<String, Integer>, String>) value -> value.f0)
                .window(ProcessingTimeSessionWindows.withGap(Time.seconds(10)))
                .trigger(CountTrigger.of(1))
                /*.apply(new JoinFunction<Tuple2<String, Integer>, Tuple2<String, Integer>, Tuple3<String, Integer, Integer>>() {
                    @Override
                    public Tuple3<String, Integer, Integer> join(Tuple2<String, Integer> first, Tuple2<String, Integer> second) throws Exception {
                        return Tuple3.of(first.f0, first.f1, second.f1);
                    }
                })*/
                .apply((FlatJoinFunction<Tuple2<String, Integer>, Tuple2<String, Integer>, Tuple3<String, Integer, Integer>>) (first, second, out) -> out.collect(Tuple3.of(first.f0, first.f1, second.f1)))

                .print();
        env.execute("join test");
    }

    public static void keyby() throws Exception {
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
                .flatMap((FlatMapFunction<Tuple1<String>, Tuple2<String, Long>>) (value, out) -> {
                    for (String item : value.f0.split(" ")) {
                        out.collect(Tuple2.of(item, 1L));
                    }
                })
                .keyBy(0)
                .print();

        env.execute("filter test");
    }

    public static void map() throws Exception {
        //获取环境变量
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.fromElements(
                Tuple1.of("haddop"),
                Tuple1.of("spark"),
                Tuple1.of("flink"))
                //.map(value -> "I like " + value.f0)
                .map((MapFunction<Tuple1<String>, String>) value -> "I like " + value.f0)
                .print();


        env.execute("map test");
    }

    public static void reduce() throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.createLocalEnvironment();
        env.fromElements(Tuple1.of("flink jobmanger taskmanager flink flink streaming spark streaming hadoop hdfs flink spark"))
                .flatMap((FlatMapFunction<Tuple1<String>, Tuple2<String, Long>>) (value, out) -> {
                    for (String item : value.f0.split(" ")) {
                        out.collect(Tuple2.of(item, 1L));
                    }
                }).keyBy(0)
                .reduce((ReduceFunction<Tuple2<String, Long>>) (value1, value2) -> Tuple2.of(value1.f0, value1.f1 + value2.f1))
                .print();

        env.execute("Flatmap");
    }

    public static void union() throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.createLocalEnvironment();
        env.fromElements("haddpp", "flink", "spark", "storm", "kafka")
                .union(env.fromElements("haddpp", "kafka", "rabbitmq", "activemq", "rocketmq"))
                .print();

        env.execute("uinon test");
    }


}
