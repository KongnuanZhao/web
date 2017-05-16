package com.acsm.test.testcases.purchase;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.acsm.test.base.BaseParpare;
import com.acsm.test.testpages.purchase.Enter.EnterPurchase;
import com.acsm.test.testpages.purchase.Enter.EnterPurchaseElements;
import com.acsm.test.testpages.purchase.workflow.orderproduct.OrderProduct;
import com.acsm.test.utils.SeleniumUtil;

public class Basic_Test extends BaseParpare {

	public static Logger logger = Logger.getLogger(SeleniumUtil.class.getName());

	/**
	 * @description 验证进入订单模块
	 * @author GuoKuo
	 */
	@Test(groups = { "enterPurchase" })
	public void enterPurchaseWorkflow() {
		System.out.println(timeOut);
		EnterPurchase.enterPurchasePage(seleniumUtil);

		// 订单页面打开
		boolean flag = seleniumUtil.isDisplayed(SeleniumUtil.driver.findElement(EnterPurchaseElements.EP_LIST_ORDER));
		if (flag) {
			logger.info("订单打开成功");
		}
	}

	/**
	 * @description 添加订单
	 * @author GuoKuo
	 */
	@Test(groups = { "enterPurchase" }, dependsOnMethods = { "enterPurchaseWorkflow" })
	public void addOrder() {
		seleniumUtil.pause(1000);
//		EnterPurchase.waitPurchasePageLoad(seleniumUtil, timeOut);
//		EnterPurchase.orderAll(seleniumUtil);
		EnterPurchase.orderAdded(seleniumUtil);
	}

	/**
	 * @description 下单管理
	 * @author GuoKuo
	 */
	@Test(groups = { "enterPurchase" }, dependsOnMethods = { "addOrder" })
	public void orderProductPage() {

		// 下单页面打开
		boolean flag = OrderProduct.isOrderPagedisplayed(seleniumUtil);
		seleniumUtil.pause(2000);
		if (flag) {
			logger.info("订单打开成功");
		}
	}
}
