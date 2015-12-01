package com.ibm.data.mining.hotel.common;

import java.text.SimpleDateFormat;

import org.joda.time.DateTime;

/**
 * Get the random date，from 2014-01-01 to 2014-12-31.
 * 
 * @author wunan
 */
public class RandomDateUtils {

	private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	private static String beginDate = "2014-01-01";
	private static String endDate = "2014-12-31";

	/**
	 * 获取随机日期
	 */
	public static DateTime randomDate() {
		try {
			long date = random(format.parse(beginDate).getTime(), format.parse(endDate).getTime());
			return new DateTime(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static long random(long begin, long end) {
		long rtn = begin + (long) (Math.random() * (end - begin));
		return rtn;
	}

	/**
	 * 获取入住时间 Date 转化为 String
	 * 
	 * @param dateTime
	 * @return
	 */
	public static String getCheckInDateToStr(DateTime dateTime) {
		return dateTime.toString("yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 获取退房时间 Date 转化为 String
	 * 
	 * @param dateTime
	 * @info 最长时间入住7天 *
	 * @return
	 */
	public static String getCheckOutDatePlusSomeDayToStr(DateTime dateTime) {
		return dateTime.plusDays(CommonUtils.randomGenerateIntAndGatherZero(7)).toString("yyyy-MM-dd HH:mm:ss");
	}
}