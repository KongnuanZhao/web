package com.acsm.test.testcases.stock.inventorybill;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.acsm.test.base.BaseParpare;
import com.acsm.test.testpages.stock.inventorybill.InventoryBill;
import com.acsm.test.testpages.stock.outstorage.OutStorage;
import com.acsm.test.utils.SeleniumUtil;

public class InventorBill_Test extends BaseParpare {

	public static Logger logger = Logger.getLogger(SeleniumUtil.class.getName());

	/**
	 * 进入盘点单，并等待元素加载
	 */
	@Test(groups = { "inventorBill" })
	public void inventorBillAdd() {
		InventoryBill.enterInventoryBill(seleniumUtil, timeOut);
		// OutStorage.waitElementsLoad(seleniumUtil, timeOut);
	}

	/**
	 * 选择物料类型 （2：原料 3：商品 4：辅料）
	 */
	@Test(groups = { "inventorBill" }, dependsOnMethods = { "inventorBillAdd" })
	public void selectGoodsType() {
		String result = InventoryBill.selectGoodsType(seleniumUtil, timeOut, 2);
		Assert.assertEquals("原料", result);
	}

	/**
	 * 选择仓库
	 */
	@Test(groups = { "inventorBill" }, dependsOnMethods = { "selectGoodsType" })
	public void selectStockRoom() {
		String result = InventoryBill.selectStockRoom(seleniumUtil, timeOut);
		Assert.assertEquals("原料库", result);
	}

	/**
	 * 选择经办人
	 */
	@Test(groups = { "inventorBill" }, dependsOnMethods = { "selectStockRoom" })
	public void selectStockOperator() {
		String result = InventoryBill.selectStockOperator(seleniumUtil, timeOut);
		Assert.assertEquals("里路飞", result);
	}

	/**
	 * 添加物料
	 */
	@Test(groups = { "inventorBill" }, dependsOnMethods = { "selectStockOperator" })
	public void addGoods() {
		InventoryBill.addGoods(seleniumUtil, timeOut);
	}
}
