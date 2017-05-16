package com.acsm.test.testpages.stock.instockadd;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.acsm.test.utils.SeleniumUtil;

public class InstockAdd {

	public static Logger logger = Logger.getLogger(SeleniumUtil.class.getName());
	public static WebDriver driver = SeleniumUtil.driver;

	/**
	 * 进入入库单
	 * 
	 * @param seleniumUtil
	 * @param timeOut
	 */
	public static void enterInstock(SeleniumUtil seleniumUtil, int timeOut) {
//		seleniumUtil.click(InstockAddElement.IA_BTN_LEFTBTN);
		seleniumUtil.pause(2000);
		seleniumUtil.click(InstockAddElement.IA_BTN_INSTOCKADD);
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
		seleniumUtil.waitForElementToLoad(timeOut, InstockAddElement.IA_BTN_INSTOCKADD);
		seleniumUtil.waitForElementToLoad(timeOut, InstockAddElement.IA_BTN_GOODSTYPE);
		seleniumUtil.waitForElementToLoad(timeOut, InstockAddElement.IA_BTN_INSTOCKTYPE);
		seleniumUtil.waitForElementToLoad(timeOut, InstockAddElement.IA_BTN_ROOM);
		seleniumUtil.waitForElementToLoad(timeOut, InstockAddElement.IA_BTN_OPERATOR);
		seleniumUtil.waitForElementToLoad(timeOut, InstockAddElement.IA_BTN_TIME);
		seleniumUtil.waitForElementToLoad(timeOut, InstockAddElement.IA_INPUT_COMMENT);
		seleniumUtil.waitForElementToLoad(timeOut, InstockAddElement.IA_BTN_ADDGOODS);
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
		seleniumUtil.click(InstockAddElement.IA_BTN_GOODSTYPE);
		seleniumUtil.waitForElementToLoad(timeOut, InstockAddElement.IA_LIST_GOODSTYPE);
		WebElement el = driver.findElement(By.xpath("//ul[@role='menu']/li[" + index + "]"));
		el.click();
		String str = seleniumUtil.getAttributeText(InstockAddElement.IA_BTN_GOODSTYPE, "title");
		return str;
	}

	/**
	 * 添加入库类型
	 * 
	 * @param seleniumUtil
	 * @param timeOut
	 * @param index
	 *            （69：自定义 11：采购 12：生产 13：退货 15：其他）
	 * @return 自定义、采购、生产和退货入库
	 */
	public static String selectInstockType(SeleniumUtil seleniumUtil, int timeOut, int index) {
		seleniumUtil.click(InstockAddElement.IA_BTN_INSTOCKTYPE);
		seleniumUtil.waitForElementToLoad(timeOut, InstockAddElement.IA_LIST_INSTOCKTYPE);
		WebElement el = driver.findElement(By.xpath("//li[@myid=" + index + "]"));
		el.click();
		if (index == 12) {
			WebElement provider = driver.findElement(InstockAddElement.IA_BTN_PROVIDER);
			seleniumUtil.isDisplayed(provider);
		} else if (index == 15) {
			WebElement provider = driver.findElement(InstockAddElement.IA_BTN_OUTCODE);
			seleniumUtil.isDisplayed(provider);
		}
		String str = seleniumUtil.getText(InstockAddElement.IA_TEXT_INSTOCKTYPE);
		return str;
	}

	/**
	 * 选择仓库
	 * 
	 * @param seleniumUtil
	 * @param timeOut
	 */
	public static String selectStockRoom(SeleniumUtil seleniumUtil, int timeOut) {
		seleniumUtil.click(InstockAddElement.IA_BTN_ROOM);
		seleniumUtil.waitForElementToLoad(timeOut, InstockAddElement.IA_LIST_ROOM);
		seleniumUtil.click(InstockAddElement.IA_BTN_ROOM_1);
		String str = seleniumUtil.getAttributeText(InstockAddElement.IA_BTN_ROOM, "title");
		return str;
	}

