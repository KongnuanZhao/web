package com.acsm.test.testpages.digitalcard.digitalcardedit;

import java.awt.event.KeyEvent;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.acsm.test.utils.SeleniumUtil;

public class DigitalCardEdit {

	public static Logger logger = Logger.getLogger(DigitalCardEdit.class);

	/**
	 * 等待页面加载
	 * 
	 * @param seleniumUtil
	 * @param timeout
	 */
	public static void waitEditPageLoaded(SeleniumUtil seleniumUtil, int timeOut) {
		seleniumUtil.waitForElementToLoad(timeOut, DigitalCardEditElement.DCE_INPUT_SEARCH);
		seleniumUtil.waitForElementToLoad(timeOut, DigitalCardEditElement.DCE_BTN_CREATFARMSHOW);
		seleniumUtil.waitForElementToLoad(timeOut, DigitalCardEditElement.DCE_INPUT_FARMSHOWTITLE);
		seleniumUtil.waitForElementToLoad(timeOut, DigitalCardEditElement.DCE_BTN_COPYSHAREADDRESS);
		seleniumUtil.waitForElementToLoad(timeOut, DigitalCardEditElement.DCE_BTN_MAPSETTINGS);
		seleniumUtil.waitForElementToLoad(timeOut, DigitalCardEditElement.DCE_BTN_MORESETTINGS);
		seleniumUtil.waitForElementToLoad(timeOut, DigitalCardEditElement.DCE_BTN_BASEINFO);
		seleniumUtil.waitForElementToLoad(timeOut, DigitalCardEditElement.DCE_BTN_PRODUCTINTRODUCE);
		seleniumUtil.waitForElementToLoad(timeOut, DigitalCardEditElement.DCE_BTN_SHARING);
	}

	/**
	 * 搜索功能验证
	 * 
	 * @param seleniumUtil
	 * @param input
	 * @param timeOut
	 * @return
	 */
	public static int searchFunctionVerification(SeleniumUtil seleniumUtil, String input, int timeOut) {
		seleniumUtil.pause(2000);
		seleniumUtil.click(DigitalCardEditElement.DCE_INPUT_SEARCH);
		seleniumUtil.clear(DigitalCardEditElement.DCE_INPUT_SEARCH);
		seleniumUtil.type(DigitalCardEditElement.DCE_INPUT_SEARCH, input);
		seleniumUtil.pause(2000);
		seleniumUtil.keyBoardInput(KeyEvent.VK_ENTER);
		List<WebElement> list = seleniumUtil.findElementsBy(DigitalCardEditElement.DCE_LIST_SEARCHRESULT);
		return (list.size());
	}

	/**
	 * 数字名片标题
	 * 
	 * @param seleniumUtil
	 * @param input
	 */
	public static String digitalCardTitle(SeleniumUtil seleniumUtil, String input) {
		seleniumUtil.click(DigitalCardEditElement.DCE_INPUT_FARMSHOWTITLE);
		seleniumUtil.clear(DigitalCardEditElement.DCE_INPUT_FARMSHOWTITLE);
		seleniumUtil.type(DigitalCardEditElement.DCE_INPUT_FARMSHOWTITLE, input);
		return seleniumUtil.getAttributeText(DigitalCardEditElement.DCE_INPUT_FARMSHOWTITLE, "value");
	}
	
	/**
	 * 分享链接
	 * 
	 * @param seleniumUtil
	 */
	public static WebElement copyButtonVerificaction(SeleniumUtil seleniumUtil){
		seleniumUtil.click(DigitalCardEditElement.DCE_BTN_COPYSHAREADDRESS);
		seleniumUtil.switchToPromptedAlertAfterWait(2000).accept();
		seleniumUtil.keyBoardInput(KeyEvent.VK_CONTROL,KeyEvent.VK_T);
		seleniumUtil.pause(2000);
		seleniumUtil.keyBoardInput(KeyEvent.VK_CONTROL,KeyEvent.VK_V);
		seleniumUtil.keyBoardInput(KeyEvent.VK_ENTER);
		return null;
	}
	
	/**
	 * 地图设置勾选用例
	 * @param seleniumUtil
	 * @param driver
	 */
	public static void mapSettings(SeleniumUtil seleniumUtil,WebDriver driver){
		seleniumUtil.click(DigitalCardEditElement.DCE_BTN_MORESETTINGS);
		seleniumUtil.isDisplayed(driver.findElement(DigitalCardEditElement.DCE_INPUT_PLANTINFO));
		logger.info("找到种植信息,列表展开正确");
		By[] by = DigitalCardEditElement.byElements;
		for (int i = 0; i < by.length; i++) {
			boolean flag = seleniumUtil.doesCheckboxSelected(by[i]);
			WebElement element = driver.findElement(by[i]);
			if (!flag) {
				logger.info("元素["+by[i]+"]没有被勾选");
				element.click();
				logger.info("元素["+by[i]+"]勾选完毕");
			}
		}
	}
	
	/**
	 * 勾选完毕后,查看预览页面
	 * 
	 * @param seleniumUtil
	 */
	public static void checkSelectedElementsDisplayed(SeleniumUtil seleniumUtil){
		
		
	}
}
