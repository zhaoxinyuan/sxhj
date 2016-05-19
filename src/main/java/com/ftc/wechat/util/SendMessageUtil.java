package com.ftc.wechat.util;

import com.ftc.base.util.HttpUtil;
import com.ftc.wechat.entity.MessageByText;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/** 
* @ClassName: SendMessageUtil 
* @Description: 微信公众发送消息
* @author Zo 
* @date 2016-2-26 下午3:27:17 
*  
*/
public class SendMessageUtil {

	public static Gson gson = new GsonBuilder().disableHtmlEscaping().create();
	
	
	/** 
	* @Title: sendMessage 
	* @Description: 调用微信接口,发送文本消息
	* @param text 消息内容
	* @return String 调用接口结果
	* @throws 
	*/
	public static String sendMessage(MessageByText text){
		return HttpUtil.sendPost("https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=" + AccessTokenUtil.getAccessToken().getAccess_token(),gson.toJson(text), "json");
	}
}
