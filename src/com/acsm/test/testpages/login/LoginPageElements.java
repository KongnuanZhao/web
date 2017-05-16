package com.acsm.test.testpages.login;

import org.openqa.selenium.By;

public class LoginPageElements
{
        
        /** 账号输入框 */
        public static final By LP_INPUT_USERNAME = By.id("loginForm:username");
        
        /** 密码输入框 */
        public static final By LP_INPUT_PASSWORD = By.id("loginForm:password");
        
        /** 登陆按钮 */
        public static final By LP_BUTTON_SUBMIT = By.id("btn");
        
        /** 忘记密码 */
        public static final By LP_LINK_RESET_PW = By.xpath("//a[contains(text(),'忘记')]");
        
        /** 用户名错误 */
        public static final By LP_STR_NAMEERR = By.xpath("//span[contains(text(),'用户名错误')]");
        
        /** 密码错误 */
        public static final By LP_STR_PSWERR = By.xpath("//span[contains(text(),'密码错误')]");
        
      

}
