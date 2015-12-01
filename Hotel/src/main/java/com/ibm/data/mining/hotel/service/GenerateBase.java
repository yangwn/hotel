package com.ibm.data.mining.hotel.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.ibm.data.mining.hotel.common.CommonUtils;

@Component
public class GenerateBase {

	@Value("${userid.prefix}")
	private String userIdPrefix;

	@Value("${separator.char}")
	protected String separator;

	protected String getUserId(int index, int genrateDataLength) {
		StringBuilder sb = new StringBuilder();
		String userIdSuffix = CommonUtils.fillUpZeroFormatNumber(index, genrateDataLength);
		sb.append(userIdPrefix).append(userIdSuffix);
		return sb.toString();
	}
}
