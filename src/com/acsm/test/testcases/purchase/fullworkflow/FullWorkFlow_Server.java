package com.acsm.test.testcases.purchase.fullworkflow;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.acsm.test.base.BaseParpare;
import com.acsm.test.testcases.purchase.Basic_Test;
import com.acsm.test.testpages.purchase.Enter.EnterPurchase;
import com.acsm.test.testpages.purchase.workflow.orderaudit.OrderAudit;
import com.acsm.test.testpages.purchase.workflow.orderfinish.OrderFinish;
import com.acsm.test.testpages.purchase.workflow.orderproduct.OrderProduct;
import com.acsm.test.utils.RandomUtils;
import com.acsm.test.utils.SeleniumUtil;

import junit.framework.Assert;

public class FullWorkFlow_Server extends BaseParpare {

	public static Logger logger = Logger.getLogger(SeleniumUtil.class.getName());

	/**
	 * @description 选择客户
	 * @author GuoKuo
	 */
	@Test(groups = { "placeOrder" })
	public void custmerSelected() {

		// 下单页面打开
		boolean flag = OrderProduct.selectCustmer(seleniumUtil);
		if (flag) {
			logger.info("客户添加成功");
		}
	}

	/**
	 * @description 选择商品
	 * @author GuoKuo
	 */
	@Test(groups = { "placeOrder" }, alwaysRun = true, dependsOnMethods = { "custmerSelected" })
	public void productSelected() {

		// 下单页面打开
		boolean flag = OrderProduct.productAdded(seleniumUtil);
		if (flag) {
			logger.info("商品添加成功");
		}
	}

	/**
	 * @description 点击下一步
	 * @author GuoKuo
	 */
	@Test(groups = { "placeOrder" }, alwaysRun = true, dependsOnMethods = { "productSelected" })
	public void clickNext() {

		// 点击下一步
		OrderProduct.next(seleniumUtil);
		logger.info("点击下一步点击完毕");
		//处理alert
//		OrderProduct.alertVerification(seleniumUtil);
//		logger.info("alert处理完毕");
	}

	/**
	 * @description 选择时间
	 * @author GuoKuo
	 */
	@Test(groups = { "placeOrder" }, alwaysRun = true, dependsOnMethods = { "clickNext" })
	public void selectTime() {

		// 选择时间
		OrderProduct.time(seleniumUtil);

		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(date);

		logger.info("时间选择成功，时间为：" + time);
	}

	/**
	 * @description 填写备注
	 * @author GuoKuo
	 */
	@Test(groups = { "placeOrder" }, alwaysRun = true, dependsOnMethods = { "selectTime" })
	public void addComments() {

		// 填写备注
		String key = RandomUtils.generateString(20);
		OrderProduct.comments(key, seleniumUtil);
		logger.info("备注填写完毕");
	}

	/**
	 * @description 提交订单
	 * @author GuoKuo
	 */
	@Test(groups = { "placeOrder" }, alwaysRun = true, dependsOnMethods = { "addComments" })
	public void orderSubmit() {

		// 提交订单
		OrderProduct.submitOrder(seleniumUtil);
//		OrderProduct.alertVerification(seleniumUtil);
		logger.info("提交成功，订单已生成");
	}


	/**
	 * @description 验证完成订单数量
	 * @author GuoKuo
	 */
	@Test(groups = { "orderFinish" }, alwaysRun = true, dependsOnMethods = { "orderSubmit" })
	public void orderCount() {
		seleniumUtil.pause(2000);
		int count = OrderFinish.orderCount(seleniumUtil);
		logger.info("=================当前订单数量为：" + count + "======================");
		seleniumUtil.pause(1000);

		 if (count<100000) {
		// EnterStock.enterStock(seleniumUtil);
		// InstockAdd.enterInstock(seleniumUtil, timeOut);
		// InstockAdd.selectGoodsType(seleniumUtil, timeOut, 2);
		// InstockAdd.selectInstockType(seleniumUtil, timeOut, 48);
		// InstockAdd.selectStockRoom(seleniumUtil, timeOut);
		// InstockAdd.addGoods(seleniumUtil, timeOut);
		// OutStorage.enterOutstock(seleniumUtil, timeOut);
		// OutStorage.selectGoodsType(seleniumUtil, timeOut, 2);
		// OutStorage.selectOutstockType(seleniumUtil, timeOut, 53);
		// OutStorage.selectStockRoom(seleniumUtil, timeOut);
		// OutStorage.selectStockOperator(seleniumUtil, timeOut);
		// OutStorage.addGoods(seleniumUtil, timeOut);
		 Basic_Test bt = new Basic_Test();
//		 EnterPurchase.enterPurchasePage(seleniumUtil);
		 bt.addOrder();
		 custmerSelected();
		 productSelected();
		 clickNext();
		 selectTime();
		 orderSubmit();
		 orderCount();
		 }
	}

	/**
	 * @description 验证订单已生成
	 * @author GuoKuo
	 */
	@Test(groups = { "orderFinish" }, enabled = false, dependsOnMethods = { "orderCount" })
	public void orderSearch() {
		boolean flag = OrderFinish.orderSearch(seleniumUtil, OrderAudit.orderNumber);
		Assert.assertEquals(true, flag);
	}
}
