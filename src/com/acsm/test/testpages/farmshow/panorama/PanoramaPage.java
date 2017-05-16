package com.acsm.test.testpages.farmshow.panorama;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.acsm.test.testpages.farmshow.ourhonor.OurHonorElements;
import com.acsm.test.utils.SeleniumUtil;

/**
 * @ClassName: Panorama_Page
 * @Description: 农场实景测试用例
 * @author GuoKuo
 * @date 2016年7月12日
 *
 */

public class PanoramaPage
{
    public static Logger logger = Logger.getLogger(SeleniumUtil.class.getName());
    public static WebDriver driver = SeleniumUtil.driver;
    protected String scenePageTitle;
    protected String pageText;
    public static String imgSrc;

    /**
     * @Title: farmScenePage @Description: 农场实景@param 参数 @return void
     *         返回类型 @throws
     */
    public static String farmScenePage(SeleniumUtil seleniumUtil)
    {
        // 进入农场实景
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",
                driver.findElement(PanoramaPageElements.CLICK_OUR_SCENERY));
//        seleniumUtil.click(PanoramaPageElements.CLICK_OUR_SCENERY);
        WebElement element =driver.findElement(PanoramaPageElements.CLICK_OUR_SCENERY);
        element.click();
        return seleniumUtil.getText(PanoramaPageElements.OS_STRING_PAGE);
    }

    /**
     * @Title: pageTitleByDefault @Description: 获取页面主题 @param 参数 @return void
     *         返回类型 @throws
     */
    public static String scenePageTitleByDefault(SeleniumUtil seleniumUtil)
    {
        // 验证默认项目名称
        WebElement getProjectName = driver.findElement(PanoramaPageElements.GET_PAGE_TITLE);
        return getProjectName.getAttribute("value");

    }

    /**
     * @Title: pageTextVerification @Description: 验证页面文字 @param 参数 @return void
     *         返回类型 @throws
     */
    public static String scenePageTextVerification(SeleniumUtil seleniumUtil)
    {
        // 验证默认项目名称
        WebElement getProjectName = driver.findElement(PanoramaPageElements.GET_PAGE_TEXT);
        return getProjectName.getText();

    }

    /**
     * @Title: selectFarmImg @Description: 选择图片 @param 参数 @return void
     *         返回类型 @throws
     */
    public static Map<String, String> selectFarmImg(SeleniumUtil seleniumUtil)
    {
        // 点击选择图片
        seleniumUtil.click(PanoramaPageElements.SELECT_IMAGE);
        seleniumUtil.waitForElementToLoad(1000, PanoramaPageElements.IMAGE_SELECT_DIALOG);
        // 选择一张农场图片
        List<WebElement> list = seleniumUtil.findElementsBy(PanoramaPageElements.FARM_IMAGE);
        int b = (int) (Math.random() * list.size());// 选择随机图片
        list.get(b).click();
        // 选择两张全景;
        seleniumUtil.click(PanoramaPageElements.FARM_SCENERY_IMAGE_DIALOG);
        seleniumUtil.click(PanoramaPageElements.FARM_SCENERY_IMAGE);
        seleniumUtil.click(PanoramaPageElements.FARM_SCENERY_IMAGE_1);
        // 点击确认
        seleniumUtil.click(PanoramaPageElements.CONFIRM_BUTTON);
        // 判断图片是否上传成功(仅挑选一张图片进行对比)
        imgSrc = seleniumUtil.getAttributeText(PanoramaPageElements.GET_IMG_SRC, "src");
        String actureSrc = seleniumUtil.getAttributeText(PanoramaPageElements.GET_IMG_ACTURAL_SRC, "src");
        Map<String, String> result = new HashMap<String, String>();
        result.put("resouceImg", imgSrc);
        result.put("targetImg", actureSrc);
        return result;
    }

    /**
     * @Title: panoramaImgVerification @Description: 查看打开全景图 @param 参数 @return
     *         void 返回类型 @throws
     */
    public static void panoramaImgVerification(SeleniumUtil seleniumUtil)
    {
        // 鼠标悬浮四季田景
        seleniumUtil.mouseMoveToElement(PanoramaPageElements.OS_IMG_PANORAMA);
        seleniumUtil.pause(1000);
        seleniumUtil.click(PanoramaPageElements.OS_IMG_PANORAMAFIND);
        seleniumUtil.pause(4000);
        seleniumUtil.switchFrame(driver.findElement(PanoramaPageElements.OS_IMG_PANORAMAIFRAME));
        seleniumUtil.isDisplayed(driver.findElement(PanoramaPageElements.OS_IMG_PANORAMAOPEN));
        seleniumUtil.pause(4000);
        seleniumUtil.outFrame();
        seleniumUtil.click(PanoramaPageElements.OS_IMG_PANORAMACLOSE);
        logger.info("全景图关闭成功");
    }
    
    /**
     * @Title: panoramaImgDEL @Description: 删除全景图 @param 参数 @return
     *         void 返回类型 @throws
     */
    public static int panoramaImgDEL(SeleniumUtil seleniumUtil)
    {
        // 鼠标悬浮四季田景
        seleniumUtil.mouseMoveToElement(PanoramaPageElements.OS_IMG_PANORAMA);
        seleniumUtil.pause(1000);
        seleniumUtil.click(PanoramaPageElements.OS_IMG_PANORAMADEL);
        Alert alert = seleniumUtil.switchToPromptedAlertAfterWait(2000);
        alert.accept();
        List<WebElement> panoramaList = driver.findElements(PanoramaPageElements.OS_IMG_PANORAMALIST);
        return panoramaList.size();
        
    }
    
    /**
     * @Title: panoramaAddAfterDEL @Description: 删除全景图后再次添加 @param 参数 @return
     *         void 返回类型 @throws
     */
    public static void panoramaAddAfterDEL(SeleniumUtil seleniumUtil)
    {
        // 点击选择全景
        seleniumUtil.click(PanoramaPageElements.SELECT_IMAGE);
        seleniumUtil.waitForElementToLoad(1000, PanoramaPageElements.IMAGE_SELECT_DIALOG);
        seleniumUtil.click(PanoramaPageElements.FARM_SCENERY_IMAGE_DIALOG);
        seleniumUtil.click(PanoramaPageElements.FARM_SCENERY_IMAGE);
        
    }

}
