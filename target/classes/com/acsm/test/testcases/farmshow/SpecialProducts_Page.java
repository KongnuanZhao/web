package com.acsm.test.testcases.farmshow;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.acsm.test.base.BaseParpare;
import com.acsm.test.testpages.farmshow.specalproduct.SpecialProductsElements;
import com.acsm.test.testpages.farmshow.specalproduct.SpecialProductsPage;
import com.acsm.test.utils.SeleniumUtil;

/**
 * @author GuoKuo
 * @description 履历
 */

public class SpecialProducts_Page extends BaseParpare
{

    /**
     * @author GuoKuo
     */

    public static Logger logger = Logger.getLogger(SeleniumUtil.class.getName());

    /**
     * @author GuoKuo
     * @description 验证进入特色产品
     */
    @Test(groups =
    { "specialproducts" }, alwaysRun = true)
    public void openSpecialProductsPage()
    {
        String specialPRoductsPageName = SpecialProductsPage.specialProductsPage(BaseParpare.seleniumUtil);
        seleniumUtil.isTextCorrect(specialPRoductsPageName, "特色产品");
    }

    /**
     * @author GuoKuo
     * @description 验证弹出框
     */
    @Test(groups =
    { "specialproducts" }, dependsOnMethods =
    { "openSpecialProductsPage" }, alwaysRun = true)
    public void productPageTitleEdit()
    {

        Alert alert = SpecialProductsPage.productPageTitleEdit(BaseParpare.seleniumUtil);
        seleniumUtil.isTextCorrect("页面主题最多能为6个字！", alert.getText());
        alert.accept();
        seleniumUtil.clear(SpecialProductsElements.SP_INPUT_RESUME);
        seleniumUtil.type(SpecialProductsElements.SP_INPUT_RESUME, "特色产品");
    }

    /**
     * @author GuoKuo
     * @description 验证弹出框 验证履历上传成功
     */
    @Test(groups =
    { "specialproducts" }, dependsOnMethods =
    { "productPageTitleEdit" }, alwaysRun = true)
    public void resumeUpload()
    {
        WebElement resume = SpecialProductsPage.resumeSelected(BaseParpare.seleniumUtil);
        seleniumUtil.isDisplayed(resume);
        // 切换回农场秀
        SpecialProductsPage.resumeSee(BaseParpare.seleniumUtil);
    }

    /**
     * @author GuoKuo
     * @description 验证删除履历
     */
    @Test(enabled=false,groups =
    { "specialproducts" }, dependsOnMethods =
    { "resumeUpload" }, alwaysRun = true)
    public void resumeDelete()
    {
        SpecialProductsPage.resumeRemove(BaseParpare.seleniumUtil);
        logger.info("履历删除成功");
        // 点击选择
        seleniumUtil.click(SpecialProductsElements.SELECT_IMAGE);
        seleniumUtil.waitForElementToLoad(1000, SpecialProductsElements.IMAGE_SELECT_DIALOG);
        // 选择履历
        List<WebElement> list = seleniumUtil.findElementsBy(SpecialProductsElements.IMAGE_SELECT_DIALOG);
        seleniumUtil.pause(2000);
        int b = (int) (Math.random() * (list.size()-1));// 选择随机图片
        seleniumUtil.pause(2000);
        list.get(b).click();
        seleniumUtil.click(SpecialProductsElements.CONFIRM_BUTTON);
        seleniumUtil.pause(2000);
    }

}
