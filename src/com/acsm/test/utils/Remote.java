package com.acsm.test.utils;


/**
 * for remote browser bean
 * @author Young
 *
 */
public class Remote {
    private String browserName;
    private String version;
    private String[] platform;
    private String hubURL;
    public String getBrowserName() {
        return browserName;
    }
    
    public Remote()
    {
        this.browserName="firefox";
        this.version="38";
        this.platform=new String[]{"VISTA", "windows 7"};
        this.hubURL="http://localhost:4444/wd/hub";
        
    }
    
    public Remote(String browser,String localhost)
    {
        this.browserName=browser;
        this.version="42";
        this.platform=new String[]{"VISTA", "windows 7"};
        this.hubURL="http://"+localhost+":4444/wd/hub";
        
    }
    
    public void setBrowserName(String browserName) {
        this.browserName = browserName;
    }
    public String getVersion() {
        return version;
    }
    public void setVersion(String version) {
        this.version = version;
    }
 
    
    public String[] getPlatform() {
        return platform;
    }

    public void setPlatform(String[] platform) {
        this.platform = platform;
    }

    public String getHubURL() {
        return hubURL;
    }
    public void setHubURL(String hubURL) {
        this.hubURL = hubURL;
    }
    

}
