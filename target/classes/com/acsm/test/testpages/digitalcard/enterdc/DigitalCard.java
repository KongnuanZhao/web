package com.acsm.test.testpages.digitalcard.enterdc;

import org.apache.log4j.Logger;

import com.acsm.test.base.BaseParpare;
import com.acsm.test.utils.SeleniumUtil;

public class DigitalCard{

	public static Logger logger = Logger.getLogger(DigitalCard.class);

	/**
	 * 进入数字名片
	 * 
	 * @param seleniumUtil
	 * @param timeout
	 */
	public static String enterDigitCard(SeleniumUtil seleniumUtil, int timeOut) {
		seleniumUtil.mouseMoveToElement(DigitalCardElement.DC_BTN_SALE);
		seleniumUtil.waitForElementToLoad(timeOut, DigitalCardElement.DC_BTN_DIGITALCARD);
		seleniumUtil.click(DigitalCardElement.DC_BTN_DIGITALCARD);
		return SeleniumUtil.driver.getCurrentUrl().substring(0,38);
	}
	
	/**
	 * 选择套餐
	 * 
	 * @param seleniumUtil
	 * @param timeout
	 */
	public static void selectBase(SeleniumUtil seleniumUtil, int timeOut,int sleepTime) {
		seleniumUtil.mouseMoveToElement(DigitalCardElement.DC_BTN_BASESELECT);
		seleniumUtil.waitForElementToLoad(timeOut, DigitalCardElement.DC_BTN_SELECTFIRSTBASE);
		seleniumUtil.click(DigitalCardElement.DC_BTN_SELECTFIRSTBASE);
		seleniumUtil.pause(sleepTime);
	}

}
