package com.acsm.test.testpages.purchase.workflow.orderfinish;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.acsm.test.testpages.purchase.orderoperatelist.OrderOperateListElements;
import com.acsm.test.testpages.purchase.workflow.orderaudit.OrderAudit;
import com.acsm.test.testpages.purchase.workflow.orderaudit.OrderAuditElement;
import com.acsm.test.utils.SeleniumUtil;

public class OrderFinish {

	public static Logger logger = Logger.getLogger(SeleniumUtil.class.getName());
	public static WebDriver driver = SeleniumUtil.driver;
	
	/**
	 * 进入订单已完成
	 * @param seleniumUtil
	 */
	public static void orderFinish(SeleniumUtil seleniumUtil){
		seleniumUtil.pause(2000);
		seleniumUtil.click(OrderOperateListElements.OOL_BTN_FINISH);
		seleniumUtil.pause(2000);
		
	}
	
	/**
	 * 验证已完成订单数量
	 */
	public static int orderCount(SeleniumUtil seleniumUtil){
		seleniumUtil.pause(2000);
		String count = seleniumUtil.getText(OrderFinishElement.OF_BTN_COMPLETECOUNT);
		seleniumUtil.pause(2000);
		return Integer.parseInt(count);
	}
	
	/**
	 * 搜索新生成的订单，确保生成成功
	 */
	public static boolean orderSearch(SeleniumUtil seleniumUtil,String str){
		seleniumUtil.clear(OrderFinishElement.OF_INPUT_SERACH);
		seleniumUtil.type(OrderFinishElement.OF_INPUT_SERACH, str);
		seleniumUtil.pause(2000);
		seleniumUtil.click(OrderFinishElement.OF_BTN_SERACH);
		seleniumUtil.pause(2000);
		return seleniumUtil.isDisplayed(driver.findElement(OrderAuditElement.OA_STRING_ORDERNUMBER));
	}
}
