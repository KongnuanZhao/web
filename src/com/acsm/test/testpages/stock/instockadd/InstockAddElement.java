package com.acsm.test.testpages.stock.instockadd;

import org.openqa.selenium.By;

public class InstockAddElement {
	
	/** 入库单 */
	public static final By IA_BTN_LEFTBTN = By.xpath("//i[@class='collapse_btn']");
	
	/** 入库单 */
	public static final By IA_BTN_INSTOCKADD = By.xpath("//li[contains(@onclick,'InStockAdd.seam')]");

	/** 物料类型 */
	public static final By IA_BTN_GOODSTYPE = By.xpath("//button[@data-id='goodsType']");

	/** 物料类型 下拉列表 */
	public static final By IA_LIST_GOODSTYPE = By.xpath("//div[@class='dropdown-menu open']");

	/** 物料类型 选择*/
	public static final By IA_BTN_YUANLIAO = By.xpath("//ul[@role='menu']/li[2]");

	/** 入库类型 */
	public static final By IA_BTN_INSTOCKTYPE = By.xpath("//div[contains(@class,'groupselect_add')]");

	/** 入库类型 列表 */
	public static final By IA_LIST_INSTOCKTYPE = By.id("inStockTypeUl");

	/** 入库类型选择 */
	public static final By IA_TEXT_INSTOCKTYPE = By.id("inStockType");

	/** 仓库 */
	public static final By IA_BTN_ROOM = By.xpath("//button[@data-id='storageRoom']");

	/** 仓库列表 */
	public static final By IA_LIST_ROOM = By.xpath("//div[@id='showPanel']//div[@class='dropdown-menu open']");

	/** 选择仓库 */
	public static final By IA_BTN_ROOM_1 = By.linkText("原料库");

	/** 经办人 */
	public static final By IA_BTN_OPERATOR = By.xpath("//button[@data-id='operator']");

	/** 经办人列表 */
	public static final By IA_LIST_OPERATOR = By.xpath("//div[@id='showOperator']//div[@class='dropdown-menu open']");

	/** 选择经办人 */
	public static final By IA_BTN_OPERATOR_1 = By
			.xpath("//div[@id='showOperator']//div[@class='dropdown-menu open']//li[2]");

	/** 入库日期 */
	public static final By IA_BTN_TIME = By.id("inStorageTime");

	/** 入库日期列表 */
	public static final By IA_BTN_TIMELIST = By.id("//div[@class='datetimepicker-days']");

	/** 当前时间 */
	public static final By IA_BTN_CURDATE = By.xpath("//td[@class='day active']");

	/** 备注 */
	public static final By IA_INPUT_COMMENT = By.id("comments");

	/** 添加物料 */
	public static final By IA_BTN_ADDGOODS = By.id("addButton");

	/** 添加物料对话框 */
	public static final By IA_DIALOG_ADDGOODS = By.id("selectGoods");

	/** 选择物料 */
	public static final By IA_CHECKBOX_ADDGOODS = By.xpath("//div[@id='modelListPanel']//tr[2]//input");

	/** 添加 */
	public static final By IA_BTN_CONFIRM = By.xpath("//button[@onclick='addGoods()']");

	/** 提交 */
	public static final By IA_BTN_SUBMIT = By.id("submitButton");
	
	/** 入库量 */
	public static final By IA_TEXT_INSTOCKNUM = By.name("numInput");
	
	/** 入库总重量 */
	public static final By IA_TEXT_INSTOCKWEIGHT = By.name("weightInput");
	
	/** 保质期 */
	public static final By IA_TEXT_RELEASEDATE = By.name("shelfLifeInput");
	
	/** 物料单价 */
	public static final By IA_TEXT_GOODSPRICE = By.name("priceInput");
	
	/** 物料总价 */
	public static final By IA_TEXT_TOTALPRICE = By.name("totolPrice");
	
	/** 供应商 */
	public static final By IA_BTN_PROVIDER = By.id("purchaseId");

	/** 出库编码 */
	public static final By IA_BTN_OUTCODE = By.id("outStockCode");
}
