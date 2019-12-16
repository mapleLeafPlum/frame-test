package com.test.scala.fun

import scala.annotation.meta.{beanGetter, beanSetter}
import scala.beans.BeanProperty

class FunTest(var name:String,var age:Int) {

  var money=100;

  @BeanProperty var balance=100;


  @beanSetter @beanGetter var pay=100;
}
