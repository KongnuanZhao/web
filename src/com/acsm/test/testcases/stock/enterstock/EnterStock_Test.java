package com.acsm.test.testcases.stock.enterstock;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.acsm.test.base.BaseParpare;
import com.acsm.test.testpages.stock.enter.EnterStock;
import com.acsm.test.utils.SeleniumUtil;

public class EnterStock_Test extends BaseParpare {

	public static Logger logger = Logger.getLogger(SeleniumUtil.class.getName());

	@Test(groups = { "enterStock" })
	public void enterStockWorkflow() {

		String URL = EnterStock.enterStock(seleniumUtil);
		// 验证打开地址是否正确
		Assert.assertEquals(URL.substring(27, 32), "stock");
	}
}
