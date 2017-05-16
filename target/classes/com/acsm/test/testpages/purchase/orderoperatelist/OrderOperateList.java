package com.acsm.test.testpages.purchase.orderoperatelist;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.acsm.test.testpages.entsettings.EntSetting;
import com.acsm.test.testpages.purchase.Enter.EnterPurchase;
import com.acsm.test.utils.JdbcUtil;
import com.acsm.test.utils.SeleniumUtil;

public class OrderOperateList {

	public static Logger logger = Logger.getLogger(OrderOperateList.class);
	WebDriver driver = SeleniumUtil.driver;

	/**
	 * Description 查看已勾选的项目，如果缺少执行前去勾选
	 */
	public void orderStatesList(SeleniumUtil seleniumUtil) {
		List<WebElement> list = driver.findElements(OrderOperateListElements.OOL_LIST_ORDERSTATES);
		// 更新订单模块sql
//		String sql = "update enterprise_settings es set es.order_shipments=1, es.order_dispatching =1,  "
//				+ "es.order_receive =1,es.order_tally =1, es.order_repertory=1,es.order_audit=1,es.order_handle=1 where es.enterprise_info_id=933;";
		int count = list.size();
		if (count != 14) {
//			JdbcUtil.update(sql);
			logger.info("订单流程缺失，前去完善。。。");
			seleniumUtil.pause(2000);
			EntSetting.enterSettingsPage(seleniumUtil);// 去系统设置中保存
			EntSetting.sale(seleniumUtil);
			EntSetting.save(seleniumUtil);
			seleniumUtil.waitForPageLoading(2000);
			EnterPurchase.enterPurchasePage(seleniumUtil);
			seleniumUtil.pause(2000);
		} else {
			seleniumUtil.refresh();
		}
	}

	/**
	 * Description 搜索功能验证
	 * 
	 * @return WebElement
	 */
	public WebElement search(String str, SeleniumUtil seleniumUtil) {
		seleniumUtil.click(OrderOperateListElements.OOL_INPUT_SEARCH);
		seleniumUtil.type(OrderOperateListElements.OOL_INPUT_SEARCH, str);
		seleniumUtil.pause(2000);
		seleniumUtil.click(OrderOperateListElements.OOL_BTN_SEARCH);
		WebElement order = driver.findElement(OrderOperateListElements.OOL_ELEMENT_ORDER);
		return order;
	}

	/**
	 * Description 筛选模块展示正常
	 * 
	 * @return WebElement
	 */
	public WebElement filter(SeleniumUtil seleniumUtil) {
		seleniumUtil.isDisplayed(driver.findElement(OrderOperateListElements.OOL_BTN_FILTER));
		seleniumUtil.click(OrderOperateListElements.OOL_BTN_FILTER);
		WebElement filterList = driver.findElement(OrderOperateListElements.OOL_ELEMENT_FILTER);
		return filterList;
	}

	/**
	 * Description 添加订单、采摘、导入导出
	 */
	public void isBtnDisplayed(SeleniumUtil seleniumUtil) {
		seleniumUtil.isDisplayed(driver.findElement(OrderOperateListElements.OOL_BTN_ADDORDER));
		seleniumUtil.isDisplayed(driver.findElement(OrderOperateListElements.OOL_BTN_ADDPICK));
		seleniumUtil.isDisplayed(driver.findElement(OrderOperateListElements.OOL_BTN_IMPORTANDEXPORT));
	}

	/**
	 * Description 验证导出文件 调用时需要传递driver类型，通过xml中parameter传递
	 */
	public boolean export(String driverName, SeleniumUtil seleniumUtil) {
		File file = null;
		seleniumUtil.click(OrderOperateListElements.OOL_BTN_IMPORTANDEXPORT);
		seleniumUtil.waitForElementToLoad(2000, OrderOperateListElements.OOL_LIST_EXPORT);
		seleniumUtil.click(OrderOperateListElements.OOL_LIST_EXPORT);
		seleniumUtil.pause(2000);

		// 确认文件已经下载
		if (driverName.toLowerCase().contains("chrome")) {
			String fileName = "order_export.xls";
			file = new File("C:\\Users\\Kuu\\Downloads" + "\\" + fileName);
		} else if (driverName.toLowerCase().contains("firefox")) {
			// ...
		}
		return file.exists();
	}

	/**
	 * Description 验证导出订单数量
	 * 
	 * @throws IOException
	 */
	public void exportOrderCount(SeleniumUtil seleniumUtil) throws IOException {
		String sql = "SELECT COUNT(order_info_id) as orderNum FROM order_info WHERE enterpriseInfo_id = 933 "
				+ "and deleted = 0 AND DATE_SUB(CURDATE(), INTERVAL 6 DAY) <= insert_time";
		int count = Integer.parseInt(JdbcUtil.query(sql, "orderNum"));
		File file = new File("C:\\Users\\Kuu\\Downloads\\order_export.xls");
		try {
			BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
			POIFSFileSystem fs = new POIFSFileSystem(in);
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			wb.getNumberOfSheets();// 获得excel中sheet的个数
			HSSFSheet st = wb.getSheetAt(0);// 取得第一个sheet
			int actual = st.getLastRowNum();// 这个就能取得第一个sheet中一共多少行
			seleniumUtil.isCountCorrect(actual, count);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Description 导入文件
	 * 调用时需要确认是否上传成功
	 */

	public void importFileDialog(SeleniumUtil seleniumUtil) {
		// 点击导入
		seleniumUtil.click(OrderOperateListElements.OOL_BTN_IMPORTANDEXPORT);
		seleniumUtil.waitForElementToLoad(2000, OrderOperateListElements.OOL_BTN_IMPORT);
		seleniumUtil.click(OrderOperateListElements.OOL_BTN_IMPORT);
		seleniumUtil.pause(2000);
		// 验证导入文件对话框弹出
		WebElement importOrderDialog = driver.findElement(OrderOperateListElements.OOL_DIALOG_IMPORT);
		seleniumUtil.isDisplayed(importOrderDialog);
		// 上传文件
		seleniumUtil.type(OrderOperateListElements.OOL_INPUT_UPLOAD, "D:\\xxxx");
		// 点击确定
		seleniumUtil.click(OrderOperateListElements.OOL_BTN_CONFIRM);
		seleniumUtil.pause(2000);

	}

}
