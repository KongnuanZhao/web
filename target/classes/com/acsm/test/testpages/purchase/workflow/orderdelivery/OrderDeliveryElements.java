package com.acsm.test.testpages.purchase.workflow.orderdelivery;

import org.openqa.selenium.By;

public class OrderDeliveryElements {

	// 日期
	public static final By OD_BTN_TIME = By.id("searchTime");

	// 导出
	public static final By OD_BTN_EXPORT = By.id("orderSearch:excelButton");

	// 批量发货
	public static final By OD_BTN_DELIVERYALL = By.id("orderSearch:excelButton");
	// 扫码发货
	public static final By OD_BTN_SCAN = By.id("orderSearch:excelButton");
	// 批量打印四联单
	public static final By OD_BTN_PRINT = By.id("orderSearch:excelButton");
	// 发货按钮
	public static final By OD_BTN_TALLY = By.xpath("//span[@class='auditBtn']//a[contains(text(),'发货')]");

	// 发货对话框
	public static final By OD_DIALOG_SEND = By.cssSelector("div#sendGood_modal div");

	// 确认发货
	public static final By OD_BTN_CONFIRM = By.xpath("//button[contains(text(),'是')]");
}
