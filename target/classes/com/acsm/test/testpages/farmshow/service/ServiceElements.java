package com.acsm.test.testpages.farmshow.service;

import org.openqa.selenium.By;

public class ServiceElements
{

    /** 我们荣誉 */
    public static final By SE_PAGE_SERVICE = By.xpath("//li[contains(@temp,'11')]");

    /** 模块名称 */
    public static final By SE_STRING_PAGENAME = By.xpath("//p[contains(text(),'我们的服务')]");

    /** 读取页面主题 */
    public static final By SE_PAGE_TITLE = By.id("all:serviceTitleId");

    /** 手机中的title */
    public static final By SE_PHONE_TITLE = By.xpath("//div[@class='page11 pageShow']//em[contains(@class,'ttl-h3')]");

    /** 添加服务按钮*/
    public static final By SE_BTN_ADDSERVICE = By.xpath("//div[contains(@onclick,'openFwmc()')]");
            
    /** 添加服务对话框 */
    public static final By SE_DIALOG_ADDSERVICE = By.cssSelector("div.modal-dialog.addService");
  
    /** 点击上传图片 */
    public static final By SE_BTN_SERVICEIMG = By.xpath("//form[@action='/map/PropagandasPic.seam']//input[@id='inputsImages:logoUrl']");
  
    /** 验证图片上传 */
    public static final By SE_STRING_SERVICEIMG = By.xpath("//img[contains(@src,'http://img3.farmeasy.cn/00003323/farm_show')]");
  
    /** 验证服务名称 */
    public static final By SE_INPUT_SERVICENAME = By.xpath("//input[contains(@value,'输入服务名称')]");
 
    /** 验证服务描述*/
    public static final By SE_INPUT_SERVICEDIALOG = By.xpath("//textarea[@onkeyup='showDescLength(this);']");
    
    /** 点击确认 */
    public static final By SE_INPUT_CONFIRM = By.xpath("//button[contains(@onclick,'bcFw()')]");
  
    /** 获取页面名称*/
    public static final By SE_NAME_SERVICE = By.xpath("//div[@tempr='11']//span");
    
    /** 获取页面描述*/
    public static final By SE_DESCRIPTRION_SERVICE = By.cssSelector("div.page11.pageShow div.txt-block p");
}
