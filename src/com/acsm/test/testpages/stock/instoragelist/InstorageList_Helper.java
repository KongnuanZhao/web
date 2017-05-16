package com.acsm.test.testpages.stock.instoragelist;

import java.io.File;
import java.io.IOException;

import javax.swing.text.html.MinimalHTMLWriter;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import com.acsm.test.utils.SeleniumUtil;

public class InstorageList_Helper {
	public static Logger logger = Logger.getLogger(InstorageList_Helper.class);


	/**
	 * 入库明细点击事件
	 */
	public static void click(SeleniumUtil seleniumUtil, By byElement){
		seleniumUtil.click(byElement);
	}
	
	/** 等待入库明细页面加载 */
	public static void waitPageUI(SeleniumUtil seleniumUtil, int elementTimeOut) {
		seleniumUtil.waitForElementToLoad(elementTimeOut, InstorageListElement.IL_BTN_ROOM);
		seleniumUtil.waitForElementToLoad(elementTimeOut, InstorageListElement.IL_BTN_GOODSTYPE);
		seleniumUtil.waitForElementToLoad(elementTimeOut, InstorageListElement.IL_BTN_OPERATOR);
		seleniumUtil.waitForElementToLoad(elementTimeOut, InstorageListElement.IL_BTN_INSTOCKTYPE);
		seleniumUtil.waitForElementToLoad(elementTimeOut, InstorageListElement.IL_INPUT_SEARCH);
		seleniumUtil.waitForElementToLoad(elementTimeOut, InstorageListElement.IL_BTN_SEARCH);
//		seleniumUtil.waitForElementToLoad(elementTimeOut, InstorageListElement.IL_BTN_EXPORT);
		logger.info("入库明细加载完毕");
	}
	
	/**
	 * 入库明细输入事件
	 */
	public static void input(SeleniumUtil seleniumUtil, By byElement,String str){
		seleniumUtil.type(byElement, str);
	}
	
	/**
	 * 入库明细等待事件
	 */
	public static void waitForElementLoaded(SeleniumUtil seleniumUtil, int timeOut, By byElement){
		seleniumUtil.waitForElementToLoad(timeOut, byElement);
	}
	
	/**
	 * 入库明细操作alert
	 */
	public static void alert(SeleniumUtil seleniumUtil, int waitMillisecondsForAlert){
		Alert alert = seleniumUtil.switchToPromptedAlertAfterWait(waitMillisecondsForAlert);
		alert.accept();
	}
	
	/**
	 * 入库明细清空事件
	 */
	public static void clear(SeleniumUtil seleniumUtil, By byElement){
		seleniumUtil.clear(byElement);
	}
	
	/**
	 * 入库明细等待事件
	 */
	public static void wait(SeleniumUtil seleniumUtil){
		seleniumUtil.pause(2000);
	}

	/**
	 * 入库明细判断事件
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
