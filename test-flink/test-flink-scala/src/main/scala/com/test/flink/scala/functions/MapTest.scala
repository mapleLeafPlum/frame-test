package com.test.flink.scala.functions

import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment
import org.apache.flink.streaming.api.scala._

object MapTest {
  def main(args: Array[String]): Unit = {
    val env = StreamExecutionEnvironment.createLocalEnvironment();
    val dataSource = env.fromElements(
      Tuple1.apply("hadoop")
      , Tuple1.apply("spark")
      , Tuple1.apply("flink"))
      .map(r=>"I like "+r)
      .print()

    Tuple1.apply(100)
    env.execute("scala map ")
  }

}
