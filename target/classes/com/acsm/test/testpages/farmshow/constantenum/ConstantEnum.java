package com.acsm.test.testpages.farmshow.constantenum;

public enum ConstantEnum
{
        ANCHOR1("//div[1]/div[2]/ul/li[3]/p", "我们的环境"), 
        ANCHOR2("//div[1]/div[2]/ul/li[4]/p", "特色种植技术"), 
        ANCHOR3(
                        "//div[1]/div[2]/ul/li[5]/p",
                        "我们农场实景"), 
        ANCHOR4("//div[1]/div[2]/ul/li[6]/p", "我们的荣誉"), 
        ANCHOR5("//div[1]/div[2]/ul/li[7]/p",
                                        "我们的团队"), 
        ANCHOR6("//div[1]/div[2]/ul/li[9]/p", "安全种植"), 
        ANCHOR7(
                                                        "//div[1]/div[2]/ul/li[10]/p",
                                                        "产品供应"), 
        ANCHOR8("//div[1]/div[2]/ul/li[11]/p", "我们的服务"),
        ANCHOR9("//div[1]/div[2]/ul/li[12]/p", "我们的活动");
        private String path;
        private String exceptionResult;

        private ConstantEnum(String path, String exceptionResult)
        {
                this.path = path;
                this.exceptionResult = exceptionResult;
        }

        public String getPath()
        {
                return path;
        }

        public void setPath(String path)
        {
                this.path = path;
        }

        public String getExceptionResult()
        {
                return exceptionResult;
        }

        public void setExceptionResult(String exceptionResult)
        {
                this.exceptionResult = exceptionResult;
        }

}
