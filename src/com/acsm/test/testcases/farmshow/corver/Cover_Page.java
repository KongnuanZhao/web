package com.acsm.test.testcases.farmshow.corver;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.acsm.test.base.BaseParpare;
import com.acsm.test.testpages.farmshow.corver.ProjectSettingPageElements;
import com.acsm.test.testpages.farmshow.corver.corverPageElements;
import com.acsm.test.utils.SeleniumUtil;

/**
 * @name 控件设置
 */

public class Cover_Page extends BaseParpare {

	public static Logger logger = Logger.getLogger(SeleniumUtil.class.getName());

	/**
	 * @author GuoKuo
	 * @description 更换背景图片
	 */
	@Test(groups = { "corver" }, alwaysRun = true)
	public void corverPageBGImg() {
		// 点击更换背景图片
		seleniumUtil.click(corverPageElements.CP_BTN_CHANGEBGIMG);
		seleniumUtil.waitForElementToLoad(2000, corverPageElements.CP_DIALOG_BGIMGLIST);
		// 选择背景图片
		List<WebElement> list = seleniumUtil.findElementsBy(corverPageElements.CP_DIALOG_BGIMGLIST);
		int[] arr = seleniumUtil.randomList(list);
		list.get(arr[0]).click();

		// 点击确定
		seleniumUtil.click(corverPageElements.CP_BTN_CONFIRM);

		// // 获取图片地址
		// WebElement selectedBackGroundImg =
		// SeleniumUtil.driver.findElement(corverPageElements.CP_IMAGE_BGIMG);
		// String str = selectedBackGroundImg.getAttribute("src");
		//
		// // 获取展示背景图片
		// WebElement actureBackGroundImg =
		// SeleniumUtil.driver.findElement(corverPageElements.CP_PAGE_SHOWBGIMG);
		// String str1 = actureBackGroundImg.getAttribute("src");
		//
		// // 拼接字符串，添加网站地址
		// String newStr1 = str1.replace("..", "http://app.farmeasy.cn");
		//
		// // 验证图片是否一致
		// Assert.assertEquals(str, newStr1);
	}

	/**
	 * @author GuoKuo
	 * @description 更换LOGO图片
	 */

	@Test(groups = { "corver" }, alwaysRun = true, dependsOnMethods = { "corverPageBGImg" })
	public void corverPageLogo() {
		seleniumUtil.click(corverPageElements.CP_LINK_CHANGELOGO);
		seleniumUtil.pause(2000);

		// 定位iframe,通过sendkeys上传图片，定位iframe后必须要退出frame，返回到默认模式，否则无法继续找元素
		WebElement findIframe = SeleniumUtil.driver.switchTo().frame("myframPicLogo")
				.findElement(corverPageElements.CP_IFRAME_SWITCHTO);
		File file = new File("./res/img/bocai.jpg");
		String str = file.getAbsolutePath();
		findIframe.sendKeys(str);
		SeleniumUtil.driver.switchTo().defaultContent();

		// 点击提交
		seleniumUtil.pause(2000);
		seleniumUtil.click(corverPageElements.CP_BTN_SUBMIT);

		// 验证logo上传成功，通过对比URL判断图片一致
		seleniumUtil.pause(2000);
		WebElement uploadPic = SeleniumUtil.driver.findElement(corverPageElements.CP_IMG_UPLOADLOGO);
		String getUploadPicSrc = uploadPic.getAttribute("src");
		seleniumUtil.pause(2000);
		WebElement resultPic = SeleniumUtil.driver.findElement(corverPageElements.CP_IMG_ACTURELOGO);
		String getResultPicSrc = resultPic.getAttribute("src");

		// 验证图片是否一致
		Assert.assertEquals(getUploadPicSrc, getResultPicSrc);
	}

	/**
	 * @author GuoKuo
	 * @description 更换公司名称
	 */

	@Test(groups = { "corver" }, alwaysRun = true, dependsOnMethods = { "corverPageBGImg" })
	public void corverPageCompanyName() {
		seleniumUtil.executeJS("arguments[0].scrollIntoView(true)",
				SeleniumUtil.driver.findElement(corverPageElements.CP_INPUT_COMPANYNAME));
		seleniumUtil.click(corverPageElements.CP_INPUT_COMPANYNAME);
		seleniumUtil.type(corverPageElements.CP_INPUT_COMPANYNAME,
				"黑龙江绥化市康荣大队黑龙江绥化市康荣大队黑龙江绥化市康荣大队黑龙江绥化市康荣大队黑龙江绥化市康荣大队");
		seleniumUtil.click(ProjectSettingPageElements.PS_IMG_PHONE);
		Alert alert = seleniumUtil.switchToPromptedAlertAfterWait(2000);
		logger.info(alert.getText());
		Assert.assertEquals("公司名称设置最多能为45个字！", alert.getText());
		alert.accept();
		seleniumUtil.clear(corverPageElements.CP_INPUT_COMPANYNAME);
		seleniumUtil.type(corverPageElements.CP_INPUT_COMPANYNAME, "黑龙江绥化市康荣大队");

	}
}