package com.acsm.test.testpages.stock.outstorage;

import org.openqa.selenium.By;

public class OutStorageElement {

	/** 出库单 */
	public static final By OS_BTN_OUTSTORAGE = By.xpath("//li[contains(@onclick,'OutStorage')][2]");

	/** 物料类型 */
	public static final By OS_BTN_GOODSTYPE = By.xpath("//button[@data-id='goodsType']");

	/** 物料类型 下拉列表 */
	public static final By OS_LIST_GOODSTYPE = By.xpath("//button[@data-id='goodsType']/following::div");

	/** 物料类型选择 */
	public static final By OS_BTN_YUANLIAO = By.xpath("//ul[@role='menu']/li[2]");

	/** 出库类型 */
	public static final By OS_BTN_OUTSTOCKTYPE = By.xpath("//div[contains(@class,'groupselect_add')]");

	/** 出库类型 列表 */
	public static final By OS_LIST_OUTSTOCKTYPE = By.id("inStockTypeUl");

	/** 出库类型选择 */
	public static final By OS_TEXT_OUTSTOCKTYPE = By.xpath("//li[@myid='21']");

	/** 仓库 */
	public static final By OS_BTN_ROOM = By.xpath("//button[@data-id='storageRoomId']");

	/** 仓库列表 */
	public static final By OS_LIST_ROOM = By.xpath("//button[@data-id='storageRoomId']/following::div");

	/** 选择仓库 */
	public static final By OS_BTN_ROOM_1 = By.linkText("原料库");

	/** 经办人 */
	public static final By OS_BTN_OPERATOR = By.xpath("//button[@data-id='operaterId']");

	/** 经办人列表 */
	public static final By OS_LIST_OPERATOR = By.xpath("//button[@data-id='operaterId']/following::div");

	/** 选择经办人 */
	public static final By OS_BTN_OPERATOR_1 = By.xpath("//button[@data-id='operaterId']/following::div//li[2]");

	/** 备注 */
	public static final By OS_INPUT_COMMENT = By.id("remark");

	/** 添加物料 */
	public static final By OS_BTN_ADDGOODS = By.id("addMaterial");

	/** 添加物料对话框 */
	public static final By OS_DIALOG_ADDGOODS = By.id("material:goodsInfoId");

	/** 选择物料 */
	public static final By OS_CHECKBOX_ADDGOODS = By.id("iCheck_1");

	/** 确认 */
	public static final By OS_BTN_CONFIRM = By.xpath("//button[@onclick='choiceMaterial()']");

	/** 提交 */
	public static final By OS_BTN_SUBMIT = By.id("save");

}
