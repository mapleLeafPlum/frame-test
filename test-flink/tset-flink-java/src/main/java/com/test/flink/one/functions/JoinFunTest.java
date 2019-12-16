package com.test.flink.one.functions;

import org.apache.flink.api.common.functions.FlatJoinFunction;
import org.apache.flink.api.common.functions.JoinFunction;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.assigners.ProcessingTimeSessionWindows;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.api.windowing.triggers.CountTrigger;
import org.apache.flink.util.Collector;


public class JoinFunTest {
    public static void main(String[] args) throws Exception {
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
                .where(new KeySelector<Tuple2<String, Integer>, String>() {
                    @Override
                    public String getKey(Tuple2<String, Integer> value) throws Exception {
                        return value.f0;
                    }
                })
                .equalTo(new KeySelector<Tuple2<String, Integer>, String>() {
                    @Override
                    public String getKey(Tuple2<String, Integer> value) throws Exception {
                        return value.f0;
                    }
                })
                .window(ProcessingTimeSessionWindows.withGap(Time.seconds(10)))
                .trigger(CountTrigger.of(1))
                /*.apply(new JoinFunction<Tuple2<String, Integer>, Tuple2<String, Integer>, Tuple3<String, Integer, Integer>>() {
                    @Override
                    public Tuple3<String, Integer, Integer> join(Tuple2<String, Integer> first, Tuple2<String, Integer> second) throws Exception {
                        return Tuple3.of(first.f0, first.f1, second.f1);
                    }
                })*/
                .apply(new FlatJoinFunction<Tuple2<String,Integer>, Tuple2<String,Integer>, Tuple3<String, Integer, Integer>>() {
                    @Override
                    public void join(Tuple2<String, Integer> first, Tuple2<String, Integer> second, Collector<Tuple3<String, Integer, Integer>> out) throws Exception {
                        out.collect(Tuple3.of(first.f0,first.f1,second.f1));
                    }
                })

                .print();
        env.execute("join test");

    }
}
