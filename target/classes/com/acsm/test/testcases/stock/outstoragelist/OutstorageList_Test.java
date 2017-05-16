package com.acsm.test.testcases.stock.outstoragelist;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.acsm.test.base.BaseParpare;
import com.acsm.test.testpages.stock.outstoragelist.OutstorageListElement;
import com.acsm.test.testpages.stock.outstoragelist.OutstorageList_Helper;
import com.acsm.test.utils.SeleniumUtil;

public class OutstorageList_Test extends BaseParpare {

	public static Logger logger = Logger.getLogger(SeleniumUtil.class.getName());

	/**
	 * 进入出库明细,等待元素加载
	 */
	@Test(groups = { "outstorageList" })
	public void enterOutstorageList() {
		OutstorageList_Helper.click(seleniumUtil, OutstorageListElement.OL_BTN_INSTORAGELIST);
		OutstorageList_Helper.waitPageUI(seleniumUtil, timeOut);
	}

	/** 仓库 */
	@Test(groups = { "outstorageList" }, dependsOnMethods = { "enterOutstorageList" })
	public void selectRoom() {
		OutstorageList_Helper.click(seleniumUtil, OutstorageListElement.OL_BTN_ROOM);
		OutstorageList_Helper.waitForElementLoaded(seleniumUtil, timeOut, OutstorageListElement.OL_LIST_ROOM);
		OutstorageList_Helper.click(seleniumUtil, OutstorageListElement.OL_BTN_ROOM_1);
		logger.info("仓库选择完毕");
	}

	/** 物料类型 */
	@Test(groups = { "outstorageList" }, dependsOnMethods = { "enterOutstorageList" })
	public void selectGoodsType() {
		OutstorageList_Helper.click(seleniumUtil, OutstorageListElement.OL_BTN_GOODSTYPE);
		OutstorageList_Helper.waitForElementLoaded(seleniumUtil, timeOut, OutstorageListElement.OL_LIST_GOODSTYPE);
		OutstorageList_Helper.click(seleniumUtil, OutstorageListElement.OL_BTN_YUANLIAO);
		logger.info("物料类型选择完毕");
	}

	/** 经办人 */
	@Test(groups = { "outstorageList" }, dependsOnMethods = { "enterOutstorageList" })
	public void selectOperator() {
		OutstorageList_Helper.click(seleniumUtil, OutstorageListElement.OL_BTN_OPERATOR);
		OutstorageList_Helper.waitForElementLoaded(seleniumUtil, timeOut, OutstorageListElement.OL_LIST_OPERATOR);
		OutstorageList_Helper.click(seleniumUtil, OutstorageListElement.OL_BTN_OPERATOR_1);
		logger.info("经办人选择完毕");
	}

	/** 出库类型 */
	@Test(groups = { "outstorageList" }, dependsOnMethods = { "enterOutstorageList" })
	public void selectOutRoomType() {
		OutstorageList_Helper.click(seleniumUtil, OutstorageListElement.OL_BTN_INSTOCKTYPE);
		OutstorageList_Helper.waitForElementLoaded(seleniumUtil, timeOut, OutstorageListElement.OL_LIST_INSTOCKTYPE);
		OutstorageList_Helper.click(seleniumUtil, OutstorageListElement.OL_TEXT_INSTOCKTYPE);
		logger.info("出库类型选择完毕");
	}

	/** 搜索功能 */
	@Test(groups = { "outstorageList" }, dependsOnMethods = { "enterOutstorageList", "selectRoom", "selectGoodsType",
			"selectOutRoomType" })
	public void searchOutstorageList() {
		OutstorageList_Helper.click(seleniumUtil, OutstorageListElement.OL_INPUT_SEARCH);
		OutstorageList_Helper.clear(seleniumUtil, OutstorageListElement.OL_INPUT_SEARCH);
		OutstorageList_Helper.input(seleniumUtil, OutstorageListElement.OL_INPUT_SEARCH, "穿心莲");
		OutstorageList_Helper.click(seleniumUtil, OutstorageListElement.OL_BTN_SEARCH);
		OutstorageList_Helper.wait(seleniumUtil);
//		OutstorageList_Helper.compare(seleniumUtil, OutstorageListElement.OL_WEBELEMENT_SEARCHRESULT);
		logger.info("搜索完成");
	}

	/** 文件导出 */

	@Test(groups = { "outstorageList" }, enabled = false, dependsOnMethods = { "enterOutstorageList" })
	public void fileDownload() throws IOException {
		OutstorageList_Helper.click(seleniumUtil, OutstorageListElement.OL_BTN_EXPORT);
		boolean flag = OutstorageList_Helper.fileDownload(seleniumUtil, timeOut);
		Assert.assertEquals(true, flag);
		logger.info("查找到文件，下载成功");
	}

	/** 查看 */

	@Test(groups = { "outstorageList" }, dependsOnMethods = { "searchOutstorageList" })
	public void view() {
		OutstorageList_Helper.click(seleniumUtil, OutstorageListElement.OL_BTN_VIEW);
		OutstorageList_Helper.wait(seleniumUtil);
		OutstorageList_Helper.waitForElementLoaded(seleniumUtil, timeOut, OutstorageListElement.OL_BTN_BACK);
		OutstorageList_Helper.compare(seleniumUtil, OutstorageListElement.OL_BTN_BACK);
		OutstorageList_Helper.click(seleniumUtil, OutstorageListElement.OL_BTN_BACK);
	}

	/** 编辑 */
	@Test(groups = { "outstorageList" }, dependsOnMethods = { "searchOutstorageList" })
	public void edit() {
		OutstorageList_Helper.click(seleniumUtil, OutstorageListElement.OL_BTN_EDIT);
		OutstorageList_Helper.wait(seleniumUtil);
		OutstorageList_Helper.waitForElementLoaded(seleniumUtil, timeOut, OutstorageListElement.OL_BTN_EDITBACK);
		OutstorageList_Helper.compare(seleniumUtil, OutstorageListElement.OL_BTN_EDITBACK);
		OutstorageList_Helper.click(seleniumUtil, OutstorageListElement.OL_BTN_EDITBACK);
	}

	/** 删除 */

	@Test(groups = { "outstorageList" }, enabled = false, dependsOnMethods = { "view", "edit" })
	public void delete() {
		OutstorageList_Helper.click(seleniumUtil, OutstorageListElement.OL_BTN_DELETE);
		OutstorageList_Helper.alert(seleniumUtil, timeOut);
		boolean flag = OutstorageList_Helper.compare(seleniumUtil, OutstorageListElement.OL_BTN_BACK);
		if (flag) {
			logger.info("删除成功");
		}
	}

}
