package com.acsm.test.testcases.farmshow;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.acsm.test.base.BaseParpare;
import com.acsm.test.testpages.farmshow.ourhonor.OurHonorPage;
import com.acsm.test.testpages.farmshow.safeplant.SafePlanting;
import com.acsm.test.testpages.farmshow.safeplant.SafePlantingElements;
import com.acsm.test.testpages.farmshow.supply.ProductsSupply;
import com.acsm.test.testpages.farmshow.supply.ProductsSupplyElements;
import com.acsm.test.utils.SeleniumUtil;

/**
 * @author GuoKuo
 * @name 产品供应
 */

public class Product_Supply extends BaseParpare
{

    public static Logger logger = Logger.getLogger(OurHonorPage.class);

    /**
     * @description 验证产品供应默认标题
     */
    @Test(groups =
    { "supply" }, alwaysRun = true)
    public void SupplyPage()
    {
    	seleniumUtil.pause(2000);
        String supplyPageName = ProductsSupply.SupplyPage(BaseParpare.seleniumUtil);
        seleniumUtil.isTextCorrect(supplyPageName, "产品供应");
    }

    /**
     * @description 验证输入正确的标题
     */
    @Test(groups =
    { "supply" }, dependsOnMethods =
    { "SupplyPage" }, alwaysRun = true)
    public void SupplyPageTitleEdit_Correct()
    {
        String inputSting = "产品供应";
        String actual = ProductsSupply.SupplyPageTitleEdit(inputSting, BaseParpare.seleniumUtil);
        seleniumUtil.isTextCorrect(actual, inputSting);
    }

    /**
     * @description 验证输入较长的标题
     */
    @Test(groups =
    { "supply" }, dependsOnMethods =
    { "SupplyPage" }, alwaysRun = true)
    public void SupplyPageTitleEdit_inCorrect()
    {
        String inputSting = "产品供应名字比较长哦啊";
        String actual = ProductsSupply.SupplyPageTitleEdit(inputSting, BaseParpare.seleniumUtil);
        seleniumUtil.isTextCorrect("页面主题最多能为10个字！", actual);
        seleniumUtil.clear(SafePlantingElements.PAGE_TITLE_1);
        seleniumUtil.type(SafePlantingElements.PAGE_TITLE_1, "产品供应");
    }

    /**
     * @description 验证微商城是否勾选
     */
    @Test(enabled=false,groups =
    { "supply" }, dependsOnMethods =
    { "SupplyPageTitleEdit_inCorrect" }, alwaysRun = true)
    public void WSSelect()
    {
        WebElement WSCheckBox = ProductsSupply.WSCheckbox(BaseParpare.seleniumUtil);
        WSCheckBox.isSelected();
    }

    /**
     * @description 验证微商城输入内容
     */
    @Test(enabled=false,groups =
    { "supply" }, dependsOnMethods =
    { "WSSelect" }, alwaysRun = true)
    public void WSInput()
    {
        String input = "www.baidu.com";
        String actual = ProductsSupply.WSInput(input, BaseParpare.seleniumUtil);
        String act = "http://" + input + "/";
        seleniumUtil.isTextCorrect(actual, act);
    }

    /**
     * @description 上传供应图片
     */
    @Test(groups =
    { "supply" }, dependsOnMethods =
    { "SupplyPageTitleEdit_inCorrect" }, alwaysRun = true)
    public void supplyUpload()
    {
        int excepted = 4;
        int actual = ProductsSupply.SupplyCount(excepted, seleniumUtil);
        seleniumUtil.isCountCorrect(actual, excepted);
    }
    
    /**
     * @description 删除供应图片
     */
    @Test(groups =
    { "supply" }, dependsOnMethods =
    { "supplyUpload" }, alwaysRun = true)
    public void supplyIMGDEL()
    {
        int excepted = 3;
        int actual = ProductsSupply.SupplyIMGDEL(seleniumUtil);
        seleniumUtil.isCountCorrect(actual, excepted);
    }
    
    /**
     * @description 供应图片二次添加
     */
    @Test(groups =
    { "supply" }, dependsOnMethods =
    { "supplyIMGDEL" }, alwaysRun = true)
    public void SupplyUploadAfterDEL()
    {
        ProductsSupply.SupplyAddAfterDEL(seleniumUtil);
    }

    /**
     * @description 上传预售供应
     */
    @Test(groups =
    { "supply" }, dependsOnMethods =
    { "SupplyUploadAfterDEL" }, alwaysRun = true)
    public void PresellUpload()
    {
        int excepted = 6;
        int actual = ProductsSupply.Presell(excepted, seleniumUtil);
        seleniumUtil.isCountCorrect(actual, excepted);
    }
    
    /**
     * @description 删除预售供应图片
     */
    @Test(groups =
    { "supply" }, dependsOnMethods =
    { "PresellUpload" }, alwaysRun = true)
    public void PreSupplyIMGDEL()
    {
        seleniumUtil.pause(1000);
        int excepted = 5;
        int actual = ProductsSupply.PreSupplyIMGDEL(seleniumUtil);
        seleniumUtil.isCountCorrect(actual, excepted);
    }
    
    /**
     * @description 预售图片二次添加
     */
    @Test(groups =
    { "supply" }, dependsOnMethods =
    { "PreSupplyIMGDEL" }, alwaysRun = true)
    public void PresellUploadAfterDEL()
    {
        ProductsSupply.PresellAddAfterDEL(seleniumUtil);
    }



}
