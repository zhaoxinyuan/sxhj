package com.tech.sayo.wechat.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tech.sayo.base.config.SystemConfig;
import com.tech.sayo.base.controller.BaseAction;
import com.tech.sayo.wechat.entity.WechatJSConfig;
import com.tech.sayo.wechat.util.JsonpUtil;
import com.tech.sayo.wechat.util.SignatureUtil;
import com.tech.sayo.wechat.util.TicketTokenUtil;

@Controller
@RequestMapping("/wechatJSConfigAction")
public class WechatJSConfigAction extends BaseAction{
	
	@RequestMapping(value = "getWechatJSConfig", method = RequestMethod.GET)
	public String getWechatJSConfig(String url,String callback){
		WechatJSConfig config = new WechatJSConfig();
 		config.setAppId(SystemConfig.appId);
		config.setNonceStr(RandomStringUtils.random(8, "123456789"));
		config.setTimestamp((System.currentTimeMillis() + "").substring(0,10));
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("noncestr", config.getNonceStr());
		map.put("jsapi_ticket", TicketTokenUtil.getTicketToken().getTicket());
		map.put("timestamp", config.getTimestamp());
		map.put("url", url);
		
		config.setSignature(SignatureUtil.encryptionBySH1(SignatureUtil.createSign(map, false), "UTF-8", false));
		return JsonpUtil.jsonpCllback(config, callback);
	}
}
