package main.com.bhr.spark

import org.apache.spark._

/**
  * Created by yesterday on 2016/4/27.
  */
object LearnSortByKey {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("wordcount")
    val sc = new SparkContext(conf)

    val data = List((1, 4), (4, 8), (0, 4), (12, 8))
    val rdd = sc.parallelize(data)

    //rdd.sortByKey().foreach(println)

    implicit val st = new Ordering[Int] {
      override def compare(a: Int, b: Int) = a.toString.compare(b.toString)
    }
    rdd.sortByKey().foreach(println)
  }

}
