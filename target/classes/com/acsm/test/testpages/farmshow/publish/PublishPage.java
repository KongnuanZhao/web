package com.acsm.test.testpages.farmshow.publish;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.acsm.test.testpages.farmshow.corver.ProjectSettingPageElements;
import com.acsm.test.utils.SeleniumUtil;

public class PublishPage
{
    public static Logger logger = Logger.getLogger(SeleniumUtil.class.getName());

    /**
     * @description 点击发布
     * @author GuoKuo
     */

    public static String publicShow(SeleniumUtil seleniumUtil)
    {
        seleniumUtil.pause(2000);
        WebElement goToProjectSettingPage = SeleniumUtil.driver
                .findElement(ProjectSettingPageElements.PS_BTN_PROJECTSETTING);
        goToProjectSettingPage.click();
        JavascriptExecutor js = (JavascriptExecutor) SeleniumUtil.driver;
        js.executeScript("arguments[0].scrollIntoView(true)",
                SeleniumUtil.driver.findElement(ProjectSettingPageElements.PS_BTN_PUBLISH));
//        seleniumUtil.executeJS("arguments[0].scrollIntoView(true)", SeleniumUtil.driver.findElement(ProjectSettingPageElements.PS_BTN_PUBLISH));
        seleniumUtil.click(ProjectSettingPageElements.PS_BTN_PUBLISH);
        seleniumUtil.pause(3000);
        String str = SeleniumUtil.driver.getCurrentUrl().substring(0, 51);
        return str;
    }

    /**
     * @description 验证是否生成农场秀
     * @author GuoKuo
     */

    public static int showCount(SeleniumUtil seleniumUtil)
    {
        List<WebElement> currentFarmShow = SeleniumUtil.driver.findElements(By.cssSelector("ul.c-list li"));
        int currentCount = currentFarmShow.size();
        return currentCount;
    }

    /**
     * @description 搜索功能验证
     * @author GuoKuo
     */

    public static void search(SeleniumUtil seleniumUtil, String str)
    {
        WebElement searchInput = SeleniumUtil.driver.findElement(PublichElements.PE_BTN_SEARCH);

        seleniumUtil.clear(PublichElements.PE_BTN_SEARCH);
        seleniumUtil.type(PublichElements.PE_BTN_SEARCH, str);

        // 模拟键盘回车操作
        seleniumUtil.pressKeysOnKeyboard(searchInput, Keys.ENTER, "");

        if (PublishPage.showCount(seleniumUtil) == 0)
        {
            logger.info("没有标题为：“" + str+ "”的农场秀");
        } else
        {
            WebElement element = SeleniumUtil.driver.findElement(PublichElements.PE_STR_PROPAGANDASLISTTITLE);
            String title = element.getAttribute("title");
            if (title == str)
            {
                logger.info("找到标题为：" + title + "的农场秀");

            }
        }
    }

    /**
     * @description 点击农场秀
     * @author GuoKuo
     */

    public static boolean showClick(SeleniumUtil seleniumUtil)
    {
        WebElement holdOnFarmShowDemo = SeleniumUtil.driver.findElement(By.cssSelector("ul.c-list li"));
        holdOnFarmShowDemo.click();
        seleniumUtil.pause(2000);
        return seleniumUtil.switchToWindow("农场", seleniumUtil);
    }

    /**
     * @description 获取图片地址
     * @author GuoKuo
     */

    public static String getLogoAddress(SeleniumUtil seleniumUtil)
    {
        JavascriptExecutor js = (JavascriptExecutor) SeleniumUtil.driver;
        js.executeScript("arguments[0].scrollIntoView(true)",
                SeleniumUtil.driver.findElement(PublichElements.PE_STR_PICADD));
        return SeleniumUtil.driver.findElement(PublichElements.PE_STR_PICADD).getAttribute("src");
    }

    /**
     * @description 获取项目描述
     * @author GuoKuo
     */

    public static String getProjectDescription(SeleniumUtil seleniumUtil)
    {
        JavascriptExecutor js = (JavascriptExecutor) SeleniumUtil.driver;
        js.executeScript("arguments[0].scrollIntoView(true)",
                SeleniumUtil.driver.findElement(PublichElements.PE_STR_DESCRIPTION));
        return SeleniumUtil.driver.findElement(PublichElements.PE_STR_DESCRIPTION).getText();
    }

    /**
     * @description 获取农场地址
     * @author GuoKuo
     */

    public static String getFarmAddress(SeleniumUtil seleniumUtil)
    {
        JavascriptExecutor js = (JavascriptExecutor) SeleniumUtil.driver;
        js.executeScript("arguments[0].scrollIntoView(true)",
                SeleniumUtil.driver.findElement(PublichElements.PE_STR_FARMADD));
        return SeleniumUtil.driver.findElement(PublichElements.PE_STR_FARMADD).getText();
    }

}
