package com.acsm.test.testpages.stock.inventoryrecord;

import org.openqa.selenium.By;

public class InventoryRecordElement {

	/** 盘点记录 */
	public static final By IR_BTN_INVENTRYRECORD = By.xpath("//li[contains(@onclick,'InventoryRecord.seam')]");

	/** 物料类型 */
	public static final By IR_BTN_GOODSTYPE = By.xpath("//button[@data-id='goodsType']");

	/** 物料类型 下拉列表 */
	public static final By IR_LIST_GOODSTYPE = By.xpath("//button[@data-id='goodsType']/following::div");

	/** 物料类型选择 */
	public static final By IR_BTN_YUANLIAO = By.xpath("//button[@data-id='goodsType']/following::li[2]");

	/** 仓库 */
	public static final By IR_BTN_ROOM = By.xpath("//button[@data-id='storageRoom']");

	/** 仓库列表 */
	public static final By IR_LIST_ROOM = By.xpath("//button[@data-id='storageRoom']/following::ul");

	/** 选择仓库 */
	public static final By IR_BTN_ROOM_1 = By.linkText("原料库");

	/** 经办人 */
	public static final By IR_BTN_OPERATOR = By.xpath("//button[@data-id='operator']");

	/** 经办人列表 */
	public static final By IR_LIST_OPERATOR = By.xpath("//button[@data-id='operator']/following::div");

	/** 选择经办人 */
	public static final By IR_BTN_OPERATOR_1 = By.xpath("//button[@data-id='operator']/following::div//li[2]");

	/** 搜索框*/
	public static final By IR_INPUT_SEARCH = By.id("searchStr");
	
	/** 搜索按钮*/
	public static final By IR_BTN_SEARCH = By.id("searchButton");
	
	/** 搜索结果*/
	public static final By IR_WEBELEMENT_SEARCHRESULT = By.xpath("//div[@id='showPanel_body']//tr[2]/td");
	
	/** 查看*/
	public static final By IR_BTN_VIEW = By.xpath("//a[@title='查看']");
	
	/** 查看/编辑页面返回*/
	public static final By IR_BTN_BACK = By.xpath("//input[@value='返回']");

}
