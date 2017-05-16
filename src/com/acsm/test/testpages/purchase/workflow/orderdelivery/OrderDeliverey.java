package com.acsm.test.testpages.purchase.workflow.orderdelivery;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.acsm.test.testpages.purchase.Enter.EnterPurchaseElements;
import com.acsm.test.testpages.purchase.orderoperatelist.OrderOperateListElements;
import com.acsm.test.testpages.purchase.workflow.orderaudit.OrderAuditElement;
import com.acsm.test.utils.SeleniumUtil;

public class OrderDeliverey {

	public static Logger logger = Logger.getLogger(SeleniumUtil.class.getName());
	public static WebDriver driver = SeleniumUtil.driver;

	/**
	 * 进入订单待发货
	 * 
	 * @param seleniumUtil
	 * @return 待发货按钮
	 */
	public static void orderDelivery(SeleniumUtil seleniumUtil) {
		seleniumUtil.pause(2000);
		seleniumUtil.click(OrderOperateListElements.OOL_BTN_DELIVERY);
	}
	
	/**
	 * 等待页面加载结束,检查页面元素
	 * @param seleniumUtil
	 * @param timeOut
	 */
	public static void waitOrderDelivery(SeleniumUtil seleniumUtil, int timeOut) {
		seleniumUtil.waitForElementToLoad(timeOut, OrderDeliveryElements.OD_BTN_EXPORT);
		seleniumUtil.waitForElementToLoad(timeOut, OrderDeliveryElements.OD_BTN_DELIVERYALL);
		seleniumUtil.waitForElementToLoad(timeOut, OrderDeliveryElements.OD_BTN_SCAN);
		seleniumUtil.waitForElementToLoad(timeOut, OrderDeliveryElements.OD_BTN_PRINT);
		seleniumUtil.waitForElementToLoad(timeOut, OrderAuditElement.OA_BTN_VIEW);
		seleniumUtil.waitForElementToLoad(timeOut, OrderAuditElement.OA_BTN_EDIT);
		seleniumUtil.waitForElementToLoad(timeOut, OrderAuditElement.OA_BTN_DEL);
		seleniumUtil.waitForElementToLoad(timeOut, OrderAuditElement.OA_BTN_EDITPAYMENTSTATE);
		seleniumUtil.waitForElementToLoad(timeOut, OrderAuditElement.OA_INPUT_SEARCH);
		seleniumUtil.waitForElementToLoad(timeOut, OrderAuditElement.OA_BTN_SEARCH);
	}

	/**
	 * 点击发货
	 * 
	 * @param seleniumUtil
	 * @return 发货对话框
	 */
	public static void orderDeliveryPage(SeleniumUtil seleniumUtil) {
		seleniumUtil.pause(2000);
		seleniumUtil.click(OrderDeliveryElements.OD_BTN_TALLY);
	}

	/**
	 * 确认发货
	 * 
	 * @param seleniumUtil
	 * @return 发货确认
	 */
	public static void orderDeliveryConfirm(SeleniumUtil seleniumUtil) {
		seleniumUtil.pause(2000);
		seleniumUtil.click(OrderDeliveryElements.OD_BTN_CONFIRM);
	}

}
