package com.acsm.test.testpages.farmshow.ourhonor;

import org.openqa.selenium.By;

public class OurHonorElements
{

    /** 我们荣誉 */
    public static final By CLICK_OUR_HONOR = By.xpath("//li[contains(@temp,'6')]");

    /** 模块名称 */
    public static final By OH_STRING_PAGENAME = By.xpath("//p[contains(text(),'我们的荣誉')]");

    /** 读取页面主题 */
    public static final By GET_PAGE_TITLE = By.id("all:honorTitleId");

    /** 图片上传按钮 */
    public static final By SELECT_IMAGE = By.xpath("//div[contains(@onclick,'openHonor()')]");

    /** 选择图片对话框 */
    public static final By IMAGE_SELECT_DIALOG = By.cssSelector("span#honorIds li");

    /** 点击确认 */
    public static final By CONFIRM_BUTTON = By.xpath("//div[@id='honor']//button[contains(text(),'确定')]");

    /** 获取图片列表 */
    public static final By OH_TABLE_HONORIMGS = By.xpath("//div[@tempr=6]//li");

    /** 获取第一个图片 */
    public static final By OH_IMG_HONORFIRSTIMG = By.xpath("//div[@tempr=6]//img");

    /** 删除图片 */
    public static final By OH_BTN_HONORFIRSTIMGDELETE = By.xpath("//img[contains(@onclick,'delRytp(this)')]");
}
