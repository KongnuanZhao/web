package com.acsm.test.testcases.farmshow;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.acsm.test.base.BaseParpare;
import com.acsm.test.testpages.farmshow.service.ServiceElements;
import com.acsm.test.testpages.farmshow.service.ServicePage;

/**
 * @author GuoKuo
 * @name 我们的服务
 */

public class Service_Page extends BaseParpare
{

    public static Logger logger = Logger.getLogger(Service_Page.class);

    /**
     * @description 验证我们的服务标题
     */
    @Test(groups =
    { "service" }, alwaysRun = true)
    public void ServicePage()
    {
        String servicePageName = ServicePage.servicePage(BaseParpare.seleniumUtil);
        seleniumUtil.isTextCorrect(servicePageName, "我们的服务");
    }

    /**
     * @description 验证输入正确的标题
     */
    @Test(groups =
    { "service" }, dependsOnMethods =
    { "ServicePage" }, alwaysRun = true)
    public void ServicePageTitleEdit_Correct()
    {
        String inputSting = "我们的服务";
        String actual = ServicePage.ServicePageTitleEdit(inputSting, BaseParpare.seleniumUtil);
        seleniumUtil.isTextCorrect(actual, inputSting);
    }

    /**
     * @description 验证输入较长的标题
     */
    @Test(groups =
    { "service" }, dependsOnMethods =
    { "ServicePageTitleEdit_Correct" }, alwaysRun = true)
    public void ServicePageTitleEdit_inCorrect()
    {
        String inputSting = "我们的服务名字比较长哦啊";
        String actual = ServicePage.ServicePageTitleEdit(inputSting, BaseParpare.seleniumUtil);
        seleniumUtil.isTextCorrect("页面主题最多能为10个字！", actual);
        seleniumUtil.clear(ServiceElements.SE_PAGE_TITLE);
        seleniumUtil.type(ServiceElements.SE_PAGE_TITLE, "我们的服务");
    }

    /**
     * @description 验证上传按钮是否可用
     */
    @Test(groups =
    { "service" }, dependsOnMethods =
    { "ServicePageTitleEdit_inCorrect" }, alwaysRun = true)
    public void ServiceIMG()
    {
        WebElement WSCheckBox = ServicePage.serviceImgUpload(BaseParpare.seleniumUtil);
        WSCheckBox.isDisplayed();
    }

    /**
     * @description 修改服务名称
     */
    @Test(groups =
    { "service" }, dependsOnMethods =
    { "ServiceIMG" }, alwaysRun = true)
    public void ServiceName()
    {
        String input = "我们的服务真好";
        ServicePage.serviceNameInput(input, BaseParpare.seleniumUtil);
    }

    /**
     * @description 验证上传图片
     */
    @Test(groups =
    { "service" }, dependsOnMethods =
    { "ServiceName" }, alwaysRun = true)
    public void ServiceIMGUpload()
    {
        String input = "./res/img/bocai.jpg";
        String actual = ServicePage.serviceIMGUpload(input, BaseParpare.seleniumUtil);
        if (!actual.isEmpty())
        {
            logger.info("上传图片成功");
        }
    }

    /**
     * @description 修改服务描述
     */
    @Test(groups =
    { "service" }, dependsOnMethods =
    { "ServiceIMGUpload" }, alwaysRun = true)
    public void ServiceDescription()
    {
        String input = "遇到每一位客人和同事时，给予真诚的微笑。表现喜达屋是一个温暖的";
        ServicePage.descripitonInput(input, BaseParpare.seleniumUtil);
    }

     /**
     * @description 点击确定
     */
     @Test(groups =
     { "service" }, dependsOnMethods =
     { "ServiceDescription" }, alwaysRun = true)
     public void Confirm()
     {
     ServicePage.Confirm(BaseParpare.seleniumUtil);
     }
    
     /**
     * @description 验证上传数据
     */
     @Test(groups =
     { "service" }, dependsOnMethods =
     { "Confirm" }, alwaysRun = true)
     public void EditVerification()
     {
     // 验证服务标题
     String serviceName = ServicePage.ServiceName(BaseParpare.seleniumUtil);
     String nameInput = "我们的服务真好";
     seleniumUtil.isTextCorrect(serviceName, nameInput);
     seleniumUtil.pause(2000);
     // 验证服务描述
     String serviceDescrioption =
     ServicePage.ServiceDescription(BaseParpare.seleniumUtil);
     String descriptionInput = "遇到每一位客人和同事时，给予真诚的微笑。表现喜达屋是一个温暖的";
     seleniumUtil.isTextCorrect(serviceDescrioption, descriptionInput);
     seleniumUtil.pause(2000);
     // 验证服务图片
     }

}
