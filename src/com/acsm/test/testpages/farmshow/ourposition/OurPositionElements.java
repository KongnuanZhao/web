package com.acsm.test.testpages.farmshow.ourposition;

import org.openqa.selenium.By;

public class OurPositionElements
{

    /** 我们的位置 */
    public static final By CLICK_OUR_POSITION = By.xpath("//li[contains(@temp,'2')]");

    /** 模块名称 */
    public static final By OP_STRING_PAGE = By.xpath("//p[contains(text(),'我们的位置')]");

    /** 读取我们的位置 */
    public static final By OUR_POSITION = By.cssSelector("p.address");

    /** 读取页面主题 */
    public static final By PAGE_TITLE_ON_EDITWORKFLOW = By.xpath("//*[@id='all:positionTitleId']");

    /** 点击手机预览 */
    public static final By CLICK_PHONE = By.cssSelector("td.phone-bg");

    /** 点击授予预览 */
    public static final By PAGE_TITLE_ON_PHONE = By.xpath("//em[@class='ttl-h3']");

}
