package com.acsm.test.testpages.farmshow.ourteam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.acsm.test.testpages.farmshow.corver.ProjectSettingPageElements;
import com.acsm.test.testpages.farmshow.ourhonor.OurHonorElements;
import com.acsm.test.utils.SeleniumUtil;

/**
 * @ClassName: OurTeamPage
 * @Description: 我们的团队测试用例
 * @author Kuu
 * @date 2016年7月13日
 *
 */

public class OurTeamPage
{
    public static Logger logger = Logger.getLogger(SeleniumUtil.class.getName());
    public static WebDriver driver = SeleniumUtil.driver;
    
    /**
     * @Title: ourTeamPage
     * @Description: 进入我们的团队
     * @param 参数
     * @return void
     */
    public static String ourTeamPage(SeleniumUtil seleniumUtil)
    {
        // 进入我们的团队
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(OurTeamElements.CLICK_OUR_TEAM));
//        seleniumUtil.click(OurTeamElements.CLICK_OUR_TEAM);
        WebElement element =driver.findElement(OurTeamElements.CLICK_OUR_TEAM);
        element.click();
        return seleniumUtil.getText(OurTeamElements.OH_STRING_PAGENAME);
    }

    /**
     * @Title: teamPageTitleByDefault
     * @Description: 获取页面主题
     * @param 参数
     * @return
     */
    public static String teamPageTitleByDefault(SeleniumUtil seleniumUtil)
    {
        // 验证默认项目名称
        WebElement getProjectName = driver.findElement(OurTeamElements.GET_PAGE_TITLE);
        return getProjectName.getAttribute("value");
    }

    /**
     * @Title: teamPageTitleEdit @Description: 更换页面主题 @param 参数 @return void
     *         返回类型 @throws
     */
    public static Alert teamPageTitleEdit(SeleniumUtil seleniumUtil)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(OurTeamElements.CLICK_OUR_TEAM));
        seleniumUtil.click(OurTeamElements.CLICK_OUR_TEAM);
        // 验证默认项目名称
        seleniumUtil.type(OurTeamElements.GET_PAGE_TITLE, "我们的团队我们的团队我们的团队我们的团队");
        seleniumUtil.click(ProjectSettingPageElements.PS_IMG_PHONE);
        Alert alert = seleniumUtil.switchToPromptedAlertAfterWait(2000);
        System.out.println(alert.getText());
        return alert;

    }

    /**
     * @Title: teamMemberSelected @Description: 选择团队成员 @param 参数 @return void
     *         返回类型 @throws
     */
    public static int teamMemberSelected(SeleniumUtil seleniumUtil)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(OurTeamElements.CLICK_OUR_TEAM));
        seleniumUtil.click(OurTeamElements.CLICK_OUR_TEAM);
        /** 点击选择图片 */
        seleniumUtil.click(OurTeamElements.SELECT_IMAGE);
        seleniumUtil.waitForElementToLoad(1000, OurTeamElements.IMAGE_SELECT_DIALOG);
        List<WebElement> list = seleniumUtil.findElementsBy(OurTeamElements.IMAGE_SELECT_DIALOG);
        list.get(0).click();
        list.get(1).click();
        list.get(2).click();
        list.get(3).click();
        list.get(4).click();

//        int[] arr = seleniumUtil.randomList(list);
//        seleniumUtil.pause(1000);
//        list.get(arr[0]).click();
//        list.get(arr[1]).click();
//        list.get(arr[2]).click();
//        list.get(arr[3]).click();
        seleniumUtil.pause(1000);
        /** 点击确认 */
        seleniumUtil.click(OurTeamElements.CONFIRM_BUTTON);
        seleniumUtil.pause(2000);

        List<WebElement> imgCount = seleniumUtil.findElementsBy(OurTeamElements.OT_LIST_MEMEBERLIST);
        return imgCount.size();
    }

    /**
     * @Title: teamMemberDelete @Description: 删除团队成员 @param 参数 @return void
     *         返回类型 @throws
     */
    public static Map<String, Integer> teamMemberDelete(SeleniumUtil seleniumUtil)
    {
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(OurTeamElements.CLICK_OUR_TEAM));
        seleniumUtil.click(OurTeamElements.CLICK_OUR_TEAM);
        
        List<WebElement> list = seleniumUtil.findElementsBy(OurTeamElements.OT_LIST_MEMEBERLIST);
        int imgUploaded = list.size();
        seleniumUtil.mouseMoveToElement(OurTeamElements.OT_LIST_MEMEBERLIST);
        seleniumUtil.click(OurTeamElements.OT_LIST_MEMEBERDELETE);
        Alert alert = seleniumUtil.switchToPromptedAlertAfterWait(2000);
        alert.accept();
        List<WebElement> list_1 = seleniumUtil.findElementsBy(OurTeamElements.OT_LIST_MEMEBERLIST);
        int afterDelete = list_1.size();
        Map<String, Integer> count = new HashMap<String, Integer>();
        count.put("resource", imgUploaded);
        count.put("target", afterDelete);
        return count;
    }
    
    /**
     * @Title: teamMemberAddAfterDelete @Description: 删除团队成员后添加 @param 参数 @return void
     *         返回类型 @throws
     */
    public static void teamMemberAddAfterDelete(SeleniumUtil seleniumUtil)
    {
        /** 点击选择图片 */
        seleniumUtil.pause(2000);
        seleniumUtil.click(OurTeamElements.SELECT_IMAGE);
        seleniumUtil.waitForElementToLoad(1000, OurTeamElements.IMAGE_SELECT_DIALOG);
        
        List<WebElement> list = seleniumUtil.findElementsBy(OurTeamElements.IMAGE_SELECT_DIALOG);
        list.get(0).click();
        seleniumUtil.pause(1000);
        seleniumUtil.click(OurTeamElements.CONFIRM_BUTTON);
        seleniumUtil.pause(2000);
    }

}
