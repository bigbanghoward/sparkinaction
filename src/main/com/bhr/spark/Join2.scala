package main.com.bhr.spark

import org.apache.spark._

/**
  * Created by yesterday on 2016/4/27.
  */
object Join2 {

  def main(args:Array[String]): Unit ={
    val conf = new SparkConf().setMaster("local").setAppName("wordcount")
    val sc = new SparkContext(conf)

    val data1 = sc.parallelize(List(("zhangsan",12),("lisi",13),("wangwu",14)))
    val data2 = sc.parallelize(List(("zhangsan",56),("zhangsan",89),("wangwu",41)))

    data1.join(data2).foreach(println)
  }

}
