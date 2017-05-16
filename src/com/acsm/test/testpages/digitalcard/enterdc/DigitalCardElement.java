package com.acsm.test.testpages.digitalcard.enterdc;

import org.openqa.selenium.By;

public class DigitalCardElement {

	// 精准营销按钮
	public static final By DC_BTN_SALE = By.xpath("//img[contains(@src,'left_icon_4.png')]");

	// 农场秀按钮
	public static final By DC_BTN_DIGITALCARD = By.xpath("//img[contains(@src,'left_icon_4_7.png')]");

	// 选择基地
	public static final By DC_BTN_BASESELECT = By.xpath("//span[@class='siteSeleHd']");

	// 选择基地-第一个基地
	public static final By DC_BTN_SELECTFIRSTBASE = By.linkText("魂之挽歌产业基地");
}
