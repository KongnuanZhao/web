package com.acsm.test.testpages.stock.allocationrecord;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import com.acsm.test.utils.SeleniumUtil;

public class AllocationRecord_Helper {
	public static Logger logger = Logger.getLogger(AllocationRecord_Helper.class);


	/**
	 * 调拨记录点击事件
	 */
	public static void click(SeleniumUtil seleniumUtil, By byElement){
		seleniumUtil.click(byElement);
	}
	
	/**
	 * 调拨记录等待事件
	 */
	public static void wait(SeleniumUtil seleniumUtil){
		seleniumUtil.pause(2000);
	}
	
	/** 调拨记录明细页面加载 */
	public static void waitPageUI(SeleniumUtil seleniumUtil, int elementTimeOut) {
		seleniumUtil.waitForElementToLoad(elementTimeOut, AllocationRecordElement.AR_BTN_ROOM);
		seleniumUtil.waitForElementToLoad(elementTimeOut, AllocationRecordElement.AR_BTN_ROOMANOTHER);
		seleniumUtil.waitForElementToLoad(elementTimeOut, AllocationRecordElement.AR_BTN_OPERATOR);
		seleniumUtil.waitForElementToLoad(elementTimeOut, AllocationRecordElement.AR_INPUT_SEARCH);
		seleniumUtil.waitForElementToLoad(elementTimeOut, AllocationRecordElement.AR_BTN_SEARCH);
//		seleniumUtil.waitForElementToLoad(elementTimeOut, AllocationRecordElement.AR_BTN_EXPORT);
		logger.info("调拨记录加载完毕");
	}
	
	/**
	 * 调拨记录输入事件
	 */
	public static void input(SeleniumUtil seleniumUtil, By byElement,String str){
		seleniumUtil.type(byElement, str);
	}
	
	/**
	 * 调拨记录等待事件
	 */
	public static void waitForElementLoaded(SeleniumUtil seleniumUtil, int timeOut, By byElement){
		seleniumUtil.waitForElementToLoad(timeOut, byElement);
	}
	
	/**
	 * 调拨记录操作alert
	 */
	public static void alert(SeleniumUtil seleniumUtil, int timeOut){
		Alert alert = seleniumUtil.switchToPromptedAlertAfterWait(timeOut);
		alert.accept();
	}
	
	/**
	 * 调拨记录清空事件
	 */
	public static void clear(SeleniumUtil seleniumUtil, By byElement){
		seleniumUtil.clear(byElement);
	}

	/**
	 * 调拨记录判断事件
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
		File file=new File("C:\\Users\\Kuu\\Downloads\\入库明细.xls");
		if (file.exists()) {
			file.delete();
			file.createNewFile();
		}
		return file.exists();
	}


}
