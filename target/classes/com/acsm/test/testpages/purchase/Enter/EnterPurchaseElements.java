package com.acsm.test.testpages.purchase.Enter;

import org.openqa.selenium.By;

public class EnterPurchaseElements {

	// 采销存按钮
	public static final By EP_BTN_SALE = By.xpath("//img[contains(@src,'left_icon_3.png')]");

	// 订单按钮
	public static final By EP_BTN_ORDER = By.xpath("//img[contains(@src,'left_icon_3_9.png')]");

	// 订单状态列表
	public static final By EP_LIST_ORDER = By.xpath("//div[@class='levelMenu_list3']");

	// 添加订单
	public static final By EP_BTN_ADDORDER = By.xpath("//input[contains(@value,'添加订单')]");

	// 添加采摘
	public static final By EP_BTN_ADDCAIZHAI = By.xpath("//input[@value='添加采摘']");

	// 导入导出
	public static final By EP_BTN_IMPORT = By.xpath("xpath=(//button[@type='button'])[4]");
	// 下单时间
	public static final By OP_BTN_XDTIME = By.id("sortType1");
	// 配送时间
	public static final By OP_BTN_PSTIME = By.id("sortType2");
	// 支付状态
	public static final By OP_BTN_PAYMENTSTATUES = By.id("sortType3");
	// 订单状态
	public static final By OP_BTN_ORDERSTATUES = By.id("sortType4");

}
