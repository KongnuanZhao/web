package com.acsm.test.testcases.digitalcard.digitalcardedit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.acsm.test.base.BaseParpare;
import com.acsm.test.testpages.digitalcard.digitalcardedit.DigitalCardEdit;
import com.acsm.test.utils.SeleniumUtil;

public class DigitalCardEdit_Test extends BaseParpare {

	public static Logger logger = Logger.getLogger(SeleniumUtil.class.getName());
	boolean flag = false;
	/**
	 * 等待页面加载完毕
	 */
	@Test(groups = { "digitalCardEdit" })
	public void waitPageLoaded() {
		DigitalCardEdit.waitEditPageLoaded(seleniumUtil, timeOut);
		logger.info("数字名片页面加载完毕");
	}

	/**
	 * 搜索功能验证
	 */
	@Test(groups = { "digitalCardEdit" }, dependsOnMethods = { "waitPageLoaded" })
	public void digitalCardSearch() {
		
		int acture = DigitalCardEdit.searchFunctionVerification(seleniumUtil, "魂之挽歌产业基地",timeOut);
		if (acture>0) {
			logger.info("搜索完毕,共有"+ acture +"个结果被搜出");
		}
		logger.info("搜索完毕,没有结果被搜出");
	}
	
	/**
	 * 农场秀标题
	 */
	@Test(groups = { "digitalCardEdit" }, dependsOnMethods = { "waitPageLoaded" })
	public void digitalCardTitle() {
		String input = "魂之挽歌产业基地";
		String title = DigitalCardEdit.digitalCardTitle(seleniumUtil, input);
		Assert.assertEquals(input, title);
		logger.info("输入框验证完毕");
	}
	
	/**
	 * 复制链接验证
	 */
	@Test(groups = { "digitalCardEdit" }, dependsOnMethods = { "waitPageLoaded" })
	public void linkSharedVerification() {
		WebElement element = DigitalCardEdit.copyButtonVerificaction(seleniumUtil);
		flag = element.isDisplayed();
		if (flag) {
			logger.info("复制地址验证完毕,模块正确打开");
		}
		logger.info("模块未打开");
	}
}
