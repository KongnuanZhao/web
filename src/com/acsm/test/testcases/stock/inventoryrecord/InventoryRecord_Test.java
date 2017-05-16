package com.acsm.test.testcases.stock.inventoryrecord;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.acsm.test.base.BaseParpare;
import com.acsm.test.testpages.stock.inventoryrecord.InventoryRecordElement;
import com.acsm.test.testpages.stock.inventoryrecord.InventoryRecord_Helper;
import com.acsm.test.utils.SeleniumUtil;

public class InventoryRecord_Test extends BaseParpare {

	public static Logger logger = Logger.getLogger(SeleniumUtil.class.getName());

	/**
	 * 进入盘点记录,等待元素加载
	 */
	@Test(groups = { "inventoryRecord" })
	public void enterInventoryRecord() {
		InventoryRecord_Helper.click(seleniumUtil, InventoryRecordElement.IR_BTN_INVENTRYRECORD);
		InventoryRecord_Helper.waitPageUI(seleniumUtil, timeOut);
	}

	/** 仓库 */
	@Test(groups = { "inventoryRecord" }, dependsOnMethods = { "enterInventoryRecord" })
	public void selectRoom() {
		InventoryRecord_Helper.click(seleniumUtil, InventoryRecordElement.IR_BTN_ROOM);
		InventoryRecord_Helper.waitForElementLoaded(seleniumUtil, timeOut, InventoryRecordElement.IR_LIST_ROOM);
		InventoryRecord_Helper.click(seleniumUtil, InventoryRecordElement.IR_BTN_ROOM_1);
		logger.info("仓库选择完毕");
	}

	/** 物料类型 */
	@Test(groups = { "inventoryRecord" }, dependsOnMethods = { "enterInventoryRecord" })
	public void selectOutroom_2() {
		InventoryRecord_Helper.click(seleniumUtil, InventoryRecordElement.IR_BTN_GOODSTYPE);
		InventoryRecord_Helper.waitForElementLoaded(seleniumUtil, timeOut, InventoryRecordElement.IR_LIST_GOODSTYPE);
		InventoryRecord_Helper.click(seleniumUtil, InventoryRecordElement.IR_BTN_YUANLIAO);
		logger.info("物料类型选择完毕");
	}

	/** 经办人 */
	@Test(groups = { "inventoryRecord" }, dependsOnMethods = { "enterInventoryRecord" })
	public void selectOperator() {
		InventoryRecord_Helper.click(seleniumUtil, InventoryRecordElement.IR_BTN_OPERATOR);
		InventoryRecord_Helper.waitForElementLoaded(seleniumUtil, timeOut, InventoryRecordElement.IR_LIST_OPERATOR);
		InventoryRecord_Helper.click(seleniumUtil, InventoryRecordElement.IR_BTN_OPERATOR_1);
		logger.info("经办人选择完毕");
	}

	/** 搜索功能 */
	@Test(groups = { "inventoryRecord" }, dependsOnMethods = { "enterInventoryRecord", "selectRoom", "selectOperator" })
	public void searchAllocationRecord() {
		InventoryRecord_Helper.click(seleniumUtil, InventoryRecordElement.IR_INPUT_SEARCH);
		InventoryRecord_Helper.clear(seleniumUtil, InventoryRecordElement.IR_INPUT_SEARCH);
		InventoryRecord_Helper.input(seleniumUtil, InventoryRecordElement.IR_INPUT_SEARCH, "pk4");
		InventoryRecord_Helper.click(seleniumUtil, InventoryRecordElement.IR_BTN_SEARCH);
		InventoryRecord_Helper.wait(seleniumUtil);
		InventoryRecord_Helper.compare(seleniumUtil, InventoryRecordElement.IR_WEBELEMENT_SEARCHRESULT);
		logger.info("搜索完成");
	}

	/** 查看 */

	@Test(groups = { "inventoryRecord" }, dependsOnMethods = { "searchAllocationRecord" })
	public void view() {
		InventoryRecord_Helper.click(seleniumUtil, InventoryRecordElement.IR_BTN_VIEW);
		InventoryRecord_Helper.wait(seleniumUtil);
		InventoryRecord_Helper.waitForElementLoaded(seleniumUtil, timeOut, InventoryRecordElement.IR_BTN_BACK);
		InventoryRecord_Helper.compare(seleniumUtil, InventoryRecordElement.IR_BTN_BACK);
		InventoryRecord_Helper.click(seleniumUtil, InventoryRecordElement.IR_BTN_BACK);
	}

}
