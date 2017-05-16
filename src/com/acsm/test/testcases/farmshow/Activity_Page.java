package com.acsm.test.testcases.farmshow;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.acsm.test.base.BaseParpare;
import com.acsm.test.testpages.farmshow.activity.Activity;
import com.acsm.test.testpages.farmshow.activity.ActivityElements;
import com.acsm.test.utils.SeleniumUtil;

/**
 * @author GuoKuo
 * @name 我们的活动
 */

public class Activity_Page extends BaseParpare {

	public static Logger logger = Logger.getLogger(Activity_Page.class);

	/**
	 * @description 验证进入我们的活动
	 */
	@Test(groups = { "activity" }, alwaysRun = true)
	public void ActivityPage() {
		String activityPageName = Activity.ActivityPage(BaseParpare.seleniumUtil);
		seleniumUtil.isTextCorrect(activityPageName, "我们的活动");
	}

	/**
	 * @description 验证输入正确的页面主题
	 */
	@Test(groups = { "activity" }, dependsOnMethods = { "ActivityPage" }, alwaysRun = true)
	public void ActivityPageTitleEdit_Correct() {
		String inputSting = "我们的活动";
		String actual = Activity.PageTitleEdit(inputSting, BaseParpare.seleniumUtil);
		seleniumUtil.isTextCorrect(actual, inputSting);
	}

	/**
	 * @description 验证输入较长的页面主题
	 */
	@Test(groups = { "activity" }, dependsOnMethods = { "ActivityPageTitleEdit_Correct" }, alwaysRun = true)
	public void ActivityPageTitleEdit_inCorrect() {
		String inputSting = "我们的活动名字比较长哦啊";
		String actual = Activity.PageTitleEdit(inputSting, BaseParpare.seleniumUtil);
		seleniumUtil.isTextCorrect("页面主题最多能为10个字！", actual);
		seleniumUtil.clear(ActivityElements.AE_PAGE_TITLE);
		seleniumUtil.type(ActivityElements.AE_PAGE_TITLE, "我们的服务");
	}

	/**
	 * @description 验证输入正确的活动标题
	 */
	@Test(groups = { "activity" }, dependsOnMethods = { "ActivityPageTitleEdit_inCorrect" }, alwaysRun = true)
	public void ActivityPageBTEdit_Correct() {
		String inputSting = "我们的活动标题";
		String actual = Activity.ActivityTitleEdit(inputSting, BaseParpare.seleniumUtil);
		seleniumUtil.isTextCorrect(actual, inputSting);
	}

	/**
	 * @description 验证输入较长的活动标题
	 */
	@Test(groups = { "activity" }, dependsOnMethods = { "ActivityPageBTEdit_Correct" }, alwaysRun = true)
	public void ActivityPageBTEdit_inCorrect() {
		String inputSting = "通过准备和参加主题队会，使队员们了解我们党的光辉历程，激发队员从小树立立志报国的志向，进一步增强爱党爱国情感。";
		String actual = Activity.ActivityTitleEdit(inputSting, BaseParpare.seleniumUtil);
		seleniumUtil.isTextCorrect("活动标题最多能为30个字！", actual);
		seleniumUtil.pause(2000);
		seleniumUtil.clear(ActivityElements.AE_INPUT_ACTIVITYTITLE);
		seleniumUtil.type(ActivityElements.AE_INPUT_ACTIVITYTITLE, "我们的活动标题");
	}

	/**
	 * @description 验证输入正确的活动主题
	 */
	@Test(groups = { "activity" }, dependsOnMethods = { "ActivityPageBTEdit_inCorrect" }, alwaysRun = true)
	public void ActivityPageTheme_Correct() {
		String inputSting = "我们的活动主题";
		String actual = Activity.ActivityTheme(inputSting, BaseParpare.seleniumUtil);
		seleniumUtil.isTextCorrect(actual, inputSting);
	}

	/**
	 * @description 验证输入较长的活动主题
	 */
	@Test(groups = { "activity" }, dependsOnMethods = { "ActivityPageTheme_Correct" }, alwaysRun = true)
	public void ActivityPageTheme_inCorrect() {
		String inputSting = "通过准备和参加主题队会，使队员们了解我们党的光辉历程，激发队员从小树立立志报国的志向，进一步增强爱党爱国情感。";
		String actual = Activity.ActivityTheme(inputSting, BaseParpare.seleniumUtil);
		seleniumUtil.isTextCorrect("活动主题最多能为30个字！", actual);
		seleniumUtil.clear(ActivityElements.AE_INPUT_THEME);
		seleniumUtil.type(ActivityElements.AE_INPUT_THEME, "我们的活动主题");
	}

	/**
	 * @description 验证输入正确的宣传语
	 */
	@Test(groups = { "activity" }, dependsOnMethods = { "ActivityPageTheme_inCorrect" }, alwaysRun = true)
	public void ActivityPagePropaganda_Correct() {
		String inputSting = "我们的宣传语";
		String actual = Activity.ActivityPropaganda(inputSting, BaseParpare.seleniumUtil);
		seleniumUtil.isTextCorrect(actual, inputSting);
	}

