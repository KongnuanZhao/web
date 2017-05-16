package com.acsm.test.testpages.purchase.workflow.ordertally;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.acsm.test.testpages.purchase.Enter.EnterPurchaseElements;
import com.acsm.test.testpages.purchase.orderoperatelist.OrderOperateListElements;
import com.acsm.test.testpages.purchase.workflow.orderaudit.OrderAuditElement;
import com.acsm.test.utils.SeleniumUtil;

public class OrderTally {

	public static Logger logger = Logger.getLogger(SeleniumUtil.class.getName());
	public static WebDriver driver = SeleniumUtil.driver;

	/**
	 * 进入订单理货
	 * 
	 * @param seleniumUtil
	 * @return 理货按钮
	 */
	public static void orderTally(SeleniumUtil seleniumUtil) {
		seleniumUtil.pause(2000);
		seleniumUtil.click(OrderOperateListElements.OOL_BTN_TALLY);
	}

	/**
	 * 等待页面加载结束,检查页面元素
	 * @param seleniumUtil
	 * @param timeOut
	 */
	public static void waitOrderTallyList(SeleniumUtil seleniumUtil, int timeOut) {
		seleniumUtil.waitForElementToLoad(timeOut, EnterPurchaseElements.OP_BTN_XDTIME);
		seleniumUtil.waitForElementToLoad(timeOut, EnterPurchaseElements.OP_BTN_PSTIME);
		seleniumUtil.waitForElementToLoad(timeOut, EnterPurchaseElements.OP_BTN_PAYMENTSTATUES);
		seleniumUtil.waitForElementToLoad(timeOut, EnterPurchaseElements.OP_BTN_ORDERSTATUES);
		seleniumUtil.waitForElementToLoad(timeOut, OrderAuditElement.OA_BTN_VIEW);
		seleniumUtil.waitForElementToLoad(timeOut, OrderAuditElement.OA_BTN_EDIT);
		seleniumUtil.waitForElementToLoad(timeOut, OrderAuditElement.OA_BTN_DEL);
		seleniumUtil.waitForElementToLoad(timeOut, OrderAuditElement.OA_BTN_EDITPAYMENTSTATE);
		seleniumUtil.waitForElementToLoad(timeOut, OrderAuditElement.OA_INPUT_SEARCH);
		seleniumUtil.waitForElementToLoad(timeOut, OrderAuditElement.OA_BTN_SEARCH);
		seleniumUtil.waitForElementToLoad(timeOut, OrderTallyElement.OT_BTN_PRINT);
		seleniumUtil.waitForElementToLoad(timeOut, OrderTallyElement.OT_BTN_WITHOUTTALLY);		
	}
	
	/**
	 * 进入理货页面
	 * 
	 * @param seleniumUtil
	 * @return 理货
	 */
	public static void orderTallyPage(SeleniumUtil seleniumUtil) {
		seleniumUtil.pause(2000);
		seleniumUtil.click(OrderTallyElement.OT_BTN_TALLY);
	}
	
	/**
	 * 进入订单理货,输入来源数量
	 * 
	 * @param seleniumUtil
	 */
	public static void tallyCount(SeleniumUtil seleniumUtil,String str) {
		seleniumUtil.pause(2000);
		seleniumUtil.type(OrderTallyElement.OT_INPUT_DTALLYCOUNT, str);
	}
	
	/**
	 * 进入订单理货,输入履历追溯码
	 * 
	 * @param seleniumUtil
	 */
	public static void tallyCode(SeleniumUtil seleniumUtil,String str) {
		seleniumUtil.pause(2000);
		seleniumUtil.click(OrderTallyElement.OT_INPUT_DTALLYCODE);
		seleniumUtil.waitForElementToLoad(2000, OrderTallyElement.OT_DIALOG_TALLYCODE);
		seleniumUtil.isDisplayed(driver.findElement(OrderTallyElement.OT_DIALOG_TALLYCODE));
		seleniumUtil.type(OrderTallyElement.OT_INPUT_TALLYCODE, str);
		seleniumUtil.pause(2000);
		seleniumUtil.click(OrderTallyElement.OT_BTN_CONFIRM);
		}
	/**
	 * 点击完成
	 * 
	 * @param seleniumUtil
	 * @return 是否跳转到订单流程页面
	 */
	public static void tallyPass(SeleniumUtil seleniumUtil) {
		seleniumUtil.pause(2000);
		seleniumUtil.click(OrderTallyElement.OT_BTN_DONE);
	}
}
