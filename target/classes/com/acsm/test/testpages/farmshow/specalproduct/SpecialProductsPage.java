package com.acsm.test.testpages.farmshow.specalproduct;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.acsm.test.testpages.farmshow.corver.ProjectSettingPageElements;
import com.acsm.test.testpages.farmshow.ourhonor.OurHonorElements;
import com.acsm.test.utils.SeleniumUtil;

/**
 * @ClassName: SpecialProducts_Page
 * @Description: 特色产品测试用例
 * @author Kuu
 * @date 2016年7月12日
 *
 */

public class SpecialProductsPage
{
    public static Logger logger = Logger.getLogger(SeleniumUtil.class.getName());
    public static WebDriver driver = SeleniumUtil.driver;

    /**
     * @param seleniumUtil 
     * @Title: specialProductsPage @Description: 进入特色产品@param 参数 @return void
     *         返回类型 @throws
     */
    public static String specialProductsPage(SeleniumUtil seleniumUtil)
    {
        // 进入特色种植
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",
                driver.findElement(SpecialProductsElements.SP_BTN_SPECIALPRODUCTS));
        WebElement element =driver.findElement(SpecialProductsElements.SP_BTN_SPECIALPRODUCTS);
        element.click();
//        seleniumUtil.click(SpecialProductsElements.SP_BTN_SPECIALPRODUCTS);
        return seleniumUtil.getText(SpecialProductsElements.OH_STRING_PAGENAME);

    }
    
    /**
     * @Title: honorPageTitleEdit @Description: 更换页面主题 @param 参数 @return void
     *         返回类型 @throws
     */
    public static Alert productPageTitleEdit(SeleniumUtil seleniumUtil)
    {
        // 验证默认项目名称
        seleniumUtil.type(SpecialProductsElements.SP_INPUT_RESUME, "特色产品特色产品");
        seleniumUtil.click(ProjectSettingPageElements.PS_IMG_PHONE);
        Alert alert = seleniumUtil.switchToPromptedAlertAfterWait(2000);
        return alert;

    }
    
    /**
     * @Title: resumeSelected @Description: 选择履历 @param 参数 @return void
     *         返回类型 @throws
     */
    public static WebElement resumeSelected(SeleniumUtil seleniumUtil)
    {
        // 点击选择
        seleniumUtil.click(SpecialProductsElements.SELECT_IMAGE);
        seleniumUtil.waitForElementToLoad(1000, SpecialProductsElements.IMAGE_SELECT_DIALOG);
        // 选择履历
        List<WebElement> list = seleniumUtil.findElementsBy(SpecialProductsElements.IMAGE_SELECT_DIALOG);
        seleniumUtil.pause(2000);
        int b = (int) (Math.random() * (list.size()-1));// 选择随机图片
        seleniumUtil.pause(2000);
        list.get(b).click();
        seleniumUtil.pause(2000);
        // 点击确认
        seleniumUtil.click(SpecialProductsElements.CONFIRM_BUTTON);
        seleniumUtil.pause(2000);
        // 判断是否选择成功
        WebElement resume =driver.findElement(SpecialProductsElements.SP_LIST_RESUME);
        return resume;
    }
    
    /**
     * @Title: resumeSee @Description: 查看履历 @param 参数 @return void
     *         返回类型 @throws
     */
    public static void resumeSee(SeleniumUtil seleniumUtil)
    {
        seleniumUtil.mouseMoveToElementNoHight(SpecialProductsElements.SP_LIST_RESUME);
        seleniumUtil.pause(2000);
        seleniumUtil.click(SpecialProductsElements.SP_LIST_RESUMESEE);
//        String windowTitle = "绿色履历";
//        seleniumUtil.switchToWindowBack(windowTitle,seleniumUtil);
//        seleniumUtil.pause(3000);
        seleniumUtil.pause(5000);
        Actions action = new Actions(driver);
        action.keyDown(Keys.CONTROL).sendKeys(Keys.TAB).keyUp(Keys.CONTROL).sendKeys(Keys.NULL).perform(); 
        seleniumUtil.pause(3000);

    }
    
    /**
     * @Title: resumeRemove @Description: 删除履历 @param 参数 @return void
     *         返回类型 @throws
     */
    public static void resumeRemove(SeleniumUtil seleniumUtil)
    {
        seleniumUtil.mouseMoveToElement(SpecialProductsElements.SP_LIST_RESUME);
        seleniumUtil.pause(2000);
        seleniumUtil.click(SpecialProductsElements.SP_BTN_RESUMEDELETE);
        
    }
}
