package com.tech.sayo.wechat.util;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tech.sayo.base.config.SystemConfig;
import com.tech.sayo.base.util.HttpUtil;
import com.tech.sayo.wechat.entity.AccessToken;

/** 
* @ClassName: AccessTokenUtil 
* @Description: 管理调用微信接口凭证
* @author Zo 
* @date 2016-2-26 下午3:25:46 
*  
*/
public class AccessTokenUtil {
	private static Logger log = LoggerFactory.getLogger(AccessTokenUtil.class);
	public final static String access_token_url = "https://api.weixin.qq.com/cgi-bin/token";
	
	public static AccessToken accessToken;

	/** 
	* @Title: getAccessToken 
	* @Description: 获取 AccessToken,如果距离上次获取时间超过118分钟,重新获取(有效期为120分钟,避免网络延迟等其他不可控因素，提前两分钟重新获取)
	* @return AccessToken
	* @throws 
	*/
	public static AccessToken getAccessToken() {
		if(AccessTokenUtil.accessToken == null){
			return getNewAccessToken();
		}else if((new Date().getTime() - AccessTokenUtil.accessToken.getAccess_getDate().getTime()) / (1000 * 60) > 118){
			return getNewAccessToken();
		}
		return accessToken;
	}
	
	/** 
	* @Title: getNewAccessToken 
	* @Description: 调用微信接口获取AccessToken
	* @return AccessToken
	* @throws 
	*/
	@SuppressWarnings("unused")
	private static AccessToken getNewAccessToken(){
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
	    AccessToken accessToken =  gson.fromJson(HttpUtil.sendGet(access_token_url, "grant_type=client_credential&appid="+SystemConfig.appId+"&secret="+SystemConfig.appSecret), AccessToken.class);
		accessToken.setAccess_getDate(new Date());
	    if (null == accessToken) {  
	    	log.error("accessToken errcode:{} errmsg:{}", accessToken.getErrcode() , accessToken.getErrmsg());  
	    } 
	    AccessTokenUtil.accessToken = accessToken;
	    return accessToken;
	}
}
