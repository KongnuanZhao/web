package com.acsm.test.testcases.stock.instockadd;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.acsm.test.base.BaseParpare;
import com.acsm.test.testpages.stock.instockadd.InstockAdd;
import com.acsm.test.utils.RandomUtils;
import com.acsm.test.utils.SeleniumUtil;

public class InStockAdd_Test extends BaseParpare {

	public static Logger logger = Logger.getLogger(SeleniumUtil.class.getName());

	/**
	 * 进入入库单，并等待元素加载
	 */
	@Test(groups = { "inStockAdd" })
	public void inStockAdd() {
		InstockAdd.enterInstock(seleniumUtil, timeOut);
		// InstockAdd.waitElementsLoad(seleniumUtil, timeOut);
	}

	/**
	 * 选择物料类型 （2：原料 3：商品 4：辅料）
	 */
	@Test(groups = { "inStockAdd" }, dependsOnMethods = { "inStockAdd" })
	public void selectGoodsType() {
		String result = InstockAdd.selectGoodsType(seleniumUtil, timeOut, 2);
		Assert.assertEquals("原料", result);
	}

	/**
	 * 添加如可类型 （69：自定义 11：采购 12：生产 13：退货 15：其他）
	 */
	@Test(groups = { "inStockAdd" }, dependsOnMethods = { "selectGoodsType" })
	public void selectInstockType() {
		String result = InstockAdd.selectInstockType(seleniumUtil, timeOut, 69);
		Assert.assertEquals("自定义入库", result);
	}

	/**
	 * 选择仓库
	 */
	@Test(groups = { "inStockAdd" }, dependsOnMethods = { "selectInstockType" })
	public void selectStockRoom() {
		String result = InstockAdd.selectStockRoom(seleniumUtil, timeOut);
		Assert.assertEquals("原料库", result);
	}

	/**
	 * 选择经办人
	 */
	@Test(groups = { "inStockAdd" }, dependsOnMethods = { "selectStockRoom" })
	public void selectStockOperator() {
		String result = InstockAdd.selectStockOperator(seleniumUtil, timeOut);
		Assert.assertEquals("里路飞", result);
	}

	/**
	 * 选择当前时间,输入备注
	 */
	@Test(enabled = false, dependsOnMethods = { "selectStockOperator" })
	public void inRoomTime() {
		// InstockAdd.inRoomTime(seleniumUtil, timeOut);
		InstockAdd.typeMessage(seleniumUtil, timeOut, RandomUtils.generateMixString(20));
	}

	/**
	 * 添加物料
	 */
	@Test(groups = { "inStockAdd" }, dependsOnMethods = { "selectStockOperator" })
	public void addGoods() {
		InstockAdd.addGoods(seleniumUtil, timeOut);
	}

}
