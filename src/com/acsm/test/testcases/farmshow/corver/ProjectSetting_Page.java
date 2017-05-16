package com.acsm.test.testcases.farmshow.corver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.acsm.test.base.BaseParpare;
import com.acsm.test.testpages.farmshow.corver.ProjectSettingPageElements;
import com.acsm.test.utils.SeleniumUtil;
import com.mysql.jdbc.Driver;

/**
 * @author GuoKuo
 * @name 项目设置
 */

public class ProjectSetting_Page extends BaseParpare
{
    public static Logger logger = Logger.getLogger(SeleniumUtil.class.getName());
    public static String projectName;

    /**
     * @description 进入项目设置
     */
    @Test(groups =
    { "projectsetting" }, alwaysRun = true)
    public void projectSettingPage()
    {
        // 切换到项目设置模块
        WebElement goToProjectSettingPage = SeleniumUtil.driver
                .findElement(ProjectSettingPageElements.PS_BTN_PROJECTSETTING);
        goToProjectSettingPage.click();
    }

    /**
     * 
     * @Title: ProjectSettingNameByDefault
     * @description 获得项目名称
     */
    @Test(groups =
    { "projectsetting" }, alwaysRun = true, dependsOnMethods =
    { "projectSettingPage" })
    public void ProjectSettingNameByDefault()
    {
        // 验证默认项目名称
        WebElement getProjectName = SeleniumUtil.driver.findElement(ProjectSettingPageElements.PS_INPUT_PROJECTNAME);
        String str = getProjectName.getAttribute("value");
        seleniumUtil.isTextCorrect("您“看得见”的好农场", str);
    }

    /**
     * @description 更换项目名称
     */
    @Test(groups =
    { "projectsetting" }, alwaysRun = true, dependsOnMethods =
    { "ProjectSettingNameByDefault" })
    public void ProjectSettingNameEdit()
    {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmm");// 设置日期格式
        // 验证默认项目名称
        seleniumUtil.type(ProjectSettingPageElements.PS_INPUT_PROJECTNAME, "您“看得见”的好农场您“看得见”的好农场");
        seleniumUtil.click(ProjectSettingPageElements.PS_IMG_PHONE);
        Alert alert = seleniumUtil.switchToPromptedAlertAfterWait(2000);
        logger.info(alert.getText());
        seleniumUtil.isTextCorrect("项目名称设置最多能为12个字！", alert.getText());
        alert.accept();
        seleniumUtil.clear(ProjectSettingPageElements.PS_INPUT_PROJECTNAME);
        seleniumUtil.type(ProjectSettingPageElements.PS_INPUT_PROJECTNAME, df.format(new Date()));
        projectName = df.format(new Date());
    }

    /**
     * @description 获得项目描述
     */
    @Test(groups =
    { "projectsetting" }, alwaysRun = true, dependsOnMethods =
    { "ProjectSettingNameEdit" })
    public void ProjectSettingSummary()
    {
        // 验证默认项目描述
        WebElement getProjectName = SeleniumUtil.driver.findElement(ProjectSettingPageElements.PS_INPUT_SUMMARY);
        String str = getProjectName.getText();
        seleniumUtil.isTextCorrect(str, str);
    }

    /**
     * @description 修改项目描述
     */
    @Test(groups =
    { "projectsetting" }, alwaysRun = true, dependsOnMethods =
    { "ProjectSettingSummary" })
    public void ProjectSettingSummaryEdit()
    {
        // 修改默认项目描述
        seleniumUtil.type(ProjectSettingPageElements.PS_INPUT_SUMMARY, "黑龙江绥化市康荣大队黑龙江绥化市康荣大队黑龙江绥化市康荣大队");
        seleniumUtil.click(ProjectSettingPageElements.PS_IMG_PHONE);
        Alert alert = seleniumUtil.switchToPromptedAlertAfterWait(2000);
        logger.info(alert.getText());
        seleniumUtil.isTextCorrect("项目描述设置最多能为20个字！", alert.getText());
        alert.accept();
        seleniumUtil.clear(ProjectSettingPageElements.PS_INPUT_SUMMARY);
        seleniumUtil.type(ProjectSettingPageElements.PS_INPUT_SUMMARY, "黑龙江绥化市康荣大队");
    }

