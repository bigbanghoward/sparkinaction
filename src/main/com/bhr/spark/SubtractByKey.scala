package main.com.bhr.spark

import org.apache.spark._

/**
  * Created by yesterday on 2016/4/27.
  */
object SubtractByKey {

  def main(args:Array[String]): Unit ={
    val conf = new SparkConf().setMaster("local").setAppName("wordcount")
    val sc = new SparkContext(conf)
    val textRdd = sc.textFile("data3.txt")
    val textRdd3 = sc.textFile("data4.txt")

    val wordCount = textRdd.flatMap {
      line => line.toString.split("\\s+")
    }.map(word => (word,1))

    val wordCount3 = textRdd3.flatMap {
      line => line.toString.split("\\s+")
    }.map(word => (word,1))

    wordCount.subtract(wordCount3).foreach(println)

  }

}
