package com.acsm.test.testpages.farmshow.corver;

import org.openqa.selenium.By;

public class ProjectSettingPageElements
{
    /** 切換到項目設置 */
    public static final By PS_BTN_PROJECTSETTING = By.xpath("//span[contains(text(),'项目设置')]");
    
    /** 切換到項目設置 */
    public static final By PS_BTN_CORVER = By.xpath("//span[contains(text(),'控件设置')]");

    /** 项目名称 */
    public static final By PS_INPUT_PROJECTNAME = By.xpath("//*[@id='all:projectNameId']");

    /** 背景图片对话框确定按钮 */
    public static final By PS_INPUT_SUMMARY = By.id("all:projcetDescriptionpId");

    /** 点击手机模块 */
    public static final By PS_IMG_PHONE = By.cssSelector("div.p-contant");
    
    /** 点击手机模块 */
    public static final By PS_BTN_PUBLISH = By.xpath("//button[contains(text(),'发布项目')]");

    /** 点击文件上传 */
    public static final By PS_BTN_MUSICUPLOAD = By.id("inputsImages:logoUrl");

}
