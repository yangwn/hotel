package com.ibm.data.mining.hotel.service

import org.apache.spark.SparkContext
import org.apache.spark.sql.SQLContext

import com.ibm.data.mining.hotel.module.UserBaseInfoModule

class HotelComprehensiveAnalysisService(@transient sparkContext: SparkContext)(filePath : String){
  val collManagedDeviceModule = UserBaseInfoModule(sparkContext)(filePath).run
  
}

object HotelComprehensiveAnalysisService {
  def apply(@transient sparkContext: SparkContext)(filePath : String) = new HotelComprehensiveAnalysisService(sparkContext)(filePath)
}