package main.com.bhr.scala

import java.io.FileReader

/**
  * Created by baihr on 2016/4/29.
  */
object PropertiesUtils {

  def main(args:Array[String]) :Unit ={
    val pro = getPropertyByPath("F:\\workspace_maven\\tydic-ctcloud-poster-hadoop-analysis\\src\\main\\resources\\jdbc.properties")
    println(pro.getProperty("jdbc.url"))

  }

  def getPropertyByPath(path:String):java.util.Properties = {
    if(path == null){
      new java.util.Properties
    }else{
      println("PropertiesUtils load:" + path)
      val pro = new java.util.Properties
      val file = new java.io.File(path)
      try{
        pro.load(new FileReader(file))
        pro
      }catch {
        case e:java.io.FileNotFoundException => {
          e.printStackTrace()
          pro
        }
      }finally{
      }
    }
  }
}
