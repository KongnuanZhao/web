package com.acsm.test.testcases.purchase.fullworkflow;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.acsm.test.base.BaseParpare;
import com.acsm.test.testpages.purchase.workflow.orderaudit.OrderAudit;
import com.acsm.test.testpages.purchase.workflow.orderdelivery.OrderDeliverey;
import com.acsm.test.testpages.purchase.workflow.orderdispose.OrderDispose;
import com.acsm.test.testpages.purchase.workflow.orderfinish.OrderFinish;
import com.acsm.test.testpages.purchase.workflow.orderproduct.OrderProduct;
import com.acsm.test.testpages.purchase.workflow.ordertally.OrderTally;
import com.acsm.test.testpages.purchase.workflow.ordertransport.OrderTransport;
import com.acsm.test.utils.RandomUtils;
import com.acsm.test.utils.SeleniumUtil;

import junit.framework.Assert;

public class FullWorkFlow_Test extends BaseParpare {

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
		logger.info("提交成功，订单已生成");
	}

	/**
	 * @description 跳转到订单待审核
	 * @author GuoKuo
	 */
	@Test(groups = { "orderAudit" }, dependsOnMethods = { "orderSubmit" })
	public void orderAudit() {

		OrderAudit.orderAudit(seleniumUtil);
		logger.info("跳转到待审核页面");
		OrderAudit.waitOrderAuditListPageLoad(seleniumUtil, 5);
		logger.info("待审核页面元素加载完毕");
	}

	/**
	 * @description 点击审核
	 * @author GuoKuo
	 */
	@Test(groups = { "orderAudit" }, dependsOnMethods = { "searchInAudit" })
	public void audit() {

		// 提交订单
		OrderAudit.audit(seleniumUtil);
		logger.info("点击审核");
	}

	/**
	 * @description 搜索功能验证
	 * @author GuoKuo
	 */
	@Test(groups = { "orderAudit" }, dependsOnMethods = { "orderAudit" })
	public void searchInAudit() {

		OrderAudit.searchFunction(seleniumUtil);
		logger.info("搜索结束");
	}

	/**
	 * @description 点击审核通过
	 * @author GuoKuo
	 */
	@Test(groups = { "orderAudit" }, dependsOnMethods = { "searchInAudit" })
	public void auditPass() {

		// 提交订单
		OrderAudit.auditPass(seleniumUtil);
		logger.info("审核通过");
	}

	/**
	 * @description 跳转到订单待处理
	 * @author GuoKuo
	 */
	@Test(groups = { "orderDispose" }, dependsOnMethods = { "auditPass" })
	public void orderDispose() {

		// 提交订单
		OrderDispose.orderDispose(seleniumUtil);
		logger.info("跳转到待处理页面");
		OrderDispose.waitOrderDispose(seleniumUtil, 8);
		logger.info("页面元素加载完毕");
		OrderAudit.searchFunction(seleniumUtil);
		logger.info("搜索结束");
	}

	/**
	 * @description 点击处理
	 * @author GuoKuo
	 */
	@Test(groups = { "orderDispose" }, dependsOnMethods = { "orderDispose" })
	public void dispose() {
//		OrderDispose.batchProcess(seleniumUtil);
//		logger.info("勾选全选完毕");
		OrderDispose.dispose(seleniumUtil);
		logger.info("点击处理");
	}

	/**
	 * @description 点击下一步
	 * @author GuoKuo
	 */
	@Test(groups = { "orderDispose" }, dependsOnMethods = { "dispose" })
	public void nextStep() {
		OrderDispose.nextStep(seleniumUtil);
		logger.info("点击下一步");
	}

	/**
	 * @description 点击完成
	 * @author GuoKuo
	 */
	@Test(groups = { "orderDispose" }, dependsOnMethods = { "nextStep" })
	public void complete() {
		OrderDispose.complete(seleniumUtil);
		logger.info("点击下一步");
	}

	/**
	 * @description 点击理货
	 * @author GuoKuo
	 */
	@Test(groups = { "orderTally" }, dependsOnMethods = { "complete" })
	public void orderTally() {
		seleniumUtil.pause(2000);
		OrderTally.orderTally(seleniumUtil);
		logger.info("进入理货");
	}

	/**
	 * @description 点击理货
	 * @author GuoKuo
	 */
	@Test(groups = { "orderTally" }, dependsOnMethods = { "orderTally" })
	public void orderTallyPage() {
		seleniumUtil.pause(2000);
		OrderTally.waitOrderTallyList(seleniumUtil, 8);
		seleniumUtil.pause(2000);
		OrderTally.orderTallyPage(seleniumUtil);
		logger.info("点击理货");
	}

	/**
	 * @description 输入来源数量
	 * @author GuoKuo
	 */
	@Test(groups = { "orderTally" }, dependsOnMethods = { "orderTallyPage" })
	public void tallyCount() {

		// 提交订单
		OrderTally.tallyCount(seleniumUtil, ("" + 1));
		seleniumUtil.pause(2000);
		logger.info("跳转到理货页面,输入理货数量完毕");
	}

	/**
	 * @description 输入有机追溯码
	 * @author GuoKuo
	 */
	@Test(groups = { "orderTally" }, dependsOnMethods = { "tallyCount" })
	public void tallyCode() {

		// 提交订单
		OrderTally.tallyCount(seleniumUtil, ("0001000100000003"));
		seleniumUtil.pause(2000);
		logger.info("跳转到理货页面,输入理货数量完毕");
	}

	/**
	 * @description 点击完成理货
	 * @author GuoKuo
	 */
	@Test(groups = { "orderTally" }, dependsOnMethods = { "tallyCode" })
	public void tallyPass() {
		seleniumUtil.pause(2000);

		OrderTally.tallyPass(seleniumUtil);
		logger.info("理货通过");
	}

	/**
	 * @description 跳转待发货
	 * @author GuoKuo
	 */
	@Test(groups = { "orderDeliverey" }, dependsOnMethods = { "tallyPass" })
	public void orderDeliverey() {

		// 提交订单
		OrderDeliverey.orderDelivery(seleniumUtil);
		seleniumUtil.pause(2000);

		logger.info("跳转到待发货页面");
	}

	/**
	 * @description 点击发货
	 * @author GuoKuo
	 */
	@Test(groups = { "orderDeliverey" }, dependsOnMethods = { "orderDeliverey" })
	public void deliverey() {

		OrderDeliverey.waitOrderDelivery(seleniumUtil, 8);
		logger.info("待发货页面加载完毕");
		seleniumUtil.pause(2000);
		OrderDeliverey.orderDeliveryPage(seleniumUtil);
		seleniumUtil.pause(2000);
		logger.info("确认发货对话框弹出");
	}

	/**
	 * @description 确认发货
	 * @author GuoKuo
	 */
	@Test(groups = { "orderDeliverey" }, dependsOnMethods = { "deliverey" })
	public void orderDeliveryConfirm() {
		seleniumUtil.pause(2000);

		OrderDeliverey.orderDeliveryConfirm(seleniumUtil);

	}

	/**
	 * @description 进入订单配送中
	 * @author GuoKuo
	 */
	@Test(groups = { "orderTransport" }, dependsOnMethods = { "orderDeliveryConfirm" })
	public void orderTransport() {

		// 提交订单
		OrderTransport.orderTransport(seleniumUtil);
		seleniumUtil.pause(2000);
		logger.info("进入订单配送");
	}

	/**
	 * @description 进入订单配送中
	 * @author GuoKuo
	 */
	@Test(groups = { "orderTransport" }, dependsOnMethods = { "orderTransport" })
	public void orderTransportPage() {

		WebElement element = OrderTransport.orderTransportPage(seleniumUtil);
		if (element.isDisplayed() == true) {
			logger.info("点击订单签收，弹出确认签收对话框");
		}
	}

	/**
	 * @description 订单签收
	 * @author GuoKuo
	 */
	@Test(groups = { "orderTransport" }, dependsOnMethods = { "orderTransportPage" })
	public void confirm() {

		OrderTransport.confirm(seleniumUtil);
		logger.info("点击提交，订单生成成功");
	}

	/**
	 * @description 验证订单已生成
	 * @author GuoKuo
	 */
	@Test(groups = { "orderFinish" }, dependsOnMethods = { "confirm" })
	public void orderFinishPage() {
		OrderFinish.orderFinish(seleniumUtil);
	}

	/**
	 * @description 验证完成订单数量
	 * @author GuoKuo
	 */
	@Test(groups = { "orderFinish" }, alwaysRun = true, dependsOnMethods = { "orderFinishPage" })
	public void orderCount() {
		seleniumUtil.pause(2000);
		int count = OrderFinish.orderCount(seleniumUtil);
		logger.info("=================当前订单数量为：" + count + "======================");
		seleniumUtil.pause(1000);

		// if (count<100000) {
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
		// Basic_Test bt = new Basic_Test();
		// EnterPurchase.enterPurchasePage(seleniumUtil);
		// bt.addOrder();
		// custmerSelected();
		// productSelected();
		// next();
		// time();
		// orderSubmit();
		// orderCount();
		// }
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
