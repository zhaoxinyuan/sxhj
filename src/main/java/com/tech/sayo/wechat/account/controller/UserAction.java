package com.tech.sayo.wechat.account.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tech.sayo.base.entity.MyPage;
import com.tech.sayo.base.entity.MySort;
import com.tech.sayo.base.entity.MyStatus;
import com.tech.sayo.wechat.account.bean.User;
import com.tech.sayo.wechat.account.service.UserService;
import com.tech.sayo.wechat.util.JsonpUtil;
import com.tech.sayo.wechat.util.UploadImgaeUtil;

@Controller 
@ResponseBody
@Scope("prototype")
@RequestMapping("/accountAction")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class UserAction {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "userInfo",method = RequestMethod.GET)
	public String getUserInfo(HttpServletRequest request,HttpServletResponse response,String wechatId,String callback){
		return JsonpUtil.jsonpCllback(userService.getUserByWechatId(wechatId),callback);
		//return userService.getUserByWechatId(wechatId);
	}
	
	@RequestMapping(value = "userHead",method = RequestMethod.GET)
	public String updateUserHead(HttpServletRequest request,HttpServletResponse response,Integer userId,String mediaId,String callback){
		User u = new User();
		u.setUserId(userId);
		u.setUserHead(UploadImgaeUtil.getWechatImgPath(mediaId,request));
		userService.updateUser(u);
		return JsonpUtil.jsonpCllback(userService.getUser(u.getUserId()),callback);
	}
	
	@RequestMapping(value = "modifyUser",method = RequestMethod.GET)
	public String updateUser(HttpServletRequest request,HttpServletResponse response,User user,String callback){
		userService.updateUser(user);
		return JsonpUtil.jsonpCllback(userService.getUser(user.getUserId()),callback);
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "userList",method = RequestMethod.POST)
	public MyPage getUserList(HttpServletRequest request,HttpServletResponse response,User user,MyPage page,MySort sort){
		return userService.getUsers(user,page,sort);
	}
	
	@RequestMapping(value = "getUser",method = RequestMethod.GET)
	public User getUser(HttpServletRequest request,HttpServletResponse response,Integer userId){
		return userService.getUser(userId);
	}
	
	@RequestMapping(value = "updateUser",method = RequestMethod.GET)
	public MyStatus updateUser(HttpServletRequest request,HttpServletResponse response,User user){
		userService.updateUser(user);
		return new MyStatus().MyStatusSuccess();
	}
}
