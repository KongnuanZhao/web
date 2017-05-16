package com.acsm.test.testcases.stock.outstorage;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.acsm.test.base.BaseParpare;
import com.acsm.test.testpages.stock.instockadd.InstockAdd;
import com.acsm.test.testpages.stock.outstorage.OutStorage;
import com.acsm.test.utils.RandomUtils;
import com.acsm.test.utils.SeleniumUtil;

public class OutStorage_Test extends BaseParpare {

	public static Logger logger = Logger.getLogger(SeleniumUtil.class.getName());

	/**
	 * 进入出库单，并等待元素加载
	 */
	@Test(groups = { "outStorage" })
	public void outStockAdd() {
		OutStorage.enterOutstock(seleniumUtil, timeOut);
		// OutStorage.waitElementsLoad(seleniumUtil, timeOut);
	}

	/**
	 * 选择物料类型 （2：原料 3：商品 4：辅料）
	 */
	@Test(groups = { "outStorage" }, dependsOnMethods = { "outStockAdd" })
	public void selectGoodsType() {
		String result = OutStorage.selectGoodsType(seleniumUtil, timeOut, 2);
		Assert.assertEquals("原料", result);
	}

	/**
	 * 添加如可类型 （21：销售出库 22：生产出库 23:报损出库 25:其他出库）
	 */
	@Test(groups = { "outStorage" }, dependsOnMethods = { "selectGoodsType" })
	public void selectOutstockType() {
		String result = OutStorage.selectOutstockType(seleniumUtil, timeOut, 78);
		Assert.assertEquals("自定义出库", result);
	}

	/**
	 * 选择仓库
	 */
	@Test(groups = { "outStorage" }, dependsOnMethods = { "selectOutstockType" })
	public void selectStockRoom() {
		String result = OutStorage.selectStockRoom(seleniumUtil, timeOut);
		Assert.assertEquals("原料库", result);
	}

	/**
	 * 选择经办人
	 */
	@Test(groups = { "outStorage" }, dependsOnMethods = { "selectStockRoom" })
	public void selectStockOperator() {
		String result = OutStorage.selectStockOperator(seleniumUtil, timeOut);
		Assert.assertEquals("里路飞", result);
	}

	/**
	 * 添加物料
	 */
	@Test(groups = { "outStorage" }, dependsOnMethods = { "selectStockOperator" })
	public void addGoods() {
		OutStorage.addGoods(seleniumUtil, timeOut);
	}
}
