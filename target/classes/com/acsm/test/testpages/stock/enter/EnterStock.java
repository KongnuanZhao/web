package com.acsm.test.testpages.stock.enter;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.acsm.test.utils.SeleniumUtil;

public class EnterStock {
	public static Logger logger = Logger.getLogger(SeleniumUtil.class.getName());
	public static WebDriver driver = SeleniumUtil.driver;

	/**
	 * 进入库存
	 * @param seleniumUtil
	 * @return webURL
	 */
	public static String enterStock(SeleniumUtil seleniumUtil) {
		seleniumUtil.waitForPageLoading(2000);
		// 悬浮采销存
		seleniumUtil.mouseMoveToElement(EnterStockElements.ES_BTN_SALE);
		seleniumUtil.click(EnterStockElements.ES_BTN_SALE);
		seleniumUtil.pause(2000);
		// 点击库存
		seleniumUtil.waitForElementToLoad(2000, EnterStockElements.EP_BTN_STOCK);
		seleniumUtil.click(EnterStockElements.EP_BTN_STOCK);
		seleniumUtil.pause(2000);
		String webURL = driver.getCurrentUrl();
		System.out.println(webURL);
		return webURL;
	}
}
