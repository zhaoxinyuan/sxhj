package com.ftc.wechat.util;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ftc.base.config.SystemConfig;
import com.ftc.base.util.HttpUtil;
import com.ftc.wechat.account.bean.User;
import com.ftc.wechat.entity.AccessToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/** 
* @ClassName: UserInfoUtil 
* @Description: 微信用户授权后获取用户信息
* @author Zo 
* @date 2016-3-1 上午10:49:13 
*  
*/
public class UserInfoUtil {
	
	private static Logger log = LoggerFactory.getLogger(UserInfoUtil.class);

	public final static String openid_url = "https://api.weixin.qq.com/sns/oauth2/access_token";
	public final static String userinfo_url = "https://api.weixin.qq.com/cgi-bin/user/info";
	
	public static Gson gson = new GsonBuilder().disableHtmlEscaping().create();
	
	/** 
	* @Title: getOpenId 
	* @Description: 根据code获取用户微信id
	* @param code
	* @return String 微信id
	* @throws 
	*/
	@SuppressWarnings("unchecked")
	public static String getOpenId(String code) {
		StringBuffer param = new StringBuffer();
		param.append("appid=" + SystemConfig.appId);
		param.append("&secret=").append(SystemConfig.appSecret);
		param.append("&code=").append(code);
		param.append("&grant_type=authorization_code");
		Map<String, Object> rsMap = gson.fromJson((HttpUtil.sendGet(openid_url, param.toString())), Map.class);
		return (String) rsMap.get("openid");
	}
	
	/** 
	* @Title: getSignUserInfo 
	* @Description: 根据微信id获取用户基本信息,关注时间,头像,昵称等
	* @param wechatid
	* @param user
	* @return WechatUser 将传入的user对象赋予基本信息资料并返回
	* @throws 
	*/
	@SuppressWarnings("unchecked")
	public static User getSignUserInfo(String wechatid, User user) {
		AccessToken at = AccessTokenUtil.getAccessToken();
		if (null != at) {
			StringBuffer param = new StringBuffer();
			param.append("access_token=" + at.getAccess_token());
			param.append("&openid=" + wechatid);
			param.append("&lang=zh_CN");

			Map<String, Object> rsMap = gson.fromJson(HttpUtil.sendGet(userinfo_url, param.toString()),Map.class);
			log.debug("wechat userinfo{}",rsMap);
			if(rsMap.get("subscribe").toString().equals("1.0")){
				user.setUserWechatid(wechatid);
				user.setUserHead((String)rsMap.get("headimgurl"));
				user.setUserNickname((String)rsMap.get("nickname"));
				user.setUserSex(rsMap.get("sex").toString().equals("2.0") ? 2 : 1);
				//user.setUsersubscribetime(new SimpleDateFormat("yyyy-MM-dd").format(new Date(Math.round((double)rsMap.get("subscribe_time") * 1000L))));
				return user;
			}
			return null;
		}else
			return null;
	}
}
