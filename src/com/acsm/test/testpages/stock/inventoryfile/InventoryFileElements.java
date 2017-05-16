package com.acsm.test.testpages.stock.inventoryfile;

import org.openqa.selenium.By;

public class InventoryFileElements {

	/** 左侧库存模块栏 */
	public static final By IF_LIST_LEVEL = By.xpath("//div[@class='inbentory_level']");

	/** 隐藏目录按钮 */
	public static final By IF_BTN_LEVEL = By.xpath("//i[@class='collapse_btn']");

	/** 仓库 */
	public static final By IF_LIST_GOODSDEPOT = By.xpath("//button[contains(@data-id,'storageRoom')]");

	/** 仓库列表 */
	public static final By IF_LIST_GOODSDEPOTLIST = By.xpath("//ul[@role='menu']");
	/** 物料类型 */
	public static final By IF_LIST_GOODSTYPE = By.xpath("//button[contains(@data-id,'goodsType')]");

	/** 物料类型列表 */
	public static final By IF_LIST_GOODSTYPELIST = By.xpath("//dl[2]//ul");
	/** 经办人 */
	public static final By IF_LIST_PICKER = By.xpath("//button[contains(@data-id,'operator')]");
	/** 经办人列表 */
	public static final By IF_LIST_PICKERLIST = By.xpath("//div[2]/dl[1]/dd/div/div/ul");
	/** 来源 */
	public static final By IF_LIST_RESOURCE = By.xpath("//button[@data-id='goodsSource']");
	/** 来源列表 */
	public static final By IF_LIST_RESOURCELIST = By.xpath("//div[2]/dl[2]/dd/div/div/ul");
	/** 搜索输入框 */
	public static final By IF_INPUT_SEARCH = By.id("code");

	/** 搜索按钮 */
	public static final By IF_BTN_SEARCH = By.id("searchButton");

	/** 导出按钮 */
	public static final By IF_BTN_EXPORT = By.xpath("//img[contains(@src,'exportExcel')]");

	/** 库存内容 */
	public static final By IF_LIST_STOCKINFO = By.xpath("//table[@class='inventory_modal_table mt20']");
	
	/** 搜索结果内容 */
	public static final By IF_STRING_SEARCHRESULT = By.xpath("//tr[@class='odd']/td[2]");
	

}
