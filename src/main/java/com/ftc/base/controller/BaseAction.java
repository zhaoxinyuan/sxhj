package com.ftc.base.controller;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ftc.base.entity.MyStatus;
import com.ftc.wechat.account.bean.User;

/** 
* @ClassName: BaseAction 
* @Description: Action的基类
* @author Zo 
* @date 2016-2-26 下午3:40:43 
*  
*/
@ResponseBody
@Scope("prototype")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class BaseAction {

	public User getSignUser(HttpServletRequest request){
		return (User)request.getSession().getAttribute("signUser");
	}
	
	public MyStatus backSuccess(){
		return new MyStatus().MyStatusSuccess();
	}
}
