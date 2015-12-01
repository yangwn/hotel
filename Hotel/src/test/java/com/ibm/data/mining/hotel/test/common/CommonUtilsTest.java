package com.ibm.data.mining.hotel.test.common;

import org.junit.Test;

import com.ibm.data.mining.hotel.common.CommonUtils;

import junit.framework.Assert;

public class CommonUtilsTest {

	@Test
	public void fillUpZeroFormatNumberTest() {
		int genrateNumber = 10000;
		int length = String.valueOf(genrateNumber).length();
		String res = CommonUtils.fillUpZeroFormatNumber(1, length);
		Assert.assertEquals(res, "00001");
	}
}
