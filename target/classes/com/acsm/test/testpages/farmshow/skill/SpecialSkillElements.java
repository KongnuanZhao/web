package com.acsm.test.testpages.farmshow.skill;

import org.openqa.selenium.By;

public class SpecialSkillElements
{

    /** 点击特色种植技术 */
    public static final By CLICK_SPECIAL_PAGE = By.xpath("//li[contains(@temp,'4')]");

    /** 主题名称 */
    public static final By PAGE_TITLE = By.id("all:specialTitleId");

    /** 模块名称 */
    public static final By SS_STRING_PAGENAME = By.xpath("//p[contains(text(),'特色种植技术')]");

    /** 认证单图 -选择图片*/
    public static final By SINGLE_PIC = By.cssSelector("div.picS div.pic");

    /** 认证单图图片地址 */
    public static final By SINGLE_PIC_ADDRESS = By.cssSelector("li.r-pic img");

    /** 认证单图图片实际地址 */
    public static final By SINGLE_PIC_ACTURE_ADDRESS = By.cssSelector("table.report img");
    
    /** 认证多图 - 选择图片 */
    public static final By MULTI_PIC = By.cssSelector("div.picM div.pic");

    /** 认证多图列表 */
    public static final By SS_LIST_MULTIIMG = By.cssSelector("div.picM ul");

    /** 认证单图-编辑名称输入框 */
    public static final By SINGLE_PIC_INPUT = By.id("all:specialSingleTitleId");

    /** 认证多图-编辑名称输入框 */
    public static final By MULTI_PIC_INPUT = By.id("all:specialMultipleTitleId");

    /** 认证图片添加页 */
    public static final By AUTH_ADD_DIALOG = By.cssSelector("div#honorMore div.modal-content");

    /** 认证图片 */
    public static final By AUTH_PIC = By.cssSelector("span#companyhouonrIds li");

    /** 认证图片添加页 - 确认按钮 */
    public static final By ACCEPT_CLICK = By.xpath("//div[@id='honorMore']//button[contains(text(),'确定')]");
  
    /** 认证单图 - 图片*/
    public static final By MULTI_IMG = By.cssSelector("div.picM img");
    
    /** 认证单图删除*/
    public static final By MULTI_IMG_DELETE = By.xpath("//div[@class='picM']//img[contains(@onclick,'delRztp(this)')]");
    
    /** 认证多图列表 */
    public static final By SS_LIST_MULTIIMG1 = By.cssSelector("div.picM ul li");
}
