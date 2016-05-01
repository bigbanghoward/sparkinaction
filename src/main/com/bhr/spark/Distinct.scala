package main.com.bhr.spark

import org.apache.spark._

/**
  * Created by yesterday on 2016/4/27.
  */
object Distinct {

  def main(args:Array[String]): Unit ={
    val conf = new SparkConf().setMaster("local").setAppName("wordcount")
    val sc = new SparkContext(conf)
    val textRdd = sc.textFile("data3.txt")

    println(textRdd)

    val testRdd = sc.parallelize(List("1","2","3"))

    val rdd = textRdd.union(testRdd).distinct()

    rdd.foreach(println)

  }

}
