package com.acsm.test.testcases.farmshow;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.acsm.test.base.BaseParpare;
import com.acsm.test.testcases.farmshow.corver.ProjectSetting_Page;
import com.acsm.test.testpages.farmshow.CreatFarmShow_NoneCompanyInfo;
import com.acsm.test.testpages.farmshow.publish.PublishPage;
import com.acsm.test.utils.SeleniumUtil;

/**
 * 
    * @ClassName: Publish_Page
    * @Description: 发布
    * @author Kuu
    * @date 2016年11月8日
    *
 */
public class Publish_Page extends BaseParpare
{
    public static Logger logger = Logger.getLogger(SeleniumUtil.class.getName());
    public static WebDriver driver = SeleniumUtil.driver;

    /**
     * @description 点击发布，查看是否创建成功
     * @author GuoKuo
     */
    @Test(groups =
    { "propagandas" }, alwaysRun = true)
    public void PropagandasPage()
    {
        String expectURL = "http://cs1.nongchangyun.cn/map/PropagandasList.seam";
        String actualURL = PublishPage.publicShow(BaseParpare.seleniumUtil);
        seleniumUtil.pause(3000);
        seleniumUtil.isTextCorrect(actualURL, expectURL);
    }

    /**
     * @description 对比数量，确保生成
     * @author GuoKuo
     * 
     */
    @Test(groups =
    { "propagandas" }, alwaysRun = true, dependsOnMethods =
    { "PropagandasPage" })
    public void PropagandasList()
    {
        int beforeCreated = CreatFarmShow_NoneCompanyInfo.beforeCreateFarmShow;
        int currentCount = PublishPage.showCount(seleniumUtil);
        if (currentCount == beforeCreated + 1)
        {
            logger.info("农场秀由" + beforeCreated + "变成" + currentCount + "个，创建成功");
        }
    }

    /**
     * @description 搜索功能验证
     * @author GuoKuo
     */
    @Test(groups =
    { "propagandas" }, alwaysRun = true, dependsOnMethods =
    { "PropagandasList" })
    public void searchFunction()
    {
        String input = ProjectSetting_Page.projectName;
        if (input != null)
        {
            PublishPage.search(BaseParpare.seleniumUtil, input);
            System.out.println(input);
        }else{
            input= "您“看得见”的好农场";
            PublishPage.search(BaseParpare.seleniumUtil, input);
        }
    }

    /**
     * @description 切换
     * @author GuoKuo
     */
    @Test(groups =
    { "propagandas" }, alwaysRun = true, dependsOnMethods =
    { "searchFunction" })
    public void switchToPropagandas()
    {
        WebElement holdOnFarmShowDemo = SeleniumUtil.driver.findElement(By.cssSelector("ul.c-list li"));
        holdOnFarmShowDemo.click();
        seleniumUtil.pause(2000);
        seleniumUtil.switchToWindow("农场", BaseParpare.seleniumUtil);
        seleniumUtil.pause(2000);
    }

    /**
     * @description 测试上传数据正确性
     */
//    @Test(groups =
//    { "propagandas" }, alwaysRun = true, dependsOnMethods =
//    { "switchToPropagandas" })
//    public void scrollFramShow()
//    {
//        seleniumUtil.pause(3000);
//        seleniumUtil.inFrame("ifr");
//        seleniumUtil.click(By.cssSelector("div.show"));
//        seleniumUtil.pause(3000);
//        // 首页-验证图片
//        String picAddress = PublishPage.getLogoAddress(BaseParpare.seleniumUtil);
//        seleniumUtil.isTextCorrect(picAddress,
//                "http://img3.farmeasy.cn/00003323/enterprise/20160414/1460640462023862a3.jpg");
//
//        // 农场实景
//        seleniumUtil.pause(3000);
//        JavascriptExecutor js = (JavascriptExecutor) SeleniumUtil.driver;
//        js.executeScript("arguments[0].scrollIntoView(true)",
//                SeleniumUtil.driver.findElement(PublichElements.PE_STR_PAGENAME_1));
//        logger.info("找到“我们的位置”");
//        seleniumUtil.pause(2000);
//        js.executeScript("arguments[0].scrollIntoView(true)",
//                SeleniumUtil.driver.findElement(PublichElements.PE_STR_PAGENAME_2));
//        logger.info("找到“我们的环境”");
//        seleniumUtil.pause(2000);
//        js.executeScript("arguments[0].scrollIntoView(true)",
//                SeleniumUtil.driver.findElement(PublichElements.PE_STR_PAGENAME_3));
//        logger.info("找到“特色种植技术”");
//        seleniumUtil.pause(2000);
//        js.executeScript("arguments[0].scrollIntoView(true)",
//                SeleniumUtil.driver.findElement(PublichElements.PE_STR_PAGENAME_4));
//        logger.info("找到“我们农场实景”");
//        seleniumUtil.pause(2000);
//        js.executeScript("arguments[0].scrollIntoView(true)",
//                SeleniumUtil.driver.findElement(PublichElements.PE_STR_PAGENAME_5));
//        logger.info("找到“我们的荣誉”");
//        seleniumUtil.pause(2000);
//        js.executeScript("arguments[0].scrollIntoView(true)",
//                SeleniumUtil.driver.findElement(PublichElements.PE_STR_PAGENAME_6));
//        logger.info("找到“我们的团队”");
//        seleniumUtil.pause(2000);
//        js.executeScript("arguments[0].scrollIntoView(true)",
//                SeleniumUtil.driver.findElement(PublichElements.PE_STR_PAGENAME_7));
//        seleniumUtil.outFrame();
//    }
}
