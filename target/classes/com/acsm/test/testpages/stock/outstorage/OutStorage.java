package com.acsm.test.testpages.stock.outstorage;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.acsm.test.utils.SeleniumUtil;

public class OutStorage {

	public static Logger logger = Logger.getLogger(SeleniumUtil.class.getName());
	public static WebDriver driver = SeleniumUtil.driver;

	/**
	 * 进入出库单
	 * 
	 * @param seleniumUtil
	 * @param timeOut
	 */
	public static void enterOutstock(SeleniumUtil seleniumUtil, int timeOut) {
//		seleniumUtil.click(InstockAddElement.IA_BTN_LEFTBTN);
		seleniumUtil.pause(2000);
		seleniumUtil.click(OutStorageElement.OS_BTN_OUTSTORAGE);
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
		seleniumUtil.waitForElementToLoad(timeOut, OutStorageElement.OS_BTN_GOODSTYPE);
		seleniumUtil.waitForElementToLoad(timeOut, OutStorageElement.OS_BTN_OUTSTOCKTYPE);
		seleniumUtil.waitForElementToLoad(timeOut, OutStorageElement.OS_BTN_ROOM);
		seleniumUtil.waitForElementToLoad(timeOut, OutStorageElement.OS_BTN_OPERATOR);
		seleniumUtil.waitForElementToLoad(timeOut, OutStorageElement.OS_BTN_ADDGOODS);
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
		seleniumUtil.click(OutStorageElement.OS_BTN_GOODSTYPE);
		seleniumUtil.waitForElementToLoad(timeOut, OutStorageElement.OS_LIST_GOODSTYPE);
		WebElement el = driver.findElement(By.xpath("//ul[@role='menu']/li[" + index + "]"));
		el.click();
		String str = seleniumUtil.getAttributeText(OutStorageElement.OS_BTN_GOODSTYPE, "title");
		return str;
	}

	/**
	 * 添加入库类型
	 * 
	 * @param seleniumUtil
	 * @param timeOut
	 * @param index
	 *            （21：销售出库 22：生产出库 23:报损出库 25:其他出库）
	 * @return 自定义、采购、生产和退货入库
	 */
	public static String selectOutstockType(SeleniumUtil seleniumUtil, int timeOut, int index) {
		seleniumUtil.click(OutStorageElement.OS_BTN_OUTSTOCKTYPE);
		seleniumUtil.waitForElementToLoad(timeOut, OutStorageElement.OS_LIST_OUTSTOCKTYPE);
		WebElement el = driver.findElement(By.xpath("//li[@myid=" + index + "]"));
		el.click();
		String str = seleniumUtil.getText(OutStorageElement.OS_BTN_OUTSTOCKTYPE);
		return str;
	}
	
	/**
	 * 选择仓库
	 * 
	 * @param seleniumUtil
	 * @param timeOut
	 */
	public static String selectStockRoom(SeleniumUtil seleniumUtil, int timeOut) {
		seleniumUtil.click(OutStorageElement.OS_BTN_ROOM);
		seleniumUtil.waitForElementToLoad(timeOut, OutStorageElement.OS_LIST_ROOM);
		seleniumUtil.click(OutStorageElement.OS_BTN_ROOM_1);
		String str = seleniumUtil.getAttributeText(OutStorageElement.OS_BTN_ROOM, "title");
		return str;
	}
	
	/**
	 * 选择经办人
	 * 
	 * @param seleniumUtil
	 * @param timeOut
	 */
	public static String selectStockOperator(SeleniumUtil seleniumUtil, int timeOut) {
		seleniumUtil.click(OutStorageElement.OS_BTN_OPERATOR);
		seleniumUtil.waitForElementToLoad(timeOut, OutStorageElement.OS_LIST_OPERATOR);
		seleniumUtil.click(OutStorageElement.OS_BTN_OPERATOR_1);
		String str = seleniumUtil.getAttributeText(OutStorageElement.OS_BTN_OPERATOR, "title");
		return str;
	}
	
	/**
	 * 输入备注
	 * 
	 * @param seleniumUtil
	 * @param timeOut
	 */
	public static void typeMessage(SeleniumUtil seleniumUtil, int timeOut, String key) {
		seleniumUtil.clear(OutStorageElement.OS_INPUT_COMMENT);
		seleniumUtil.click(OutStorageElement.OS_INPUT_COMMENT);
		seleniumUtil.type(OutStorageElement.OS_INPUT_COMMENT, key);
	}
	
	/**
	 * 添加物料
	 * 
	 * @param seleniumUtil
	 * @param timeOut
	 */
	public static void addGoods(SeleniumUtil seleniumUtil, int timeOut) {
		seleniumUtil.click(OutStorageElement.OS_BTN_ADDGOODS);
		seleniumUtil.pause(2000);
		seleniumUtil.waitForElementToLoad(timeOut, OutStorageElement.OS_DIALOG_ADDGOODS);
		seleniumUtil.pause(2000);
		seleniumUtil.click(OutStorageElement.OS_CHECKBOX_ADDGOODS);
		seleniumUtil.pause(2000);
		seleniumUtil.click(OutStorageElement.OS_BTN_CONFIRM);
		seleniumUtil.pause(2000);
		logger.info("物料编号一致，为相同物料");
		seleniumUtil.click(OutStorageElement.OS_BTN_SUBMIT);
		seleniumUtil.pause(2000);
	}
}
