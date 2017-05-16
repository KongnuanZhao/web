package com.acsm.test.testcases.farmshow;

import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import com.acsm.test.base.BaseParpare;
import com.acsm.test.testpages.farmshow.ourposition.OurPositionElements;
import com.acsm.test.testpages.farmshow.ourposition.OurPositionPage;
import com.acsm.test.utils.SeleniumUtil;

import junit.framework.Assert;

/**
 * 
    * @ClassName: FarmPosition_Page
    * @Description: 我们的位置
    * @author Kuu
    * @date 2016年11月8日
    *
 */
public class FarmPosition_Page extends BaseParpare
{

    public static Logger logger = Logger.getLogger(SeleniumUtil.class.getName());

    /**
     * @description 验证进入我们的位置
     * @author GuoKuo
     * 
     */
    @Test(groups =
    { "position" }, alwaysRun = true)
    public void openOurPositionPage()
    {
        String scenePageName = OurPositionPage.farmPositionPage(BaseParpare.seleniumUtil);
        seleniumUtil.isTextCorrect(scenePageName, "我们的位置");
    }

    /**
     * @description 验证默认标题
     * 
     * @author GuoKuo
     */
    @Test(groups =
    { "position" }, alwaysRun = true, dependsOnMethods =
    { "openOurPositionPage" })
    public void positonPageTitle()
    {

        String positionPageTitle = OurPositionPage.positionPageTitleByDefault(BaseParpare.seleniumUtil);
        seleniumUtil.isTextCorrect(positionPageTitle, "我们的位置");
    }

    /**
     * @description 验证错误提示对话框
     * @author GuoKuo
     */
    @Test(groups =
    { "position" }, alwaysRun = true, dependsOnMethods =
    { "openOurPositionPage" })
    public void alertVerification()
    {

        Alert alert = OurPositionPage.alertTextVerification(BaseParpare.seleniumUtil);
        String alertString = alert.getText();
        seleniumUtil.isTextCorrect(alertString, "页面主题最多能为10个字！");
        alert.accept();
        seleniumUtil.clear(OurPositionElements.PAGE_TITLE_ON_EDITWORKFLOW);
        seleniumUtil.type(OurPositionElements.PAGE_TITLE_ON_EDITWORKFLOW, "我们的位置");
    }

    /**
     * @description 验证农场位置
     * @author GuoKuo
     *
     */
    @Test(groups =
    { "position" }, alwaysRun = true, dependsOnMethods =
    { "openOurPositionPage" })
    public void positionVerification()
    {
        Map<String, String> address = OurPositionPage.positonVerification();
        String localication = address.get("地址");
        String except = OurPositionPage.getPositon();
        Assert.assertEquals(except, localication);
    }

    /**
     * @description 纬度合理性验证
     * @author GuoKuo
     */
    @Test(groups =
    { "position" }, alwaysRun = true, dependsOnMethods =
    { "openOurPositionPage" })
    public void latitudeVerification()
    {
        // 获取数据库中的经纬度
        Map<String, String> coordinate = OurPositionPage.getCoordinateinDB(BaseParpare.seleniumUtil);
        String latitude = coordinate.get("纬度");
        String longitude = coordinate.get("经度");

        // 获取实际结果（页面）
        // String latitude = op.latitudeVerification();
        // double num = Double.valueOf(latitude.substring(1)).doubleValue();

        // 获取实际结果（数据库）
        double coordinateY = Double.valueOf(latitude).doubleValue();
        double coordinateX = Double.valueOf(longitude).doubleValue();
        if (coordinateY > 4 || coordinateY < 53.33)
        {
            logger.info("获取的纬度为：" + coordinateY + "位置合规");
        } else
        {
            logger.info("纬度不合规");
        }

        if (coordinateX > 73 || coordinateX < 135.30)
        {
            logger.info("获取的纬度为：" + coordinateX + "位置合规");
        } else
        {
            logger.info("经度不合规");
        }
    }

}
