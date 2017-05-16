package com.acsm.test.testpages.login;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.acsm.test.utils.SeleniumUtil;

/**
 * @author Young
 * @description 登录页面帮助类：提供在这个页面上做的操作的方法封装
 */
public class LoginPage {
	// 提供本类中日志输出对象
	public static Logger logger = Logger.getLogger(LoginPage.class);
    public static WebDriver driver = SeleniumUtil.driver;
	/**
	 * @author Young
	 * @description 等待登录页面元素加载
	 * @param seleniumUtil
	 *            selenium api封装引用对象
	 * @param timeOut
	 *            等待元素超时的时间u
	 */
	public static void waitLoginPageLoad(SeleniumUtil seleniumUtil, int timeOut) {
		seleniumUtil.waitForElementToLoad(timeOut, LoginPageElements.LP_INPUT_USERNAME);
		WebElement element = driver.findElement(LoginPageElements.LP_INPUT_USERNAME);
		System.out.println("----------------------------"+element);
		seleniumUtil.waitForElementToLoad(timeOut, LoginPageElements.LP_BUTTON_SUBMIT);
		seleniumUtil.waitForElementToLoad(timeOut, LoginPageElements.LP_INPUT_PASSWORD);
		seleniumUtil.waitForElementToLoad(timeOut, LoginPageElements.LP_LINK_RESET_PW);

	}

	/**
	 * @author Young
	 * @description 登录操作封装
	 * @param seleniumUtil
	 *            selenium api封装引用对象
	 * @param username
	 *            用户名值
	 * @param password
	 *            用户密码值
	 * @throws FindFailed 
	 */
	public static void typeLoginInfo(SeleniumUtil seleniumUtil, String username, String password) {

		logger.info("开始输入登录信息");
		// 清空用户名输入框
		seleniumUtil.clear(LoginPageElements.LP_INPUT_USERNAME);
		// 输入用户名到用户名输入框
		seleniumUtil.type(LoginPageElements.LP_INPUT_USERNAME, username);
		// 清空密码输入框
		seleniumUtil.clear(LoginPageElements.LP_INPUT_PASSWORD);
		// 输入密码到密码输入框
		seleniumUtil.type(LoginPageElements.LP_INPUT_PASSWORD, password);
		logger.info("输入登录信息完毕");
		// 点击登录按钮
		seleniumUtil.executeJS("arguments[0].scrollIntoView(true)",driver.findElement(LoginPageElements.LP_BUTTON_SUBMIT));
		seleniumUtil.click(LoginPageElements.LP_BUTTON_SUBMIT);

	}

}
