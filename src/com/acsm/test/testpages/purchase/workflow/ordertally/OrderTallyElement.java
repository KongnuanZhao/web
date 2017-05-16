package com.acsm.test.testpages.purchase.workflow.ordertally;

import org.openqa.selenium.By;

public class OrderTallyElement {

	// 理货
	public static final By OT_BTN_TALLY = By.xpath("//span[@class='auditBtn']//a[contains(text(),'理货')]");
	
	//跳过理货
	public static final By OT_BTN_WITHOUTTALLY = By.xpath("//span[@class='auditBtn']//a[contains(text(),'理货')]//following::a");	
	// 打印理货单
	public static final By OT_BTN_PRINT = By.xpath("//a[@title='打印理货单']");
	// 完成
	public static final By OT_BTN_DONE = By.xpath("//input[contains(@value,'完成')]");

	// 理货数量
	public static final By OT_INPUT_DTALLYCOUNT = By.id("num_0");

	// 有机追溯吗
	public static final By OT_INPUT_DTALLYCODE = By.id("tracingCode_0");

	// duihukuang
	public static final By OT_DIALOG_TALLYCODE = By.cssSelector("#myModal_ZScode .modal-content");

	// shuruhuang
	public static final By OT_INPUT_TALLYCODE = By.id("tracingCode");

	// shuruhuang
	public static final By OT_BTN_CONFIRM = By.cssSelector("#myModal_ZScode a.btn.btn-success");

}
