package com.ibm.data.mining.hotel.common

import org.joda.time.format.DateTimeFormat
import org.joda.time.DateTime

object AppUtils {
  
  val dayformat = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")

  def getMonth(dateTime: String) = {
    DateTime.parse(dateTime, dayformat).getMonthOfYear
  }

  def getHour(dateTime: String) = {
    DateTime.parse(dateTime, dayformat).getHourOfDay
  }
  
}