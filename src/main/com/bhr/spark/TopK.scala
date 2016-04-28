package main.com.bhr.spark

import org.apache.spark._

/**
  * Created by yesterday on 2016/4/27.
  */
object TopK {

  def main(args:Array[String]): Unit ={
    val conf = new SparkConf().setMaster("local").setAppName("wordcount")
    val sc = new SparkContext(conf)

    println(conf)
    println(sc)

    val textRdd = sc.textFile("data.txt")
    println(textRdd)

    println("rdd:" + textRdd.count)

    val wordCount = textRdd.flatMap {
      line => line.toString.split("\\s+")
    }.map(word => (word,1)).reduceByKey{
      (key,value) => key + value
    }.collect()

    wordCount.foreach(println)

  }

}
