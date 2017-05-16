package com.acsm.test.testpages.farmshow.safeplant;

import org.openqa.selenium.By;

public class SafePlantingElements
{

    /** 安全种植 */
    public static final By SP_ELEMENT_PAGE = By.xpath("//li[contains(@temp,'9')]");

    /** 安全种植 */
    public static final By PAGE_TITLE = By.id("all:backwardTitleId");

    public static final By PAGE_TITLE_1 = By.name("all:supplyTitleId");

    /** 选择方式 - 手动选择 */
    public static final By SP_RADIO_MANUAL = By.cssSelector("li.auto-s div");

    /** 選擇当前农事图片 - 手动选择 */
    public static final By CURRENT_IMG_BY_MANUAL1 = By.xpath("//div[@onclick='openfaming()']");

    /** 当前农事图片 - 选择图片对话框 */
    public static final By CURRENT_IMG_DIALOG = By.cssSelector("ul.our-team.plant li");

    /** 当前农事图片 - 确定 */
    public static final By CONFIRM = By.xpath("//button[contains(@onclick,'bcNstp()')]");

    /** 当前农事图片 - 选择张数 */
    public static final By IMG_SELECTED = By.cssSelector("div.picM.pic-current li");

    /** 选择特色农事图片 */
    public static final By SPECIAL_IMG_BUTTON = By.xpath("//div[@onclick='openfaming2()']");

    /** 选择特色农事图片 - 选择图片对话框 */
    public static final By SPECIAL_IMG_DIALOG = By.cssSelector("span#famingIds2 li");

    /** 特色农事图片 - 确定 */
    public static final By SPECIAL_CONFIRM = By.xpath("//div[@id='special']//button[contains(text(),'确定')]");

    /** 特色农事图片 - 选择张数 */
    public static final By SPECIAL_IMG_SELECTED = By.xpath("//div[@tempr=9]//div[@class='picM']//li");

    /** 选择方式 - 指定区域选择 */
    public static final By SPECIFIC_AREA_RADIO = By.cssSelector("li.zd-s ins");

    /** 选择方式 - 指定区域选择 - 区域选择下拉框按鈕 */
    public static final By AREA_DROPDOWN_LIST = By.xpath("//button[@data-id='famingTunnelId']");

    /** 选择方式 - 指定区域选择 - 区域选择下拉框 */
    public static final By AREA_DROPDOWN_LIST_SELECT = By.xpath("//ul[@role='menu']//li");

    /** 区域下拉列表 */
    public static final By AREA_DROPDOWN = By.xpath("//button[@data-id='famingTunnelId']");

    /** 点击手机 */
    public static final By CLICK_PHONE = By.cssSelector("div.p-contant");
    
    /** 删除当前农事图片 */
    public static final By BTN_CURFARMIMG_DET = By.xpath("//img[contains(@onclick,'delNstp(this)')]");
    
    /** 删除特色农事图片 */
    public static final By BTN_SPEFARMIMG_DET = By.xpath("//div[@tempr=9]//div[@class='picM']//img[contains(@src,'sha.png')]");
}
