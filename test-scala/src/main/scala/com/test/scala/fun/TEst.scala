package com.test.scala.fun

object TEst {
  def main(args: Array[String]): Unit = {
    var a=new FunTest("caoxu",100);
    a.money=200;
    println(a.money,a.name,a.age)

    println(a.getBalance)
    a.setBalance(3000)
    println(a.getBalance)

    var person=new Person("caox",100);
    println(person.age,person.name)

  }
}
