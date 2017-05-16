package com.acsm.test.testpages.purchase.workflow.orderaudit;

import org.openqa.selenium.By;

public class OrderAuditElement {

	// 审核
	public static final By OA_BTN_AUDIT = By.xpath("//span[@class='auditBtn']//a[contains(text(),'审核')]");

	// 获取订单编号#
	public static final By OA_STRING_ORDERNUMBER = By.cssSelector("#contentList span");

	// 取消订单
	public static final By OA_BTN_CANCLE = By.xpath("//a[contains(text(),'取消订单')]");

	// 查看
	public static final By OA_BTN_VIEW = By.xpath("//a[@title='查看']");

	// 编辑
	public static final By OA_BTN_EDIT = By.xpath("//a[@title='编辑']");

	// 删除
	public static final By OA_BTN_DEL = By.xpath("//a[@title='删除']");

	// 修改支付状态
	public static final By OA_BTN_EDITPAYMENTSTATE = By.xpath("//a[@title='修改支付状态']");

	// 首个订单的订单编号
	public static final By OA_STRING_ORDERID = By.xpath("//div[@id='contentList']//span");

	// 搜索
	public static final By OA_INPUT_SEARCH = By.id("orderSearch:orderSearch");

	// 搜索按钮
	public static final By OA_BTN_SEARCH = By.id("orderSearch:orderCommand");

	// 审核通过按钮
	public static final By OA_BTN_AUDITPASS = By.xpath("//input[contains(@value,'审核通过')]");

	// 订单管理-客户信息
	public static final By OA_STRING_CUSTMOR = By.xpath("//div[@class='singleManage_con']//h2");

	// 订单管理-收货人信息
	public static final By OA_STRING_RECEIVER = By.xpath("//div[@class='singleManage_con']//h2[2]");

	// 订单管理-配送时间
	public static final By OA_STRING_SENDTIME = By.xpath("//div[@class='singleManage_con']//h2[3]");
	// 订单管理-付款方式
	public static final By OA_STRING_PAYMENTSTYLE = By.xpath("//div[@class='singleManage_con']//h2[4]");
	// 订单管理-备注
	public static final By OA_STRING_COMMENTS = By.xpath("//div[@class='singleManage_con']//h2[5]");
	// 订单管理-商品清单
	public static final By OA_STRING_ORDERLIST = By.xpath("//div[@class='singleManage_con']//h2[6]");

}