	/**
	 * 选择经办人
	 * 
	 * @param seleniumUtil
	 * @param timeOut
	 */
	public static String selectStockOperator(SeleniumUtil seleniumUtil, int timeOut) {
		seleniumUtil.click(InstockAddElement.IA_BTN_OPERATOR);
		seleniumUtil.waitForElementToLoad(timeOut, InstockAddElement.IA_LIST_OPERATOR);
		seleniumUtil.click(InstockAddElement.IA_BTN_OPERATOR_1);
		String str = seleniumUtil.getAttributeText(InstockAddElement.IA_BTN_OPERATOR, "title");
		return str;
	}

	/**
	 * 选择当前时间
	 * 
	 * @param seleniumUtil
	 * @param timeOut
	 */
	public static void inRoomTime(SeleniumUtil seleniumUtil, int timeOut) {
		seleniumUtil.click(InstockAddElement.IA_BTN_TIME);
		seleniumUtil.pause(2000);
		seleniumUtil.click(InstockAddElement.IA_BTN_CURDATE);
	}

	/**
	 * 输入备注
	 * 
	 * @param seleniumUtil
	 * @param timeOut
	 */
	public static void typeMessage(SeleniumUtil seleniumUtil, int timeOut, String key) {
		seleniumUtil.clear(InstockAddElement.IA_INPUT_COMMENT);
		seleniumUtil.click(InstockAddElement.IA_INPUT_COMMENT);
		seleniumUtil.type(InstockAddElement.IA_INPUT_COMMENT, key);
	}

	/**
	 * 添加物料
	 * 
	 * @param seleniumUtil
	 * @param timeOut
	 */
	public static void addGoods(SeleniumUtil seleniumUtil, int timeOut) {
		seleniumUtil.click(InstockAddElement.IA_BTN_ADDGOODS);
		seleniumUtil.pause(2000);
		seleniumUtil.waitForElementToLoad(timeOut, InstockAddElement.IA_DIALOG_ADDGOODS);
		seleniumUtil.click(InstockAddElement.IA_CHECKBOX_ADDGOODS);
		seleniumUtil.pause(2000);
		seleniumUtil.click(InstockAddElement.IA_BTN_CONFIRM);
		seleniumUtil.pause(2000);
		logger.info("物料编号一致，为相同物料");
//		seleniumUtil.clear(InstockAddElement.IA_TEXT_INSTOCKNUM);
//		seleniumUtil.click(InstockAddElement.IA_TEXT_INSTOCKNUM);
//		seleniumUtil.type(InstockAddElement.IA_TEXT_INSTOCKNUM, "1");
//		seleniumUtil.clear(InstockAddElement.IA_TEXT_INSTOCKWEIGHT);
//		seleniumUtil.click(InstockAddElement.IA_TEXT_INSTOCKWEIGHT);
//		seleniumUtil.type(InstockAddElement.IA_TEXT_INSTOCKWEIGHT, "1");
//		seleniumUtil.clear(InstockAddElement.IA_TEXT_RELEASEDATE);
//		seleniumUtil.click(InstockAddElement.IA_TEXT_RELEASEDATE);
//		seleniumUtil.type(InstockAddElement.IA_TEXT_RELEASEDATE, "1");
//		seleniumUtil.clear(InstockAddElement.IA_TEXT_GOODSPRICE);
//		seleniumUtil.click(InstockAddElement.IA_TEXT_GOODSPRICE);
//		seleniumUtil.type(InstockAddElement.IA_TEXT_GOODSPRICE, "1");
//		seleniumUtil.clear(InstockAddElement.IA_TEXT_TOTALPRICE);
//		seleniumUtil.click(InstockAddElement.IA_TEXT_TOTALPRICE);
//		seleniumUtil.type(InstockAddElement.IA_TEXT_TOTALPRICE, "1");
		seleniumUtil.pause(1000);
		seleniumUtil.click(InstockAddElement.IA_BTN_SUBMIT);
		seleniumUtil.pause(1000);
	}
}
