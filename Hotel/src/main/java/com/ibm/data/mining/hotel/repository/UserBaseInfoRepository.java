package com.ibm.data.mining.hotel.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.data.mining.hotel.common.CommonUtils;

/**
 * 随机获取用户基本信息项
 * 
 * @author wunan
 */
@Service
public class UserBaseInfoRepository {

	@Autowired
	private UserBaseInfoConfigParameters userBaseInfoConfigParameters;

	public int getCostLevelByRandom(int randomNumber) {
		List<Integer> costLevel = userBaseInfoConfigParameters.getCostLevel();
		return costLevel.get(CommonUtils.getConfigId(randomNumber, costLevel.size()));
	}

	public int getCityNames(int randomNumber) {
		List<Integer> cityNames = userBaseInfoConfigParameters.getCityNames();
		return cityNames.get(CommonUtils.getConfigId(randomNumber, cityNames.size()));
	}

	public int getRoomKind(int randomNumber) {
		List<Integer> roomKind = userBaseInfoConfigParameters.getRoomKind();
		return roomKind.get(CommonUtils.getConfigId(randomNumber, roomKind.size()));
	}

	public int getIsSmoke(int randomNumber) {
		List<Integer> isSmoke = userBaseInfoConfigParameters.getIsSmoke();
		return isSmoke.get(CommonUtils.getConfigId(randomNumber, isSmoke.size()));
	}

	public int getBookedChannel(int randomNumber) {
		List<Integer> bookedChannel = userBaseInfoConfigParameters.getBookedChannel();
		return bookedChannel.get(CommonUtils.getConfigId(randomNumber, bookedChannel.size()));
	}

	public int getHasNetwork(int randomNumber) {
		List<Integer> hasNetwork = userBaseInfoConfigParameters.getHasNetwork();
		return hasNetwork.get(CommonUtils.getConfigId(randomNumber, hasNetwork.size()));
	}

	public int getIsAddedBed(int randomNumber) {
		List<Integer> isAddedBed = userBaseInfoConfigParameters.getIsAddedBed();
		return isAddedBed.get(CommonUtils.getConfigId(randomNumber, isAddedBed.size()));
	}

	public int getIsOrderFood(int randomNumber) {
		List<Integer> isOrderFood = userBaseInfoConfigParameters.getIsOrderFood();
		return isOrderFood.get(CommonUtils.getConfigId(randomNumber, isOrderFood.size()));
	}

	public int getHasBreakfast(int randomNumber) {
		List<Integer> hasBreakfast = userBaseInfoConfigParameters.getHasBreakfast();
		return hasBreakfast.get(CommonUtils.getConfigId(randomNumber, hasBreakfast.size()));
	}

	public int getPayWay(int randomNumber) {
		List<Integer> payWay = userBaseInfoConfigParameters.getPayWay();
		return payWay.get(CommonUtils.getConfigId(randomNumber, payWay.size()));
	}

	public int getUsedPurpose(int randomNumber) {
		List<Integer> usedPurpose = userBaseInfoConfigParameters.getUsedPurpose();
		return usedPurpose.get(CommonUtils.getConfigId(randomNumber, usedPurpose.size()));
	}

}
