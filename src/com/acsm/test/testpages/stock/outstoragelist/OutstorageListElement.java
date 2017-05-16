package com.acsm.test.testpages.stock.outstoragelist;

import org.openqa.selenium.By;

public class OutstorageListElement {

	/** 出库明细 */
	public static final By OL_BTN_INSTORAGELIST = By.xpath("//li[contains(@onclick,'OutStorageList.seam')]");
	
	/** 仓库	 */
	public static final By OL_BTN_ROOM= By.xpath("//button[@data-id='storageRoomId']");
	
	/** 仓库列表*/
	public static final By OL_LIST_ROOM = By.xpath("//div[@class='dropdown-menu open']");	
	
	/** 仓库选择*/
	public static final By OL_BTN_ROOM_1 = By.linkText("原料库");
	
	/** 物料类型 */
	public static final By OL_BTN_GOODSTYPE = By.xpath("//button[@data-id='goodsType']");
	
	/** 物料类型 下拉列表*/
	public static final By OL_LIST_GOODSTYPE = By.xpath("//button[@data-id='goodsType']/following::div");	
	
	/** 物料类型选择*/
	public static final By OL_BTN_YUANLIAO = By.linkText("原料");
	
	/** 经办人*/
	public static final By OL_BTN_OPERATOR = By.xpath("//button[@data-id='operaterId']");	
	
	/** 经办人列表*/
	public static final By OL_LIST_OPERATOR = By.xpath("//button[@data-id='operaterId']/following::div");
	
	/** 经办人选择*/
	public static final By OL_BTN_OPERATOR_1= By.linkText("里路飞");
	
	/** 出库类型 */
	public static final By OL_BTN_INSTOCKTYPE = By.xpath("//button[@data-id='storageType']");
	
	/** 出库类型 列表*/
	public static final By OL_LIST_INSTOCKTYPE = By.xpath("//button[@data-id='storageType']/following::div");
	
	/** 出库类型 选择*/
	public static final By OL_TEXT_INSTOCKTYPE = By.linkText("自定义出库");
	
	/** 搜索框*/
	public static final By OL_INPUT_SEARCH = By.id("searchStr");
	
	/** 搜索按钮*/
	public static final By OL_BTN_SEARCH = By.id("searchButton");
	
	/** 搜索结果*/
	public static final By OL_WEBELEMENT_SEARCHRESULT = By.xpath("//div[@id='showPanel_body']//tr[2]/td");
	
	/** 文件导出*/
	public static final By OL_BTN_EXPORT = By.id("//img[contains(@src,'icon_exportExcel.jpg')]");
	
	/** 查看*/
	public static final By OL_BTN_VIEW = By.xpath("//a[@title='查看']");
	
	/** 编辑*/
	public static final By OL_BTN_EDIT = By.xpath("//a[@title='编辑']");
	
	/** 查看页面返回*/
	public static final By OL_BTN_BACK = By.id("detailId");
	
	/** 编辑页面返回*/
	public static final By OL_BTN_EDITBACK = By.linkText("返回");

	/** 删除*/
	public static final By OL_BTN_DELETE = By.xpath("//a[@title='删除']");
}
