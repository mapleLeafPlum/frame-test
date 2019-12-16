package com.test.scala.fun

class Person {

  var name:String=null;
  var age:Int=0;

  def this(name:String){
    this();
    this.name=name;
  }

  def this(name:String,age:Int){
    this(name);
    this.age=age;
  }

}
