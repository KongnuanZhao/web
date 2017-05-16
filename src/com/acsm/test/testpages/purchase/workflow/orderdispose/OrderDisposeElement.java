package com.acsm.test.testpages.purchase.workflow.orderdispose;

import org.openqa.selenium.By;

public class OrderDisposeElement {

	// 订单待处理
	public static final By OD_BTN_DISPOSE = By.xpath("//a[contains(@href,'OrderRoute.seam?')]");

	// 处理
	public static final By OD_BTN_NEXT = By.xpath("//input[contains(@value,'下一步')]");

	// 处理记录
	public static final By OD_BTN_DISPOSERECORD = By.linkText("处理记录>>");

	// 完成
	public static final By OD_BTN_DONE = By.xpath("//a[contains(text(),'完成')]");

	// 全选
	public static final By OD_CHECKBOX_SELECTALL = By.xpath("//input[@id='orderCheckAll']/following::ins");

	// 批量处理按钮
	public static final By OD_BTN_DISPOSEALL = By.linkText("批量处理");
	// 查看
	public static final By OD_BTN_VIEW = By.xpath("//a[@title='查看']");

	// 编辑
	public static final By OD_BTN_EDIT = By.xpath("//a[@title='编辑']");

	// 删除
	public static final By OD_BTN_DEL = By.xpath("//a[@title='删除']");

	// 修改支付状态
	public static final By OD_BTN_EDITPAYMENTSTATE = By.xpath("//a[@title='修改支付状态']");

	// 首个订单的订单编号
	public static final By OD_STRING_ORDERID = By.xpath("//div[@id='contentList']//span");

	// 搜索
	public static final By OD_INPUT_SEARCH = By.id("orderSearch:orderSearch");

	// 搜索按钮
	public static final By OD_BTN_SEARCH = By.id("orderSearch:orderCommand");

	// 订单处理
	public static final By OD_BTN_OPERATE = By.xpath("//span[@id='select']//button");

}
