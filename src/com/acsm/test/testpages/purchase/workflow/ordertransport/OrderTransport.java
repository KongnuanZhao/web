package com.acsm.test.testpages.purchase.workflow.ordertransport;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.acsm.test.testpages.purchase.orderoperatelist.OrderOperateListElements;
import com.acsm.test.testpages.purchase.workflow.orderdelivery.OrderDeliveryElements;
import com.acsm.test.utils.SeleniumUtil;

public class OrderTransport {

	public static Logger logger = Logger.getLogger(SeleniumUtil.class.getName());
	public static WebDriver driver = SeleniumUtil.driver;

	/**
	 * 进入订单待发货
	 * 
	 * @param seleniumUtil
	 * @return 订单签收按钮
	 */
	public static void orderTransport(SeleniumUtil seleniumUtil) {
		seleniumUtil.pause(2000);
		seleniumUtil.click(OrderOperateListElements.OOL_BTN_TRANSPORT);
	}
	
	/**
	 * 点击收货
	 * 
	 * @param seleniumUtil
	 * @return 确认签收对话框
	 */
	public static WebElement orderTransportPage(SeleniumUtil seleniumUtil) {
		seleniumUtil.pause(2000);
		seleniumUtil.click(OrderTransportElement.OT_BTN_SIGN);
		return driver.findElement(OrderTransportElement.OD_DIALOG_SEND);
	}
	
	/**
	 * 点击提交
	 * 
	 * @param seleniumUtil
	 */
	public static void confirm(SeleniumUtil seleniumUtil) {
		seleniumUtil.pause(2000);
		seleniumUtil.click(OrderTransportElement.OD_BTN_CONFIRM);
	}
	
}
