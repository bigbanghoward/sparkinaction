package main.com.bhr.spark

import org.apache.spark._

/**
  * Created by yesterday on 2016/4/27.
  */
object FlatMapValues {

  def main(args:Array[String]): Unit ={
    val conf = new SparkConf().setMaster("local").setAppName("wordcount")
    val sc = new SparkContext(conf)

    val textRdd = sc.textFile("data3.txt")

    val result = textRdd.flatMap( line => {
      line.split("\\s+")
    }).map(x => (x,x.length))

    val word = result.flatMapValues( 1 to _ )

    word.foreach(println)
  }

}
