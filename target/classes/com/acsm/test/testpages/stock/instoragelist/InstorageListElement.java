package com.acsm.test.testpages.stock.instoragelist;

import org.openqa.selenium.By;

public class InstorageListElement {

	/** 入库明细 */
	public static final By IL_BTN_INSTORAGELIST = By.xpath("//li[contains(@onclick,'InStorageList.sea')]");
	
	/** 仓库	 */
	public static final By IL_BTN_ROOM= By.xpath("//button[@data-id='storageRoomId']");
	
	/** 仓库列表*/
	public static final By IL_LIST_ROOM = By.xpath("//div[@class='dropdown-menu open']");	
	
	/** 仓库选择*/
	public static final By IL_BTN_ROOM_1 = By.linkText("原料库");
	
	/** 物料类型 */
	public static final By IL_BTN_GOODSTYPE = By.xpath("//button[@data-id='goodsType']");
	
	/** 物料类型 下拉列表*/
	public static final By IL_LIST_GOODSTYPE = By.xpath("//button[@data-id='goodsType']/following::div");	
	
	/** 物料类型选择*/
	public static final By IL_BTN_YUANLIAO = By.linkText("原料");
	
	/** 经办人*/
	public static final By IL_BTN_OPERATOR = By.xpath("//button[@data-id='operaterId']");	
	
	/** 经办人列表*/
	public static final By IL_LIST_OPERATOR = By.xpath("//button[@data-id='operaterId']/following::div");
	
	/** 经办人选择*/
	public static final By IL_BTN_OPERATOR_1= By.linkText("采收1");
	
	/** 经办人选择全部*/
	public static final By IL_BTN_OPERATOR_0= By.linkText("全部");
	
	/** 入库类型 */
	public static final By IL_BTN_INSTOCKTYPE = By.xpath("//button[@data-id='storageType']");
	
	/** 入库类型 列表*/
	public static final By IL_LIST_INSTOCKTYPE = By.xpath("//button[@data-id='storageType']/following::div");
	
	/** 入库类型 选择*/
	public static final By IL_TEXT_INSTOCKTYPE = By.linkText("自定义入库");
	
	/** 搜索框*/
	public static final By IL_INPUT_SEARCH = By.id("searchStr");
	
	/** 搜索按钮*/
	public static final By IL_BTN_SEARCH = By.id("searchButton");
	
	/** 搜索结果*/
	public static final By IL_WEBELEMENT_SEARCHRESULT = By.xpath("//div[@id='showPanel_body']//tr[2]/td");
	
	/** 文件导出*/
	public static final By IL_BTN_EXPORT = By.id("exp");
	
	/** 查看*/
	public static final By IL_BTN_VIEW = By.xpath("//a[@title='查看']");
	
	/** 编辑*/
	public static final By IL_BTN_EDIT = By.xpath("//a[@title='编辑']");
	
	/** 查看/编辑页面返回*/
	public static final By IL_BTNBACK = By.xpath("//input[@value='返回']");

	/** 删除*/
	public static final By IL_BTN_DELETE = By.xpath("//a[@title='删除']");
}
