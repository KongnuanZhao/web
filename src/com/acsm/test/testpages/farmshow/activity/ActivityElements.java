package com.acsm.test.testpages.farmshow.activity;

import org.openqa.selenium.By;

public class ActivityElements
{


    /** 我们的活动模块 */
    public static final By AE_PAGE_TITLE = By.id("all:activityPageTitle");

    /** 我们的活动 */
    public static final By AE_ELEMENT_ACTIVITY = By.xpath("//li[contains(@temp,'12')]");
    
    /** 我们的活动模块名称 */
    public static final By AE_STRING_PAGENAME = By.xpath("//p[contains(text(),'我们的活动')]");

    /** 活动标题 */
    public static final By AE_INPUT_ACTIVITYTITLE = By.id("all:activityTitle");
    
    /** 手机中的活动标题*/
    public static final By AE_ELEMENT_IPHONE_ACTIVITYTITLE = By.cssSelector("span.txt1_bt");

    /** 活动主题 */
    public static final By AE_INPUT_THEME = By.id("all:activityTheme");

    /** 手机中的活动主题 */
    public static final By AE_ELEMENT_IPHONE_ACTIVITYTHEME = By.cssSelector("span.txt1_zt");

    /** 宣传语 */
    public static final By AE_INPUT_PROPAGANDA = By.id("all:activityPublicity");

    /** 手机中的宣传语 */
    public static final By AE_ELEMENT_IPHONE_PROPAGANDA = By.cssSelector("div.page12.pageShow p.txt2");

    /** 活动说明 */
    public static final By AE_INPUT_EXPLAIN = By.id("all:activityExplain");

    /** 手机中的活动说明 */
    public static final By AE_ELEMENT_IPHONE_EXPLAIN = By.cssSelector("p.detail");

    /** 活动连接*/
    public static final By AE_INPUT_LINK = By.id("all:activityLink");

    /** 手机中的活动说明 */
    public static final By AE_ELEMENT_IPHONE_LINK = By.cssSelector("p.active a");

    /** 手机中的title */
    public static final By AE_PHONE_TITLE = By.xpath("//div[@class='page12 pageShow']//em[contains(@class,'ttl-h3')]");
    
    /** 选择活动图片 */
    public static final By AE_BTN_ACTIVITY = By.xpath("//div[@onclick='openActivityModel()']");
    
    /** 点击上传图片 */
    public static final By AE_BTN_SERVICEIMG = By.xpath("//form[@action='/map/PropagandasActivityPic.seam']//input[@id='inputsImages:logoUrl']");
    
    /** 选择活动图片 */
    public static final By AE_LIST_ACTIVITY = By.cssSelector("ul#showUploadActivityImg li");
  
    /** 点击确定*/
    public static final By AE_BTN_CONFIRM = By.xpath("//button[contains(@onclick,'bcActivityModel()')]");
  
    /** 图片是上传个数验证*/
    public static final By AE_LIST_ACTIVITYLIST = By.xpath("//ul[@class='activityImg']//li");
    
    /** 图片删除*/
    public static final By AE_BTN_IMGREMOVE = By.xpath("//img[contains(@onclick,'delUploadActiveImg(this)')]");
  

}
