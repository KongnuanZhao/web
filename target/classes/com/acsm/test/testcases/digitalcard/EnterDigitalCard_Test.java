package com.acsm.test.testcases.digitalcard;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.acsm.test.base.BaseParpare;
import com.acsm.test.testpages.digitalcard.enterdc.DigitalCard;
import com.acsm.test.utils.SeleniumUtil;

public class EnterDigitalCard_Test extends BaseParpare {
	
	public static Logger logger = Logger.getLogger(SeleniumUtil.class.getName());

	/**
	 * 进入数字名片
	 */
	@Test(groups = { "enterDigitalCard" })
	public void enterDigitalCard() {
		System.out.println(timeOut);
		String actureTitle = DigitalCard.enterDigitCard(seleniumUtil,timeOut);
		String expectTitle = "http://cs1.nongchangyun.cn/digitalCard";
		Assert.assertEquals(expectTitle, actureTitle);
		logger.info("数字名片页面打开成功");
	}
	
	/**
	 * 选择基地
	 */
	@Test(groups = { "enterDigitalCard" })
	public void selectBase() {
		DigitalCard.selectBase(seleniumUtil, timeOut, sleepTime);
		logger.info("数字名片页面打开成功");
	}
	
}
