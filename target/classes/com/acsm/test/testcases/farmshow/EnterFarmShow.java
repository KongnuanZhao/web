package com.acsm.test.testcases.farmshow;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.acsm.test.base.BaseParpare;
import com.acsm.test.testpages.farmshow.CreatFarmShow_NoneCompanyInfo;


public class EnterFarmShow extends BaseParpare
{
    public static Logger logger = Logger.getLogger(EnterFarmShow.class);

    /**
     * @author GuoKuo
     */
    @Test(groups =
        { "enter" },alwaysRun= true)
    public void enterFarmshow()
    {
    	
        CreatFarmShow_NoneCompanyInfo cfs = new CreatFarmShow_NoneCompanyInfo();
        cfs.CreateFarmShowflow(BaseParpare.seleniumUtil);
    }
    
    /**
     * @author GuoKuo
     * @description 验证页面删除
     */
    @Test(enabled = false,groups =
        { "enter" },dependsOnMethods={"enterFarmshow"},alwaysRun= true)
    public void pageDelect()
    {
        CreatFarmShow_NoneCompanyInfo cfs = new CreatFarmShow_NoneCompanyInfo();
        cfs.DeletePage(BaseParpare.seleniumUtil);
    }
    
    /**
     * @author GuoKuo
     * @description 验证页面添加
     */
    @Test(enabled = false,groups =
        { "enter" },dependsOnMethods={"pageDelect"},alwaysRun= true)
    public void pageAddBack()
    {
        CreatFarmShow_NoneCompanyInfo cfs = new CreatFarmShow_NoneCompanyInfo();
        cfs.addPageBack(BaseParpare.seleniumUtil);
    }
}

