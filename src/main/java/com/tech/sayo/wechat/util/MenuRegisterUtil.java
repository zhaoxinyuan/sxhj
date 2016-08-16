package com.tech.sayo.wechat.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ServletContextAware;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tech.sayo.base.config.SystemConfig;
import com.tech.sayo.base.util.HttpUtil;
import com.tech.sayo.wechat.entity.AccessToken;
import com.tech.sayo.wechat.entity.Button;
import com.tech.sayo.wechat.entity.ButtonComplex;
import com.tech.sayo.wechat.entity.ButtonView;
import com.tech.sayo.wechat.entity.ErrorInfo;
import com.tech.sayo.wechat.entity.Menu;

/** 
* @ClassName: MenuRegisterUtil 
* @Description: 微信公众平台菜单注册
* @author Zo 
* @date 2016-2-26 下午3:26:31 
*  
*/
public class MenuRegisterUtil implements ServletContextAware{
	private static Logger log = LoggerFactory.getLogger(MenuRegisterUtil.class);
	
	public static String menu_create_url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=";
	
	public static Gson gson = new GsonBuilder().disableHtmlEscaping().create();
	
	/** 
	* @Title: setServletContext 
	* @Description: 系统启动时执行,初始化 SystemConfig ,根据配置选择是否注册菜单(Debug 模式下不注册)
	* @return 
	* @throws 
	*/
	public void setServletContext(ServletContext ctx) {
		SystemConfig.init();
		
		if (SystemConfig.model.equals("0")) {
			System.out.println("is debug model can not create menu");
			return;
		}

		AccessToken at = AccessTokenUtil.getAccessToken();

		if (null != at) {
			int result;
			try {
				result = MenuRegisterUtil.createMenu(MenuRegisterUtil.getMenu(), at.getAccess_token());
				if (0 == result)
					System.out.println("create menu success");
				else
					System.out.println("create menu error :" + result);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	/** 
	* @Title: getMenu 
	* @Description: 生成微信公众平台菜单
	* @return Menu
	* @throws 
	*/
	private static Menu getMenu() throws UnsupportedEncodingException {
		
		ButtonView btn11 = new ButtonView();
		btn11.setName("主页");
		btn11.setType("view"); 
		btn11.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid="+SystemConfig.appId+"&redirect_uri="+(URLEncoder.encode(SystemConfig.localUrl + "forwardAction/forwardRequest?path=main/index.html?pageId=page_index", "utf-8"))+"&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect");
		
		ButtonView btn12 = new ButtonView();
		btn12.setName("保洁保姆预约");
		btn12.setType("view"); 
		btn12.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid="+SystemConfig.appId+"&redirect_uri="+(URLEncoder.encode(SystemConfig.localUrl + "forwardAction/forwardRequest?path=main/index.html?pageId=page_clean", "utf-8"))+"&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect");
		
		ButtonView btn13 = new ButtonView();
		btn13.setName("便利店预约");
		btn13.setType("view"); 
		btn13.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid="+SystemConfig.appId+"&redirect_uri="+(URLEncoder.encode(SystemConfig.localUrl + "forwardAction/forwardRequest?path=main/index.html?pageId=page_store", "utf-8"))+"&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect");
		
		ButtonView btn14 = new ButtonView();
		btn14.setName("洗衣预约");
		btn14.setType("view"); 
		btn14.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid="+SystemConfig.appId+"&redirect_uri="+(URLEncoder.encode(SystemConfig.localUrl + "forwardAction/forwardRequest?path=main/index.html?pageId=page_laundry", "utf-8"))+"&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect");
		
		ButtonView btn15 = new ButtonView();
		btn15.setName("综合服务");
		btn15.setType("view"); 
		btn15.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid="+SystemConfig.appId+"&redirect_uri="+(URLEncoder.encode(SystemConfig.localUrl + "forwardAction/forwardRequest?path=main/index.html?pageId=page_integratedServices", "utf-8"))+"&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect");
		
		//btn11.setUrl(WechatConfig.localUrl+"home/index.jsp");
		
		ButtonComplex mainBtn1 = new ButtonComplex();
		mainBtn1.setName("舒心晓管家");
		mainBtn1.setSub_button(new Button[] {btn11,btn12,btn13,btn14,btn15});
		
		ButtonView btn21 = new ButtonView();
		btn21.setName("保洁订单");
		btn21.setType("view"); 
		btn21.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid="+SystemConfig.appId+"&redirect_uri="+(URLEncoder.encode(SystemConfig.localUrl + "forwardAction/forwardRequest?path=main/index.html?pageId=page_clean_order", "utf-8"))+"&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect");
		
		ButtonView btn22 = new ButtonView();
		btn22.setName("保姆订单");
		btn22.setType("view"); 
		btn22.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid="+SystemConfig.appId+"&redirect_uri="+(URLEncoder.encode(SystemConfig.localUrl + "forwardAction/forwardRequest?path=main/index.html?pageId=page_clean_nanorder", "utf-8"))+"&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect");
		
		ButtonView btn23 = new ButtonView();
		btn23.setName("便利店订单");
		btn23.setType("view"); 
		btn23.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid="+SystemConfig.appId+"&redirect_uri="+(URLEncoder.encode(SystemConfig.localUrl + "forwardAction/forwardRequest?path=main/index.html?pageId=page_store_order", "utf-8"))+"&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect");
		
		ButtonView btn24 = new ButtonView();
		btn24.setName("洗衣订单");
		btn24.setType("view"); 
		btn24.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid="+SystemConfig.appId+"&redirect_uri="+(URLEncoder.encode(SystemConfig.localUrl + "forwardAction/forwardRequest?path=main/index.html?pageId=page_laundry_order", "utf-8"))+"&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect");
		
		ButtonComplex mainBtn2 = new ButtonComplex();
		mainBtn2.setName("订单查询");
		mainBtn2.setSub_button(new Button[] {btn21,btn22,btn23,btn24});
		
		ButtonView btn31 = new ButtonView();
		btn31.setName("我的账户");
		btn31.setType("view"); 
		btn31.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid="+SystemConfig.appId+"&redirect_uri="+(URLEncoder.encode(SystemConfig.localUrl + "forwardAction/forwardRequest?path=main/index.html?pageId=page_me_account", "utf-8"))+"&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect");
		
		ButtonView btn32 = new ButtonView();
		btn32.setName("个人设置");
		btn32.setType("view"); 
		btn32.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid="+SystemConfig.appId+"&redirect_uri="+(URLEncoder.encode(SystemConfig.localUrl + "forwardAction/forwardRequest?path=main/index.html?pageId=page_me_edit", "utf-8"))+"&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect");
		
		ButtonView btn33 = new ButtonView();
		btn33.setName("地址管理");
		btn33.setType("view"); 
		btn33.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid="+SystemConfig.appId+"&redirect_uri="+(URLEncoder.encode(SystemConfig.localUrl + "forwardAction/forwardRequest?path=main/index.html?pageId=page_me_address", "utf-8"))+"&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect");
		
		ButtonView btn34 = new ButtonView();
		btn34.setName("联系客服");
		btn34.setType("view"); 
		btn34.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid="+SystemConfig.appId+"&redirect_uri="+(URLEncoder.encode(SystemConfig.localUrl + "forwardAction/forwardRequest?path=main/index.html?pageId=page_service", "utf-8"))+"&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect");
		
		ButtonComplex mainBtn3 = new ButtonComplex();
		mainBtn3.setName("个人中心");
		mainBtn3.setSub_button(new Button[] {btn31,btn32,btn33,btn34});
		
		
		Menu menu = new Menu();
		menu.setButton(new Button[] { mainBtn1,mainBtn2,mainBtn3});

		return menu;
	}
	
	/** 
	* @Title: createMenu 
	* @Description: 调用微信接口 注册微信公众平台菜单
	* @param  menu
	* @param  accessToken
	* @return int 调用接口结果
	* @throws 
	*/
	public static int createMenu(Menu menu, String accessToken) {
		int result = 0;
		String jsonMenu = gson.toJson(menu);
		ErrorInfo error = gson.fromJson(HttpUtil.sendPost(menu_create_url + accessToken, jsonMenu, "json"),ErrorInfo.class);

		if (null != error) {
			if (0 != error.getErrcode()) {
				result = error.getErrcode();
				log.error("Menu errcode:{} errmsg:{}", error.getErrcode(), error.getErrmsg());
			}
		}
		return result;
	}
}
