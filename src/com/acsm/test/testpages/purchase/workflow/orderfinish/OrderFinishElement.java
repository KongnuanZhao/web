package com.acsm.test.testpages.purchase.workflow.orderfinish;

import org.openqa.selenium.By;

public class OrderFinishElement {

	// 搜索框
	public static final By OF_INPUT_SERACH = By.id("orderSearch:orderSearch");
	
	//搜索
	public static final By OF_BTN_SERACH = By.id("orderSearch:orderCommand");

	//已完成订单数量
	public static final By OF_BTN_COMPLETECOUNT = By.xpath("//a[contains(@href,'orderStatus=5')]//em[@class='num']");
}
