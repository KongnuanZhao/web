package com.acsm.test.testpages.farmshow.ourteam;

import org.openqa.selenium.By;

public class OurTeamElements
{

    /** 我们的团队 */
    public static final By CLICK_OUR_TEAM = By.xpath("//li[contains(@temp,'7')]");

    /** 模块名称 */
    public static final By OH_STRING_PAGENAME = By.xpath("//p[contains(text(),'我们的团队')]");

    /** 读取页面主题 */
    public static final By GET_PAGE_TITLE = By.id("all:teamTitleId");

    /** 图片上传按钮 */
    public static final By SELECT_IMAGE = By.cssSelector("div.click");

    /** 选择图片对话框 */
    public static final By IMAGE_SELECT_DIALOG = By.cssSelector("span#teamIds li");

    /** 点击确认 */
    public static final By CONFIRM_BUTTON = By.xpath("//div[@id='ourTeam']//button[contains(text(),'确定')]");

    /** 获取人员图片地址 */
    public static final By GET_IMG_SRC = By.cssSelector("div.tup img");

    /** 获取人员后图片地址 */
    public static final By GET_IMG_ACTURAL_SRC = By.cssSelector("div#featured-area2 img");

    /** 获取人员列表 */
    public static final By OT_LIST_MEMEBERLIST = By.cssSelector("ul.people li");

    /** 删除人员 */
    public static final By OT_LIST_MEMEBERDELETE = By.xpath("//img[contains(@onclick,'delTdtp')]");
    
    /** 获取人员的名字 */
    public static final By OT_LIST_MEMEBERNAME = By.cssSelector("ul.people span:nth-child(2)");
    
}
