package com.test.scala
import scala.collection.mutable.ArrayBuffer

object AppStart {

  def main(args: Array[String]): Unit = {
      println(12323)
  }
  println("------------------------------------")

  for(i <- 1 to 10 reverse;if i%2==0){
    println(i)
  }
  println("------------------------------------")
  var tem=for(i <- 1 until 10)yield{
    i*2;
    i+1;
  }
  println(tem)
  println("------------------------------------")
  var arr=Array[Int](1,3,4,8,5);
  for(i <- arr){
    println(i)
  }

  println("------------------------------------")
  var arrBuffer=ArrayBuffer[Int](2,3,89,5,6,7,5,4,3,4);
  arrBuffer+=454;

  for(i <- arrBuffer){
    println(i)
  }
  println("-----------------arrayList-------------------")
 /* var list=new util.ArrayList[Int];
  list.add(10);
  list.add(20)
  list.add(30)
  for(i <- 0 until  list.size()){
    println(list.get(i))
  }*/
  println("-----------------List-------------------")
  var abc=List(1,2,3,4,5,6,67,7,8,8,89,6,5,45);
  var abd=abc.filter(x=>x%2==0).map(x=>x*2)
  for(i <- abd){
    println(i)
  }
  abc.exists(_%2==0);
  abc.exists(x=>x%2==0)
  println("-----------------tuple-------------------")
  var t=(1,2,3,4,5)
  t.productIterator.foreach(println)
  println(t._1,t._2)
  var tup=Tuple3(3,4,5)
  println(tup._3)

  var (a,b,c,d,e)=t
  println(a)


}
