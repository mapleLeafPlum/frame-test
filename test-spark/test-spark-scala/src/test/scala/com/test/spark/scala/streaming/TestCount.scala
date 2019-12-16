package com.test.spark.scala.streaming

import org.apache.spark.sql.SparkSession

/**
  *
  * 2019/2/18 cx
  */
object TestCount {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder()
      .appName("count")
      .master("local[3]")
      .getOrCreate()

    val json = spark.read.json("D:/resources/people.json")
    json.show()
    // spark.stop()
  }
}
