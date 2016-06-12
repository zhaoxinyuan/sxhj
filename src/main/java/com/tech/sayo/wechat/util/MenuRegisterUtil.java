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
		btn11.setName("个人中心");
		btn11.setType("view"); 
		btn11.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid="+SystemConfig.appId+"&redirect_uri="+(URLEncoder.encode(SystemConfig.localUrl + "forwardAction/forwardRequest?path=main/index.html?pageId=page_me", "utf-8"))+"&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect");
		//btn11.setUrl(WechatConfig.localUrl+"home/index.jsp");
		
		ButtonComplex mainBtn1 = new ButtonComplex();
		mainBtn1.setName("会员功能");
		mainBtn1.setSub_button(new Button[] {btn11});
		
  
		Menu menu = new Menu();
		menu.setButton(new Button[] { mainBtn1});

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
