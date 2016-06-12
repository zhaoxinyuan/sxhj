package com.tech.sayo.wechat.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tech.sayo.base.config.SystemConfig;
import com.tech.sayo.base.controller.BaseAction;
import com.tech.sayo.wechat.account.bean.User;
import com.tech.sayo.wechat.account.service.UserService;
import com.tech.sayo.wechat.util.UserInfoUtil;


/** 
* @ClassName: ForwardAction 
* @Description: 微信授权后跳转公众平台
* @author Zo 
* @date 2016-2-26 下午3:25:33 
*  
*/
@Controller
@RequestMapping("/forwardAction")
public class ForwardAction extends BaseAction{
	
	private static Logger log = LoggerFactory.getLogger(ForwardAction.class);
	
	@Autowired
	UserService userservice;
	
	@RequestMapping(value = "forwardRequest")
	public void forwardRequest(HttpServletRequest request,
			HttpServletResponse resp, String code,String path) throws ServletException, IOException {
		String wechatId = null;
		if (code != null && !code.equals("")) {
			wechatId = UserInfoUtil.getOpenId(code);
			if (wechatId != null && !wechatId.equals("")) {
				User user = userservice.getUserByWechatId(wechatId);
				if(user == null){
					user = UserInfoUtil.getSignUserInfo(wechatId,new User());
					if(user != null){
						userservice.saveUser(user);
						log.debug("wechatId:{} ", wechatId);
						resp.sendRedirect(SystemConfig.wechatlUrl + path + "&wechatid=" + wechatId);
					}else{
						log.debug("未关注该公众号,跳转到关注页面");
						resp.sendRedirect("http://mp.weixin.qq.com/s?__biz=MzA3ODMzMDc1MQ==&mid=401626688&idx=1&sn=400d52d33f9f97e132548762c8027dab&scene=0&previewkey=YyKiz7h4aifQX9zQTANiL8NS9bJajjJKzz%2F0By7ITJA%3D#wechat_redirect");
					}
				}else{
					log.debug("wechatId:{} ", wechatId);
					resp.sendRedirect(SystemConfig.wechatlUrl + path + "&wechatid=" + wechatId);
				}
			}
		}
	}
	
}
