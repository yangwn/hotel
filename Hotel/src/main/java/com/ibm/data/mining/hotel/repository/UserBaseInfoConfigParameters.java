package com.ibm.data.mining.hotel.repository;

import java.util.List;

/**
 * 用户基本信息
 * 
 * @author wunan
 *
 */
public class UserBaseInfoConfigParameters {

	// 消费等级
	private List<Integer> costLevel;
	// 所到城市
	private List<Integer> cityNames;
	// 房间类型
	private List<Integer> roomKind;
	// 吸烟
	private List<Integer> isSmoke;
	// 订房途径
	private List<Integer> bookedChannel;
	// 有无网络
	private List<Integer> hasNetwork;
	// 是否加床
	private List<Integer> isAddedBed;
	// 是否点餐
	private List<Integer> isOrderFood;
	// 是否提供早餐
	private List<Integer> hasBreakfast;
	// 付费方式
	private List<Integer> payWay;
	// 订房用途
	private List<Integer> usedPurpose;

	public void setCostLevel(List<Integer> costLevel) {
		this.costLevel = costLevel;
	}

	public void setCityNames(List<Integer> cityNames) {
		this.cityNames = cityNames;
	}

	public void setRoomKind(List<Integer> roomKind) {
		this.roomKind = roomKind;
	}

	public void setIsSmoke(List<Integer> isSmoke) {
		this.isSmoke = isSmoke;
	}

	public void setBookedChannel(List<Integer> bookedChannel) {
		this.bookedChannel = bookedChannel;
	}

	public void setHasNetwork(List<Integer> hasNetwork) {
		this.hasNetwork = hasNetwork;
	}

	public void setIsAddedBed(List<Integer> isAddedBed) {
		this.isAddedBed = isAddedBed;
	}

	public void setIsOrderFood(List<Integer> isOrderFood) {
		this.isOrderFood = isOrderFood;
	}

	public void setHasBreakfast(List<Integer> hasBreakfast) {
		this.hasBreakfast = hasBreakfast;
	}

	public void setPayWay(List<Integer> payWay) {
		this.payWay = payWay;
	}

	public void setUsedPurpose(List<Integer> usedPurpose) {
		this.usedPurpose = usedPurpose;
	}

	public List<Integer> getCostLevel() {
		return costLevel;
	}

	public List<Integer> getCityNames() {
		return cityNames;
	}

	public List<Integer> getRoomKind() {
		return roomKind;
	}

	public List<Integer> getIsSmoke() {
		return isSmoke;
	}

	public List<Integer> getBookedChannel() {
		return bookedChannel;
	}

	public List<Integer> getHasNetwork() {
		return hasNetwork;
	}

	public List<Integer> getIsAddedBed() {
		return isAddedBed;
	}

	public List<Integer> getIsOrderFood() {
		return isOrderFood;
	}

	public List<Integer> getHasBreakfast() {
		return hasBreakfast;
	}

	public List<Integer> getPayWay() {
		return payWay;
	}

	public List<Integer> getUsedPurpose() {
		return usedPurpose;
	}

}