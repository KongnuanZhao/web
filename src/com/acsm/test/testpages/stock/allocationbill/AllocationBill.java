package com.acsm.test.testpages.stock.allocationbill;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.acsm.test.utils.SeleniumUtil;

public class AllocationBill {

	public static Logger logger = Logger.getLogger(SeleniumUtil.class.getName());
	public static WebDriver driver = SeleniumUtil.driver;

	/**
	 * 进入调拨单
	 * 
	 * @param seleniumUtil
	 * @param timeOut
	 */
	public static void enterAllocationBill(SeleniumUtil seleniumUtil, int timeOut) {
		seleniumUtil.click(AllocationBillElement.AB_BTN_ALLOCATIONBILL);
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
		seleniumUtil.waitForElementToLoad(timeOut, AllocationBillElement.AB_BTN_GOODSTYPE);
		seleniumUtil.waitForElementToLoad(timeOut, AllocationBillElement.AB_BTN_OUTROOM);
		seleniumUtil.waitForElementToLoad(timeOut, AllocationBillElement.AB_BTN_INROOM);
		seleniumUtil.waitForElementToLoad(timeOut, AllocationBillElement.AB_BTN_OPERATOR);
		seleniumUtil.waitForElementToLoad(timeOut, AllocationBillElement.AB_INPUT_COMMENT);
		seleniumUtil.waitForElementToLoad(timeOut, AllocationBillElement.AB_BTN_ADDGOODS);
	}

	/**
	 * 选择物料类型
	 * 
	 * @param seleniumUtil
	 * @param timeOut
	 * @param index
	 *            （2：原料 3：商品 ）
	 */
	public static String selectGoodsType(SeleniumUtil seleniumUtil, int timeOut, int index) {
		seleniumUtil.click(AllocationBillElement.AB_BTN_GOODSTYPE);
		seleniumUtil.waitForElementToLoad(timeOut, AllocationBillElement.AB_LIST_GOODSTYPE);
		WebElement el = driver.findElement(By.xpath("//button[@data-id='goodsType']/following::div//li["+index+"]"));
		el.click();
		String str = seleniumUtil.getAttributeText(AllocationBillElement.AB_BTN_GOODSTYPE, "title");
		return str;
	}

	/**
	 * 选择调出仓库
	 * 
	 * @param seleniumUtil
	 * @param timeOut
	 * @param index
	 *            （2:原料库 3:商品库）
	 * @return 自定义、采购、生产和退货入库
	 */
	public static String selectOutstockType(SeleniumUtil seleniumUtil, int timeOut, int index) {
		seleniumUtil.click(AllocationBillElement.AB_BTN_OUTROOM);
		seleniumUtil.waitForElementToLoad(timeOut, AllocationBillElement.AB_LIST_OUTROOMTYPE);
		WebElement el = driver.findElement(By.xpath("//div[@id='outStoragePanel_body']//li["+index+"]"));
		el.click();
		String str = seleniumUtil.getText(AllocationBillElement.AB_BTN_OUTROOM);
		return str;
	}
	
	/**
	 * 选择调入仓库
	 * 
	 * @param seleniumUtil
	 * @param timeOut
	 * @param index
	 *            （2:原料库 3:商品库）
	 * @return 自定义、采购、生产和退货入库
	 */
	public static String selectInstockType(SeleniumUtil seleniumUtil, int timeOut, int index) {
		seleniumUtil.click(AllocationBillElement.AB_BTN_INROOM);
		seleniumUtil.waitForElementToLoad(timeOut, AllocationBillElement.AB_LIST_INROOM);
		WebElement el = driver.findElement(By.xpath("//div[@id='inStoragePanel_body']//li["+index+"]"));
		el.click();
		String str = seleniumUtil.getText(AllocationBillElement.AB_BTN_INROOM);
		return str;
	}
	
	/**
	 * 选择经办人
	 * 
	 * @param seleniumUtil
	 * @param timeOut
	 */
	public static String selectStockOperator(SeleniumUtil seleniumUtil, int timeOut) {
		seleniumUtil.click(AllocationBillElement.AB_BTN_OPERATOR);
		seleniumUtil.waitForElementToLoad(timeOut, AllocationBillElement.AB_LIST_OPERATOR);
		seleniumUtil.click(AllocationBillElement.AB_BTN_OPERATOR_1);
		String str = seleniumUtil.getAttributeText(AllocationBillElement.AB_BTN_OPERATOR, "title");
		return str;
	}
	
	/**
	 * 输入备注
	 * 
	 * @param seleniumUtil
	 * @param timeOut
	 */
	public static void typeMessage(SeleniumUtil seleniumUtil, int timeOut, String key) {
		seleniumUtil.clear(AllocationBillElement.AB_INPUT_COMMENT);
		seleniumUtil.click(AllocationBillElement.AB_INPUT_COMMENT);
		seleniumUtil.type(AllocationBillElement.AB_INPUT_COMMENT, key);
	}
	
	/**
	 * 添加物料
	 * 
	 * @param seleniumUtil
	 * @param timeOut
	 */
	public static void addGoods(SeleniumUtil seleniumUtil, int timeOut) {
		seleniumUtil.click(AllocationBillElement.AB_BTN_ADDGOODS);
		seleniumUtil.pause(2000);
		seleniumUtil.waitForElementToLoad(10, AllocationBillElement.AB_DIALOG_ADDGOODS);
		seleniumUtil.pause(2000);
		seleniumUtil.click(AllocationBillElement.AB_CHECKBOX_ADDGOODS);
		seleniumUtil.pause(2000);
		seleniumUtil.click(AllocationBillElement.AB_BTN_CONFIRM);
		seleniumUtil.pause(2000);
		logger.info("物料编号一致，为相同物料");
		seleniumUtil.click(AllocationBillElement.AB_BTN_SUBMIT);
		seleniumUtil.pause(2000);
	}
}
