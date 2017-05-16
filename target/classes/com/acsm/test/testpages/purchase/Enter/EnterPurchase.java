package com.acsm.test.testpages.purchase.Enter;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.acsm.test.testpages.purchase.orderoperatelist.OrderOperateListElements;
import com.acsm.test.utils.SeleniumUtil;

public class EnterPurchase {

	public static Logger logger = Logger.getLogger(EnterPurchase.class);
	static SeleniumUtil seleniumUtil;
	static WebDriver driver = SeleniumUtil.driver;

	/**
	 * 进入订单模块
	 */
	public static void enterPurchasePage(SeleniumUtil seleniumUtil) {

		seleniumUtil.pause(5000);
		seleniumUtil.refresh();
		seleniumUtil.waitForPageLoading(5);
		// 点击采销存
		seleniumUtil.mouseMoveToElement(EnterPurchaseElements.EP_BTN_SALE);
		seleniumUtil.click(EnterPurchaseElements.EP_BTN_SALE);
		seleniumUtil.pause(2000);

		// 悬浮等待订单模块显示
		seleniumUtil.waitForElementToLoad(5, EnterPurchaseElements.EP_BTN_ORDER);
		// 选择订单管理
		seleniumUtil.click(EnterPurchaseElements.EP_BTN_ORDER);
		seleniumUtil.pause(2000);

	}

	/**
	 * 等待页面加载
	 */
	public static void waitPurchasePageLoad(SeleniumUtil seleniumUtil, int timeOut) {
		seleniumUtil.waitForElementToLoad(timeOut, EnterPurchaseElements.OP_BTN_XDTIME);
		seleniumUtil.waitForElementToLoad(timeOut, EnterPurchaseElements.OP_BTN_PSTIME);
		seleniumUtil.waitForElementToLoad(timeOut, EnterPurchaseElements.OP_BTN_PAYMENTSTATUES);
		seleniumUtil.waitForElementToLoad(timeOut, EnterPurchaseElements.OP_BTN_ORDERSTATUES);
		seleniumUtil.waitForElementToLoad(timeOut, EnterPurchaseElements.EP_BTN_ADDORDER);
		// seleniumUtil.waitForElementToLoad(timeOut,
		// EnterPurchaseElements.EP_BTN_ADDCAIZHAI);
	}

	/**
	 * 点击全部订单
	 */

	public static void orderAll(SeleniumUtil seleniumUtil) {

		seleniumUtil.click(OrderOperateListElements.OOL_BTN_ALL);
	}
	
	/**
	 * 点击添加订单
	 */

	public static void orderAdded(SeleniumUtil seleniumUtil) {

		seleniumUtil.waitForElementToLoad(5, EnterPurchaseElements.EP_BTN_ADDORDER);
		seleniumUtil.click(EnterPurchaseElements.EP_BTN_ADDORDER);
	}
}
