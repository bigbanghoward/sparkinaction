package main.com.bhr.spark

import org.apache.spark._

/**
  * Created by yesterday on 2016/4/27.
  */
object Partitioner {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("wordcount")
    val sc = new SparkContext(conf)

    val data = List((1, 4), (4, 8), (0, 4), (12, 8))
    val rdd = sc.parallelize(data)

    println(rdd.partitioner)
    println(rdd.partitioner.isDefined)

    val rdd2 = rdd.sortByKey()

    println(rdd2.partitioner)
    println(rdd2.partitioner.isDefined)
    println(rdd2.partitioner.get)

    val rdd3 = rdd2.partitionBy(new org.apache.spark.HashPartitioner(2))

    println(rdd3.partitioner)
    println(rdd3.partitioner.isDefined)
    println(rdd3.partitioner.get)
  }

}
