package com.acsm.test.testpages.stock.inventorybill;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.acsm.test.utils.SeleniumUtil;

public class InventoryBill {

	public static Logger logger = Logger.getLogger(SeleniumUtil.class.getName());
	public static WebDriver driver = SeleniumUtil.driver;

	/**
	 * 进入盘点单
	 * 
	 * @param seleniumUtil
	 * @param timeOut
	 */
	public static void enterInventoryBill(SeleniumUtil seleniumUtil, int timeOut) {
//		seleniumUtil.click(InventoryBillElement.IA_BTN_LEFTBTN);
//		seleniumUtil.pause(2000);
		seleniumUtil.click(InventoryBillElement.IB_BTN_INVENTRYBILL);
		seleniumUtil.pause(2000);
	}

	/**
	 * 等待页面元素加载
	 * 
	 * @param seleniumUtil
	 * @param timeOut
	 *            等待超时时间
	 */
	public static void waitElementsLoad(SeleniumUtil seleniumUtil, int timeOut) {
		seleniumUtil.waitForElementToLoad(timeOut, InventoryBillElement.IB_BTN_GOODSTYPE);
		seleniumUtil.waitForElementToLoad(timeOut, InventoryBillElement.IB_BTN_ROOM);
		seleniumUtil.waitForElementToLoad(timeOut, InventoryBillElement.IB_BTN_OPERATOR);
		seleniumUtil.waitForElementToLoad(timeOut, InventoryBillElement.IB_BTN_ADDGOODS);
	}

	/**
	 * 输入物料类型
	 * 
	 * @param seleniumUtil
	 * @param timeOut
	 * @param index
	 *            （2：原料 3：商品 4：辅料）
	 */
	public static String selectGoodsType(SeleniumUtil seleniumUtil, int timeOut, int index) {
		seleniumUtil.click(InventoryBillElement.IB_BTN_GOODSTYPE);
		seleniumUtil.waitForElementToLoad(timeOut, InventoryBillElement.IB_LIST_GOODSTYPE);
		WebElement el = driver.findElement(By.xpath("//button[@data-id='goodsType']/following::li[" + index + "]"));
		el.click();
		String str = seleniumUtil.getAttributeText(InventoryBillElement.IB_BTN_GOODSTYPE, "title");
		return str;
	}

	/**
	 * 选择仓库
	 * 
	 * @param seleniumUtil
	 * @param timeOut
	 */
	public static String selectStockRoom(SeleniumUtil seleniumUtil, int timeOut) {
		seleniumUtil.click(InventoryBillElement.IB_BTN_ROOM);
		seleniumUtil.waitForElementToLoad(timeOut, InventoryBillElement.IB_LIST_ROOM);
		seleniumUtil.click(InventoryBillElement.IB_BTN_ROOM_1);
		String str = seleniumUtil.getAttributeText(InventoryBillElement.IB_BTN_ROOM, "title");
		return str;
	}
	
	/**
	 * 选择经办人
	 * 
	 * @param seleniumUtil
	 * @param timeOut
	 */
	public static String selectStockOperator(SeleniumUtil seleniumUtil, int timeOut) {
		seleniumUtil.click(InventoryBillElement.IB_BTN_OPERATOR);
		seleniumUtil.waitForElementToLoad(timeOut, InventoryBillElement.IB_LIST_OPERATOR);
		seleniumUtil.click(InventoryBillElement.IB_BTN_OPERATOR_1);
		String str = seleniumUtil.getAttributeText(InventoryBillElement.IB_BTN_OPERATOR, "title");
		return str;
	}
	
	
	/**
	 * 添加物料
	 * 
	 * @param seleniumUtil
	 * @param timeOut
	 */
	public static void addGoods(SeleniumUtil seleniumUtil, int timeOut) {
		seleniumUtil.click(InventoryBillElement.IB_BTN_ADDGOODS);
		seleniumUtil.pause(4000);
		seleniumUtil.click(InventoryBillElement.IB_CHECKBOX_ADDGOODS);
		seleniumUtil.pause(2000);
		seleniumUtil.click(InventoryBillElement.IB_BTN_CONFIRM);
		seleniumUtil.pause(2000);
		logger.info("物料编号一致，为相同物料");
		seleniumUtil.click(InventoryBillElement.IB_BTN_SUBMIT);
		seleniumUtil.pause(2000);
	}
}
