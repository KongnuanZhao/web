package com.acsm.test.testpages.farmshow.supply;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.acsm.test.testpages.farmshow.corver.ProjectSettingPageElements;
import com.acsm.test.testpages.farmshow.ourhonor.OurHonorElements;
import com.acsm.test.testpages.farmshow.safeplant.SafePlantingElements;
import com.acsm.test.utils.SeleniumUtil;

public class ProductsSupply
{
    public static Logger logger = Logger.getLogger(SeleniumUtil.class.getName());
    public static WebDriver driver = SeleniumUtil.driver;

    /**
     * @Title: supplyPage
     * @description 进入产品供应，验证标题
     * @param seleniumUtil
     * @return String 返回类型
     */
    public static String SupplyPage(SeleniumUtil seleniumUtil)
    {

        /** 点击特色产品 */
        seleniumUtil.executeJS("arguments[0].scrollIntoView(true)",
                driver.findElement(ProductsSupplyElements.PS_ELEMENT_SUPPLY));
        WebElement element =driver.findElement(ProductsSupplyElements.PS_ELEMENT_SUPPLY);
        element.click();
//        seleniumUtil.click(ProductsSupplyElements.PS_ELEMENT_SUPPLY);
        logger.info("进入产品供应");
        /** 验证页面主题 */
        String pageTitle = seleniumUtil.getAttributeText(ProductsSupplyElements.GET_PAGE_TITLE, "value");
        return pageTitle;
    }

    /**
     * 
     * @Title: SupplyPageTitleEdit @description: 更换页面主题 @param 参数 @return Alert
     *         返回类型 @throws
     */
    public static String SupplyPageTitleEdit(String input, SeleniumUtil seleniumUtil)
    {
        String str = null;
        // 验证默认项目名称
        if (input.length() >= 10)
        {
            seleniumUtil.clear(ProductsSupplyElements.GET_PAGE_TITLE);
            seleniumUtil.type(ProductsSupplyElements.GET_PAGE_TITLE, input);
            seleniumUtil.click(ProjectSettingPageElements.PS_IMG_PHONE);
            Alert alert = seleniumUtil.switchToPromptedAlertAfterWait(2000);
            str = alert.getText();
            seleniumUtil.pause(2000);
            alert.accept();
        } else
        {
            seleniumUtil.clear(ProductsSupplyElements.GET_PAGE_TITLE);
            seleniumUtil.type(ProductsSupplyElements.GET_PAGE_TITLE, input);
            seleniumUtil.click(ProjectSettingPageElements.PS_IMG_PHONE);
            WebElement element = driver.findElement(ProductsSupplyElements.PRE_PHONE_TITLE);
            str = element.getText();
        }
        return str;
    }

    /**
     * @Title: WSCheckbox
     * @param seleniumUtil
     * @description 验证微商城是否勾选
     * @return WebElement
     */
    public static WebElement WSCheckbox(SeleniumUtil seleniumUtil)
    {
        WebElement WSCheckBox = driver.findElement(ProductsSupplyElements.CHECKBOX_MICRO_MART);
        // seleniumUtil.isSelected(driver.findElement(ProductsSupplyElements.CHECKBOX_MICRO_MART));
        seleniumUtil.click(ProductsSupplyElements.CHECKBOX_MICRO_MART);
        return WSCheckBox;
    }

    /**
     * @Title: WSInput
     * @description 验证微商城输入内容是否正确
     * @param seleniumUtil
     * @return String 返回类型
     */

    public static String WSInput(String inputHTML, SeleniumUtil seleniumUtil)
    {
        seleniumUtil.isDisplayed(driver.findElement(ProductsSupplyElements.INPUT_MICRO_MART));
        seleniumUtil.type(ProductsSupplyElements.INPUT_MICRO_MART, inputHTML);
//        seleniumUtil.click(ProjectSettingPageElements.PS_IMG_PHONE);
        seleniumUtil.click(ProductsSupplyElements.GET_PAGE_TITLE);
        String str = driver.findElement(By.id("supplyMarketUrl")).getAttribute("href");
        return str;
    }

    /**
     * @Title: supplyCount
     * @description 验证上传供应图片数量
     * @param inputCount
     * @param seleniumUtil
     * @return int 返回类型
     */

    public static int SupplyCount(int inputCount, SeleniumUtil seleniumUtil)
    {
        /** 点击选择供应商品 */
        seleniumUtil.click(ProductsSupplyElements.SUPPLY_PRODUCTS_ICON);
//        WebElement element = driver.findElement(ProductsSupplyElements.SUPPLY_PRODUCTS_ICON);
//        element.click();
        seleniumUtil.waitForElementToLoad(1000, ProductsSupplyElements.IMAGE_SELECT_DIALOG);
        // 选择任意供应
        List<WebElement> currentImgList = seleniumUtil.findElementsBy(ProductsSupplyElements.IMAGE_SELECT_DIALOG);
        currentImgList.get(0).click();
        currentImgList.get(1).click();
        currentImgList.get(2).click();
        currentImgList.get(3).click();
//        List<Integer> selectSizes = seleniumUtil.randomList1(inputCount, currentImgList);
//        for (int selectSize : selectSizes)
//        {
//            currentImgList.get(selectSize).click();
//        }
        seleniumUtil.click(ProductsSupplyElements.CONFIRM_BUTTON);
        seleniumUtil.pause(2000);
        List<WebElement> listImg = seleniumUtil.findElementsBy(ProductsSupplyElements.IMAGE_SELECT);
        int imgCount = listImg.size();
        logger.info("共上传" + imgCount + "张供应图片");
        return imgCount;
    }

