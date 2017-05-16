package com.acsm.test.testpages.farmshow;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.acsm.test.testpages.farmshow.constantenum.musicSelectionEnum;
import com.acsm.test.utils.SeleniumUtil;

public class ProjectSettingPage
{

    public static Logger logger = Logger.getLogger(SeleniumUtil.class.getName());
    SeleniumUtil seleniumUtil = null;

    public void projectSettingPage(WebDriver driver)
    {
        /**
         * 切换到项目设置模块
         */
        WebElement goToProjectSettingPage = driver.findElement(By.cssSelector("div.hd span:nth-child(2)"));
        goToProjectSettingPage.click();

        /**
         * 获取项目名称
         */
        WebElement getProjectName = driver.findElement(By.xpath("//*[@id='all:projectNameId']"));
        String str = getProjectName.getAttribute("value");

        /**
         * 获取描述
         */
        WebElement getDescription = driver.findElement(By.id("all:projcetDescriptionpId"));
        String description = getDescription.getText();

        /**
         * 我的音乐
         */
        WebElement musicSetting = driver.findElement(By.cssSelector("span.rowS"));
        musicSetting.click();
        // 上传我的音乐。（无法判断上传5个最多）
        seleniumUtil.pause(2000);
        WebElement myMusic = driver.findElement(By.cssSelector("div#music-set ul.farmHd li:nth-child(2)"));
        myMusic.click();
        List<WebElement> elements = driver.findElements(By.cssSelector("div.farmCont.cur ul.musicSet li"));

        // AutoIt 上传方式
        // File f = new File("/res/script/autoit/upload.exe");
        // AutoItUploadFile.handleUpload("firefox",f);

        // selenium 方法
        for (int i = 0; i < 1; i++)
        {
            int beforeUpload = elements.size();
            WebElement findIframe = driver.switchTo().frame("myframPic3").findElement(By.className("logoUrl"));
            File file = new File("./res/img/music.mp3");
            String musicPath = file.getAbsolutePath();
            findIframe.sendKeys(musicPath);
            driver.switchTo().defaultContent();
            elements.add(findIframe);
            if (elements.size() == beforeUpload + 1)
            {
                int leftSize = 5 - elements.size();
                logger.info("歌曲上传成功，当前数量为：" + elements.size() + "，还可以上传:" + leftSize);
            }
        }

        // 删除选择的音乐
        seleniumUtil.pause(2000);
        List<musicSelectionEnum> musicList = new ArrayList<musicSelectionEnum>();
        musicList.add(musicSelectionEnum.ANCHOR1);
        // musicList.add(musicSelectionEnum.ANCHOR2);
        // musicList.add(musicSelectionEnum.ANCHOR3);
        // musicList.add(musicSelectionEnum.ANCHOR4);
        // musicList.add(musicSelectionEnum.ANCHOR5);

        for (int i = 0; i < 1; i++)
        {
            musicSelectionEnum constant = musicList.get(0);
            WebElement anchor = driver.findElement(By.xpath(constant.getPath()));
            anchor.click();
            WebElement delete = driver.findElement(By.cssSelector("div.farmCont.cur span.m-close"));
            delete.click();
            logger.info("删除成功");
        }

        /**
         * 音乐库
         */
        // 选择音乐库
        seleniumUtil.pause(2000);
        WebElement musicStore = driver.findElement(By.cssSelector("div#music-set ul.farmHd li:nth-child(1)"));
        musicStore.click();
        // 选择音乐
        WebElement selectMusic = driver.findElement(By.xpath("//*[@id='music3']"));
        selectMusic.click();
        // 获得音乐名字
        WebElement getSelectiedMusicName = driver.findElement(By.cssSelector("li.bca.bca span.turn-c audio.musicFl"));
        String uploadFileName = getSelectiedMusicName.getAttribute("sr");
        // 点击确认
        WebElement clickConfirm = driver.findElement(By.cssSelector(
                "#music-set > div.modal-dialog.pageW > div.modal-content > div.modal-footer > button.btn.btn-primary"));
        clickConfirm.click();
        // 点击一下右侧工具栏，否则找不到元素
        WebElement getActureMusicName = driver.findElement(By.xpath("//*[@id='all:musicId']"));
        String getActuralMusic = getActureMusicName.getAttribute("value");
        // 判断是否一致
        if (getActuralMusic.equals(uploadFileName))
        {
            logger.info("音乐地址一致，为相同音乐");
        }
        /** 切换到控件设置 */
        seleniumUtil.pause(2000);
        WebElement goToHomePageSettingPage = driver.findElement(By.cssSelector("div.hd span:nth-child(1)"));
        goToHomePageSettingPage.click();
    }
}
