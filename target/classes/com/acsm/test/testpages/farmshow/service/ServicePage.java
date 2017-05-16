package com.acsm.test.testpages.farmshow.service;

import java.io.File;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.acsm.test.testpages.farmshow.corver.ProjectSettingPageElements;
import com.acsm.test.testpages.farmshow.specalproduct.SpecialProductsElements;
import com.acsm.test.utils.SeleniumUtil;

/**
 * @ClassName: SerivcePage
 * @Description: 我们的服务
 * @author GuoKuo
 * @date 2016年7月12日
 *
 */
public class ServicePage
{
    public static Logger logger = Logger.getLogger(ServicePage.class);
    public static WebDriver driver = SeleniumUtil.driver;

    /**
     * @author Young
     * @description 
     * @param seleniumUtil
     */
    public static String servicePage(SeleniumUtil seleniumUtil)
    {

        // 进入我们的服务
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(ServiceElements.SE_STRING_PAGENAME));
//        seleniumUtil.click(ServiceElements.SE_STRING_PAGENAME);
        WebElement element =driver.findElement(ServiceElements.SE_STRING_PAGENAME);
        element.click();
        return seleniumUtil.getText(ServiceElements.SE_STRING_PAGENAME);
    }

    /**
     * @Title: pageTitleByDefault @Description: 获取页面主题 @param 参数 @return void
     *         返回类型 @throws
     */
    public static String servicePageTitleByDefault(SeleniumUtil seleniumUtil)
    {

        // 验证默认项目名称
        WebElement getProjectName = driver.findElement(ServiceElements.SE_PAGE_TITLE);
        return getProjectName.getAttribute("value");
    }

    /**
     * @Title: pageTitleEdit @Description: 更换页面主题 @param 参数 @return void
     *         返回类型 @throws
     */
    public static String ServicePageTitleEdit(String input, SeleniumUtil seleniumUtil)
    {
        String str = null;
        // 验证默认项目名称
        if (input.length() >= 10)
        {
            seleniumUtil.clear(ServiceElements.SE_PAGE_TITLE);
            seleniumUtil.type(ServiceElements.SE_PAGE_TITLE, input);
            seleniumUtil.click(ProjectSettingPageElements.PS_IMG_PHONE);
            Alert alert = seleniumUtil.switchToPromptedAlertAfterWait(2000);
            str = alert.getText();
            seleniumUtil.pause(2000);
            alert.accept();
        } else
        {
            seleniumUtil.clear(ServiceElements.SE_PAGE_TITLE);
            seleniumUtil.type(ServiceElements.SE_PAGE_TITLE, input);
            seleniumUtil.click(ProjectSettingPageElements.PS_IMG_PHONE);
            WebElement element = driver.findElement(ServiceElements.SE_PHONE_TITLE);
            str = element.getText();
        }
        return str;
    }

    /**
     * @Title: serviceImgBTN @Description: 点击上传服务按钮 @param 参数 @return void
     *         返回类型 @throws
     */
    public static WebElement serviceImgUpload(SeleniumUtil seleniumUtil)
    {
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(ServiceElements.SE_BTN_ADDSERVICE));
        seleniumUtil.click(ServiceElements.SE_BTN_ADDSERVICE);
        seleniumUtil.pause(2000);
        seleniumUtil.waitForElementToLoad(3000, ServiceElements.SE_DIALOG_ADDSERVICE);
        WebElement uploadDialog = driver.findElement(ServiceElements.SE_DIALOG_ADDSERVICE);
        return uploadDialog;
    }

    /**
     * @Title: serviceIMGUpload @Description: 上传服务图片 @param 参数 @return void
     *         返回类型 @throws
     */
    public static String serviceIMGUpload(String str,SeleniumUtil seleniumUtil)
    {
        //进入iFrame
        WebElement serviceBTN = driver.switchTo().frame("myframPic2").findElement(ServiceElements.SE_BTN_SERVICEIMG);
        File file = new File(str);
        String musicPath = file.getAbsolutePath();
        serviceBTN.sendKeys(musicPath);
        driver.switchTo().defaultContent();
        return str;
    }
    
    /**
     * @Title: serviceNameInput @Description: 修改服务名称  @param 参数 @return void
     *         返回类型 @throws
     */
    public static void serviceNameInput(String str,SeleniumUtil seleniumUtil)
    {
        WebElement serviceNameInput = driver.findElement(ServiceElements.SE_INPUT_SERVICENAME);
        serviceNameInput.clear();
        serviceNameInput.click();
        seleniumUtil.type(ServiceElements.SE_INPUT_SERVICENAME, str);
        seleniumUtil.pause(2000);
    }
    
    /**
     * @Title: descripitonInput @Description: 修改服务描述  @param 参数 @return void
     *         返回类型 @throws
     */
    public static String descripitonInput(String str,SeleniumUtil seleniumUtil)
    {
        seleniumUtil.pause(2000);

        seleniumUtil.type(ServiceElements.SE_INPUT_SERVICEDIALOG, str);
        seleniumUtil.pause(2000);
        
        return str;
    }
    
    /**
     * @Title: confirm @Description: 点击确定  @param 参数 @return void
     *         返回类型 @throws
     */
    public static void Confirm(SeleniumUtil seleniumUtil)
    {
        WebElement Confirm = driver.findElement(ServiceElements.SE_INPUT_CONFIRM);
        Confirm.click();
        seleniumUtil.pause(2000);
    }
    
    /**
     * @Title: ServiceName @Description: 获取修改的项目名称  @param 参数 @return void
     *         返回类型 @throws
     */
    public static String ServiceName(SeleniumUtil seleniumUtil)
    {
        WebElement sName = driver.findElement(ServiceElements.SE_NAME_SERVICE);
        String actureName = sName.getText();
        return actureName;
    }
    
    /**
     * @Title: ServiceDescription @Description: 获取修改的描述  @param 参数 @return void
     *         返回类型 @throws
     */
    public static String ServiceDescription(SeleniumUtil seleniumUtil)
    {
        WebElement sName = driver.findElement(ServiceElements.SE_DESCRIPTRION_SERVICE);
        String actureName = sName.getText();
        return actureName;
    }

}
