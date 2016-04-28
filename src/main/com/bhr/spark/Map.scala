package main.com.bhr.spark

import org.apache.spark._

/**
  * Created by yesterday on 2016/4/27.
  */
object Map {

  def main(args:Array[String]): Unit ={
    val conf = new SparkConf().setMaster("local").setAppName("wordcount")
    val sc = new SparkContext(conf)
    val textRdd = sc.textFile("data.txt")

    println(textRdd)

    val wordCount = textRdd.map {
      line => line.toString.split("\\s+")
    }

    wordCount.foreach(_.foreach(println))

  }

}
