package com.acsm.test.testpages.farmshow.environment;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.acsm.test.testpages.farmshow.corver.ProjectSettingPageElements;
import com.acsm.test.utils.SeleniumUtil;

/**
 * @ClassName: OurEnvPage
 * @Description: 我们的环境-修改主题，勾选矽肺指数
 * @author Kuu
 * @date 2016年7月7日
 *
 */

public class OurEnvironmentPage
{

    public static Logger logger = Logger.getLogger(SeleniumUtil.class.getName());

    /**
     * @Title: ourEnvironment @Description: 进入我们的环境 @param @param seleniumUtil
     *         参数 @return void 返回类型 @throws
     */
    public static void ourEnvironment(SeleniumUtil seleniumUtil)
    {
        /** 点击我们的环境 */
        WebElement clickOurPosition = SeleniumUtil.driver.findElement(By.cssSelector("ul.leftSide li:nth-child(3)"));
        clickOurPosition.click();
    }

    /**
     * @Title: getOurEnvironment
     * @Description: 获取页面主题
     */
    public static String getOurEnvironment(SeleniumUtil seleniumUtil)
    {

        /** 获取页面主题 */
        String pageTitle = SeleniumUtil.driver.findElement(OurEnviromentElements.OE_INPUT_PAGETIELE)
                .getAttribute("value");
        return pageTitle;
    }

    /**
     * @Title: updatePageTitle
     * @Description: 修改页面主题
     */
    public static Alert updatePageTitle(SeleniumUtil seleniumUtil)
    {
        seleniumUtil.clear(OurEnviromentElements.OE_INPUT_PAGETIELE);
        seleniumUtil.type(OurEnviromentElements.OE_INPUT_PAGETIELE, "我们的环境我们的环境我们的环境");
        seleniumUtil.click(ProjectSettingPageElements.PS_IMG_PHONE);
        Alert alert = seleniumUtil.switchToPromptedAlertAfterWait(2000);
        return alert;
    }

    
    public static int ourEnvironment3(SeleniumUtil seleniumUtil)
    {
        seleniumUtil.pause(2000);
        /** 勾选洗肺指数 */
        SeleniumUtil.driver.findElement(OurEnviromentElements.OE_CHECKBOX_CLEAN).click();
        List<WebElement> unselected = SeleniumUtil.driver.findElements(OurEnviromentElements.OE_LIST_STARSLIST);
        return unselected.size();
    }

}