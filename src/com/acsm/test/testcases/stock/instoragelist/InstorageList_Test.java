package com.acsm.test.testcases.stock.instoragelist;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.acsm.test.base.BaseParpare;
import com.acsm.test.testpages.stock.instoragelist.InstorageListElement;
import com.acsm.test.testpages.stock.instoragelist.InstorageList_Helper;
import com.acsm.test.utils.SeleniumUtil;

public class InstorageList_Test extends BaseParpare {

	public static Logger logger = Logger.getLogger(SeleniumUtil.class.getName());

	/**
	 * 进入入库明细,等待元素加载
	 */
	@Test(groups = { "inStockList" })
	public void enterInstorageList() {
		InstorageList_Helper.click(seleniumUtil, InstorageListElement.IL_BTN_INSTORAGELIST);
		InstorageList_Helper.waitPageUI(seleniumUtil, timeOut);
	}
	
	/** 仓库 */
	@Test(groups = { "inStockList" },dependsOnMethods = { "enterInstorageList" })
	public void selectRoom() {
		InstorageList_Helper.click(seleniumUtil, InstorageListElement.IL_BTN_ROOM);
		InstorageList_Helper.waitForElementLoaded(seleniumUtil, timeOut, InstorageListElement.IL_LIST_ROOM);
		InstorageList_Helper.click(seleniumUtil, InstorageListElement.IL_BTN_ROOM_1);
		logger.info("仓库选择完毕");
	}

	/** 物料类型 */
	@Test(groups = { "inStockList" },dependsOnMethods = { "enterInstorageList" })
	public void selectGoodsType() {
		InstorageList_Helper.click(seleniumUtil, InstorageListElement.IL_BTN_GOODSTYPE);
		InstorageList_Helper.waitForElementLoaded(seleniumUtil, timeOut, InstorageListElement.IL_LIST_GOODSTYPE);
		InstorageList_Helper.click(seleniumUtil, InstorageListElement.IL_BTN_YUANLIAO);
		logger.info("物料类型选择完毕");
	}

	/** 经办人 */
	@Test(groups = { "inStockList" }, dependsOnMethods = { "enterInstorageList" })
	public void selectOperator() {
		InstorageList_Helper.click(seleniumUtil, InstorageListElement.IL_BTN_OPERATOR);
		InstorageList_Helper.waitForElementLoaded(seleniumUtil, timeOut, InstorageListElement.IL_LIST_OPERATOR);
		InstorageList_Helper.click(seleniumUtil, InstorageListElement.IL_BTN_OPERATOR_0);
		logger.info("经办人选择完毕");
	}

	/** 入库类型 */
	@Test(groups = { "inStockList" },dependsOnMethods = { "enterInstorageList" })
	public void selectInRoomType() {
		InstorageList_Helper.click(seleniumUtil, InstorageListElement.IL_BTN_INSTOCKTYPE);
		InstorageList_Helper.waitForElementLoaded(seleniumUtil, timeOut, InstorageListElement.IL_LIST_INSTOCKTYPE);
		InstorageList_Helper.click(seleniumUtil, InstorageListElement.IL_TEXT_INSTOCKTYPE);
		logger.info("入库类型选择完毕");
	}

	/** 搜索功能 */
	@Test(groups = { "inStockList" },dependsOnMethods = { "enterInstorageList", "selectRoom", "selectGoodsType", "selectInRoomType" })
	public void searchInstorageList() {
		InstorageList_Helper.click(seleniumUtil, InstorageListElement.IL_INPUT_SEARCH);
		InstorageList_Helper.clear(seleniumUtil, InstorageListElement.IL_INPUT_SEARCH);
		InstorageList_Helper.input(seleniumUtil, InstorageListElement.IL_INPUT_SEARCH, "pk4");
		InstorageList_Helper.click(seleniumUtil, InstorageListElement.IL_BTN_SEARCH);
		InstorageList_Helper.wait(seleniumUtil);
		InstorageList_Helper.compare(seleniumUtil, InstorageListElement.IL_WEBELEMENT_SEARCHRESULT);
		logger.info("搜索完成");
	}

	/** 文件导出 */

	@Test(groups = { "inStockList" },enabled=false,dependsOnMethods = { "enterInstorageList" })
	public void fileDownload() throws IOException {
		InstorageList_Helper.click(seleniumUtil, InstorageListElement.IL_BTN_EXPORT);
		boolean flag = InstorageList_Helper.fileDownload(seleniumUtil, timeOut);
		Assert.assertEquals(true, flag);
		logger.info("查找到文件，下载成功");
	}

	/** 查看 */

	@Test(groups = { "inStockList" },dependsOnMethods = { "searchInstorageList" })
	public void view() {
		InstorageList_Helper.click(seleniumUtil, InstorageListElement.IL_BTN_VIEW);
		InstorageList_Helper.wait(seleniumUtil);
		InstorageList_Helper.waitForElementLoaded(seleniumUtil, timeOut, InstorageListElement.IL_BTNBACK);
		InstorageList_Helper.compare(seleniumUtil, InstorageListElement.IL_BTNBACK);
		InstorageList_Helper.click(seleniumUtil, InstorageListElement.IL_BTNBACK);
	}

	/** 编辑 */

	@Test(groups = { "inStockList" },dependsOnMethods = { "searchInstorageList" })
	public void edit() {
		InstorageList_Helper.click(seleniumUtil, InstorageListElement.IL_BTN_EDIT);
		InstorageList_Helper.wait(seleniumUtil);
		InstorageList_Helper.waitForElementLoaded(seleniumUtil, timeOut, InstorageListElement.IL_BTNBACK);
		InstorageList_Helper.compare(seleniumUtil, InstorageListElement.IL_BTNBACK);
		InstorageList_Helper.click(seleniumUtil, InstorageListElement.IL_BTNBACK);
	}

	/** 删除 */

	@Test(groups = { "inStockList" },enabled=false,dependsOnMethods = { "view", "edit" })
	public void delete() {
		InstorageList_Helper.click(seleniumUtil, InstorageListElement.IL_BTN_DELETE);
		InstorageList_Helper.alert(seleniumUtil, waitMillisecondsForAlert);
		boolean flag = InstorageList_Helper.compare(seleniumUtil, InstorageListElement.IL_BTNBACK);
		if (flag) {
			logger.info("删除成功");
		}
	}

}
