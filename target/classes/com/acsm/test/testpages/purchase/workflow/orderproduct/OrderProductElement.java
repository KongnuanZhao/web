package com.acsm.test.testpages.purchase.workflow.orderproduct;

import org.openqa.selenium.By;

public class OrderProductElement {


	// 商品清单
	public static final By OP_BTN_PRODUCTSLIST = By.cssSelector("div button[data-id='productInfoId']");

	// 商品清单列表
	public static final By OP_LIST_PRODUCTSLIST = By.xpath("//ul[contains(@role,'menu')]//li");

	// 添加商品
	public static final By OP_BTN_PRODUCTADD = By.cssSelector("a.btn.btn-success.fl.mr15.ml15");

	// 商品显示
	public static final By OP_ELEMENT_PRODUCT = By.id("productMess");

	// 添加客户
	public static final By OP_BTN_CUSTMERADD = By.xpath("//a[contains(text(),'选择客户')]");

	// 添加客户对话框
	public static final By OP_DIALOG_CUSTMER = By.xpath("//div[@id='seltCustomModal']//div[@class='modal-content']");

	// 选择第一个客户
	public static final By OP_ELEMENT_CUSTMER = By.id("memberControlDiv");

	// 判断客户是否选择成功
	public static final By OP_ELEMENT_USERCONFIRM = By.id("showMemberInfoDiv");

	// 下一步
	public static final By OP_BTN_NEXT = By.id("next");

	// 配送时间
	public static final By OP_BTN_DELIVERTIME = By.cssSelector("input#deliverTime");

	// 当前时间
	public static final By OP_BTN_CURDATE = By.xpath("//td[@class='day active']");

	// 填写备注
	public static final By OP_INPUT_COMMENTS = By.cssSelector("textarea#orderRemark");

	// 提交订单
	public static final By OP_BTN_CONFIRM = By.id("submitOrder:next");

}
