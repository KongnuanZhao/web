package com.acsm.test.testpages.farmshow.safeplant;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.acsm.test.base.BaseParpare;
import com.acsm.test.testpages.farmshow.corver.ProjectSettingPageElements;
import com.acsm.test.testpages.farmshow.service.ServiceElements;
import com.acsm.test.utils.SeleniumUtil;

public class SafePlanting extends BaseParpare
{
    public static Logger logger = Logger.getLogger(SeleniumUtil.class.getName());
    public static WebDriver driver = SeleniumUtil.driver;

    /**
     * 
     * @Title safePlantingPage
     * @description 进入安全种植，获取标题
     * @return String 返回类型
     */
    public static String safePlantingPage(SeleniumUtil seleniumUtil)
    {
        // 进入安全种植
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(SafePlantingElements.SP_ELEMENT_PAGE));
//        seleniumUtil.click(SafePlantingElements.SP_ELEMENT_PAGE);
        WebElement element =driver.findElement(SafePlantingElements.SP_ELEMENT_PAGE);
        element.click();
        return seleniumUtil.getAttributeText(SafePlantingElements.PAGE_TITLE, "value");
    }

    /**
     * 
     * @Title: pageTitleEdit @description: 更换页面主题 @param 参数 @return void
     *         返回类型 @throws
     */
    public static Alert safePlantingPageTitleEdit(SeleniumUtil seleniumUtil)
    {
        // 验证默认项目名称
        seleniumUtil.type(SafePlantingElements.PAGE_TITLE, "安全种植，全程可追溯啊");
        seleniumUtil.click(ProjectSettingPageElements.PS_IMG_PHONE);
        Alert alert = seleniumUtil.switchToPromptedAlertAfterWait(2000);
        logger.info(alert.getText());
        return alert;
    }

    /**
     * @Title mannualSelecting
     * @description 手动选择
     * @return WebElement 返回类型
     */
    public static WebElement mannualSelecting(SeleniumUtil seleniumUtil)
    {
        WebElement mannualRadioButton = driver.findElement(SafePlantingElements.SP_RADIO_MANUAL);
        seleniumUtil.click(SafePlantingElements.SP_RADIO_MANUAL);
        return mannualRadioButton;
    }

    /**
     * @Title specifiedRadioButton
     * @description 指定选择
     * @return WebElement 返回类型
     */
    public static WebElement specifiedSelecting(SeleniumUtil seleniumUtil)
    {
        WebElement specifiedRadioButton = driver.findElement(SafePlantingElements.SPECIFIC_AREA_RADIO);
        seleniumUtil.click(SafePlantingElements.SPECIFIC_AREA_RADIO);
        return specifiedRadioButton;
    }

    /**
     * @Title recentImgCount
     * @description 当前农事图片数目
     * @return Integer 返回类型
     */
    public static int recentImgCount(SeleniumUtil seleniumUtil)
    {
        /** 当前农事图片 */
        seleniumUtil.click(SafePlantingElements.CURRENT_IMG_BY_MANUAL1);
        seleniumUtil.waitForElementToLoad(2000, SafePlantingElements.CURRENT_IMG_DIALOG);
        List<WebElement> currentImgList = seleniumUtil.findElementsBy(SafePlantingElements.CURRENT_IMG_DIALOG);
        int[] arr = seleniumUtil.randomList(currentImgList);
        seleniumUtil.pause(5000);
        for (int i = 0; i < arr.length - 2; i++)
        {
            if (arr[i] < 10)
            {
                currentImgList.get(arr[i]).click();
            }
        }
        seleniumUtil.click(SafePlantingElements.CONFIRM);
        seleniumUtil.pause(2000);
        List<WebElement> listImg = seleniumUtil.findElementsBy(SafePlantingElements.IMG_SELECTED);
        int imgCount = listImg.size();
        logger.info("共上传" + imgCount + "张当前图片");
        return imgCount;
    }

    /**
     * @Title specialImgCount
     * @description 特色农事图片
     * @return Integer 返回类型
     */
    public static int specialImgCount(SeleniumUtil seleniumUtil)
    {
        /** 特色农事图片 */
        seleniumUtil.executeJS("arguments[0].scrollIntoView(true)",
                driver.findElement(By.xpath("//div[@onclick='openfaming2()']")));
        seleniumUtil.click(SafePlantingElements.SPECIAL_IMG_BUTTON);
        seleniumUtil.waitForElementToLoad(2000, SafePlantingElements.SPECIAL_IMG_DIALOG);
        List<WebElement> specialImgList = seleniumUtil.findElementsBy(SafePlantingElements.SPECIAL_IMG_DIALOG);
        int[] arr1 = seleniumUtil.randomList(specialImgList);
        for (int i = 0; i < arr1.length - 2; i++)
        {
            if (arr1[i] < 10)
            {
                specialImgList.get(arr1[i]).click();
            }
        }
        seleniumUtil.click(SafePlantingElements.SPECIAL_CONFIRM);
        seleniumUtil.pause(2000);
        List<WebElement> listImg1 = seleniumUtil.findElementsBy(SafePlantingElements.SPECIAL_IMG_SELECTED);
        int imgCount1 = listImg1.size();

        logger.info("共上傳" + imgCount1 + "张特色图片");
        return imgCount1;
    }

    /**
     * @Title specialImgCount
     * @description 指定区域选择图片
     * @return Integer 返回类型
     */
    public static int safePlanting(SeleniumUtil seleniumUtil)
    {

        /** 指定区域选择 */
        seleniumUtil.executeJS("arguments[0].scrollIntoView(true)", driver.findElement(By.cssSelector("li.zd-s div")));
        seleniumUtil.click(SafePlantingElements.SPECIFIC_AREA_RADIO);
        logger.info("当前模式为：指定区域选择模式");
        seleniumUtil.pause(2000);
        seleniumUtil.click(SafePlantingElements.AREA_DROPDOWN_LIST);
        seleniumUtil.pause(2000);
        List<WebElement> specialImgByArea = seleniumUtil.findElementsBy(SafePlantingElements.AREA_DROPDOWN_LIST_SELECT);
        int[] arr2 = seleniumUtil.randomList(specialImgByArea);
        specialImgByArea.get(arr2[0]).click();
        seleniumUtil.pause(1000);
        specialImgByArea.get(arr2[1]).click();
        seleniumUtil.pause(1000);
        specialImgByArea.get(arr2[2]).click();
        seleniumUtil.pause(1000);
        specialImgByArea.get(arr2[3]).click();
        seleniumUtil.pause(3000);
        logger.info("区域勾选完毕");
        seleniumUtil.pause(3000);
        String str = driver.findElement(SafePlantingElements.AREA_DROPDOWN).getAttribute("title");
        String[] newChar = str.split(",");
        int farmCount = newChar.length;
        seleniumUtil.click(SafePlantingElements.AREA_DROPDOWN_LIST);
        return farmCount;
    }
    
    /**
     * @Title CURIMGDelete
     * @description 当前种植图片删除
     * @return WebElement 返回类型
     */
    public static void CURIMGDelete(SeleniumUtil seleniumUtil)
    {
        WebElement specifiedRadioButton = driver.findElement(SafePlantingElements.IMG_SELECTED);
        seleniumUtil.mouseMoveToElement(specifiedRadioButton);
        seleniumUtil.pause(1000);
        seleniumUtil.click(SafePlantingElements.BTN_CURFARMIMG_DET);
        Alert alert = seleniumUtil.switchToPromptedAlertAfterWait(2000);
        alert.accept();
    }
    
    /**
     * @Title SPEIMGDelete
     * @description 特色种植图片删除
     * @return WebElement 返回类型
     */
    public static void SPEIMGDelete(SeleniumUtil seleniumUtil)
    {
        seleniumUtil.pause(1000);
        seleniumUtil.executeJS("arguments[0].scrollIntoView(true)", driver.findElement(SafePlantingElements.SPECIAL_IMG_SELECTED));

        WebElement specifiedRadioButton = driver.findElement(SafePlantingElements.SPECIAL_IMG_SELECTED);
        seleniumUtil.mouseMoveToElement(specifiedRadioButton);
        seleniumUtil.pause(1000);
        seleniumUtil.click(SafePlantingElements.BTN_SPEFARMIMG_DET);
        Alert alert = seleniumUtil.switchToPromptedAlertAfterWait(2000);
        alert.accept();
    }
}
