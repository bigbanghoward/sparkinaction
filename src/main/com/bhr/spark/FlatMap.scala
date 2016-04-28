package main.com.bhr.spark

import org.apache.spark._

/**
  * Created by yesterday on 2016/4/27.
  */
object FlatMap {

  def main(args:Array[String]): Unit ={
    val conf = new SparkConf().setMaster("local").setAppName("wordcount")
    val sc = new SparkContext(conf)
    val textRdd = sc.textFile("data.txt")

    println(textRdd)

    val wordCount = textRdd.flatMap {
      line => line.toString.split("\\s+")
    }

    wordCount.foreach(println)
    println

  }

}