    /**
     * @Title: presell
     * @Description: 选择预售图片
     * @param inputPresell
     * @param seleniumUtil
     * @return int 返回类型
     */
    public static int Presell(int inputPresell, SeleniumUtil seleniumUtil)
    {
        /** 点击预售商品 */
        seleniumUtil.executeJS("arguments[0].scrollIntoView(true)",
                driver.findElement(By.xpath("//div[@onclick='openSupply(0)']")));
        seleniumUtil.click(ProductsSupplyElements.PRE_SALE_PRODUCTS_ICON);
        seleniumUtil.pause(2000);
        seleniumUtil.waitForElementToLoad(1000, ProductsSupplyElements.PRE_SALE_PRODUCTS_IMAGE);
        List<WebElement> presellImgList1 = seleniumUtil.findElementsBy(ProductsSupplyElements.IMAGE_SELECT_DIALOG);
//        List<Integer> selectSizes = seleniumUtil.randomList1(inputPresell, presellImgList1);
        presellImgList1.get(0).click();
        presellImgList1.get(1).click();
        presellImgList1.get(2).click();
        presellImgList1.get(3).click();
        presellImgList1.get(4).click();
        presellImgList1.get(5).click();
//        for (int selectSize : selectSizes)
//        {
//            presellImgList1.get(selectSize).click();
//        }
        seleniumUtil.pause(2000);
        seleniumUtil.click(ProductsSupplyElements.CONFIRM_BUTTON);
        seleniumUtil.pause(2000);
        List<WebElement> listImg = seleniumUtil.findElementsBy(ProductsSupplyElements.PRESELL_IMAGE_SELECT);
        int imgCount = listImg.size();
        logger.info("共上传" + imgCount + "张预售供应图片");
        return imgCount;
    }
    
    /**
     * @Title: SupplyIMGDEL
     * @description 验证供应图片删除
     * @param seleniumUtil
     */

    public static int SupplyIMGDEL(SeleniumUtil seleniumUtil)
    {
        seleniumUtil.mouseMoveToElement(ProductsSupplyElements.IMAGE_SELECT);
        seleniumUtil.pause(1000);
        seleniumUtil.click(ProductsSupplyElements.PRE_BTN_DELETE);
        seleniumUtil.pause(1000);
        List<WebElement> list = driver.findElements(ProductsSupplyElements.IMAGE_SELECT);
        return list.size();
    }

    /**
     * @Title: PreSupplyIMGDEL
     * @description 验证预售供应图片删除
     * @param seleniumUtil
     */

    public static int PreSupplyIMGDEL(SeleniumUtil seleniumUtil)
    {
        seleniumUtil.pause(1000);
        seleniumUtil.executeJS("arguments[0].scrollIntoView(true)",
                driver.findElement(ProductsSupplyElements.PRE_ELE_PRE));
        seleniumUtil.mouseMoveToElement(ProductsSupplyElements.PRE_ELE_PRE);
        seleniumUtil.pause(1000);
        seleniumUtil.click(ProductsSupplyElements.PRE_BTN_PREDELETE);
        seleniumUtil.pause(1000);
        List<WebElement> list = driver.findElements(ProductsSupplyElements.PRE_ELE_PRE);
        return list.size();
    }
    
    /**
     * @Title: PresellAddAfterDEL
     * @Description: 删除后重新添加供应图片
     * @param seleniumUtil
     */
    public static void PresellAddAfterDEL(SeleniumUtil seleniumUtil)
    {
        /** 点击预售商品 */
        seleniumUtil.executeJS("arguments[0].scrollIntoView(true)",
                driver.findElement(By.xpath("//div[@onclick='openSupply(0)']")));
        seleniumUtil.click(ProductsSupplyElements.PRE_SALE_PRODUCTS_ICON);
        seleniumUtil.pause(2000);
        seleniumUtil.waitForElementToLoad(1000, ProductsSupplyElements.PRE_SALE_PRODUCTS_IMAGE);
        List<WebElement> presellImgList1 = seleniumUtil.findElementsBy(ProductsSupplyElements.IMAGE_SELECT_DIALOG);
        presellImgList1.get(0).click();
        seleniumUtil.pause(2000);
        seleniumUtil.click(ProductsSupplyElements.CONFIRM_BUTTON);
        seleniumUtil.pause(2000);
    }
    
    /**
     * @Title: supplyCount
     * @description 验证上传供应图片数量
     * @param inputCount
     * @param seleniumUtil
     * @return int 返回类型
     */

    public static void SupplyAddAfterDEL(SeleniumUtil seleniumUtil)
    {
        /** 点击选择供应商品 */
        seleniumUtil.click(ProductsSupplyElements.SUPPLY_PRODUCTS_ICON);
        seleniumUtil.waitForElementToLoad(1000, ProductsSupplyElements.IMAGE_SELECT_DIALOG);
        // 选择任意供应
        List<WebElement> currentImgList = seleniumUtil.findElementsBy(ProductsSupplyElements.IMAGE_SELECT_DIALOG);
        currentImgList.get(0).click();
        seleniumUtil.click(ProductsSupplyElements.CONFIRM_BUTTON);
        seleniumUtil.pause(2000);
    }

}
