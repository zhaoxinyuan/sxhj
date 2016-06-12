package com.tech.sayo.wechat.util;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tech.sayo.base.util.HttpUtil;
import com.tech.sayo.wechat.entity.AccessToken;
import com.tech.sayo.wechat.entity.TicketToken;
/** 
* @ClassName: JSConfigUtil 
* @Description: 管理微信JavaScript SDK 配置
* @author Zo 
* @date 2016-3-15 下午2:40:13 
*  
*/
public class TicketTokenUtil {
	private static Logger log = LoggerFactory.getLogger(TicketTokenUtil.class);
	public final static String ticket_token_url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket";
	
	public static TicketToken ticketToken;
	
	/** 
	* @Title: getTicketToken 
	* @Description: 获取 TicketToken,如果距离上次获取时间超过118分钟,重新获取(有效期为120分钟,避免网络延迟等其他不可控因素，提前两分钟重新获取)
	* @return TicketToken
	* @throws 
	*/
	public static TicketToken getTicketToken(){
		if(TicketTokenUtil.ticketToken == null){
			return TicketTokenUtil.getNewTicketToken();
		}else if((new Date().getTime() - TicketTokenUtil.ticketToken.getTicket_getDate().getTime()) / (1000 * 60) > 118){
			return getNewTicketToken();
		}else{
			return ticketToken;
		}
	}
	
	/** 
	* @Title: getNewTicketToken 
	* @Description: 调用微信接口获取TicketToken
	* @param @return 
	* @return TicketToken
	* @throws 
	*/
	@SuppressWarnings("unused")
	private static TicketToken getNewTicketToken(){
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		AccessToken accessToken = AccessTokenUtil.getAccessToken();
		TicketToken ticketToken = gson.fromJson(HttpUtil.sendGet(ticket_token_url,"access_token=" + accessToken.getAccess_token() + "&type=jsapi"),TicketToken.class);
		ticketToken.setTicket_getDate(new Date());
		if(ticketToken == null){
			log.error("accessToken errcode:{} errmsg:{}", ticketToken.getErrcode() , ticketToken.getErrmsg());
		}
		TicketTokenUtil.ticketToken = ticketToken;
	    return ticketToken;  
	}
	
}
