package main.com.bhr.spark

import org.apache.spark._

/**
  * Created by yesterday on 2016/4/27.
  */
object RDDParallelize {

  def main(args:Array[String]): Unit ={
    val conf = new SparkConf().setMaster("local").setAppName("wordcount")
    val sc = new SparkContext(conf)

    val list = List("hello world","hello scala","hello spark","hello java")

    val parRdd = sc.parallelize(list);

    val mapRdd = parRdd.map(line =>  line.split(" "))

    val result = mapRdd.collect()

    result.foreach(x => println(x.getClass))
  }

}
