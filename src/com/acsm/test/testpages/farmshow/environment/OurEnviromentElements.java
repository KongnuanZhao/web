package com.acsm.test.testpages.farmshow.environment;

import org.openqa.selenium.By;

public class OurEnviromentElements
{
    /** 定义页面标题 */
    public static final By OE_STR_PAGETIELE = By.xpath("//em[contains(text(),'我们的环境')]");

    /** 定义页面标题输入框 */
    public static final By OE_INPUT_PAGETIELE = By.id("all:environmentTitleId");

    /** 定义勾选洗肺指数 */
    public static final By OE_CHECKBOX_CLEAN = By.cssSelector("div.icheckbox_minimal-aero");

    /** 点击手机模块 */
    public static final By OE_IMG_PHONE = By.cssSelector("div.p-contant");

    /** 星级列表 */
    public static final By OE_LIST_STARSLIST = By.cssSelector("div.data-block li");

}
