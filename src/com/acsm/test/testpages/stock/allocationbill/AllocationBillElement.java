package com.acsm.test.testpages.stock.allocationbill;

import org.openqa.selenium.By;

public class AllocationBillElement {

	/** 调拨单 */
	public static final By AB_BTN_ALLOCATIONBILL = By.xpath("//li[contains(@onclick,'AllocationBill')]");

	/** 物料类型 */
	public static final By AB_BTN_GOODSTYPE = By.xpath("//button[@data-id='goodsType']");

	/** 物料类型 下拉列表 */
	public static final By AB_LIST_GOODSTYPE = By.xpath("//div[@class='dropdown-menu open']");

	/** 物料类型选择 */
	public static final By AB_BTN_YUANLIAO = By.xpath("//ul[@role='menu']/li[2]");

	/** 调出仓库*/
	public static final By AB_BTN_OUTROOM = By.xpath("//button[@data-id='outStorageRoom']");

	/** 调出仓库列表 */
	public static final By AB_LIST_OUTROOMTYPE = By.xpath("//div[@id='outStoragePanel_body']/div/div");

	/** 调出仓库选择 */
	public static final By AB_BTN_OUTROOM_1 = By.xpath("//div[@id='outStoragePanel']//li[2]");

	/** 调入仓库 */
	public static final By AB_BTN_INROOM = By.xpath("//button[@data-id='inStorageRoom']");

	/** 调入仓库列表 */
	public static final By AB_LIST_INROOM = By.xpath("//button[@data-id='inStorageRoom']/following::div");

	/** 调入仓库选择 */
	public static final By AB_BTN_INROOM_1 = By.linkText("原料库");

	/** 经办人 */
	public static final By AB_BTN_OPERATOR = By.xpath("//button[@data-id='operator']");

	/** 经办人列表 */
	public static final By AB_LIST_OPERATOR = By.xpath("//button[@data-id='operator']/following::div");

	/** 选择经办人 */
	public static final By AB_BTN_OPERATOR_1 = By.xpath("//button[@data-id='operator']/following::div//li[2]");

	/** 备注 */
	public static final By AB_INPUT_COMMENT = By.id("comments");

	/** 添加物料 */
	public static final By AB_BTN_ADDGOODS = By.id("addButton");

	/** 添加物料对话框 */
	public static final By AB_DIALOG_ADDGOODS = By.xpath("//div[@class='modal-dialog material_dialog']");

	/** 选择物料 */
	public static final By AB_CHECKBOX_ADDGOODS = By.xpath("//td[@class='bg1']/input");

	/** 确认 */
	public static final By AB_BTN_CONFIRM = By.xpath("//button[@onclick='selectToAddGoods()']");

	/** 提交 */
	public static final By AB_BTN_SUBMIT = By.id("submitButton");

}