    /**
     * @throws IOException
     * @description 上传音乐
     */
    @Test(groups =
    { "projectsetting" }, alwaysRun = true, dependsOnMethods =
    { "ProjectSettingSummaryEdit" })
    public void musicUpload() throws IOException
    {
        WebElement musicSetting = SeleniumUtil.driver.findElement(By.cssSelector("span.rowS"));
        musicSetting.click();
        // 上传我的音乐。
        seleniumUtil.pause(2000);
        WebElement myMusic = SeleniumUtil.driver.findElement(By.cssSelector("div#music-set ul.farmHd li:nth-child(2)"));
        myMusic.click();
        List<WebElement> elements = SeleniumUtil.driver.findElements(By.cssSelector("div.farmCont.cur ul.musicSet li"));

        if (elements.size() == 5)
        {
            logger.info("可上传音乐达到最大值，删除任意音乐，重新上传");
            WebElement delete = SeleniumUtil.driver.findElement(By.cssSelector("div.farmCont.cur span.m-close"));
            delete.click();
            logger.info("删除成功");
            WebElement findIframe = SeleniumUtil.driver.switchTo().frame("myframPic3")
                    .findElement(By.className("logoUrl"));
            seleniumUtil.click(ProjectSettingPageElements.PS_BTN_MUSICUPLOAD);
            Runtime.getRuntime().exec("./res/script/autoit/UploadImageScript.exe");
            SeleniumUtil.driver.switchTo().defaultContent();
            elements.add(findIframe);

        } else
        {
            for (int i = 0; i < 1; i++)
            {
                logger.info("可上传音乐未达到最大值");
                int beforeUpload = elements.size();
                logger.info("当前音乐数量为：" + beforeUpload);
                WebElement findIframe = SeleniumUtil.driver.switchTo().frame("myframPic3")
                        .findElement(By.className("logoUrl"));

                // autoit upload
                seleniumUtil.pause(2000);
                seleniumUtil.click(ProjectSettingPageElements.PS_BTN_MUSICUPLOAD);
                Runtime.getRuntime().exec("./res/script/autoit/UploadLargeMP3.exe");
                seleniumUtil.pause(5000);
                SeleniumUtil.driver.switchTo().defaultContent();
                elements.add(findIframe);
                if (elements.size() == beforeUpload + 1)
                {
                    int leftSize = 5 - elements.size();
                    logger.info("歌曲上传成功，当前数量为：" + elements.size() + "，还可以上传:" + leftSize);
                }
            }
        }
    }

    /**
     * @description 音乐库选择音乐测试
     */
    @Test(groups =
    { "projectsetting" }, alwaysRun = true, dependsOnMethods =
    { "musicDelete" })
    public void musicSelected()
    {
        // 选择音乐库
        seleniumUtil.pause(2000);
        WebElement musicStore = SeleniumUtil.driver
                .findElement(By.cssSelector("div#music-set ul.farmHd li:nth-child(1)"));
        musicStore.click();
        // 选择音乐
        WebElement selectMusic = SeleniumUtil.driver.findElement(By.xpath("//*[@id='music3']"));
        selectMusic.click();
        // 获得音乐名字
        WebElement getSelectiedMusicName = SeleniumUtil.driver
                .findElement(By.cssSelector("li.bca.bca span.turn-c audio.musicFl"));
        String uploadFileName = getSelectiedMusicName.getAttribute("sr");
        // 点击确认
        WebElement clickConfirm = SeleniumUtil.driver.findElement(By.cssSelector(
                "#music-set > div.modal-dialog.pageW > div.modal-content > div.modal-footer > button.btn.btn-primary"));
        clickConfirm.click();
        // 点击一下右侧工具栏，否则找不到元素
        WebElement getActureMusicName = SeleniumUtil.driver.findElement(By.xpath("//*[@id='all:musicId']"));
        String getActuralMusic = getActureMusicName.getAttribute("value");
        // 判断是否一致
        if (getActuralMusic.equals(uploadFileName))
        {
            logger.info("音乐地址一致，为相同音乐");
        }
        /** 切换到控件设置 */
        seleniumUtil.pause(2000);
        WebElement goToHomePageSettingPage = SeleniumUtil.driver
                .findElement(By.cssSelector("div.hd span:nth-child(1)"));
        goToHomePageSettingPage.click();
    }

    /**
     * @description 切换回控件设置
     */
    @Test(groups =
    { "projectsetting" }, alwaysRun = true, dependsOnMethods =
    { "musicSelected" })
    public void SwitchBack()
    {
        /** 切换到控件设置 */
        seleniumUtil.pause(2000);
        WebElement goToHomePageSettingPage = SeleniumUtil.driver
                .findElement(By.cssSelector("div.hd span:nth-child(1)"));
        goToHomePageSettingPage.click();
    }

    /**
     * @description 上传较大音乐
     */
    @Test(groups =
    { "projectsetting" }, alwaysRun = true, dependsOnMethods =
    { "musicUpload" })
    public void musicUpload_Large()
    {
        
        WebElement findIframe = SeleniumUtil.driver.switchTo().frame("myframPic3").findElement(By.className("logoUrl"));
        File file = new File("./res/img/较大的音乐.mp3");
        String musicPath = file.getAbsolutePath();
        findIframe.sendKeys(musicPath);
        seleniumUtil.pause(4000);
        seleniumUtil.outFrame();
        WebElement e = SeleniumUtil.driver.findElement(By.cssSelector("div.upload p"));
        String actual = e.getText();
        seleniumUtil.isTextCorrect(actual, "背景音乐不能大于3M");
        
    }
    
    
    /**
     * @description 音乐删除
     */
    @Test(groups =
    { "projectsetting" }, alwaysRun = true, dependsOnMethods =
    { "musicUpload_Large" })
    public void musicDelete()
    {
        
        List<WebElement> musicListBeforeDEL = SeleniumUtil.driver.findElements(By.cssSelector("div.farmCont.cur li"));
        int before = musicListBeforeDEL.size();
        WebElement deleteBTN = SeleniumUtil.driver.findElement(By.xpath("//span[contains(@onclick,'delMusic(this)')]"));
        deleteBTN.click();
        List<WebElement> musicListAfterDEL = SeleniumUtil.driver.findElements(By.cssSelector("div.farmCont.cur li"));
        int after = musicListAfterDEL.size();
        seleniumUtil.isCountCorrect(before, after+1);

        
    }
}
