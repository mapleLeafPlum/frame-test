package com.test.flink.scala.count

import org.apache.flink.streaming.api.scala._
import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment
import org.apache.flink.streaming.api.windowing.time.Time

object SocketWindowWordCount {
  def main(args: Array[String]): Unit = {
    println("starting scala ......")
    val port: Int = 9898;

    // get the execution environment
    val env: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment

    // get input data by connecting to the socket
    val text = env.socketTextStream("192.168.1.201", port, '\n')

    // parse the data, group it, window it, and aggregate the counts
    val windowCounts = text
      .flatMap(w => w.split("\\s"))
      .map (w => WordWithCount(w, 1))
      .keyBy("word")
      .timeWindow(Time.seconds(5), Time.seconds(1))
      .sum("count")

    // print the results with a single thread, rather than in parallel
    windowCounts.print().setParallelism(1)

    env.execute("Socket Window WordCount")
  }

  // Data type for words with count
  case class WordWithCount(word: String, count: Long)
}
