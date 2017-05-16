package com.acsm.test.testpages.stock.outstoragelist;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import com.acsm.test.utils.SeleniumUtil;

public class OutstorageList_Helper {
	public static Logger logger = Logger.getLogger(OutstorageList_Helper.class);


	/**
	 * 出库明细点击事件
	 */
	public static void click(SeleniumUtil seleniumUtil, By byElement){
		seleniumUtil.click(byElement);
	}
	
	/** 等待入库明细页面加载 */
	public static void waitPageUI(SeleniumUtil seleniumUtil, int elementTimeOut) {
		seleniumUtil.waitForElementToLoad(elementTimeOut, OutstorageListElement.OL_BTN_ROOM);
		seleniumUtil.waitForElementToLoad(elementTimeOut, OutstorageListElement.OL_BTN_GOODSTYPE);
		seleniumUtil.waitForElementToLoad(elementTimeOut, OutstorageListElement.OL_BTN_OPERATOR);
		seleniumUtil.waitForElementToLoad(elementTimeOut, OutstorageListElement.OL_BTN_INSTOCKTYPE);
		seleniumUtil.waitForElementToLoad(elementTimeOut, OutstorageListElement.OL_INPUT_SEARCH);
		seleniumUtil.waitForElementToLoad(elementTimeOut, OutstorageListElement.OL_BTN_SEARCH);
//		seleniumUtil.waitForElementToLoad(elementTimeOut, OutstorageListElement.OL_BTN_EXPORT);
		logger.info("出库明细加载完毕");
	}
	
	/**
	 * 出库明细输入事件
	 */
	public static void input(SeleniumUtil seleniumUtil, By byElement,String str){
		seleniumUtil.type(byElement, str);
	}
	
	/**
	 * 出库明细暂停事件
	 */
	public static void wait(SeleniumUtil seleniumUtil){
		seleniumUtil.pause(2000);
	}
	
	/**
	 * 出库明细等待事件
	 */
	public static void waitForElementLoaded(SeleniumUtil seleniumUtil, int timeOut, By byElement){
		seleniumUtil.waitForElementToLoad(timeOut, byElement);
	}
	
	/**
	 *出库明细操作alert
	 */
	public static void alert(SeleniumUtil seleniumUtil, int timeOut){
		Alert alert = seleniumUtil.switchToPromptedAlertAfterWait(timeOut);
		alert.accept();
	}
	
	/**
	 * 出库明细清空事件
	 */
	public static void clear(SeleniumUtil seleniumUtil, By byElement){
		seleniumUtil.clear(byElement);
	}

	/**
	 * 出库明细判断事件
	 */
	public static boolean compare(SeleniumUtil seleniumUtil, By byElement){
		
		return seleniumUtil.doesElementsExist(byElement);
	}
	
	/**
	 * 验证导出
	 * 
	 * @param seleniumUtil
	 * @return
	 * @throws IOException 
	 */
	public static boolean fileDownload(SeleniumUtil seleniumUtil, int timeout) throws IOException{
		File file=new File("C:\\Users\\Kuu\\Downloads\\出库明细.xls");
		if (file.exists()) {
			file.delete();
			file.createNewFile();
		}
		return file.exists();
	}


}
