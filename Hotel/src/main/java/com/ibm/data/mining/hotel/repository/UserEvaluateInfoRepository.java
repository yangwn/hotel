package com.ibm.data.mining.hotel.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.data.mining.hotel.common.CommonUtils;

/**
 * 随机获取用户满意度信息项
 * 
 * @author wunan
 */
@Service
public class UserEvaluateInfoRepository {

	@Autowired
	private UserEvaluateInfoConfigParameters userEvaluateInfoConfigParameters;

	public int getHealth(int randomNumber) {
		List<Integer> health = userEvaluateInfoConfigParameters.getHealth();
		return health.get(CommonUtils.getConfigId(randomNumber, health.size()));
	}

	public int getBreakfast(int randomNumber) {
		List<Integer> breakfast = userEvaluateInfoConfigParameters.getBreakfast();
		return breakfast.get(CommonUtils.getConfigId(randomNumber, breakfast.size()));
	}

	public int getServicer(int randomNumber) {
		List<Integer> servicer = userEvaluateInfoConfigParameters.getServicer();
		return servicer.get(CommonUtils.getConfigId(randomNumber, servicer.size()));
	}

	public int getRoomDesign(int randomNumber) {
		List<Integer> roomDesign = userEvaluateInfoConfigParameters.getRoomDesign();
		return roomDesign.get(CommonUtils.getConfigId(randomNumber, roomDesign.size()));
	}

	public int getPrice(int randomNumber) {
		List<Integer> price = userEvaluateInfoConfigParameters.getPrice();
		return price.get(CommonUtils.getConfigId(randomNumber, price.size()));
	}

	public int getRestaurant(int randomNumber) {
		List<Integer> restaurant = userEvaluateInfoConfigParameters.getRestaurant();
		return restaurant.get(CommonUtils.getConfigId(randomNumber, restaurant.size()));
	}

	public int getHotWater(int randomNumber) {
		List<Integer> hotWater = userEvaluateInfoConfigParameters.getHotWater();
		return hotWater.get(CommonUtils.getConfigId(randomNumber, hotWater.size()));
	}

	public int getEnvironment(int randomNumber) {
		List<Integer> environment = userEvaluateInfoConfigParameters.getEnvironment();
		return environment.get(CommonUtils.getConfigId(randomNumber, environment.size()));
	}
}
