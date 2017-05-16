package com.acsm.test.testpages.entsettings;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.acsm.test.utils.SeleniumUtil;

public class EntSetting {

	public static Logger logger = Logger.getLogger(EntSetting.class);
	WebDriver driver = SeleniumUtil.driver;

	public static void enterSettingsPage(SeleniumUtil seleniumUtil) {

		// 点击系统设置
		seleniumUtil.click(EntSettingElements.ESE_BTN_SETTING);
		seleniumUtil.waitForPageLoading(2000);
	}
	
	/**
	 * 进入销售管理
	 * @param seleniumUtil
	 */
	public static void sale(SeleniumUtil seleniumUtil) {
		seleniumUtil.click(EntSettingElements.ESE_BTN_SALE);
		seleniumUtil.waitForPageLoading(2000);

	}
	
	/**
	 * 点击保存
	 * @param seleniumUtil
	 */
	public static void save(SeleniumUtil seleniumUtil) {
		seleniumUtil.click(EntSettingElements.ESE_BTN_SAVE);
	}
}
