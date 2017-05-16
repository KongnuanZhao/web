package com.acsm.test.testpages.farmshow;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.acsm.test.base.BaseParpare;
import com.acsm.test.utils.SeleniumUtil;

/**
 * @ClassName: CreatFarmShow_NoneCompanyInfo
 * @Description: 创建农场秀，没有经过获取企业信息途径，故需要选择基地
 * @author Kuu
 * @date 2016年7月8日
 *
 */

public class CreatFarmShow_NoneCompanyInfo extends BaseParpare
{
    public static int beforeCreateFarmShow;
    public static Logger logger = Logger.getLogger(SeleniumUtil.class.getName());
    public static WebDriver driver = SeleniumUtil.driver;

    public void CreateFarmShowflow(SeleniumUtil seleniumUtil)
    {

        // 等待2s
        seleniumUtil.pause(2000);

        // 选择基地
        By baseSelectButton = By.xpath("//span[@class='siteSeleHd']");
        seleniumUtil.mouseMoveToElement(baseSelectButton);
        seleniumUtil.pause(2000);
        seleniumUtil.click(baseSelectButton);
        seleniumUtil.pause(2000);
        seleniumUtil.click(By.cssSelector("#selectBaseDiv li:nth-child(2)"));
        seleniumUtil.pause(2000);

        // 进入农场秀
        By element = By.cssSelector("ul.left_cul li.left_culi:nth-child(4) a img");
        seleniumUtil.mouseMoveToElement(element);
        seleniumUtil.waitForElementToLoad(2500, By.xpath("//a[contains(@href,'PropagandasList.seam?')]"));
        seleniumUtil.pause(2000);
        By locater = By.xpath("//a[contains(@href,'PropagandasList.seam?')]");
        seleniumUtil.click(locater);

        // 查看当前拥有农场秀数量
        seleniumUtil.pause(1000);
        List<WebElement> currentFarmShow = driver.findElements(By.cssSelector("ul.c-list li"));
        beforeCreateFarmShow = currentFarmShow.size();
        logger.info("当前拥有农场秀数量为：" + beforeCreateFarmShow);

        // 点击创建项目
        seleniumUtil.pause(2000);
        WebElement clickCreateFarmShow = driver.findElement(By.id("addthree"));
        clickCreateFarmShow.click();
        seleniumUtil.pause(1000);

        // 添加全部页面
        seleniumUtil.pause(2000);
        FarmShowAddAllPages fsaa = new FarmShowAddAllPages();
        fsaa.FarmShowAddAll(seleniumUtil, driver);
        seleniumUtil.pause(2000);

    }

    public void DeletePage(SeleniumUtil seleniumUtil)
    {
        FarmShowAddAllPages fsaa = new FarmShowAddAllPages();

        // 删除页面
        fsaa.DeleteOnePage(BaseParpare.seleniumUtil);
    }

    public void addPageBack(SeleniumUtil seleniumUtil)
    {
        FarmShowAddAllPages fsaa = new FarmShowAddAllPages();

        // 恢复被删除的页面
        fsaa.AddDeletedPage(BaseParpare.seleniumUtil);
        logger.info("页面恢复成功");
    }
}
