package main.com.bhr.spark

import org.apache.spark._

/**
  * Created by yesterday on 2016/4/27.
  */
object Top {

  def main(args:Array[String]): Unit ={
    val conf = new SparkConf().setMaster("local").setAppName("wordcount")
    val sc = new SparkContext(conf)
    val textRdd = sc.parallelize(List("1","2","3","hello","spark"))

    println(textRdd)

    val wordCount = textRdd.top(3)

    wordCount.foreach(println)

  }

}
