package com.tech.sayo.wechat.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tech.sayo.wechat.controller.param.CheckSignatureParam;
import com.tech.sayo.wechat.util.SignatureUtil;

/** 
* @ClassName: CheckSignatureAction 
* @Description: 验证微信服务器地址有效性
* @author Zo 
* @date 2016-2-26 下午3:24:42 
*  
*/

@Controller
@RequestMapping("/authenticationServerAction")
public class AuthenticationServerAction {

	/** 
	* @Title: checkSignature 
	* @Description: 根据微信传入的参数验证签名
	* @param request
	* @param response
	* @param checkSign 加密签名,时间戳,随机数,随机字符串
	* @return void
	* @throws 
	*/
	@RequestMapping(value = "checkSignature",method = RequestMethod.GET) 
	public void checkSignature(HttpServletRequest request, HttpServletResponse response,CheckSignatureParam checkSign) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
			if (SignatureUtil.checkSignature(checkSign.getSignature(), checkSign.getTimestamp(), checkSign.getNonce())) {
				out.print(checkSign.getEchostr());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			out.close();
			out = null;
		}
	}
}
