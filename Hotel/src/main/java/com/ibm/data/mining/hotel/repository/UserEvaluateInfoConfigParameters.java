package com.ibm.data.mining.hotel.repository;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * 满意度整理后的数据
 * 
 * 针对每个满意度项有一个具体的分数，该分数从1至10.
 * <p>
 * 分数越低，满意度差;分数越高，满意度好
 * 
 * @author wunan
 */
public class UserEvaluateInfoConfigParameters {

	private Integer[] elements = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

	// 卫生满意度
	private List<Integer> health = Lists.newArrayList(elements);
	// 早餐满意度
	private List<Integer> breakfast = Lists.newArrayList(elements);
	// 服务人员满意度
	private List<Integer> servicer = Lists.newArrayList(elements);
	// 房间设施满意度
	private List<Integer> roomDesign = Lists.newArrayList(elements);
	// 酒店价格满意度
	private List<Integer> price = Lists.newArrayList(elements);
	// 餐厅满意度
	private List<Integer> restaurant = Lists.newArrayList(elements);
	// 热水满意度
	private List<Integer> hotWater = Lists.newArrayList(elements);
	// 环境满意度
	private List<Integer> environment = Lists.newArrayList(elements);

	public List<Integer> getHealth() {
		return health;
	}

	public List<Integer> getBreakfast() {
		return breakfast;
	}

	public List<Integer> getServicer() {
		return servicer;
	}

	public List<Integer> getRoomDesign() {
		return roomDesign;
	}

	public List<Integer> getPrice() {
		return price;
	}

	public List<Integer> getRestaurant() {
		return restaurant;
	}

	public List<Integer> getHotWater() {
		return hotWater;
	}

	public List<Integer> getEnvironment() {
		return environment;
	}

}
