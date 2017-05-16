package com.acsm.test.testpages.farmshow;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.acsm.test.testpages.farmshow.constantenum.ConstantEnum;
import com.acsm.test.utils.SeleniumUtil;

public class FarmShowAddAllPages
{

    public static Logger logger = Logger.getLogger(SeleniumUtil.class.getName());
    static int n = 5;

    public void FarmShowAddAll(SeleniumUtil seleniumUtil, WebDriver driver)
    {
        // 点击添加所有页面
        seleniumUtil.pause(2000);
        WebElement addPages = driver.findElement(By.cssSelector("span.addPage"));
        addPages.click();

        // 验证添加页面打开modal-content
        WebElement addPagesDialogOpen = (new WebDriverWait(driver, 15))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("p.s-txt")));
        seleniumUtil.pause(2000);
        seleniumUtil.isDisplayed(addPagesDialogOpen);

        // 选择全部模块
        List<WebElement> elements = driver.findElements(By.cssSelector("ul.addList li"));
        for (int i = 1; i < 12; i++)
        {
            if (elements.get(i).isDisplayed() == true)
            {
                elements.get(i).click();
            }
        }
        logger.info("所有模块选择完毕");

        // 验证全部模块文字
        List<ConstantEnum> list = new ArrayList<ConstantEnum>();
        list.add(ConstantEnum.ANCHOR1);
        list.add(ConstantEnum.ANCHOR2);
        list.add(ConstantEnum.ANCHOR3);
        list.add(ConstantEnum.ANCHOR4);
        list.add(ConstantEnum.ANCHOR5);
        list.add(ConstantEnum.ANCHOR6);
        list.add(ConstantEnum.ANCHOR7);
        list.add(ConstantEnum.ANCHOR8);
        list.add(ConstantEnum.ANCHOR9);

        for (int i = 0; i < list.size(); i++)
        {
            ConstantEnum constant = list.get(i);
            WebElement anchor = driver.findElement(By.xpath(constant.getPath()));
            Assert.assertEquals(anchor.getText(), constant.getExceptionResult());
        }
        logger.info("所有模块标题验证完毕");

        // 点击确定
        WebElement clickAccept = driver.findElement(By
                .cssSelector("div.modal-dialog.pageW > div.modal-content > div.modal-footer > button.btn.btn-primary"));
        clickAccept.click();

        // 检测是否添加成功
        List<WebElement> pagesElements = driver.findElements(By.cssSelector("ul.leftSide li"));
        if (pagesElements.size() == 12)
            logger.info("全部页面添加成功");
        else
        {
            logger.info("添加失败");
        }
    }

    public static void DeleteOnePage(SeleniumUtil seleniumUtil)
    {

        logger.info("删除序号为" + n + "的模块");
        JavascriptExecutor js = (JavascriptExecutor) SeleniumUtil.driver;
        js.executeScript("arguments[0].scrollIntoView(true)",
                SeleniumUtil.driver.findElement(By.cssSelector("ul.leftSide li:nth-child(" + 5 + ")")));

        // 添加悬浮
        seleniumUtil.mouseMoveToElementNoHight(By.cssSelector("ul.leftSide li:nth-child(" + 5 + ")"));
        seleniumUtil.click(By.cssSelector("ul.leftSide li:nth-child(" + 5 + ")"));
        seleniumUtil.pause(2000);
        // 点击删除
        WebElement deleteBTN = SeleniumUtil.driver
                .findElement(By.xpath("//li[@temp=" + 5 + "]//img[contains(@src,'del.png')]"));
        deleteBTN.click();

        // 点击alert
        seleniumUtil.pause(2000);
        Alert alert = seleniumUtil.switchToPromptedAlertAfterWait(2000);
        alert.accept();

        List<WebElement> pagesElements = SeleniumUtil.driver.findElements(By.cssSelector("ul.leftSide li"));
        if (pagesElements.size() == 11)
        {
            logger.info("页面删除成功");
        }
    }

    // 增加被删除的页面
    public void AddDeletedPage(SeleniumUtil seleniumUtil)
    {

        // 点击添加所有页面
        seleniumUtil.pause(2000);
        WebElement addPages = SeleniumUtil.driver.findElement(By.cssSelector("span.addPage"));
        addPages.click();

        // 选择全部模块
        // WebElement e =
        // SeleniumUtil.driver.findElement(By.cssSelector("ul.addList
        // li:nth-child(" + n + ") img"));
        // seleniumUtil.pause(2000);
        // seleniumUtil.click(By.cssSelector("ul.addList"));
        seleniumUtil.pause(2000);

        seleniumUtil.click(By.cssSelector("ul.addList li:nth-child(" + n + ") img"));
        // e.click();

        seleniumUtil.pause(2000);

        // 点击确定
        WebElement clickAccept = SeleniumUtil.driver
                .findElement(By.cssSelector("div.modal-dialog.pageW button.btn.btn-primary"));
        clickAccept.click();
        seleniumUtil.pause(2000);
        logger.info("所有模块选择完毕");

    }
}
