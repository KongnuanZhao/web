package com.acsm.test.testcases.farmshow;

import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.acsm.test.base.BaseParpare;
import com.acsm.test.testpages.farmshow.panorama.PanoramaPage;
import com.acsm.test.testpages.farmshow.panorama.PanoramaPageElements;
import com.acsm.test.utils.SeleniumUtil;
/**
 * @name 农场实景
 */
public class Panorama_Page extends BaseParpare
{


    public static Logger logger = Logger.getLogger(SeleniumUtil.class.getName());

    /**
     * @description 验证进入农场实景
     * @author GuoKuo
     */

    @Test(groups = { "panorama" },alwaysRun = true)
    public void openPanoramaPage()
    {
        String scenePageName = PanoramaPage.farmScenePage(BaseParpare.seleniumUtil);
        seleniumUtil.isTextCorrect(scenePageName, "我们农场实景");
    }

    /**
     * @description 验证默认标题
     * @author GuoKuo
     */
    @Test(groups = { "panorama" },alwaysRun = true,dependsOnMethods =
    { "openPanoramaPage" })
    public void panoramaPageTitle()
    {

        String scenePageTitle = PanoramaPage.scenePageTitleByDefault(BaseParpare.seleniumUtil);
        seleniumUtil.isTextCorrect(scenePageTitle, "我们农场实景");
    }

    /**
     * @description 验证页面文字
     * @author GuoKuo
     */
    @Test(groups = { "panorama" },alwaysRun = true,dependsOnMethods =
    { "panoramaPageTitle" })
    public void scenePageTextVerification()
    {

        String pageText = PanoramaPage.scenePageTextVerification(BaseParpare.seleniumUtil);
        seleniumUtil.isTextCorrect("请选择农场图片展示，您可以选择四季田景，注意，您农场图片与四季田景一共最多可以选择三张", pageText);
    }

    /**
     * @description 验证图片是否正确
     * @author GuoKuo
     */
    @Test(groups = { "panorama" },alwaysRun = true,dependsOnMethods =
    { "scenePageTextVerification" })
    public void farmImgVerification()
    {

        Map<String, String> verify = PanoramaPage.selectFarmImg(BaseParpare.seleniumUtil);
        String resouce = verify.get("resouceImg");
        String acture = verify.get("targetImg");
        seleniumUtil.isTextCorrect(acture, resouce);
    }

    /**
     * @description 点击全景图，验证是否打开
     * @author GuoKuo
     */
    @Test(groups = { "panorama" },alwaysRun = true,dependsOnMethods =
    { "farmImgVerification" })
    public void panoramaVerification()
    {
        PanoramaPage.panoramaImgVerification(BaseParpare.seleniumUtil);
    }
    
    /**
     * @description 删除全景图
     * @author GuoKuo
     */
    @Test(groups = { "panorama" },alwaysRun = true,dependsOnMethods =
    { "panoramaVerification" })
    public void panoramaDelete()
    {
        int afterDelete = PanoramaPage.panoramaImgDEL(BaseParpare.seleniumUtil);
        seleniumUtil.isCountCorrect(afterDelete, 1);
    }
    
    /**
     * @description 删除全景图
     * @author GuoKuo
     */
    @Test(groups = { "panorama" },alwaysRun = true,dependsOnMethods =
    { "panoramaDelete" })
    public void panoramaAddAfterDEL()
    {
        PanoramaPage.panoramaAddAfterDEL(BaseParpare.seleniumUtil);
        seleniumUtil.click(PanoramaPageElements.CONFIRM_BUTTON);
    }


}
