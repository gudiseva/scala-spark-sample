package com.csscorp.app

import org.apache.spark._
import org.apache.spark.SparkContext._

/**
  * Created by Nag Arvind Gudiseva on 08-Sep-16.
  */
object MainApp {

  def main(args: Array[String]) {
    val inputFile = args(0)
    val outputFile = args(1)

    // Run from main / sbt run
    //val conf = new SparkConf().setAppName("WordCount").setMaster("local")

    // Run from spark-submit
    val conf = new SparkConf().setAppName("WordCount") // SparkException: A master URL must be set in your configuration

    // Create a Scala Spark Context.
    val sc = new SparkContext(conf)
    // Load our input data.
    val input =  sc.textFile(inputFile)
    // Split up into words.
    val words = input.flatMap(line => line.split(" "))
    // Transform into word and count.
    val counts = words.map(word => (word, 1)).reduceByKey{case (x, y) => x + y}
    // Save the word count back out to a text file, causing evaluation.
    counts.saveAsTextFile(outputFile)
    // Stop Spark
    sc.stop()
    // Exit
    sys.exit()
  }

}