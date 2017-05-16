package com.acsm.test.testcases.stock.allocationbill;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.acsm.test.base.BaseParpare;
import com.acsm.test.testpages.stock.allocationbill.AllocationBill;
import com.acsm.test.utils.SeleniumUtil;

public class AllocationBill_Test extends BaseParpare {

	public static Logger logger = Logger.getLogger(SeleniumUtil.class.getName());

	/**
	 * 进入调拨单，并等待元素加载
	 */
	@Test(groups = { "allocationBill" })
	public void outAllocationBill() {
		AllocationBill.enterAllocationBill(seleniumUtil, timeOut);
		AllocationBill.waitElementsLoad(seleniumUtil, timeOut);
	}

	/**
	 * 选择物料类型 （2：原料 3：商品 ）
	 */
	@Test(groups = { "allocationBill" }, dependsOnMethods = { "outAllocationBill" })
	public void selectGoodsType() {
		String result = AllocationBill.selectGoodsType(seleniumUtil, timeOut, 2);
		Assert.assertEquals("原料", result);
	}

	/**
	 * 选择调出仓库 （2:原料库 3:商品库）
	 */
	@Test(groups = { "allocationBill" }, dependsOnMethods = { "selectGoodsType" })
	public void selectOutroom() {
		String result = AllocationBill.selectOutstockType(seleniumUtil, timeOut, 2);
		Assert.assertEquals("原料库", result);
	}

	/**
	 * 选择调入仓库（2:原料库 3:商品库）
	 */
	@Test(groups = { "allocationBill" }, dependsOnMethods = { "selectOutroom" })
	public void selectInRoom() {
		String result = AllocationBill.selectInstockType(seleniumUtil, timeOut, 2);
		Assert.assertEquals("原料库2", result);
	}

	/**
	 * 选择经办人
	 */
	@Test(groups = { "allocationBill" }, dependsOnMethods = { "selectInRoom" })
	public void selectStockOperator() {
		String result = AllocationBill.selectStockOperator(seleniumUtil, timeOut);
		Assert.assertEquals("里路飞", result);
	}

	/**
	 * 输入备注
	 */
	@Test(groups = { "allocationBill" }, dependsOnMethods = { "selectStockOperator" })
	public void typeMessage() {
		AllocationBill.typeMessage(seleniumUtil, timeOut, "里路飞");
	}

	/**
	 * 添加物料
	 */
	@Test(groups = { "allocationBill" }, dependsOnMethods = { "typeMessage" })
	public void addGoods() {
		AllocationBill.addGoods(seleniumUtil, timeOut);
	}
}
