package com.test.spark.scala.mqtt

import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.mqtt.MQTTUtils
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.{SparkConf, SparkContext}

/**
  *
  * 2019/2/19 cx
  */
object MqttTest {
  def main(args: Array[String]): Unit = {


    // 创建一个local StreamingContext，包含2个工作线程，并将批次间隔设为1秒
    // master至少需要2个CPU核，以避免出现任务饿死的情况
    val conf = new SparkConf().setMaster("local[*]").setAppName("mqttTest")
    val sc = new SparkContext(conf)
    val ssc = new StreamingContext(sc, Seconds(2))
    val brokerUrl = "tcp://192.168.8.208:1883";
    val topic = "abc/abc"
    val storageLevel = StorageLevel.MEMORY_ONLY
    val lines = MQTTUtils.createStream(ssc, brokerUrl, topic, storageLevel)
    lines.print(1000)

    ssc.start()
    ssc.awaitTermination()
  }

}
