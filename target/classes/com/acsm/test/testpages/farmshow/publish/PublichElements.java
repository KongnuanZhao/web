
/**  
* @Title: package-info.java
* @Package com.acsm.test.testpages.farmshow.publish
* @Description: 发布后的一些测试点
* @author GuoKuo
* @date 2016年10月25日
* @version V1.0  
*/

package com.acsm.test.testpages.farmshow.publish;

import org.openqa.selenium.By;

public class PublichElements
{

    /** 发布 */
    public static final By PE_BTN_SUBMIT = By.xpath("//img[contains(@onclick,'tJAll')]");

    /** 搜索框 */
    public static final By PE_BTN_SEARCH = By.id("storageTypeSearch:searchParam");

    /** 农场秀标题 */
    public static final By PE_STR_PROPAGANDASLISTTITLE = By.cssSelector("ul.c-list p");

    /** 图片地址 */
    public static final By PE_STR_PICADD = By.xpath("//img[contains(@src,'1460640462023862a3.jpg')]");

    /** 描述 */
    public static final By PE_STR_DESCRIPTION = By.xpath("//h2[contains(text(),'黑龙江')]");

    /** 农场地址 */
    public static final By PE_STR_FARMADD = By.xpath("//span[contains(@title,'北京市五道口王庄路27号院')]");

    /** 模块名称检验 */
    public static final By PE_STR_PAGENAME_1 = By.xpath("//em[contains(text(),'我们的位置')]");
    public static final By PE_STR_PAGENAME_2 = By.xpath("//em[contains(text(),'我们的环境')]");
    public static final By PE_STR_PAGENAME_3 = By.xpath("//span[contains(text(),'特色种植技术')]");
    public static final By PE_STR_PAGENAME_4 = By.xpath("//p[contains(text(),'我们农场实景')]");
    public static final By PE_STR_PAGENAME_5 = By.xpath("//h2[contains(text(),'我们的荣誉')]");
    public static final By PE_STR_PAGENAME_6 = By.xpath("//h2[contains(text(),'我们的团队')]");
    public static final By PE_STR_PAGENAME_7 = By.xpath("//h2[contains(text(),'特色产品')]");

}