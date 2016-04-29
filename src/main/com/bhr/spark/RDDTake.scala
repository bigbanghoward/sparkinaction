package main.com.bhr.spark

import org.apache.spark._

/**
  * Created by yesterday on 2016/4/27.
  */
object RDDTake {

  def main(args:Array[String]): Unit ={
    val conf = new SparkConf().setMaster("local").setAppName("wordcount")
    val sc = new SparkContext(conf)

    val list = List("hello world","hello scala","hello spark","hello java")

    val parRdd = sc.parallelize(list);

    val fileterRdd = parRdd.filter(x => x.contains("hello"))

    fileterRdd.take(2).foreach(println)
  }

}
