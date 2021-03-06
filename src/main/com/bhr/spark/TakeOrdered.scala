package main.com.bhr.spark

import org.apache.spark._

/**
  * Created by yesterday on 2016/4/27.
  */
object TakeOrdered {

  def main(args:Array[String]): Unit ={
    val conf = new SparkConf().setMaster("local").setAppName("wordcount")
    val sc = new SparkContext(conf)
    val textRdd = sc.parallelize(List("2","3","hello","spark","1"))

    println(textRdd)

    val wordCount = textRdd.takeOrdered(2)

    wordCount.foreach(println)

  }

}
