package main.com.bhr.spark

import org.apache.spark._

/**
  * Created by yesterday on 2016/4/27.
  */
object Reduce {

  def main(args:Array[String]): Unit ={
    val conf = new SparkConf().setMaster("local").setAppName("wordcount")
    val sc = new SparkContext(conf)
    val textRdd = sc.textFile("data.txt")

    val c = sc.parallelize(1 to 10)
    val result = c.reduce((x, y) => x + y)

    //c.foreach(println)
    println(result)
  }

}
