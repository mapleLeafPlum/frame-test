package com.test.flink.one.functions;


import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class UnionFunTest {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.createLocalEnvironment();
        DataStreamSource<String> source = env.fromElements("haddpp", "flink", "spark", "storm", "kafka");
        DataStreamSource<String> source1 = env.fromElements("haddpp", "kafka", "rabbitmq", "activemq", "rocketmq");
        source.union(source1).print();
        env.execute("uinon test");
    }
    /*
    5> haddpp
    8> activemq
    6> kafka
    4> spark
    2> haddpp
    1> rocketmq
    3> flink
    7> rabbitmq
    6> kafka
    5> storm

     */
}
