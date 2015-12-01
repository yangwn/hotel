package com.ibm.data.mining.hotel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ibm.data.mining.hotel.service.GenerateUserBaseInfoService;
import com.ibm.data.mining.hotel.service.GenerateUserEvaluateInfoService;

/**
 * Hotel Demo 数据信息
 * <p>
 * 用户基本信息与满意度信息
 * 
 * @author wunan
 */
public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		if (args.length < 2) {
			System.out.println("please input two parameter:");
			System.out.println("1.TotalNumber, generate the total about UserId");
			System.out.println("2.UserInfoKind:");
			System.out.println("\t 1).UserBaseInfo");
			System.out.println("\t 2).UserEvaluateInfo");
			return;
		}

		int totalnumber = Integer.valueOf(args[0]);
		int userKind = Integer.valueOf(args[1]);

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

		// 基础信息
		if (userKind == 1) {
			GenerateUserBaseInfoService baseInfoService = (GenerateUserBaseInfoService) applicationContext
					.getBean("generateUserBaseInfoService");
			baseInfoService.genrateUserBaseInfoData(totalnumber);
		}
		// 满意度
		if (userKind == 2) {
			GenerateUserEvaluateInfoService evaInfoService = (GenerateUserEvaluateInfoService) applicationContext
					.getBean("generateUserEvaluateInfoService");
			evaInfoService.generateUserEvaluateInfoData(totalnumber);
		}
	}
}
