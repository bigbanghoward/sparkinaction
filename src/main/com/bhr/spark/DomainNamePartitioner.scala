package main.com.bhr.spark

import java.net.URL

import org.apache.spark._

class DomainNamePartitioner(numParts :Int) extends org.apache.spark.Partitioner{

  override def numPartitions:Int = numParts

  override def getPartition(key: Any): Int = {
    val domain = new java.net.URL(key.toString).getHost
    val code = (domain.hashCode % numPartitions)

    if(code < 0){
      code + numPartitions
    }else{
      code
    }

  }

  override def equals(other: Any): Boolean = other match {
    case dnp: DomainNamePartitioner =>
      dnp.numPartitions == numPartitions
    case _ =>
      false
  }

}

/**
  * Created by yesterday on 2016/4/27.
  */
object DomainNamePartitioner {



}
