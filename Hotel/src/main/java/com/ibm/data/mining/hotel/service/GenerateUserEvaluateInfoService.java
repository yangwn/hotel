package com.ibm.data.mining.hotel.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ibm.data.mining.hotel.common.CommonUtils;
import com.ibm.data.mining.hotel.repository.UserEvaluateInfoRepository;

/**
 * 生成满意度信息
 * 
 * @author wunan
 *
 */
@Service
public class GenerateUserEvaluateInfoService extends GenerateBase {

	@Autowired
	private UserEvaluateInfoRepository userEvaluateInfoRepository;

	@Value("${userEva.file.path}")
	private String filePath;

	public void generateUserEvaluateInfoData(int maxValue) {

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
				int breakfast = userEvaluateInfoRepository.getBreakfast(CommonUtils.randomGenerateInt(maxValue));
				int environment = userEvaluateInfoRepository.getEnvironment(CommonUtils.randomGenerateInt(maxValue));
				int health = userEvaluateInfoRepository.getHealth(CommonUtils.randomGenerateInt(maxValue));
				int hotwater = userEvaluateInfoRepository.getHotWater(CommonUtils.randomGenerateInt(maxValue));
				int price = userEvaluateInfoRepository.getPrice(CommonUtils.randomGenerateInt(maxValue));
				int restaurant = userEvaluateInfoRepository.getRestaurant(CommonUtils.randomGenerateInt(maxValue));
				int roomDeSign = userEvaluateInfoRepository.getRoomDesign(CommonUtils.randomGenerateInt(maxValue));
				int servicer = userEvaluateInfoRepository.getServicer(CommonUtils.randomGenerateInt(maxValue));

				StringBuffer stringBuffer = new StringBuffer();
				stringBuffer.append(userId).append(separator).append(breakfast).append(separator).append(environment)
						.append(separator).append(health).append(separator).append(hotwater).append(separator)
						.append(price).append(separator).append(restaurant).append(separator).append(roomDeSign)
						.append(separator).append(servicer).append("\n");

				buffer.write(stringBuffer.toString().getBytes());
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