	/**
	 * @description 验证输入较长的宣传语
	 */
	@Test(groups = { "activity" }, dependsOnMethods = { "ActivityPagePropaganda_Correct" }, alwaysRun = true)
	public void ActivityPagePropaganda_inCorrect() {
		String inputSting = "通过准备和参加主题队会，使队员们了解我们党的光辉历程，激发队员从小树立立志报国的志向，进一步增强爱党爱国情感。";
		String actual = Activity.ActivityPropaganda(inputSting, BaseParpare.seleniumUtil);
		seleniumUtil.isTextCorrect("宣传语最多能为30个字！", actual);
		seleniumUtil.clear(ActivityElements.AE_INPUT_PROPAGANDA);
		seleniumUtil.type(ActivityElements.AE_INPUT_PROPAGANDA, "我们的宣传语");
	}

	/**
	 * @description 验证输入正确的活动说明
	 */
	@Test(groups = { "activity" }, dependsOnMethods = { "ActivityPagePropaganda_inCorrect" }, alwaysRun = true)
	public void ActivityPageExplain_Correct() {
		String inputSting = "我们活动说明";
		String actual = Activity.ActivityExplain(inputSting, BaseParpare.seleniumUtil);
		seleniumUtil.isTextCorrect(actual, inputSting);
	}

	/**
	 * @description 验证输入较长的活动说明
	 */
	@Test(groups = { "activity" }, dependsOnMethods = { "ActivityPageExplain_Correct" }, alwaysRun = true)
	public void ActivityPageExplain_inCorrect() {
		String inputSting = "通过准备和参加主题队会，使队员们了解我们党的光辉历程，激发队员从小树立立志报国的志向，进一步增强爱党爱国情感。"
				+ "了解今天的幸福生活来之不易，培养队员从小热爱党，热爱祖国的思想感情，引导队员树立理想，放眼未来，自信自强，勇敢前进，做新世纪的接班人。";
		String actual = Activity.ActivityExplain(inputSting, BaseParpare.seleniumUtil);
		seleniumUtil.isTextCorrect("活动说明最多能为50个字！", actual);
		seleniumUtil.clear(ActivityElements.AE_INPUT_EXPLAIN);
		seleniumUtil.type(ActivityElements.AE_INPUT_EXPLAIN, "我们的活动说明");
	}

	/**
	 * @description 验证输入正确的活动链接
	 */
	@Test(enabled = false,groups = { "activity" }, dependsOnMethods = { "ActivityPageExplain_inCorrect" }, alwaysRun = true)
	public void ActivityPageLink_Correct() {
		seleniumUtil.pause(2000);
		String inputSting = "www.baidu.com";
		String actual = Activity.ActivityLink(inputSting, BaseParpare.seleniumUtil);
		switch (1) {
		case 1:
			seleniumUtil.isTextCorrect(actual, "http://app.farmeasy.cn/map/" + inputSting);
		case 2:
			seleniumUtil.isTextCorrect(actual, "http://cs1.nongchangyun.cn/map/" + inputSting);
		
		}
		
	}

	/**
	 * @throws IOException
	 * @description 验证上传图片
	 */
	@Test(groups = { "activity" }, dependsOnMethods = { "ActivityPageExplain_inCorrect" }, alwaysRun = true)
	public void ActivityIMGUpload() throws IOException {
		// int count = 5;
		String input = "./res/img/bocai.jpg";
		Activity.ActivityIMGUpload(input, BaseParpare.seleniumUtil);
		Activity.ActivityIMGUpload_1(input, BaseParpare.seleniumUtil);
		Activity.ActivityIMGUpload_1(input, BaseParpare.seleniumUtil);
		Activity.ActivityIMGUpload_1(input, BaseParpare.seleniumUtil);
		Activity.ActivityIMGUpload_1(input, BaseParpare.seleniumUtil);

		// int actual = Activity.ActivityIMGUpload(count, input,
		// BaseParpare.seleniumUtil);
		// seleniumUtil.isCountCorrect(actual, count);

	}

	/**
	 * @description 验证删除图片
	 */
	@Test(groups = { "activity" }, dependsOnMethods = { "ActivityIMGUpload" }, alwaysRun = true)
	public void ActivityIMGDEL() {
		Activity.ActivityIMGDEL(BaseParpare.seleniumUtil);
	}

	/**
	 * @throws IOException
	 * @description 验证上传图片
	 */
	@Test(groups = { "activity" }, dependsOnMethods = { "ActivityIMGDEL" }, alwaysRun = true)
	public void ActivityIMGUploadAfterDEL() throws IOException {
		String input = "./res/img/bocai.jpg";
		Activity.ActivityIMGUpload_1(input, BaseParpare.seleniumUtil);
	}

	/**
	 * @description 点击确定
	 */
	@Test(groups = { "activity" }, dependsOnMethods = { "ActivityIMGUploadAfterDEL" }, alwaysRun = true)
	public void Confirm() {
		JavascriptExecutor js = (JavascriptExecutor) SeleniumUtil.driver;
		js.executeScript("arguments[0].scrollIntoView(true)",
				SeleniumUtil.driver.findElement(ActivityElements.AE_BTN_CONFIRM));
		seleniumUtil.click(ActivityElements.AE_BTN_CONFIRM);
		seleniumUtil.pause(3000);
	}

	/**
	 * @description 验证图片数目
	 */
	@Test(groups = { "activity" }, dependsOnMethods = { "Confirm" }, alwaysRun = true)
	public void ActivityListVerification() {
		int expected = 5;
		int actual = Activity.ActivityIMGList(BaseParpare.seleniumUtil);
		seleniumUtil.isCountCorrect(actual, expected);
		seleniumUtil.pause(3000);
	}

}
