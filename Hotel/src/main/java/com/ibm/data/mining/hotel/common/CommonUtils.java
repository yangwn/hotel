package com.ibm.data.mining.hotel.common;

import java.text.NumberFormat;

/**
 * 工具类
 * 
 * @author wunan
 *
 */
public class CommonUtils {

	/**
	 * 正整数补位
	 * 
	 * @param number
	 * @param length
	 * @return
	 */
	public static String fillUpZeroFormatNumber(int number, int length) {
		NumberFormat formatter = NumberFormat.getNumberInstance();
		formatter.setMinimumIntegerDigits(length);
		formatter.setGroupingUsed(false);
		return formatter.format(number);
	}

	/**
	 * 随机生成整数
	 * 
	 * @param maxValue
	 * @return
	 */
	public static int randomGenerateInt(int maxValue) {
		return (int) (Math.random() * maxValue);
	}

	/**
	 * 随机生成大于0的整数
	 * 
	 * @param maxValue
	 * @return
	 */
	public static int randomGenerateIntAndGatherZero(int maxValue) {
		return (int) (Math.random() * maxValue + 1);
	}

	/**
	 * 根据随机数与配置项的个数取摩,获取数据项Id
	 * 
	 * @param randomNumber
	 *            随机数
	 * @param configSize
	 *            配置项的个数， 通过applicationContext.xml中
	 * @return
	 */
	public static int getConfigId(int randomNumber, int configSize) {
		return randomNumber % configSize;
	}
}
