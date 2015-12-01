package com.ibm.data.mining.hotel

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

import com.ibm.data.mining.hotel.service.HotelComprehensiveAnalysisService

object HotelDriver extends App{
  
  var MASTER = if (!args.isEmpty) args(0) else "local[4]"
  val JOB_NAME = "Hotel_Comprehensive_Analysis_Job"
  
  val sparkConf = new SparkConf().setMaster(MASTER).setAppName(JOB_NAME)
  implicit val sparkContext = new SparkContext(sparkConf)
  
  HotelComprehensiveAnalysisService(sparkContext)("/Users/wunan/test/user-base-info.txt")
  sparkContext.stop
  
}