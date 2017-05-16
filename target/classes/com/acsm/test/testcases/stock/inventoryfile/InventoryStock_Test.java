package com.acsm.test.testcases.stock.inventoryfile;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.acsm.test.base.BaseParpare;
import com.acsm.test.testpages.stock.inventoryfile.InventoryFile;
import com.acsm.test.utils.SeleniumUtil;

public class InventoryStock_Test extends BaseParpare {

	public static Logger logger = Logger.getLogger(SeleniumUtil.class.getName());

	/**
	 * 进入库存档案,等待元素加载
	 */
	@Test(groups = { "inventoryStock" })
	public void inventoryStockWorkflow() {
		InventoryFile.waitElementsLoad(seleniumUtil, timeOut);
	}

	/**
	 * 左侧列表收缩按钮验证
	 */

	@Test(groups = { "inventoryStock" }, enabled = false, dependsOnMethods = { "stockSearchVerification" })
	public void collapseHidden() {
		boolean flag = InventoryFile.sideBarHidden(seleniumUtil);
		Assert.assertEquals(false, flag);
		logger.info("点击收缩按钮，侧栏收缩成功");
	}

	@Test(groups = { "inventoryStock" }, enabled = true, dependsOnMethods = { "stockSearchVerification" })
	public void collapseDisplayed() {
		boolean flag = InventoryFile.sideBarShow(seleniumUtil);
		Assert.assertEquals(true, flag);
		logger.info("点击收缩按钮，侧栏正常展开成功");
	}

	/**
	 * 验证下拉列表正确显示
	 */
	@Test(groups = { "inventoryStock" }, enabled = true, dependsOnMethods = { "inventoryStockWorkflow" })
	public void listVerification() {
		boolean flag_0 = InventoryFile.goodsDepot(seleniumUtil);
		Assert.assertEquals(true, flag_0);
		logger.info("点击仓库，下拉列表正常展开成功");
		boolean flag_1 = InventoryFile.goodsType(seleniumUtil);
		Assert.assertEquals(true, flag_1);
		logger.info("点击物料类型，下拉列表正常展开成功");
		boolean flag_2 = InventoryFile.picker(seleniumUtil);
		Assert.assertEquals(true, flag_2);
		logger.info("点击经办人，下拉列表正常展开成功");
		boolean flag_3 = InventoryFile.goodsResouce(seleniumUtil);
		Assert.assertEquals(true, flag_3);
		logger.info("点击来源，下拉列表正常展开成功");
	}

	/**
	 * 文件导出
	 * 
	 * @throws IOException
	 */

	@Test(groups = { "inventoryStock" }, enabled = true, dependsOnMethods = { "inventoryStockWorkflow" })
	public void fileDownload() throws IOException {
		boolean flag = InventoryFile.fileDownload(seleniumUtil, timeOut);
		Assert.assertEquals(true, flag);
		logger.info("查找到文件，下载成功");
	}

	/**
	 * 搜索验证
	 * 
	 * @throws IOException
	 */

	@Test(groups = { "inventoryStock" }, enabled = true, dependsOnMethods = { "inventoryStockWorkflow" })
	public void stockSearchVerification() {
		String str = InventoryFile.stockSearch(seleniumUtil, "SP0933201601060001");
		Assert.assertEquals("SP0933201601060001", str);
		logger.info("查找到对应结果，搜索正确");
	}
}
