package main.com.bhr.spark

import org.apache.spark._
import scala.collection.mutable.LinkedList
/**
  * Created by yesterday on 2016/4/27.
  */
object InvertedIndex {

  def main(args:Array[String]): Unit ={
    val conf = new SparkConf().setMaster("local").setAppName("wordcount")
    val sc = new SparkContext(conf)
    val textRdd = sc.textFile("data2.txt")

    val wordCount = textRdd.map(
      line => line.toString.split(",")
    ).map(item => (item(0),item(1)))

    val wordRdd = wordCount.flatMap( file => {
      val list = new LinkedList[(String,String)]
      val words = file._2.split("\\s+").iterator

      while(words.hasNext){
        val word = words.next
        //list+ (word,file._1)
      }

      list
    })

    println(wordRdd.count())
    wordRdd.foreach(println)

  }

}
