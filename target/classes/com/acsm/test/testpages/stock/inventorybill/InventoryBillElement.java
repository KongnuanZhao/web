package com.acsm.test.testpages.stock.inventorybill;

import org.openqa.selenium.By;

public class InventoryBillElement {

	/** 出库单 */
	public static final By IB_BTN_INVENTRYBILL = By.xpath("//li[contains(@onclick,'InventoryBill')]");

	/** 物料类型 */
	public static final By IB_BTN_GOODSTYPE = By.xpath("//button[@data-id='goodsType']");

	/** 物料类型 下拉列表 */
	public static final By IB_LIST_GOODSTYPE = By.xpath("//button[@data-id='goodsType']/following::div");

	/** 物料类型选择 */
	public static final By IB_BTN_YUANLIAO = By.xpath("//button[@data-id='goodsType']/following::li[2]");

	/** 仓库 */
	public static final By IB_BTN_ROOM = By.xpath("//button[@data-id='storageRoom']");

	/** 仓库列表 */
	public static final By IB_LIST_ROOM = By.xpath("//button[@data-id='storageRoom']/following::ul");

	/** 选择仓库 */
	public static final By IB_BTN_ROOM_1 = By.linkText("原料库");

	/** 经办人 */
	public static final By IB_BTN_OPERATOR = By.xpath("//button[@data-id='operatorId']");

	/** 经办人列表 */
	public static final By IB_LIST_OPERATOR = By.xpath("//button[@data-id='operatorId']/following::div");

	/** 选择经办人 */
	public static final By IB_BTN_OPERATOR_1 = By.xpath("//button[@data-id='operatorId']/following::div//li[2]");

	/** 添加物料 */
	public static final By IB_BTN_ADDGOODS = By.id("addButton");

	/** 添加物料对话框 */
	public static final By IB_DIALOG_ADDGOODS = By.id("addGoods");

	/** 选择物料 */
	public static final By IB_CHECKBOX_ADDGOODS = By.xpath("//div[@id='goodsModel']//td//input");

	/** 确认 */
	public static final By IB_BTN_CONFIRM = By.xpath("//button[@onclick='selectToAddGoods()']");

	/** 提交 */
	public static final By IB_BTN_SUBMIT = By.id("submitButton");

}
