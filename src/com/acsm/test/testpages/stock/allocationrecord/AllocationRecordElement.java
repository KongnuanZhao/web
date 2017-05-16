package com.acsm.test.testpages.stock.allocationrecord;

import org.openqa.selenium.By;

public class AllocationRecordElement {

	/** 入库明细 */
	public static final By AR_BTN_INSTORAGELIST = By.xpath("//li[contains(@onclick,'AllocationRecord.seam')]");
	
	/** 调出仓库	 */
	public static final By AR_BTN_ROOM= By.xpath("//button[@data-id='outStorageRoom']");
	
	/** 调出仓库列表*/
	public static final By AR_LIST_ROOM = By.xpath("//div[@class='dropdown-menu open']");	
	
	/** 调出仓库选择*/
	public static final By AR_BTN_ROOM_1 = By.linkText("原料库");
	
	/** 调入仓库*/
	public static final By AR_BTN_ROOMANOTHER = By.xpath("//button[@data-id='inStorageRoom']");
	
	/** 调入仓库 下拉列表*/
	public static final By AR_LIST_ROOMANOTHER = By.xpath("//button[@data-id='inStorageRoom']/following::div");	
	
	/** 调入仓库选择*/
	public static final By AR_BTN_YUANLIAO = By.linkText("原料库2");
	
	/** 经办人*/
	public static final By AR_BTN_OPERATOR = By.xpath("//button[@data-id='operaterId']");	
	
	/** 经办人列表*/
	public static final By AR_LIST_OPERATOR = By.xpath("//button[@data-id='operaterId']/following::div");
	
	/** 经办人选择*/
	public static final By AR_BTN_OPERATOR_1= By.linkText("里路飞");
	
	/** 搜索框*/
	public static final By AR_INPUT_SEARCH = By.id("searchStr");
	
	/** 搜索按钮*/
	public static final By AR_BTN_SEARCH = By.id("searchButton");
	
	/** 搜索结果*/
	public static final By AR_WEBELEMENT_SEARCHRESULT = By.xpath("//div[@id='showPanel_body']//tr[2]/td");
	
	/** 文件导出*/
	public static final By AR_BTN_EXPORT = By.id("exp");
	
	/** 查看*/
	public static final By AR_BTN_VIEW = By.xpath("//a[@title='查看']");
	
	/** 编辑*/
	public static final By AR_BTN_EDIT = By.xpath("//a[@title='编辑']");
	
	/** 查看/编辑页面返回*/
	public static final By AR_BTNBACK = By.xpath("//input[@value='返回']");

	/** 删除*/
	public static final By AR_BTN_DELETE = By.xpath("//a[@title='删除']");
}
