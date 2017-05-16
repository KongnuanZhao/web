package com.acsm.test.testpages.farmshow.specalproduct;

import org.openqa.selenium.By;

public class SpecialProductsElements
{

    /** 点击手机 */
    public static final By CLICK_PHONE = By.cssSelector("div.p-contant");

    /** 模块名称 */
    public static final By OH_STRING_PAGENAME = By.xpath("//p[contains(text(),'特色产品')]");

    /** 进入特色产品 */
    public static final By SP_BTN_SPECIALPRODUCTS = By.xpath("//li[contains(@temp,'8')]");

    /** 读取页面主题 */
    public static final By GET_PAGE_TITLE = By.xpath("//div[@tempr='8']//h3");

    /** 页面主题输入框 */
    public static final By SP_INPUT_RESUME = By.id("all:productTitleId");

    /** 点击上传履历 */
    public static final By SELECT_IMAGE = By.xpath("//div[contains(@onclick,'openProductRecord()')]");

    /** 选择图片对话框 */
    public static final By IMAGE_SELECT_DIALOG = By.cssSelector("span#productRecordids ul.resume");

    /** 点击确认 */
    public static final By CONFIRM_BUTTON = By.xpath("//div[@id='resume']//button[contains(text(),'确定')]");

    /** 修改特色产品内容 */
    public static final By SPECIAL_PRODUCTS_INPUT_DIALOG = By.id("all:productTitleId");

    /** 实际名称 */
    public static final By ACTURAL_RESULT = By.cssSelector("div.txt1 p");

    /** 履历列表 */
    public static final By SP_LIST_RESUME = By.cssSelector("div.lvli");

    /** 履历删除 */
    public static final By SP_LIST_RESUMEDELETE = By.xpath("//img[contains(@onclick,'delLvli(this)')]");

    /** 履历查看 */
    public static final By SP_LIST_RESUMESEE = By.xpath("//b[@class='see']/img[contains(@src,'map/see.png')]");
    
    /** 履历删除 */
    public static final By SP_BTN_RESUMEDELETE = By.xpath("//div[@class='lvli']//b[@class='sha']");
}
