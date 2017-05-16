package com.acsm.test.testpages.farmshow.panorama;

import org.openqa.selenium.By;

public class PanoramaPageElements {

        /** 我们农场实景 */
        public static final By CLICK_OUR_SCENERY = By.xpath("//li[contains(@temp,'5')]");
      
        /** 模块名称 */
        public static final By OS_STRING_PAGE = By.xpath("//p[contains(text(),'我们农场实景')]");
        
        /** 读取我们的位置 */
        public static final By GET_PAGE_TITLE = By.id("all:imgTitleId");
      
        /** 读取页面文字 */
        public static final By GET_PAGE_TEXT = By.xpath("//p[contains(text(),'农场图片')]");
        
        /** 读取页面主题 */
        public static final By SELECT_IMAGE = By.xpath("//div[contains(@onclick,'openFarmReal()')]");

        /** 选择图片对话框 */
        public static final By IMAGE_SELECT_DIALOG = By.cssSelector("div#farmPic div.modal-content");

        /** 选择农场图片 */
        public static final By FARM_IMAGE = By.cssSelector("ul.pre-pic.nc li");

        /** 选择全景图片模块 */
        public static final By FARM_SCENERY_IMAGE_DIALOG = By.xpath("//li[contains(text(),'四季田景')]");

        /** 选择全景图片 */
        public static final By FARM_SCENERY_IMAGE = By.cssSelector("ul.pre-pic.qj li");
        public static final By FARM_SCENERY_IMAGE_1 = By.cssSelector("ul.pre-pic.qj li:nth-child(2)");

        /** 点击确认 */
        public static final By CONFIRM_BUTTON = By.xpath("//div[@id='farmPic']//button[contains(text(),'确定')]");

        /** 获取上传图片地址 */
        public static final By GET_IMG_SRC = By.cssSelector("ul.farmList.nc img");

        /** 获取上传后图片地址 */
        public static final By GET_IMG_ACTURAL_SRC = By.cssSelector("span.img-ai img");
        
        /** 得到全景图 */
        public static final By OS_IMG_PANORAMA = By.cssSelector("ul.farmList.qj img");
        
        /** 点击查看全景图 */
        public static final By OS_IMG_PANORAMAFIND = By.xpath("//img[contains(@src,'see.png')]");
     
        /** 点击删除全景图 */
        public static final By OS_IMG_PANORAMADEL = By.xpath("//img[contains(@onclick,'delQjtp(this);')]");
        
        /** 全景图打开 */
        public static final By OS_IMG_PANORAMAOPEN = By.id("pano");
        
        /** 全景图打开 */
        public static final By OS_IMG_PANORAMALIST = By.cssSelector("ul.farmList.qj");
        
        /** 全景图iframe */
        public static final By OS_IMG_PANORAMAIFRAME = By.id("krpano_iframe");
        
        /** 全景图关闭 */
        public static final By OS_IMG_PANORAMACLOSE = By.xpath("//img[contains(@src,'closeImg.png')]");
}
