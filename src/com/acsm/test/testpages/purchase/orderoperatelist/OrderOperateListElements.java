package com.acsm.test.testpages.purchase.orderoperatelist;

import org.openqa.selenium.By;

public class OrderOperateListElements {

	// logo
	public static final By OOL_ELEMENT_LOGO = By.xpath("//div[@class='logo']");

	// 订单流程
	public static final By OOL_LIST_ORDERSTATES = By.xpath("//div[@class='levelMenu_list3']/ul");

	// 搜索
	public static final By OOL_INPUT_SEARCH = By.id("orderSearch:orderSearch");

	// 搜索按钮
	public static final By OOL_BTN_SEARCH = By.id("orderSearch:orderCommand");

	// 搜索结果
	public static final By OOL_ELEMENT_ORDER = By.id("contentList");

	// 筛选按钮
	public static final By OOL_BTN_FILTER = By.xpath("//a[contains(text(),'筛选')]");

	// 筛选模块
	public static final By OOL_ELEMENT_FILTER = By.id("ftitle");

	// 添加订单
	public static final By OOL_BTN_ADDORDER = By.xpath("//input[contains(@value,'添加订单')]");

	// 添加采摘
	public static final By OOL_BTN_ADDPICK = By.xpath("//input[contains(@value,'添加采摘')]");

	// 导入导出
	public static final By OOL_BTN_IMPORTANDEXPORT = By.xpath("//button[contains(@data-toggle,'dropdown')]");

	// 点击导出
	public static final By OOL_LIST_EXPORT = By.xpath("//ul[@role='menu']//li");

	// 点击导出
	public static final By OOL_BTN_IMPORT = By.xpath("//ul[@role='menu']//li[2]");

	// 点击导出
	public static final By OOL_DIALOG_IMPORT = By.xpath("//div[@id='excelModelDiv']//div[@class='modal-content ']");

	
	// 订单待审核
	public static final By OOL_BTN_ALL = By
			.xpath("//ul[@class='levelMenu_ul3']//a[contains(@href,'orderStatus=0&pages=1')]");

	
	// 订单待审核
	public static final By OOL_BTN_AUDIT = By
			.xpath("//ul[@class='levelMenu_ul3']//a[contains(@href,'orderStatus=1&pages=1')]");

	// 订单待处理
	public static final By OOL_BTN_DISPOSE = By
			.xpath("//ul[@class='levelMenu_ul3']//a[contains(@href,'orderStatus=2&pages=1')]");

	// 订单理货中
	public static final By OOL_BTN_TALLY = By
			.xpath("//ul[@class='levelMenu_ul3']//a[contains(@href,'orderStatus=14&pages=1')]");

	// 订单待发货
	public static final By OOL_BTN_DELIVERY = By
			.xpath("//ul[@class='levelMenu_ul3']//a[contains(@href,'orderStatus=3&pages=1')]");

	// 订单配送中
	public static final By OOL_BTN_TRANSPORT = By
			.xpath("//ul[@class='levelMenu_ul3']//a[contains(@href,'orderStatus=4&pages=1')]");

	// 订单已完成
	public static final By OOL_BTN_FINISH = By
			.xpath("//ul[@class='levelMenu_ul3']//a[contains(@href,'orderStatus=5&pages=1')]");

	// 上传订单
	public static final By OOL_INPUT_UPLOAD = By.id("excelForm:uploadFile");

	// 点击确定
	public static final By OOL_BTN_CONFIRM = By.xpath("//a[contains(text(),'确定')]");

}
