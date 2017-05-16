package com.acsm.test.testcases.farmshow;

import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import com.acsm.test.base.BaseParpare;
import com.acsm.test.testpages.farmshow.ourhonor.OurHonorElements;
import com.acsm.test.testpages.farmshow.ourhonor.OurHonorPage;

/**
 * @author GuoKuo
 * @name 我们的荣誉
 */

public class Honor_Page extends BaseParpare
{

    public static Logger logger = Logger.getLogger(OurHonorPage.class);

    /**
     * @description 验证进入我们的荣誉
     */
    @Test(groups = { "honor" },alwaysRun = true)
    public void HonorPage()
    {
        String scenePageName = OurHonorPage.ourHonorPage(BaseParpare.seleniumUtil);
        seleniumUtil.isTextCorrect(scenePageName, "我们的荣誉");
    }

    /**
     * @description 验证默认标题
     */
    @Test(groups = { "honor" },dependsOnMethods =
    { "HonorPage" },alwaysRun = true)
    public void HonorPageTitle()
    {

        String scenePageTitle = OurHonorPage.honorPageTitleByDefault(BaseParpare.seleniumUtil);
        seleniumUtil.isTextCorrect(scenePageTitle, "我们的荣誉");
    }

    /**
     * @description 验证弹出框
     */
    @Test(groups = { "honor" },dependsOnMethods =
    { "HonorPage" },alwaysRun = true)
    public void HonorPageTitleEdit()
    {

        Alert alert = OurHonorPage.honorPageTitleEdit(BaseParpare.seleniumUtil);
        logger.info(alert.getText());
        seleniumUtil.isTextCorrect("页面主题最多能为10个字！", alert.getText());
        alert.accept();
        seleniumUtil.clear(OurHonorElements.GET_PAGE_TITLE);
        seleniumUtil.type(OurHonorElements.GET_PAGE_TITLE, "我们的荣誉");
    }

    /**
     * @description 验证上傳圖片
     */
    @Test(groups = { "honor" },dependsOnMethods =
    { "HonorPage" },alwaysRun = true)
    public void HonorImgUpload()
    {

        int imgCount = OurHonorPage.ourHonorImgUpload(BaseParpare.seleniumUtil);
        seleniumUtil.isCountCorrect(imgCount, 4);
    }

    /**
     * @description 验证图片删除
     */
    @Test(groups = { "honor" },dependsOnMethods =
    { "HonorImgUpload" }, alwaysRun = true)
    public void HonorImgDelete()
    {
        Map<String, Integer> result = OurHonorPage.ourHonorImgDelete(BaseParpare.seleniumUtil);
        int beforeDelete = result.get("resource");
        int afterDelete = result.get("target");
        seleniumUtil.isCountCorrect(beforeDelete, afterDelete + 1);
    }

    /**
     * @description 验证图片二次添加
     */
    @Test(groups = { "honor" },dependsOnMethods =
    { "HonorImgDelete" }, alwaysRun = true)
    public void HonorImgAddAfterDelete()
    {
       OurHonorPage.honorImgAddAfterDEL(BaseParpare.seleniumUtil);
    }
}
