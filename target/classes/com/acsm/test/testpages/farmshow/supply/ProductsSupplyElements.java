package com.acsm.test.testpages.farmshow.supply;

import org.openqa.selenium.By;

public class ProductsSupplyElements
{

    /** 点击手机 */
    public static final By CLICK_PHONE = By.cssSelector("div.p-contant");

    /** 使用微商城 */
    public static final By CHECKBOX_MICRO_MART = By.cssSelector("div.icheckbox_minimal-blue");

    /** 微商城 地址输入框 */
    public static final By INPUT_MICRO_MART = By.id("all:linkMarketUrl");

    /** 产品供应 */
    public static final By PS_ELEMENT_SUPPLY = By.xpath("//li[contains(@temp,'10')]");

    /** 读取页面主题 */
    public static final By GET_PAGE_TITLE = By.id("all:supplyTitleId");

    /** 点击供应商品 */
    public static final By SUPPLY_PRODUCTS_ICON = By.xpath("//div[@onclick='openSupply(1)']");

    /** 选择供应图片对话框 */
    public static final By IMAGE_SELECT_DIALOG = By.cssSelector("span#saleProductids li");

    /** 点击确认 */
    public static final By CONFIRM_BUTTON = By.xpath("//div[@id='supply']//button[contains(text(),'确定')]");

    /** 实际上传供应图片张数 */
    public static final By IMAGE_SELECT = By.cssSelector("ul.goods li");

    /** 点击预售商品 */
    public static final By PRE_SALE_PRODUCTS_ICON = By.xpath("//div[@onclick='openSupply(0)']");

    /** 预售商品 - 图片对话框 */
    public static final By PRE_SALE_PRODUCTS_IMAGE = By.cssSelector("span#saleProductids li");

    /** 实际上传预售供应图片张数 */
    public static final By PRESELL_IMAGE_SELECT = By.xpath("//div[@tempr='10']//ul[last()]//li");

    /** 手机中的title */
    public static final By PRE_PHONE_TITLE = By.xpath("//div[@class='page10 pageShow']//em[contains(@class,'ttl-h3')]");
  
    /** 删除供应图片 */
    public static final By PRE_BTN_DELETE = By.xpath("//img[contains(@onclick,'delbcGysp(this,0)')]");
    
    /** 删除预售供应图片 */
    public static final By PRE_BTN_PREDELETE = By.xpath("//img[contains(@onclick,'delbcGysp(this,1)')]");
  
    /** 鼠标悬浮预售模块 */
    public static final By PRE_ELE_PRE = By.xpath("//div[@tempr=10]//ul[last()]//li");
}
