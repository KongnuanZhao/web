package com.acsm.test.testcases.farmshow;

import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import com.acsm.test.base.BaseParpare;
import com.acsm.test.testpages.farmshow.ourhonor.OurHonorElements;
import com.acsm.test.testpages.farmshow.ourteam.OurTeamElements;
import com.acsm.test.testpages.farmshow.ourteam.OurTeamPage;

/**
 * @ClassName: OurTeam_Page
 * @Description: 我们的团队测试用例
 * @author Guokuo
 * @date 2016年7月13日
 *
 */

public class Team_Page extends BaseParpare
{

    public static Logger logger = Logger.getLogger(OurTeamPage.class);

    /**
     * @description 验证进入我们的团队
     */
    @Test(groups =
    { "team" }, alwaysRun = true)
    public void TeamPage()
    {
        String teamPageName = OurTeamPage.ourTeamPage(BaseParpare.seleniumUtil);
        seleniumUtil.isTextCorrect(teamPageName, "我们的团队");
    }

    /**
     * @description 验证默认标题
     */
    @Test(groups =
    { "team" }, dependsOnMethods =
    { "TeamPage" }, alwaysRun = true)
    public void TeamPageTitle()
    {
        String scenePageTitle = OurTeamPage.teamPageTitleByDefault(BaseParpare.seleniumUtil);
        seleniumUtil.isTextCorrect(scenePageTitle, "我们的团队");
    }

    /**
     * @description 验证弹出框
     */
    @Test(groups =
    { "team" }, dependsOnMethods =
    { "TeamPageTitle" }, alwaysRun = true)
    public void TeamPageTitleEdit()
    {
        Alert alert = OurTeamPage.teamPageTitleEdit(BaseParpare.seleniumUtil);
        seleniumUtil.isTextCorrect("页面主题最多能为10个字！", alert.getText());
        alert.accept();
        seleniumUtil.clear(OurTeamElements.GET_PAGE_TITLE);
        seleniumUtil.type(OurTeamElements.GET_PAGE_TITLE, "我们的团队");

    }

    /**
     * @description 验证上傳圖片
     */
    @Test(groups =
    { "team" }, dependsOnMethods =
    { "TeamPageTitleEdit" }, alwaysRun = true)
    public void TeamImgUpload()
    {
        int imgCount = OurTeamPage.teamMemberSelected(BaseParpare.seleniumUtil);
        seleniumUtil.isCountCorrect(imgCount, 5);
    }

    /**
     * @description 验证图片删除
     */
    @Test(groups =
    { "team" }, dependsOnMethods =
    { "TeamImgUpload" }, alwaysRun = true)
    public void TeamImgDelete()
    {
        Map<String, Integer> result = OurTeamPage.teamMemberDelete(BaseParpare.seleniumUtil);
        int beforeDelete = result.get("resource");
        int afterDelete = result.get("target");
        seleniumUtil.isCountCorrect(beforeDelete, afterDelete + 1);
    }
    
    /**
     * @description 队员二次添加
     */
    @Test(groups =
    { "team" }, dependsOnMethods =
    { "TeamImgDelete" }, alwaysRun = true)
    public void TeamImgAddAfterDelete()
    {
        OurTeamPage.teamMemberAddAfterDelete(BaseParpare.seleniumUtil);
    }
}
