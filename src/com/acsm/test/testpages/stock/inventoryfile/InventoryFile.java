package com.acsm.test.testpages.stock.inventoryfile;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.acsm.test.utils.SeleniumUtil;

public class InventoryFile {

	public static Logger logger = Logger.getLogger(SeleniumUtil.class.getName());
	public static WebDriver driver = SeleniumUtil.driver;

	/**
	 * 等待页面元素加载
	 * 
	 * @param seleniumUtil
	 * @param timeOut
	 *            等待超时时间
	 */
	public static void waitElementsLoad(SeleniumUtil seleniumUtil, int timeOut) {
		seleniumUtil.waitForElementToLoad(timeOut, InventoryFileElements.IF_LIST_LEVEL);
		seleniumUtil.waitForElementToLoad(timeOut, InventoryFileElements.IF_BTN_LEVEL);
		seleniumUtil.waitForElementToLoad(timeOut, InventoryFileElements.IF_LIST_GOODSDEPOT);
		seleniumUtil.waitForElementToLoad(timeOut, InventoryFileElements.IF_LIST_GOODSTYPE);
		seleniumUtil.waitForElementToLoad(timeOut, InventoryFileElements.IF_LIST_PICKER);
		seleniumUtil.waitForElementToLoad(timeOut, InventoryFileElements.IF_INPUT_SEARCH);
		seleniumUtil.waitForElementToLoad(timeOut, InventoryFileElements.IF_BTN_SEARCH);
		seleniumUtil.waitForElementToLoad(timeOut, InventoryFileElements.IF_BTN_EXPORT);
		seleniumUtil.waitForElementToLoad(timeOut, InventoryFileElements.IF_LIST_STOCKINFO);
	}

	/**
	 * 验证收缩按钮 - 收缩
	 * 
	 * @param seleniumUtil
	 * @return
	 */
	public static boolean sideBarHidden(SeleniumUtil seleniumUtil) {
		WebElement sideBar = driver.findElement(InventoryFileElements.IF_LIST_LEVEL);
		seleniumUtil.click(InventoryFileElements.IF_BTN_LEVEL);
		return sideBar.isDisplayed();
	}

	/**
	 * 验证收缩按钮 -打开
	 * 
	 * @param seleniumUtil
	 * @return
	 */
	public static boolean sideBarShow(SeleniumUtil seleniumUtil) {
		WebElement sideBar = driver.findElement(InventoryFileElements.IF_LIST_LEVEL);
		seleniumUtil.click(InventoryFileElements.IF_BTN_LEVEL);
		seleniumUtil.pause(2000);
		seleniumUtil.click(InventoryFileElements.IF_BTN_LEVEL);
		seleniumUtil.pause(2000);
		return sideBar.isDisplayed();
	}
	
	/**
	 * 点击仓库，验证下拉列表是否打开
	 * 
	 * @param seleniumUtil
	 * @return
	 */
	public static boolean goodsDepot(SeleniumUtil seleniumUtil){
		seleniumUtil.click(InventoryFileElements.IF_LIST_GOODSDEPOT);
		WebElement goodsDepotList = driver.findElement(InventoryFileElements.IF_LIST_GOODSDEPOTLIST);
		return goodsDepotList.isDisplayed();
	}
	
	/**
	 * 点击物料类型，验证下拉列表是否打开
	 * 
	 * @param seleniumUtil
	 * @return
	 */
	public static boolean goodsType(SeleniumUtil seleniumUtil){
		seleniumUtil.click(InventoryFileElements.IF_LIST_GOODSTYPE);
		WebElement goodsDepotList = driver.findElement(InventoryFileElements.IF_LIST_GOODSTYPELIST);
		return goodsDepotList.isDisplayed();
	}
	
	/**
	 * 点击经办人，验证下拉列表是否打开
	 * 
	 * @param seleniumUtil
	 * @return
	 */
	public static boolean picker(SeleniumUtil seleniumUtil){
		seleniumUtil.click(InventoryFileElements.IF_LIST_PICKER);
		WebElement goodsDepotList = driver.findElement(InventoryFileElements.IF_LIST_PICKERLIST);
		return goodsDepotList.isDisplayed();
	}
	
	
	/**
	 * 点击来源，验证下拉列表是否打开
	 * 
	 * @param seleniumUtil
	 * @return
	 */
	public static boolean goodsResouce(SeleniumUtil seleniumUtil){
		seleniumUtil.click(InventoryFileElements.IF_LIST_RESOURCE);
		WebElement goodsDepotList = driver.findElement(InventoryFileElements.IF_LIST_RESOURCELIST);
		return goodsDepotList.isDisplayed();
	}
	
	/**
	 * 验证导出
	 * 
	 * @param seleniumUtil
	 * @return
	 * @throws IOException 
	 */
	public static boolean fileDownload(SeleniumUtil seleniumUtil, int timeout) throws IOException{
		seleniumUtil.click(InventoryFileElements.IF_BTN_EXPORT);
		seleniumUtil.pause(timeout);
		File file=new File("C:\\Users\\Kuu\\Downloads\\库存档案.xls");
		if (file.exists()) {
			file.delete();
			file.createNewFile();
		}
		return file.exists();
	}
	
	/**
	 * 验证搜索
	 * 
	 * @param seleniumUtil
	 * @return
	 */
	public static String stockSearch(SeleniumUtil seleniumUtil,String string){
		
		seleniumUtil.clear(InventoryFileElements.IF_INPUT_SEARCH);
		seleniumUtil.type(InventoryFileElements.IF_INPUT_SEARCH, string);
		seleniumUtil.pause(2000);
		seleniumUtil.click(InventoryFileElements.IF_BTN_SEARCH);
		seleniumUtil.pause(2000);

		String result = driver.findElement(InventoryFileElements.IF_STRING_SEARCHRESULT).getText();
		return result;
	}
}
