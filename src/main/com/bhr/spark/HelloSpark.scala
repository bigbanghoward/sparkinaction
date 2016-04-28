package main.com.bhr.spark

import org.apache.spark._
import SparkContext._

/**
  * Created by yesterday on 2016/4/27.
  */
object HelloSpark {

  def main(args:Array[String]): Unit ={
    val conf = new SparkConf().setMaster("local").setAppName("hello")
    val sc = new SparkContext(conf)

    println(conf)
    println(sc)

  }

}
