
/**  
* @Title: package-info.java
* @Package farmshow.corver
* @Description: 封面頁
* @author Kuu
* @date 2016年7月11日
* @version V1.0  
*/

/**
* @ClassName: package-info
* @Description: 封面頁元素
* @author Kuu
* @date 2016年7月11日
*
*/

package com.acsm.test.testpages.farmshow.corver;

import org.openqa.selenium.By;

public class corverPageElements
{

    /** 更改背景图片 */
    public static final By CP_BTN_CHANGEBGIMG = By.xpath("//img[@src='/asset/images/map/gengh.png']");

    /** 背景图片对话框 */
    public static final By CP_DIALOG_BGIMGLIST = By.cssSelector("ul.pageList li");

    /** 背景图片对话框确定按钮 */
    public static final By CP_BTN_CONFIRM = By.xpath("//div[@id='changeBg']//button[contains(text(),'确定')]");

    /** 点击保存后的背景图片 */
    public static final By CP_IMAGE_BGIMG = By.xpath("//img[contains(@class,'bjtp')]");

    /** 手机展示背景图片 */
    public static final By CP_PAGE_SHOWBGIMG = By.cssSelector("div.page1.pageShow");

    /** Logo設置-修改按钮 */
    public static final By CP_LINK_CHANGELOGO = By.xpath("//a[contains(text(),'修改>>')]");

    /** 切换iframe */
    public static final By CP_IFRAME_SWITCHTO = By.className("logoUrl");

    /** 点击提交 */
    public static final By CP_BTN_SUBMIT = By.xpath("//button[contains(@onclick,'bcLogo')]");
   
    /** 上传logo */
    public static final By CP_IMG_UPLOADLOGO = By.cssSelector("div.square img");

    /** 实际logo */
    public static final By CP_IMG_ACTURELOGO = By.cssSelector("span.circle img");

    /** 公司名称 */
    public static final By CP_INPUT_COMPANYNAME = By.id("all:enterpriseNameId");
}