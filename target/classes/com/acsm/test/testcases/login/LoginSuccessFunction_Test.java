package com.acsm.test.testcases.login;

import org.testng.annotations.Test;

import com.acsm.test.base.BaseParpare;
import com.acsm.test.testpages.login.LoginPage;

/**
 * @author GuoKuo
 * @description 验证登陆
 */

public class LoginSuccessFunction_Test extends BaseParpare {

	@Test()
	public void loginSuccessFunction() {
		// 等待登录页面加载
		System.out.println(timeOut);
		LoginPage.waitLoginPageLoad(seleniumUtil, timeOut);
		// 输入登录信息
//		LoginPage.typeLoginInfo(seleniumUtil, data.get("USERNAME_OTHER"), data.get("PASSWORD_OTHER"));
		LoginPage.typeLoginInfo(seleniumUtil, "lina123", "acsm0615");
//		LoginPage.typeLoginInfo(seleniumUtil, "axe1234", "acsm0615");

		// 断言：验证是否登陆成功

//		String pageTitle = seleniumUtil.getTitle();
//
//		Assert.assertEquals(pageTitle, "义田帮手简单实用的农场管理工具");

	}
}
