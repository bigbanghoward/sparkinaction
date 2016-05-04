package main.com.bhr.spark

import org.apache.spark._

/**
  * Created by yesterday on 2016/4/27.
  */
object GroupByKey {

  def main(args:Array[String]): Unit ={
    val conf = new SparkConf().setMaster("local").setAppName("wordcount")
    val sc = new SparkContext(conf)
    val textRdd = sc.textFile("data.txt")

    val result = textRdd.flatMap( line => {
      line.split("\\s+")
    }).map(x => (x,1))

    val word = result.groupByKey()

    word.foreach( x => println(x._1 + "\t" + x._2))
  }

}
