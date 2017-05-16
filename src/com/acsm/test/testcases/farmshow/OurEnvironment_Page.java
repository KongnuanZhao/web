package com.acsm.test.testcases.farmshow;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.testng.annotations.Test;
import com.acsm.test.base.BaseParpare;
import com.acsm.test.testpages.farmshow.environment.OurEnviromentElements;
import com.acsm.test.testpages.farmshow.environment.OurEnvironmentPage;
import com.acsm.test.utils.SeleniumUtil;

/**
 * @author GuoKuo
 * @description 我们的环境
 */

public class OurEnvironment_Page extends BaseParpare
{
    public static Logger logger = Logger.getLogger(SeleniumUtil.class.getName());

    /**
     * @description 进入我们的环境
     */
    @Test(groups =
    { "environment" }, alwaysRun = true)
    public void ourEnvironment()
    {
        OurEnvironmentPage.ourEnvironment(BaseParpare.seleniumUtil);
    }

    /**
     * @description 验证标题
     */
    @Test(groups =
    { "environment" }, alwaysRun = true, dependsOnMethods =
    { "ourEnvironment" })
    public void envPageTitle()
    {
        String actual = OurEnvironmentPage.getOurEnvironment(BaseParpare.seleniumUtil);
        seleniumUtil.isTextCorrect(actual, "我们的环境");
    }

    /**
     * @description 修改标题
     */
    @Test(groups =
    { "environment" }, alwaysRun = true,dependsOnMethods =
        { "ourEnvironment" })
    public void editEnvPageTitle()
    {
        Alert alert = OurEnvironmentPage.updatePageTitle(BaseParpare.seleniumUtil);
        logger.info(alert.getText());
        seleniumUtil.isTextCorrect("页面主题最多能为10个字！", alert.getText());
        alert.accept();
        seleniumUtil.clear(OurEnviromentElements.OE_INPUT_PAGETIELE);
        seleniumUtil.type(OurEnviromentElements.OE_INPUT_PAGETIELE, "我们的环境");
    }

    /**
     * @description 勾选洗肺指数
     */
    @Test(groups =
    { "environment" }, alwaysRun = true,dependsOnMethods =
        { "ourEnvironment" })
    public void healthSelected()
    {
        int unselected = OurEnvironmentPage.ourEnvironment3(BaseParpare.seleniumUtil);
        if (unselected == 5)
            logger.info("洗肺指数勾选成功");
        else
        {
            logger.info("洗肺指数未被勾选");
        }
    }
}