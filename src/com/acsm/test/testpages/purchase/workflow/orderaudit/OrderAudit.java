package com.acsm.test.testpages.purchase.workflow.orderaudit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.acsm.test.testpages.purchase.Enter.EnterPurchaseElements;
import com.acsm.test.testpages.purchase.orderoperatelist.OrderOperateListElements;
import com.acsm.test.utils.SeleniumUtil;

public class OrderAudit {

	public static Logger logger = Logger.getLogger(SeleniumUtil.class.getName());
	public static WebDriver driver = SeleniumUtil.driver;
	public static String orderNumber;

	/**
	 * 进入订单待审核
	 * 
	 * @param seleniumUtil
	 * @return 审核
	 */
	public static void orderAudit(SeleniumUtil seleniumUtil) {
		seleniumUtil.pause(2000);
		seleniumUtil.click(OrderOperateListElements.OOL_BTN_AUDIT);
		//获取订单编号
		orderNumber = seleniumUtil.getText(OrderAuditElement.OA_STRING_ORDERNUMBER);
		logger.info("新订单已生成："+ orderNumber);
	}
	
	/**
	 * 等待页面加载结束,检查页面元素
	 * @param seleniumUtil
	 * @param timeOut
	 */
	public static void waitOrderAuditListPageLoad(SeleniumUtil seleniumUtil, int timeOut) {
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
	}
	/**
	 * 搜索功能验证
	 * @param seleniumUtil
	 */
	public static void searchFunction(SeleniumUtil seleniumUtil){
		String orderNum = seleniumUtil.getText(OrderAuditElement.OA_STRING_ORDERID);
		seleniumUtil.type(OrderAuditElement.OA_INPUT_SEARCH, orderNum);
		logger.info("输入订单:"+ orderNum);
		seleniumUtil.click(OrderAuditElement.OA_BTN_SEARCH);
	}

	/**
	 * 点击审核
	 * 
	 * @param seleniumUtil
	 * @return 审核通过按钮
	 */
	public static void audit(SeleniumUtil seleniumUtil) {
		seleniumUtil.pause(2000);
		seleniumUtil.click(OrderAuditElement.OA_BTN_AUDIT);
	}
	
	/**
	 * 等待订单管理页面加载完毕,检查页面元素
	 * @param seleniumUtil
	 * @param timeOut
	 */
	public static void waitOrderManage(SeleniumUtil seleniumUtil, int timeOut) {
		seleniumUtil.waitForElementToLoad(timeOut, OrderAuditElement.OA_STRING_CUSTMOR);
		seleniumUtil.waitForElementToLoad(timeOut, OrderAuditElement.OA_STRING_RECEIVER);
		seleniumUtil.waitForElementToLoad(timeOut, OrderAuditElement.OA_STRING_SENDTIME);
		seleniumUtil.waitForElementToLoad(timeOut, OrderAuditElement.OA_STRING_PAYMENTSTYLE);
		seleniumUtil.waitForElementToLoad(timeOut, OrderAuditElement.OA_STRING_COMMENTS);
		seleniumUtil.waitForElementToLoad(timeOut, OrderAuditElement.OA_STRING_ORDERLIST);
		seleniumUtil.waitForElementToLoad(timeOut, OrderAuditElement.OA_BTN_AUDITPASS);
	}

	/**
	 * 点击审核通过
	 * 
	 * @param seleniumUtil
	 * @return 是否跳转到订单流程页面
	 */
	public static void auditPass(SeleniumUtil seleniumUtil) {
		seleniumUtil.pause(2000);
		seleniumUtil.executeJS("arguments[0].scrollIntoView(true)", driver.findElement(OrderAuditElement.OA_BTN_AUDITPASS));
		seleniumUtil.click(OrderAuditElement.OA_BTN_AUDITPASS);
		seleniumUtil.pause(2000);
	}

}
