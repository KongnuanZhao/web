package com.acsm.test.testpages.purchase.workflow.ordertransport;

import org.openqa.selenium.By;

public class OrderTransportElement {

	// 订单签收
	public static final By OT_BTN_SIGN = By.xpath("//a[contains(text(),'订单签收')]");
	
	// 确认签收对话框
	public static final By OD_DIALOG_SEND = By.cssSelector("div#signOrderDiv div");

	// 确认签收对话框
	public static final By OD_BTN_CONFIRM = By.xpath("//a[contains(text(),'提交')]");
}
