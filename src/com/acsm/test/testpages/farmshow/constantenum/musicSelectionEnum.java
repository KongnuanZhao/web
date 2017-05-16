package com.acsm.test.testpages.farmshow.constantenum;

public enum musicSelectionEnum {

	ANCHOR1("//div[@id='music-set']/div/div/div[2]/div/div/div[2]/ul/li[1]");
//	ANCHOR2("//div[@id='music-set']/div/div/div[2]/div/div/div[2]/ul/li[2]"),
//	ANCHOR3("//div[@id='music-set']/div/div/div[2]/div/div/div[2]/ul/li[3]"),
//	ANCHOR4("//div[@id='music-set']/div/div/div[2]/div/div/div[2]/ul/li[4]"),
//	ANCHOR5("//div[@id='music-set']/div/div/div[2]/div/div/div[2]/ul/li[5]");
	
	private String path;
	private musicSelectionEnum(String path){
		this.path = path;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
}
