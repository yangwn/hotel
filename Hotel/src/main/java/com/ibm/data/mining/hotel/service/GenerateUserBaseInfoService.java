package com.ibm.data.mining.hotel.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ibm.data.mining.hotel.common.CommonUtils;
import com.ibm.data.mining.hotel.common.RandomDateUtils;
import com.ibm.data.mining.hotel.repository.UserBaseInfoRepository;

/**
 * 生成用户基本信息
 * 
 * @author wunan
 *
 */
@Service
public class GenerateUserBaseInfoService extends GenerateBase {

	@Autowired
	private UserBaseInfoRepository userBaseInfoRepository;

	@Value("${userbase.file.path}")
	private String filePath;

	public void genrateUserBaseInfoData(int maxValue) {

		BufferedOutputStream buffer = null;
		try {
			File file = new File(filePath);
			if (file.exists()) {
				file.delete();
			}
			file.createNewFile();
			buffer = new BufferedOutputStream(new FileOutputStream(new File(filePath), true));
			int maxLength = String.valueOf(maxValue).length();
			for (int index = 1; index <= maxValue; index++) {
				String userId = getUserId(index, maxLength);
				int bookedChannel = userBaseInfoRepository.getBookedChannel(CommonUtils.randomGenerateInt(maxValue));
				int cityName = userBaseInfoRepository.getCityNames(CommonUtils.randomGenerateInt(maxValue));
				int costLevel = userBaseInfoRepository.getCostLevelByRandom(CommonUtils.randomGenerateInt(maxValue));
				int hasBreakfast = userBaseInfoRepository.getHasBreakfast(CommonUtils.randomGenerateInt(maxValue));
				int hasNetwork = userBaseInfoRepository.getHasNetwork(CommonUtils.randomGenerateInt(maxValue));
				int isAddedBed = userBaseInfoRepository.getIsAddedBed(CommonUtils.randomGenerateInt(maxValue));
				int isOrderFood = userBaseInfoRepository.getIsOrderFood(CommonUtils.randomGenerateInt(maxValue));
				int isSmoke = userBaseInfoRepository.getIsSmoke(CommonUtils.randomGenerateInt(maxValue));
				int payWay = userBaseInfoRepository.getPayWay(CommonUtils.randomGenerateInt(maxValue));
				int roomKind = userBaseInfoRepository.getRoomKind(CommonUtils.randomGenerateInt(maxValue));
				int usedPurpose = userBaseInfoRepository.getUsedPurpose(CommonUtils.randomGenerateInt(maxValue));

				DateTime checkInDateTime = RandomDateUtils.randomDate();
				String checkInDateStr = RandomDateUtils.getCheckInDateToStr(checkInDateTime);
				String checkOutDateStr = RandomDateUtils.getCheckOutDatePlusSomeDayToStr(checkInDateTime);

				StringBuffer stringBuffer = new StringBuffer();
				stringBuffer.append(userId).append(separator).append(bookedChannel).append(separator).append(cityName)
						.append(separator).append(costLevel).append(separator).append(hasBreakfast).append(separator)
						.append(hasNetwork).append(separator).append(isAddedBed).append(separator).append(isOrderFood)
						.append(separator).append(isSmoke).append(separator).append(payWay).append(separator)
						.append(roomKind).append(separator).append(usedPurpose).append(separator).append(checkInDateStr)
						.append(separator).append(checkOutDateStr);

				buffer.write(stringBuffer.toString().getBytes());
				buffer.write("\n".getBytes());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (buffer != null) {
					buffer.flush();
					buffer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}