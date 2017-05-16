package com.acsm.test.testcases.stock.allocationrecord;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.acsm.test.base.BaseParpare;
import com.acsm.test.testpages.stock.allocationrecord.AllocationRecordElement;
import com.acsm.test.testpages.stock.allocationrecord.AllocationRecord_Helper;
import com.acsm.test.testpages.stock.outstoragelist.OutstorageList_Helper;
import com.acsm.test.utils.SeleniumUtil;

public class AllocationRecord_Test extends BaseParpare {

	public static Logger logger = Logger.getLogger(SeleniumUtil.class.getName());

	/**
	 * 进入调拨记录,等待元素加载
	 */
	@Test(groups = { "allocationRecord" })
	public void enterAllocationRecord() {
		AllocationRecord_Helper.click(seleniumUtil, AllocationRecordElement.AR_BTN_INSTORAGELIST);
		AllocationRecord_Helper.waitPageUI(seleniumUtil, timeOut);
	}

	/** 调出仓库 */
	@Test(groups = { "allocationRecord" }, dependsOnMethods = { "enterAllocationRecord" })
	public void selectOutroom_1() {
		AllocationRecord_Helper.click(seleniumUtil, AllocationRecordElement.AR_BTN_ROOM);
		AllocationRecord_Helper.waitForElementLoaded(seleniumUtil, timeOut, AllocationRecordElement.AR_LIST_ROOM);
		AllocationRecord_Helper.click(seleniumUtil, AllocationRecordElement.AR_BTN_ROOM_1);
		logger.info("调出仓库选择完毕");
	}

	/** 调入仓库 */
	@Test(groups = { "allocationRecord" }, dependsOnMethods = { "enterAllocationRecord" })
	public void selectOutroom_2() {
		AllocationRecord_Helper.click(seleniumUtil, AllocationRecordElement.AR_BTN_ROOMANOTHER);
		AllocationRecord_Helper.waitForElementLoaded(seleniumUtil, timeOut,
				AllocationRecordElement.AR_LIST_ROOMANOTHER);
		AllocationRecord_Helper.click(seleniumUtil, AllocationRecordElement.AR_BTN_YUANLIAO);
		logger.info("调入仓库选择完毕");
	}

	/** 经办人 */
	@Test(groups = { "allocationRecord" }, dependsOnMethods = { "enterAllocationRecord" })
	public void selectOperator() {
		AllocationRecord_Helper.click(seleniumUtil, AllocationRecordElement.AR_BTN_OPERATOR);
		AllocationRecord_Helper.waitForElementLoaded(seleniumUtil, timeOut, AllocationRecordElement.AR_LIST_OPERATOR);
		AllocationRecord_Helper.click(seleniumUtil, AllocationRecordElement.AR_BTN_OPERATOR_1);
		logger.info("经办人选择完毕");
	}

	/** 搜索功能 */
	@Test(groups = { "allocationRecord" }, dependsOnMethods = { "enterAllocationRecord", "selectOutroom_1",
			"selectOutroom_2", "selectOperator" })
	public void searchAllocationRecord() {
		AllocationRecord_Helper.click(seleniumUtil, AllocationRecordElement.AR_INPUT_SEARCH);
		AllocationRecord_Helper.clear(seleniumUtil, AllocationRecordElement.AR_INPUT_SEARCH);
		AllocationRecord_Helper.input(seleniumUtil, AllocationRecordElement.AR_INPUT_SEARCH, "pk4");
		AllocationRecord_Helper.click(seleniumUtil, AllocationRecordElement.AR_BTN_SEARCH);
		AllocationRecord_Helper.wait(seleniumUtil);
		AllocationRecord_Helper.compare(seleniumUtil, AllocationRecordElement.AR_WEBELEMENT_SEARCHRESULT);
		logger.info("搜索完成");
	}

	/** 查看 */

	@Test(groups = { "allocationRecord" }, dependsOnMethods = { "searchAllocationRecord" })
	public void view() {
		AllocationRecord_Helper.click(seleniumUtil, AllocationRecordElement.AR_BTN_VIEW);
		AllocationRecord_Helper.wait(seleniumUtil);
		AllocationRecord_Helper.waitForElementLoaded(seleniumUtil, timeOut, AllocationRecordElement.AR_BTNBACK);
		AllocationRecord_Helper.compare(seleniumUtil, AllocationRecordElement.AR_BTNBACK);
		AllocationRecord_Helper.click(seleniumUtil, AllocationRecordElement.AR_BTNBACK);
	}

	/** 编辑 */

	@Test(groups = { "allocationRecord" }, dependsOnMethods = { "searchAllocationRecord" })
	public void edit() {
		AllocationRecord_Helper.click(seleniumUtil, AllocationRecordElement.AR_BTN_EDIT);
		AllocationRecord_Helper.wait(seleniumUtil);
		AllocationRecord_Helper.waitForElementLoaded(seleniumUtil, timeOut, AllocationRecordElement.AR_BTNBACK);
		AllocationRecord_Helper.compare(seleniumUtil, AllocationRecordElement.AR_BTNBACK);
		AllocationRecord_Helper.click(seleniumUtil, AllocationRecordElement.AR_BTNBACK);
	}

	/** 删除 */

	@Test(groups = { "allocationRecord" }, enabled = false, dependsOnMethods = { "view", "edit" })
	public void delete() {
		AllocationRecord_Helper.click(seleniumUtil, AllocationRecordElement.AR_BTN_DELETE);
		AllocationRecord_Helper.alert(seleniumUtil, timeOut);
		boolean flag = OutstorageList_Helper.compare(seleniumUtil, AllocationRecordElement.AR_BTNBACK);
		if (flag) {
			logger.info("删除成功");
		}
	}

}
