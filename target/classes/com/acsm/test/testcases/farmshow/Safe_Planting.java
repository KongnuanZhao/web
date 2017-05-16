package com.acsm.test.testcases.farmshow;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.acsm.test.base.BaseParpare;
import com.acsm.test.testpages.farmshow.ourhonor.OurHonorElements;
import com.acsm.test.testpages.farmshow.ourhonor.OurHonorPage;
import com.acsm.test.testpages.farmshow.safeplant.SafePlanting;
import com.acsm.test.testpages.farmshow.safeplant.SafePlantingElements;

/**
 * @author GuoKuo
 * @name 安全种植
 */

public class Safe_Planting extends BaseParpare
{

    public static Logger logger = Logger.getLogger(OurHonorPage.class);

    /**
     * @description 验证安全种植默认标题
     */
    @Test(groups =
    { "safeplant" }, alwaysRun = true)
    public void SafePlantingPage()
    {
        String plantPageName = SafePlanting.safePlantingPage(BaseParpare.seleniumUtil);
        seleniumUtil.isTextCorrect(plantPageName, "安全种植，全程可追溯");
    }

    /**
     * @description 验证弹出框
     */
    @Test(groups =
    { "safeplant" }, dependsOnMethods =
    { "SafePlantingPage" }, alwaysRun = true)
    public void SafePlantingPageTitleEdit()
    {

        Alert alert = SafePlanting.safePlantingPageTitleEdit(BaseParpare.seleniumUtil);
        seleniumUtil.isTextCorrect("页面主题最多能为10个字！", alert.getText());
        alert.accept();
        seleniumUtil.clear(SafePlantingElements.PAGE_TITLE);
        seleniumUtil.type(SafePlantingElements.PAGE_TITLE, "安全种植，全程可追溯");
    }

    /**
     * @description 验证单选按钮-手动选择
     */
    @Test(groups =
    { "safeplant" }, dependsOnMethods =
    { "SafePlantingPageTitleEdit" }, alwaysRun = true)
    public void mannualRadioBTN()
    {
        WebElement radioButton = SafePlanting.mannualSelecting(BaseParpare.seleniumUtil);
        if (radioButton.isSelected() == true)
        {
            logger.info("手动选择按钮选择成功");
        } else
        {
            logger.info("手动选择按钮选择失败");
        }
    }

    /**
     * @description 验证当前农事图片上传
     */
    @Test(groups =
    { "safeplant" }, dependsOnMethods =
    { "mannualRadioBTN" }, alwaysRun = true)
    public void currentFarmingIMG()
    {
        int currentImg = SafePlanting.recentImgCount(BaseParpare.seleniumUtil);
        seleniumUtil.isCountCorrect(currentImg, 5);
    }
    
    /**
     * @description 验证当前农事图片删除
     */
    @Test(groups =
    { "safeplant" }, dependsOnMethods =
    { "currentFarmingIMG" }, alwaysRun = true)
    public void currentFarmingIMGDEL()
    {
        SafePlanting.CURIMGDelete(BaseParpare.seleniumUtil);
    }
    

    /**
     * @description 验证特色农事图片上传
     */
    @Test(groups =
    { "safeplant" }, dependsOnMethods =
    { "currentFarmingIMGDEL" }, alwaysRun = true)
    public void specialFarmingIMG()
    {
        int currentImg = SafePlanting.specialImgCount(BaseParpare.seleniumUtil);
        seleniumUtil.isCountCorrect(currentImg, 5);
    }
    
    /**
     * @description 验证特色农事图片删除
     */
    @Test(groups =
    { "safeplant" }, dependsOnMethods =
    { "specialFarmingIMG" }, alwaysRun = true)
    public void specialFarmingIMGDEL()
    {
        seleniumUtil.pause(1000);
        SafePlanting.SPEIMGDelete(BaseParpare.seleniumUtil);    
    }
//    
//    /**
//     * @description 验证单选按钮-指定区域
//     */
//    @Test(groups =
//    { "safeplant" }, dependsOnMethods =
//    { "SafePlantingPage" }, alwaysRun = true)
//    public void specifiedRadioBTN()
//    {
//        WebElement radioButton = SafePlanting.specifiedSelecting(BaseParpare.seleniumUtil);
//        if (radioButton.isSelected() == true)
//        {
//            logger.info("指定区域按钮选择成功");
//        } else
//        {
//            logger.info("指定区域按钮选择失败");
//        }
//        seleniumUtil.pause(5000);
//    }
//
//    /**
//     * @description 验证区域选择
//     */
//    @Test(groups =
//    { "safeplant" }, dependsOnMethods =
//    { "specifiedRadioBTN" }, alwaysRun = true)
//    public void farmSelected()
//    {
//        int acture = SafePlanting.safePlanting(BaseParpare.seleniumUtil);
//        seleniumUtil.isCountCorrect(acture, 5);
//    }
}
