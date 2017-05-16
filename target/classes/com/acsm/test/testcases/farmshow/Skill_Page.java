package com.acsm.test.testcases.farmshow;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.acsm.test.base.BaseParpare;
import com.acsm.test.testpages.farmshow.ourhonor.OurHonorPage;
import com.acsm.test.testpages.farmshow.skill.SpecialSkillElements;
import com.acsm.test.testpages.farmshow.skill.SpecialSkillPage;

/**
 * @author GuoKuo
 * @description 特色种植技术
 */

public class Skill_Page extends BaseParpare
{
    public static Logger logger = Logger.getLogger(OurHonorPage.class.getName());

    /**
     * @description 验证进入特色种植技术
     */
    @Test(groups =
    { "skill" }, alwaysRun = true)
    public void openSkillPage()
    {
        String skillPageName = SpecialSkillPage.specialSkillPage(BaseParpare.seleniumUtil);
        seleniumUtil.isTextCorrect(skillPageName, "特色种植技术");
    }

    /**
     * @description 验证默认标题
     */
    @Test(groups =
    { "skill" }, dependsOnMethods =
    { "openSkillPage" }, alwaysRun = true)
    public void skillPageTitle()
    {

        String skillPageTitle = SpecialSkillPage.skillPageTitleByDefault();
        seleniumUtil.isTextCorrect(skillPageTitle, "特色种植技术");
    }

    /**
     * @description 验证弹出框
     */
    @Test(groups =
    { "skill" }, dependsOnMethods =
    { "openSkillPage" }, alwaysRun = true)
    public void skillPageTitleEdit()
    {
        Alert alert = SpecialSkillPage.skillPageTitleEdit(BaseParpare.seleniumUtil);
        seleniumUtil.isTextCorrect("页面主题最多能为10个字！", alert.getText());
        alert.accept();
        seleniumUtil.clear(SpecialSkillElements.PAGE_TITLE);
        seleniumUtil.type(SpecialSkillElements.PAGE_TITLE, "特色技能");
    }

    /**
     * @description 验证单图上传
     */
    @Test(groups =
    { "skill" }, dependsOnMethods =
    { "skillPageTitleEdit" }, alwaysRun = true)
    public void skillSingleImgUpload()
    {
        Map<String, String> result = SpecialSkillPage.singleImgUpload(BaseParpare.seleniumUtil);
        String uploadedAddreSpecialSkillPage = result.get("resource");
        String actureAddreSpecialSkillPage = result.get("target");
        seleniumUtil.isTextCorrect(actureAddreSpecialSkillPage, uploadedAddreSpecialSkillPage);
    }

    /**
     * @description 验证多图上传
     */
    @Test(groups =
    { "skill" }, dependsOnMethods =
    { "skillSingleImgUpload" }, alwaysRun = true)
    public void skillMultiImgUpload()
    {
        SpecialSkillPage.multiImgUpload(BaseParpare.seleniumUtil);
        List<WebElement> list = seleniumUtil.findElementsBy(SpecialSkillElements.SS_LIST_MULTIIMG);
        System.out.println(list.size());
        seleniumUtil.isCountCorrect(list.size(), 4);
    }
    
    /**
     * @description 验证多图删除
     */
    @Test(groups =
    { "skill" }, dependsOnMethods =
    { "skillMultiImgUpload" }, alwaysRun = true)
    public void MultiIMGDEL()
    {
        int afterDEL = SpecialSkillPage.multiImgDEL(BaseParpare.seleniumUtil);
        seleniumUtil.isCountCorrect(afterDEL, 1);
    }
    
    /**
     * @description 重新添加多图
     */
    @Test(groups =
    { "skill" }, dependsOnMethods =
    { "MultiIMGDEL" }, alwaysRun = true)
    public void MultiIMGAddDEL()
    {
        SpecialSkillPage.multiImgAddDEL(BaseParpare.seleniumUtil);
    }
    

    /**
     * @description 验证弹出框
     */
    @Test(groups =
    { "skill" }, dependsOnMethods =
    { "MultiIMGAddDEL" }, alwaysRun = true)
    public void skillMultiImgNameAlert()
    {
        Alert alert = SpecialSkillPage.multiImgName(BaseParpare.seleniumUtil);
        seleniumUtil.isTextCorrect("多图证书名称最多能为20个字！", alert.getText());
        alert.accept();
        seleniumUtil.clear(SpecialSkillElements.MULTI_PIC_INPUT);
        seleniumUtil.type(SpecialSkillElements.MULTI_PIC_INPUT, "奥科美");
    }
}
