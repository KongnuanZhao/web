package com.acsm.test.testpages.farmshow.activity;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.acsm.test.testpages.farmshow.corver.ProjectSettingPageElements;
import com.acsm.test.testpages.farmshow.supply.ProductsSupplyElements;
import com.acsm.test.utils.SeleniumUtil;

public class Activity
{
    public static Logger logger = Logger.getLogger(SeleniumUtil.class.getName());
    public static WebDriver driver = SeleniumUtil.driver;

    /**
     * @Title: ActivityPage
     * @description 进入我们的活动，验证标题
     * @param seleniumUtil
     * @return String 返回类型
     */
    public static String ActivityPage(SeleniumUtil seleniumUtil)
    {

        /** 点击我们的活动 */
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(ActivityElements.AE_ELEMENT_ACTIVITY));
        WebElement element =driver.findElement(ActivityElements.AE_ELEMENT_ACTIVITY);
        element.click();
//        seleniumUtil.click(ActivityElements.AE_ELEMENT_ACTIVITY);
        return seleniumUtil.getText(ActivityElements.AE_STRING_PAGENAME);
    }

    /**
     * 
     * @Title: ActivityPageTitleEdit @description 页面主题 @param 参数 @return Alert
     *         返回类型 @throws
     */
    public static String PageTitleEdit(String input, SeleniumUtil seleniumUtil)
    {
        String str = null;
        // 验证默认项目名称
        if (input.length() >= 10)
        {
            seleniumUtil.clear(ActivityElements.AE_PAGE_TITLE);
            seleniumUtil.type(ActivityElements.AE_PAGE_TITLE, input);
            seleniumUtil.click(ProjectSettingPageElements.PS_IMG_PHONE);
            Alert alert = seleniumUtil.switchToPromptedAlertAfterWait(2000);
            str = alert.getText();
            seleniumUtil.pause(2000);
            alert.accept();
        } else
        {
            seleniumUtil.clear(ActivityElements.AE_PAGE_TITLE);
            seleniumUtil.type(ActivityElements.AE_PAGE_TITLE, input);
            seleniumUtil.click(ProjectSettingPageElements.PS_IMG_PHONE);
            WebElement element = driver.findElement(ActivityElements.AE_PHONE_TITLE);
            str = element.getText();
        }
        return str;
    }

    /**
     * 
     * @Title: ActivityTitleEdit @description 活动标题 @param 参数 @return Alert
     *         返回类型 @throws
     */
    public static String ActivityTitleEdit(String input, SeleniumUtil seleniumUtil)
    {
        String str = null;
        if (input.length() >= 30)
        {
            seleniumUtil.clear(ActivityElements.AE_INPUT_ACTIVITYTITLE);
            seleniumUtil.type(ActivityElements.AE_INPUT_ACTIVITYTITLE, input);
            seleniumUtil.click(ProjectSettingPageElements.PS_IMG_PHONE);
            Alert alert = seleniumUtil.switchToPromptedAlertAfterWait(2000);
            str = alert.getText();
            seleniumUtil.pause(2000);
            alert.accept();
        } else
        {
            seleniumUtil.clear(ActivityElements.AE_INPUT_ACTIVITYTITLE);
            seleniumUtil.type(ActivityElements.AE_INPUT_ACTIVITYTITLE, input);
            seleniumUtil.click(ProjectSettingPageElements.PS_IMG_PHONE);
            WebElement element = driver.findElement(ActivityElements.AE_ELEMENT_IPHONE_ACTIVITYTITLE);
            str = element.getText();
        }
        return str;
    }

    /**
     * 
     * @Title: ActivityTheme @description 活动主题 @param 参数 @return Alert
     *         返回类型 @throws
     */
    public static String ActivityTheme(String input, SeleniumUtil seleniumUtil)
    {
        String str = null;
        if (input.length() >= 30)
        {
            seleniumUtil.clear(ActivityElements.AE_INPUT_THEME);
            seleniumUtil.type(ActivityElements.AE_INPUT_THEME, input);
            seleniumUtil.click(ProjectSettingPageElements.PS_IMG_PHONE);
            Alert alert = seleniumUtil.switchToPromptedAlertAfterWait(2000);
            str = alert.getText();
            seleniumUtil.pause(2000);
            alert.accept();
        } else
        {
            seleniumUtil.clear(ActivityElements.AE_INPUT_THEME);
            seleniumUtil.type(ActivityElements.AE_INPUT_THEME, input);
            seleniumUtil.click(ProjectSettingPageElements.PS_IMG_PHONE);
            WebElement element = driver.findElement(ActivityElements.AE_ELEMENT_IPHONE_ACTIVITYTHEME);
            str = element.getText();
        }
        return str;
    }

    /**
     * 
     * @Title: ActivityPropaganda @description 宣传语 @param 参数 @return Alert
     *         返回类型 @throws
     */
    public static String ActivityPropaganda(String input, SeleniumUtil seleniumUtil)
    {
        String str = null;
        if (input.length() >= 30)
        {
            seleniumUtil.clear(ActivityElements.AE_INPUT_PROPAGANDA);
            seleniumUtil.type(ActivityElements.AE_INPUT_PROPAGANDA, input);
            seleniumUtil.click(ProjectSettingPageElements.PS_IMG_PHONE);
            Alert alert = seleniumUtil.switchToPromptedAlertAfterWait(2000);
            str = alert.getText();
            seleniumUtil.pause(2000);
            alert.accept();
        } else
        {
            seleniumUtil.clear(ActivityElements.AE_INPUT_PROPAGANDA);
            seleniumUtil.type(ActivityElements.AE_INPUT_PROPAGANDA, input);
            seleniumUtil.click(ProjectSettingPageElements.PS_IMG_PHONE);
            WebElement element = driver.findElement(ActivityElements.AE_ELEMENT_IPHONE_PROPAGANDA);
            str = element.getText();
        }
        return str;
    }

    /**
     * 
     * @Title: ActivityExplain @description 活动说明 @param 参数 @return Alert
     *         返回类型 @throws
     */
    public static String ActivityExplain(String input, SeleniumUtil seleniumUtil)
    {
        String str = null;
        if (input.length() >= 50)
        {
            seleniumUtil.clear(ActivityElements.AE_INPUT_EXPLAIN);
            seleniumUtil.type(ActivityElements.AE_INPUT_EXPLAIN, input);
            seleniumUtil.click(ProjectSettingPageElements.PS_IMG_PHONE);
            Alert alert = seleniumUtil.switchToPromptedAlertAfterWait(2000);
            str = alert.getText();
            seleniumUtil.pause(2000);
            alert.accept();
        } else
        {
            seleniumUtil.clear(ActivityElements.AE_INPUT_EXPLAIN);
            seleniumUtil.type(ActivityElements.AE_INPUT_EXPLAIN, input);
            seleniumUtil.click(ProjectSettingPageElements.PS_IMG_PHONE);
            WebElement element = driver.findElement(ActivityElements.AE_ELEMENT_IPHONE_EXPLAIN);
            str = element.getText();
        }
        return str;
    }

    /**
     * 
     * @Title: ActivityLink @description 活动详情连接 @param 参数 @return Alert
     *         返回类型 @throws
     */
    public static String ActivityLink(String input, SeleniumUtil seleniumUtil)
    {
        String str = null;
        {
            seleniumUtil.pause(2000);
            JavascriptExecutor js = (JavascriptExecutor) SeleniumUtil.driver;
            js.executeScript("arguments[0].scrollIntoView(true)",
                    SeleniumUtil.driver.findElement(ActivityElements.AE_INPUT_LINK));
            seleniumUtil.clear(ActivityElements.AE_INPUT_LINK);
            seleniumUtil.type(ActivityElements.AE_INPUT_LINK, input);
            seleniumUtil.click(ProjectSettingPageElements.PS_IMG_PHONE);
            WebElement element = driver.findElement(ActivityElements.AE_ELEMENT_IPHONE_LINK);
            str = element.getAttribute("href");
            System.out.println(str);
        }
        return str;
    }

    /**
     * 
     * @throws IOException
     * @Title: ActivityIMGUpload @description 活动图片上传 @param 参数 @return Alert
     *         返回类型 @throws
     */
    public static void ActivityIMGUpload(String input, SeleniumUtil seleniumUtil) throws IOException
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(ActivityElements.AE_BTN_ACTIVITY));
        seleniumUtil.click(ActivityElements.AE_BTN_ACTIVITY);
        seleniumUtil.pause(2000);
        // seleniumUtil.click(ActivityElements.AE_BTN_SERVICEIMG);
        WebElement serviceBTN = driver.switchTo().frame("myActiviframPic")
                .findElement(ActivityElements.AE_BTN_SERVICEIMG);
        File file = new File(input);
        String musicPath = file.getAbsolutePath();
        // driver.switchTo().frame("myActiviframPic");
        serviceBTN.sendKeys(musicPath);
        // seleniumUtil.click(ActivityElements.AE_BTN_SERVICEIMG);
        seleniumUtil.pause(2000);
        // Runtime.getRuntime().exec("./res/script/autoit/UploadActivityImg.exe");
        // seleniumUtil.pause(2000);
        driver.switchTo().defaultContent();
        seleniumUtil.pause(2000);
        // List<WebElement> list =
        // driver.findElements(ActivityElements.AE_LIST_ACTIVITY);
        // int imgCount = list.size();
        // return imgCount;
    }

    /**
     * 
     * @throws IOException
     * @Title: ActivityIMGUpload @description 活动图片上传 @param 参数 @return Alert
     *         返回类型 @throws
     */
    public static void ActivityIMGUpload_1(String input, SeleniumUtil seleniumUtil)
    {
        WebElement serviceBTN = driver.switchTo().frame("myActiviframPic")
                .findElement(ActivityElements.AE_BTN_SERVICEIMG);
        File file = new File(input);
        String musicPath = file.getAbsolutePath();
        serviceBTN.sendKeys(musicPath);
        seleniumUtil.pause(2000);
        driver.switchTo().defaultContent();
        seleniumUtil.pause(2000);
    }


    /**
     * 
     * @Title: ActivityIMGDEL @description 活动图片删除 @param 参数 @return Alert
     *         返回类型 @throws
     */
    public static void ActivityIMGDEL(SeleniumUtil seleniumUtil)
    {
        WebElement serviceIMG = driver.findElement(ActivityElements.AE_LIST_ACTIVITY);
        seleniumUtil.mouseMoveToElement(serviceIMG);
        seleniumUtil.pause(2000);
        seleniumUtil.click(ActivityElements.AE_BTN_IMGREMOVE);
        seleniumUtil.pause(2000);
        Alert alert = seleniumUtil.switchToPromptedAlertAfterWait(2000);
        alert.accept();
    }

    /**
     * 
     * @Title: ActivityIMGList @description 上传的活动图片数量 @param 参数 返回类型 @throws
     */
    public static int ActivityIMGList(SeleniumUtil seleniumUtil)
    {
        List<WebElement> activityList = driver.findElements(ActivityElements.AE_LIST_ACTIVITYLIST);
        int count = activityList.size();
        return count;
    }
}
