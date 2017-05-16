package com.acsm.test.testpages.digitalcard.digitalcardedit;

import org.openqa.selenium.By;

public class DigitalCardEditElement {

	// 搜索框
	public static final By DCE_INPUT_SEARCH = By.id("baseCardSerch");

	// 搜索列表
	public static final By DCE_LIST_SEARCHRESULT = By.xpath("//div[@id='baseDigitalCardList']/div/child::strong");

	// 创建农场秀按钮
	public static final By DCE_BTN_CREATFARMSHOW = By.xpath("//span[contains(@onclick,'create_card')]");

	// 农场秀标题
	public static final By DCE_INPUT_FARMSHOWTITLE = By.id("card_title");

	// 复制链接按钮
	public static final By DCE_BTN_COPYSHAREADDRESS = By.xpath("//span[contains(@onclick,'copy_()')]");

	// 地图设置
	public static final By DCE_BTN_MAPSETTINGS = By.linkText("地图设置");

	// 地图设置-更多设置
	public static final By DCE_BTN_MORESETTINGS = By.xpath("//div[contains(@class,'more_seting')]/span");
	
	// 地图设置-更多设置展开
	public static final By DCE_LIST_MORESETTINGS = By.xpath("//ul[@id='more_map_sz')]/li");

	// 地图设置-默认地图全屏
	public static final By DCE_INPUT_MAPFULLSCREEN = By.xpath("//input[@id='mapFullScreen']/following::ins");

	// 地图设置-显示天气数据
	public static final By DCE_INPUT_WEATHER = By.xpath("//input[@id='cardWeather']/following::ins");

	// 地图设置-显示种植信息
	public static final By DCE_INPUT_PLANTINFO = By.xpath("//input[@id='cardPlant']/following::ins");

	// 地图设置-显示硬件设施
	public static final By DCE_INPUT_DEVICES = By.xpath("//input[@id='cardEquipment']/following::ins");

	// 地图设置-显示航拍
	public static final By DCE_INPUT_AERIAL = By.xpath("//input[@id='cardAerial']/following::ins");

	// 地图设置-显示四季田景
	public static final By DCE_INPUT_PARAMA = By.xpath("//input[@id='cardPanorama']/following::ins");

	/** 地图设置-元素组 */
	public static final By byElements[] = { DCE_INPUT_MAPFULLSCREEN, DCE_INPUT_WEATHER, DCE_INPUT_PLANTINFO,
			DCE_INPUT_DEVICES, DCE_INPUT_AERIAL, DCE_INPUT_PARAMA };

	// 基地介绍
	public static final By DCE_BTN_BASEINFO = By.linkText("基地介绍");

	// 基地介绍-基地名称
	public static final By DCE_INPUT_BASENAME = By.id("base_name");

	// 基地介绍-联系方式
	public static final By DCE_INPUT_CONTACT = By.id("base_phone");

	// 基地介绍-基地介绍
	public static final By DCE_INPUT_BASECONTENT = By.id("base_content");

	// 基地介绍-基地相册
	public static final By DCE_BTN_PHOTO = By.xpath("//img[contains(@src,'file_btn100.jpg')]");

	// 产品介绍
	public static final By DCE_BTN_PRODUCTINTRODUCE = By.linkText("产品介绍");

	// 产品介绍-保存并新增
	public static final By DCE_BTN_SAVEANDCREAT = By
			.xpath("//button[contains(@onclick,'saveAndAddSaleProductInfo()')]");

	// 产品介绍-产品列表
	public static final By pending = By.id("saleProductInfo_name");

	// 产品介绍-商品名称
	public static final By DCE_INPUT_PRODUCTNAME = By.id("saleProductInfo_name");

	// 产品介绍-作物种类
	public static final By DCE_BTN_PRODUCTTYPE = By.xpath("//button[@data-id='saleProductInfo_plantid']");

	// 产品介绍-作物品种
	public static final By DCE_BTN_PRODUCTVARIETY = By.xpath("//button[@data-id='saleProductInfo_breedIds']");

	// 产品介绍-总供货量
	public static final By DCE_INPUT_TOTALCOUNT = By.id("saleProductInfo_supplynum");

	// 产品介绍-供货开始日期
	public static final By DCE_INPUT_BEGINTIME = By.id("saleProductInfo_supplyBeginTime");

	// 产品介绍-供货结束日期
	public static final By DCE_INPUT_ENDTIME = By.id("saleProductInfo_supplyEndTime");

	// 产品介绍-产品图片
	public static final By DCE_IFRAME_IMGUPLOAD = By.id("saleProductInfoImages");

	// 产品介绍-产品图片
	public static final By DCE_INPUT_IMGUPLOAD = By.id("agriculturalImages:logoUrl");

	// 分享设置
	public static final By DCE_BTN_SHARING = By.linkText("分享设置");

	// 分享设置-分享标题
	public static final By DCE_INPUT_SHARETITLE = By.id("share_title");

	// 分享设置-分享描述
	public static final By DCE_INPUT_SHAREDESCRIPTION = By.id("share_content");

	// 分享设置-分享图片
	public static final By DCE_IFRAME_SHAREPIC = By.id("cardShareImgframe");

	// 分享设置-分享图片
	public static final By DCE_INPUT_SHAREPIC = By.id("agriculturalImages:logoUrl");
	
	// 右侧预览页
	public static final By DCE_IFRAME_VIEW = By.id("card_view");
	
	// 全景图片
	public static final By DCE_IMG_PANORAMA = By.id("abc");

	// 航拍图片
	public static final By DCE_IMG_AERIAL = By.id("base_card_aerial");
	
	// 提交
	public static final By DCE_BTN_CONFIRM = By.linkText("提交");

	// 删除
	public static final By DCE_BTN_DELETE = By.linkText("删除");
}
