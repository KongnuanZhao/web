package com.acsm.test.testpages.farmshow.skill;

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
 * @ClassName: SpecialSkill_Page
 * @Description: 特色种植技术测试用例
 * @author GuoKuo
 * @date 2016年7月12日
 *
 */

public class SpecialSkillPage
{
    public static Logger logger = Logger.getLogger(SeleniumUtil.class.getName());
    public static WebDriver driver = SeleniumUtil.driver;

    /**
     * 
     * @Title: specialSkillPage @description: 进入特色种植 @param 参数 @return String
     *         返回类型 @throws
     */
    public static String specialSkillPage(SeleniumUtil seleniumUtil)
    {
        // 进入特色种植
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",
                driver.findElement(SpecialSkillElements.CLICK_SPECIAL_PAGE));
        WebElement element =driver.findElement(SpecialSkillElements.CLICK_SPECIAL_PAGE);
        element.click();
//        seleniumUtil.click(SpecialSkillElements.CLICK_SPECIAL_PAGE);
        return seleniumUtil.getText(SpecialSkillElements.SS_STRING_PAGENAME);
    }

    /**
     * 
     * @Title: pageTitleByDefault @description: 获取页面主题 @param 参数 @return String
     *         返回类型 @throws
     */
    public static String skillPageTitleByDefault()
    {
        // 验证默认项目名称
        WebElement getProjectName = driver.findElement(SpecialSkillElements.PAGE_TITLE);
        return getProjectName.getAttribute("value");

    }

    /**
     * 
     * @Title: pageTitleEdit @description: 更换页面主题 @param 参数 @return void
     *         返回类型 @throws
     */
    public static Alert skillPageTitleEdit(SeleniumUtil seleniumUtil)
    {
        // 验证默认项目名称
        seleniumUtil.type(SpecialSkillElements.PAGE_TITLE, "特色种植技术特色种植技术");
        seleniumUtil.click(ProjectSettingPageElements.PS_IMG_PHONE);
        Alert alert = seleniumUtil.switchToPromptedAlertAfterWait(2000);
        logger.info(alert.getText());
        return alert;
    }

    /**
     * 
     * @Title: singleImgUpload @description: 上传单图 @param 参数 @return map
     *         返回类型 @throws
     */
    public static Map<String, String> singleImgUpload(SeleniumUtil seleniumUtil)
    {
        seleniumUtil.click(SpecialSkillElements.SINGLE_PIC); // 点击上传单图
        seleniumUtil.pause(2000);
        seleniumUtil.waitForElementToLoad(1000, SpecialSkillElements.AUTH_ADD_DIALOG);// 等待对话框
        List<WebElement> selectSingleAuthPic = seleniumUtil.findElementsBy(SpecialSkillElements.AUTH_PIC);// 把照片存到数组
        selectSingleAuthPic.get(2).click();

        // int[] arr = seleniumUtil.randomList(selectSingleAuthPic);
        // seleniumUtil.pause(2000);
        // selectSingleAuthPic.get(arr[0]).click();
        // seleniumUtil.pause(2000);
        seleniumUtil.click(SpecialSkillElements.ACCEPT_CLICK); // 点击上传单图確認
        seleniumUtil.pause(1000);
        String uploadedAddress = driver.findElement(SpecialSkillElements.SINGLE_PIC_ADDRESS).getAttribute("src");
        String actureAddress = driver.findElement(SpecialSkillElements.SINGLE_PIC_ACTURE_ADDRESS).getAttribute("src");
        Map<String, String> count = new HashMap<String, String>();
        count.put("resource", uploadedAddress);
        count.put("target", actureAddress);
        return count;
    }

    /**
     * 
     * @Title: singleImgName @description: 单图名称 @param 参数 @return void
     *         返回类型 @throws
     */
    public static void singleImgName(SeleniumUtil seleniumUtil)
    {
        /** 单图编辑名称 */
        seleniumUtil.executeJS("arguments[0].scrollIntoView(true)",
                driver.findElement(SpecialSkillElements.SINGLE_PIC_INPUT));
        seleniumUtil.clear(SpecialSkillElements.SINGLE_PIC_INPUT);
        seleniumUtil.type(SpecialSkillElements.SINGLE_PIC_INPUT, "单图认证啊");
        seleniumUtil.click(ProjectSettingPageElements.PS_IMG_PHONE);
        Alert alert = seleniumUtil.switchToPromptedAlertAfterWait(2000);
        String alertInfo = alert.getText();
        seleniumUtil.isTextCorrect(alertInfo, "证书名称最多能为4个字！");
        alert.accept();
    }

    /**
     * 
     * @Title: multiImgUpload @description: 上传多图 @param 参数 @return void
     *         返回类型 @throws
     */
    public static void multiImgUpload(SeleniumUtil seleniumUtil)
    {
        seleniumUtil.executeJS("arguments[0].scrollIntoView(true)", driver.findElement(SpecialSkillElements.MULTI_PIC));
        seleniumUtil.click(SpecialSkillElements.MULTI_PIC); // 点击上传多图
        seleniumUtil.waitForElementToLoad(1000, SpecialSkillElements.AUTH_ADD_DIALOG);// 等待对话框
        List<WebElement> selectMultyAuthPic = seleniumUtil.findElementsBy(SpecialSkillElements.AUTH_PIC);
        seleniumUtil.pause(1000);
        selectMultyAuthPic.get(3).click();
        selectMultyAuthPic.get(5).click();
        seleniumUtil.pause(1000);
        seleniumUtil.click(SpecialSkillElements.ACCEPT_CLICK); // 点击上传多图確認
        seleniumUtil.pause(1000);
    }

    /**
     * 
     * @Title: multiImgName @description: 多图认证文字 @param 参数 @return alert
     *         返回类型 @throws
     */
    public static Alert multiImgName(SeleniumUtil seleniumUtil)
    {
        seleniumUtil.executeJS("arguments[0].scrollIntoView(true)",
                driver.findElement(SpecialSkillElements.MULTI_PIC_INPUT));
        seleniumUtil.pause(2000);
        seleniumUtil.type(SpecialSkillElements.MULTI_PIC_INPUT, "多图认证多图认证多图认证多图认证多图认证多图认证");
        seleniumUtil.click(ProjectSettingPageElements.PS_IMG_PHONE);
        Alert alert = seleniumUtil.switchToPromptedAlertAfterWait(2000);
        return alert;
    }

    /**
     * 
     * @Title: multiImgDEL @description: 删除多图认证中一个图片 @param 参数 @return alert
     *         返回类型 @throws
     */
    public static int multiImgDEL(SeleniumUtil seleniumUtil)
    {
        seleniumUtil.executeJS("arguments[0].scrollIntoView(true)", driver.findElement(SpecialSkillElements.MULTI_PIC));
        seleniumUtil.mouseMoveToElement(SpecialSkillElements.MULTI_IMG);
        seleniumUtil.pause(1000);
        seleniumUtil.click(SpecialSkillElements.MULTI_IMG_DELETE);
        Alert alert = seleniumUtil.switchToPromptedAlertAfterWait(2000);
        alert.accept();
        seleniumUtil.pause(1000);
        List<WebElement> multi = driver.findElements(SpecialSkillElements.SS_LIST_MULTIIMG1);
        return multi.size();
    }
    
    /**
     * 
     * @Title: multiImgAddDEL @description: 删除后重新添加 @param 参数 @return alert
     *         返回类型 @throws
     */
    public static void multiImgAddDEL(SeleniumUtil seleniumUtil)
    {
        seleniumUtil.executeJS("arguments[0].scrollIntoView(true)", driver.findElement(SpecialSkillElements.MULTI_PIC));
        seleniumUtil.click(SpecialSkillElements.MULTI_PIC); // 点击上传多图
        seleniumUtil.waitForElementToLoad(1000, SpecialSkillElements.AUTH_ADD_DIALOG);// 等待对话框
        List<WebElement> selectMultyAuthPic = seleniumUtil.findElementsBy(SpecialSkillElements.AUTH_PIC);
        seleniumUtil.pause(1000);
        selectMultyAuthPic.get(3).click();
        seleniumUtil.pause(1000);
        seleniumUtil.click(SpecialSkillElements.ACCEPT_CLICK); // 点击上传多图確認
    }
}
