package com.acsm.test.testpages.purchase.workflow.orderproduct;

import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.acsm.test.utils.SeleniumUtil;

public class OrderProduct {

	public static Logger logger = Logger.getLogger(SeleniumUtil.class.getName());
	public static WebDriver driver = SeleniumUtil.driver;

	/**
	 * 是否进入订单页面
	 */
	public static boolean isOrderPagedisplayed(SeleniumUtil seleniumUtil) {
		seleniumUtil.pause(2000);
		boolean flag = seleniumUtil.isDisplayed(driver.findElement(OrderProductElement.OP_BTN_CUSTMERADD));
		return flag;
	}

	/**
	 * 选择客户
	 */
	public static boolean selectCustmer(SeleniumUtil seleniumUtil) {
		seleniumUtil.click(OrderProductElement.OP_BTN_CUSTMERADD);
		seleniumUtil.waitForElementToLoad(2000, OrderProductElement.OP_DIALOG_CUSTMER);
		int userIndex = userIndex(10, 1);
		System.out.println(userIndex);
		WebElement userList = driver.findElement(By.xpath("//div[@id='memberControlDiv']/div[" + userIndex + "]"));
		userList.click();
		//		seleniumUtil.click(OrderProductElement.OP_ELEMENT_CUSTMER);
		seleniumUtil.pause(2000);
		boolean custme = seleniumUtil.isDisplayed(driver.findElement(OrderProductElement.OP_ELEMENT_USERCONFIRM));
		return custme;
	}

	public static int userIndex(int max, int min) {
		Random random = new Random();
		int s = random.nextInt(max) % (max - min + 1) + min;
		return s;
	}

	/**
	 * 添加商品
	 */
	public static boolean productAdded(SeleniumUtil seleniumUtil) {
		boolean flag = false;
		seleniumUtil.click(OrderProductElement.OP_BTN_PRODUCTSLIST);
		boolean productDialog = seleniumUtil.isDisplayed(driver.findElement(OrderProductElement.OP_LIST_PRODUCTSLIST));
		if (productDialog == true) {
			List<WebElement> list = seleniumUtil.findElementsBy(OrderProductElement.OP_LIST_PRODUCTSLIST);
			if (list.size() != 0) {
				logger.info("商品展示正确,共" + list.size() + "件商品");
				list.get(0).click();

			} else {
				logger.info("没有商品，请及时添加");
				driver.close();
			}
		}
		
		seleniumUtil.click(OrderProductElement.OP_BTN_PRODUCTADD);
		seleniumUtil.pause(2000);
		flag = seleniumUtil.isDisplayed(driver.findElement(OrderProductElement.OP_ELEMENT_PRODUCT));
		seleniumUtil.pause(2000);
		WebElement product = driver.findElement(By.xpath("//tbody[@id='productMess']//td[2]/a"));
		String goods = product.getText();
		logger.info("商品: ========= " + goods + " ========= 被添加");
		return flag;
	}

	/**
	 * 点击下一步
	 */
	public static void next(SeleniumUtil seleniumUtil) {
		seleniumUtil.pause(2000);
		seleniumUtil.executeJS("arguments[0].scrollIntoView(true)",
				driver.findElement(OrderProductElement.OP_BTN_NEXT));
		seleniumUtil.pause(2000);
		seleniumUtil.click(OrderProductElement.OP_BTN_NEXT);
	}
	
	/**
	 * 处理alert
	 */
	public static void alertVerification(SeleniumUtil seleniumUtil) {
		seleniumUtil.pause(2000);
		Alert alert = seleniumUtil.switchToPromptedAlertAfterWait(2000);
		alert.accept();
	}

	/**
	 * 选择配送时间
	 */
	public static void time(SeleniumUtil seleniumUtil) {
		seleniumUtil.pause(2000);
		seleniumUtil.click(OrderProductElement.OP_BTN_DELIVERTIME);
		seleniumUtil.pause(2000);

		// 选择当前时间
		seleniumUtil.click(OrderProductElement.OP_BTN_CURDATE);

	}

	/**
	 * 填写备注
	 */
	public static void comments(String str, SeleniumUtil seleniumUtil) {
		System.out.println(str);
		seleniumUtil.click(OrderProductElement.OP_INPUT_COMMENTS);
		seleniumUtil.type(OrderProductElement.OP_INPUT_COMMENTS, str);
	}

	/**
	 * 提交订单
	 */
	public static void submitOrder(SeleniumUtil seleniumUtil) {
		seleniumUtil.pause(2000);
		seleniumUtil.executeJS("arguments[0].scrollIntoView(true)",
				driver.findElement(OrderProductElement.OP_BTN_CONFIRM));
		seleniumUtil.pause(2000);
		seleniumUtil.click(OrderProductElement.OP_BTN_CONFIRM);
		seleniumUtil.pause(2000);
	}

}
