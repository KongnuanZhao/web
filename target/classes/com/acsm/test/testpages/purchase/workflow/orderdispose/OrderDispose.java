package com.acsm.test.testpages.purchase.workflow.orderdispose;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.acsm.test.testpages.purchase.Enter.EnterPurchaseElements;
import com.acsm.test.testpages.purchase.orderoperatelist.OrderOperateListElements;
import com.acsm.test.testpages.purchase.workflow.orderaudit.OrderAuditElement;
import com.acsm.test.utils.SeleniumUtil;

public class OrderDispose {

	public static Logger logger = Logger.getLogger(SeleniumUtil.class.getName());
	public static WebDriver driver = SeleniumUtil.driver;
	
	/**
	 * 进入待处理
	 * @param seleniumUtil
	 * @return 处理按钮
	 */
	public static void orderDispose(SeleniumUtil seleniumUtil){
		seleniumUtil.pause(2000);
		seleniumUtil.click(OrderOperateListElements.OOL_BTN_DISPOSE);
		seleniumUtil.pause(2000);
	}
	
	/**
	 * 等待页面加载结束,检查页面元素
	 * @param seleniumUtil
	 * @param timeOut
	 */
	public static void waitOrderDispose(SeleniumUtil seleniumUtil, int timeOut) {
		seleniumUtil.waitForElementToLoad(timeOut, EnterPurchaseElements.OP_BTN_XDTIME);
		seleniumUtil.waitForElementToLoad(timeOut, EnterPurchaseElements.OP_BTN_PSTIME);
		seleniumUtil.waitForElementToLoad(timeOut, EnterPurchaseElements.OP_BTN_PAYMENTSTATUES);
		seleniumUtil.waitForElementToLoad(timeOut, EnterPurchaseElements.OP_BTN_ORDERSTATUES);
		seleniumUtil.waitForElementToLoad(timeOut, OrderDisposeElement.OD_BTN_VIEW);
		seleniumUtil.waitForElementToLoad(timeOut, OrderDisposeElement.OD_BTN_EDIT);
		seleniumUtil.waitForElementToLoad(timeOut, OrderDisposeElement.OD_BTN_DEL);
		seleniumUtil.waitForElementToLoad(timeOut, OrderDisposeElement.OD_BTN_EDITPAYMENTSTATE);
		seleniumUtil.waitForElementToLoad(timeOut, OrderDisposeElement.OD_INPUT_SEARCH);
		seleniumUtil.waitForElementToLoad(timeOut, OrderDisposeElement.OD_BTN_SEARCH);
		seleniumUtil.waitForElementToLoad(timeOut, OrderDisposeElement.OD_BTN_DISPOSERECORD);
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
	 * 点击处理
	 * @param seleniumUtil
	 */
	public static void dispose(SeleniumUtil seleniumUtil){
		seleniumUtil.pause(2000);
		seleniumUtil.click(OrderDisposeElement.OD_BTN_DISPOSE);
		seleniumUtil.waitForElementToLoad(8, OrderDisposeElement.OD_BTN_OPERATE);
		seleniumUtil.waitForElementToLoad(8, OrderDisposeElement.OD_BTN_NEXT);
	}
	
	/**
	 * 点击批量处理
	 * @param seleniumUtil
	 */
	public static void batchProcess(SeleniumUtil seleniumUtil){
		seleniumUtil.pause(2000);
		boolean flag = seleniumUtil.doesCheckboxSelected(OrderDisposeElement.OD_CHECKBOX_SELECTALL);
		if (flag == false) {
			WebElement element = driver.findElement(OrderDisposeElement.OD_CHECKBOX_SELECTALL);
			element.click();
		}
		seleniumUtil.pause(2000);
	}
	
	/**
	 * 点击下一步
	 * @param seleniumUtil
	 */
	public static void nextStep(SeleniumUtil seleniumUtil){
		seleniumUtil.pause(2000);
		seleniumUtil.click(OrderDisposeElement.OD_BTN_NEXT);
	}
	
	/**
	 * 点击完成
	 * @param seleniumUtil
	 */
	public static void complete(SeleniumUtil seleniumUtil){
		seleniumUtil.pause(2000);
		seleniumUtil.click(OrderDisposeElement.OD_BTN_DONE);
	}
	
	/**
	 * 
	 * @param seleniumUtil
	 * @return 是否跳转到订单流程页面
	 */
	public static boolean auditPass(SeleniumUtil seleniumUtil){
		seleniumUtil.click(OrderAuditElement.OA_BTN_AUDITPASS);
		return seleniumUtil.isDisplayed(driver.findElement(OrderOperateListElements.OOL_BTN_DISPOSE));
	}
}
