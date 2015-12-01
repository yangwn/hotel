package com.ibm.data.mining.hotel.module

import org.apache.commons.lang3.StringUtils
import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD.rddToPairRDDFunctions

import com.ibm.data.mining.hotel.common.AppUtils

class UserBaseInfoModule(@transient sparkContext: SparkContext)(path: String) {
  def run() = {
    val checkInTimeRdd = sparkContext.textFile(path).map(line => {
      val checkInTime = StringUtils.splitByWholeSeparatorPreserveAllTokens(line, "|")(12)
      (checkInTime, 1)
    })

    val rushHourOfDay = checkInTimeRdd.map(f => {
      (AppUtils.getHour(f._1), 1)
    }).reduceByKey(_ + _)

    val rushMonthOfYear = checkInTimeRdd.map(f => {
      (AppUtils.getMonth(f._1), 1)
    }).reduceByKey(_ + _)
    
    rushHourOfDay.saveAsTextFile("./days")
    rushMonthOfYear.saveAsTextFile("./years")
  }
}

object UserBaseInfoModule {
  def apply(@transient sparkContext: SparkContext)(path: String) = new UserBaseInfoModule(sparkContext)(path)
}