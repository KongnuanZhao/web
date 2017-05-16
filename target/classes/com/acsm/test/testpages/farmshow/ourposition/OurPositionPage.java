package com.acsm.test.testpages.farmshow.ourposition;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.acsm.test.utils.JdbcUtil;
import com.acsm.test.utils.SeleniumUtil;

/**
 * @ClassName: FarmPosition_Page
 * @description 农场实景测试用例
 * @author GuoKuo
 * @date 2016年7月12日
 *
 */

public class OurPositionPage
{
    public static Logger logger = Logger.getLogger(SeleniumUtil.class.getName());
    public static WebDriver driver = SeleniumUtil.driver;

    protected String actualPageTitle; // 实际页面标题
    protected String setPageTitle; // 设置页面标题
    protected String farmLocalStr_1; // 农场位置
    protected String longitude; // 经度
    protected String latitude; // 纬度
    static String sql = null;
    public static String address;

    /**
     * @Title: farmPositionPage @description 农场位置@param 参数 @return void
     *         返回类型 @throws
     */
    public static String farmPositionPage(SeleniumUtil seleniumUtil)
    {
        // 进入我们的位置
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",
                driver.findElement(OurPositionElements.CLICK_OUR_POSITION));
        WebElement element =driver.findElement(OurPositionElements.CLICK_OUR_POSITION);
        element.click();
//        seleniumUtil.click(OurPositionElements.CLICK_OUR_POSITION);//56版本chromedriver不支持此处点击事件，原因尚未可知
        return seleniumUtil.getText(OurPositionElements.OP_STRING_PAGE);
    }

    /**
     * @Title: positionPageTitleByDefault @description 获取页面主题 @param 参数 @return
     *         void 返回类型 @throws
     */
    public static String positionPageTitleByDefault(SeleniumUtil seleniumUtil)
    {
        // 验证默认项目名称
        WebElement getProjectName = driver.findElement(OurPositionElements.PAGE_TITLE_ON_EDITWORKFLOW);
        return getProjectName.getAttribute("value");

    }

    /**
     * @Title: getFarmPosition @description 获取农场地址 @param 参数 @return void
     *         返回类型 @throws
     */
    public static String getFarmPosition(SeleniumUtil seleniumUtil)
    {
        // 获取农场地址
        WebElement getPosition = driver.findElement(OurPositionElements.OUR_POSITION);
        return getPosition.getText().toString().substring(3, 12);

    }

    /**
     * @Title: alertTextVerification @description 验证弹出框文字 @param 参数 @return void
     *         返回类型 @throws
     */
    public static Alert alertTextVerification(SeleniumUtil seleniumUtil)
    {
        seleniumUtil.executeJS("arguments[0].scrollIntoView(true)",
                driver.findElement(By.xpath("//*[@id='all:positionTitleId']")));
        seleniumUtil.click(OurPositionElements.PAGE_TITLE_ON_EDITWORKFLOW);
        seleniumUtil.type(OurPositionElements.PAGE_TITLE_ON_EDITWORKFLOW, "OurPosition");
        // 触发字数限制alert
        seleniumUtil.click(OurPositionElements.CLICK_PHONE);
        // 处理删除alert
        seleniumUtil.switchToPromptedAlertAfterWait(2000);
        Alert alert = driver.switchTo().alert();
        return alert;
    }

    /**
     * @Title: positonVerification @description 对比农场地址 @param 参数 @return void
     *         返回类型 @throws
     */
    public static Map<String, String> positonVerification()
    {
        sql = "SELECT address FROM `base` where id = 1470;";// SQL语句
        // 验证农场地址
        Map<String, String> locationList = new HashMap<String, String>();
        String location = JdbcUtil.query(sql, "address");
        locationList.put("地址", location);
        return locationList;
    }
    //获取页面地址
    public static String getPositon()
    {
        // 验证农场地址
        WebElement getFarmAddress = driver.findElement(By.xpath("//form/div[1]/div[2]/input[2]"));
        address = getFarmAddress.getAttribute("value");
        return address;
    }
    

    /**
     * @description 从数据库中获取农场经纬度
     */
    public static Map<String, String> getCoordinateinDB(SeleniumUtil seleniumUtil)
    {
        sql = "SELECT coordinate_X, coordinate_Y FROM `base` where id = 1470;";// SQL语句
        Map<String, String> result = new HashMap<String, String>();
        String latitude = JdbcUtil.query(sql, "coordinate_X");
        String longitude = JdbcUtil.query(sql, "coordinate_Y");
        result.put("纬度", latitude);
        result.put("经度", longitude);
        return result;
    }

    /**
     * @Title: latitudeVerification @description 验证农场纬度 @param 参数 @return
     *         String 返回类型 @throws
     */
    public static String latitudeVerification(SeleniumUtil seleniumUtil)
    {
        WebElement getWeiDuValue = driver
                .findElement(By.cssSelector("div.listRight.current div:nth-child(2) p:nth-child(9)"));
        return getWeiDuValue.getText();
    }

    /**
     * @Title: longitudeVerification @description 验证农场经度 @param 参数 @re。turn
     *         String 返回类型 @throws
     */
    public static String longitudeVerification(SeleniumUtil seleniumUtil)
    {
        WebElement getJingDuValue = driver
                .findElement(By.cssSelector("div.listRight.current div:nth-child(2) p:nth-child(7)"));
        return getJingDuValue.getText();
    }
}
