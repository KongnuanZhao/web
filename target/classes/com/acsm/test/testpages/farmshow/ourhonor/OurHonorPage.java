package com.acsm.test.testpages.farmshow.ourhonor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.acsm.test.testpages.farmshow.corver.ProjectSettingPageElements;
import com.acsm.test.testpages.farmshow.ourposition.OurPositionElements;
import com.acsm.test.utils.SeleniumUtil;

/**
 * @ClassName: OurHonor_Page
 * @Description: 我们的荣誉测试用例
 * @author Kuu
 * @date 2016年7月12日
 *
 */
public class OurHonorPage
{
    public static Logger logger = Logger.getLogger(OurHonorPage.class);
    public static WebDriver driver = SeleniumUtil.driver;

    /**
     * @author Young
     * @description 
     * @param seleniumUtil
     *            selenium api封装引用对象
     * @return
     */
    public static String ourHonorPage(SeleniumUtil seleniumUtil)
    {

        // 进入我们 的荣誉
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(OurHonorElements.CLICK_OUR_HONOR));
//        seleniumUtil.click(OurHonorElements.CLICK_OUR_SCENERY);
        WebElement element =driver.findElement(OurHonorElements.CLICK_OUR_HONOR);
        element.click();
        return seleniumUtil.getText(OurHonorElements.OH_STRING_PAGENAME);
    }

    /**
     * @Title: pageTitleByDefault @Description: 获取页面主题 @param 参数 @return void
     *         返回类型 @throws
     */
    public static String honorPageTitleByDefault(SeleniumUtil seleniumUtil)
    {

        // 验证默认项目名称
        WebElement getProjectName = driver.findElement(OurHonorElements.GET_PAGE_TITLE);
        return getProjectName.getAttribute("value");
    }

    /**
     * @Title: pageTitleEdit @Description: 更换页面主题 @param 参数 @return void
     *         返回类型 @throws
     */
    public static Alert honorPageTitleEdit(SeleniumUtil seleniumUtil)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(OurHonorElements.CLICK_OUR_HONOR));
        seleniumUtil.click(OurHonorElements.CLICK_OUR_HONOR);
        // 验证默认项目名称
        seleniumUtil.type(OurHonorElements.GET_PAGE_TITLE, "我们的荣誉我们的荣誉我们的荣誉我们的荣誉");
        seleniumUtil.click(ProjectSettingPageElements.PS_IMG_PHONE);
        Alert alert = seleniumUtil.switchToPromptedAlertAfterWait(2000);
        return alert;

    }

    /**
     * @Title: ourHonorImgUpload @Description: 选择荣誉图片 @param 参数 @return void
     *         返回类型 @throws
     */
    public static int ourHonorImgUpload(SeleniumUtil seleniumUtil)
    {
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(OurHonorElements.CLICK_OUR_HONOR));
        seleniumUtil.click(OurHonorElements.CLICK_OUR_HONOR);
        /** 点击选择图片 */
        seleniumUtil.click(OurHonorElements.SELECT_IMAGE);
        seleniumUtil.waitForElementToLoad(1000, OurHonorElements.IMAGE_SELECT_DIALOG);
        seleniumUtil.pause(2000);
        // 选择一张农场图片
        List<WebElement> list = seleniumUtil.findElementsBy(OurHonorElements.IMAGE_SELECT_DIALOG);
//        int[] arr = seleniumUtil.randomList(list);
        seleniumUtil.pause(2000);
        list.get(0).click();
        list.get(1).click();
        list.get(2).click();
        list.get(3).click();
//        list.get(arr[0]).click();
//        list.get(arr[1]).click();
//        list.get(arr[2]).click();
//        list.get(arr[3]).click();
        seleniumUtil.pause(1000);
        /** 点击确认 */
        seleniumUtil.click(OurHonorElements.CONFIRM_BUTTON);
        seleniumUtil.pause(2000);

        List<WebElement> imgCount = seleniumUtil.findElementsBy(OurHonorElements.OH_TABLE_HONORIMGS);
        return imgCount.size();
    }

    /**
     * @Title: ourHonorImgDelete @Description: 删除荣誉图片 @param 参数 @return void
     *         返回类型 @throws
     */
    public static Map<String, Integer> ourHonorImgDelete(SeleniumUtil seleniumUtil)
    {
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(OurHonorElements.CLICK_OUR_HONOR));
        seleniumUtil.click(OurHonorElements.CLICK_OUR_HONOR);
        List<WebElement> list = seleniumUtil.findElementsBy(OurHonorElements.OH_TABLE_HONORIMGS);
        int imgUploaded = list.size();
        seleniumUtil.mouseMoveToElement(OurHonorElements.OH_IMG_HONORFIRSTIMG);
        seleniumUtil.click(OurHonorElements.OH_BTN_HONORFIRSTIMGDELETE);
        Alert alert = seleniumUtil.switchToPromptedAlertAfterWait(2000);
        alert.accept();
        List<WebElement> list_1 = seleniumUtil.findElementsBy(OurHonorElements.OH_TABLE_HONORIMGS);
        int afterDelete = list_1.size();
        Map<String, Integer> count = new HashMap<String, Integer>();
        count.put("resource", imgUploaded);
        count.put("target", afterDelete);
        return count;
    }
    
    /**
     * @Title: honorImgAddAfterDEL @Description: 选择荣誉图片 @param 参数 @return void
     *         返回类型 @throws
     */
    public static void honorImgAddAfterDEL(SeleniumUtil seleniumUtil)
    {
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(OurHonorElements.CLICK_OUR_HONOR));
        seleniumUtil.click(OurHonorElements.CLICK_OUR_HONOR);
        /** 点击选择图片 */
        seleniumUtil.click(OurHonorElements.SELECT_IMAGE);
        seleniumUtil.waitForElementToLoad(1000, OurHonorElements.IMAGE_SELECT_DIALOG);
        seleniumUtil.pause(2000);
        // 选择一张农场图片
        List<WebElement> list = seleniumUtil.findElementsBy(OurHonorElements.IMAGE_SELECT_DIALOG);
//        int[] arr = seleniumUtil.randomList(list);
        seleniumUtil.pause(2000);
        list.get(0).click();
        seleniumUtil.pause(1000);
        /** 点击确认 */
        seleniumUtil.click(OurHonorElements.CONFIRM_BUTTON);
        seleniumUtil.pause(2000);
    }
}
