package com.ftc.wechat.util;

import javax.servlet.http.HttpServletRequest;

import com.ftc.base.util.HttpUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class UploadImgaeUtil {

	public static String menu_create_url = "http://file.api.weixin.qq.com/cgi-bin/media/get?access_token=";
	
	public static Gson gson = new GsonBuilder().disableHtmlEscaping().create();
	
	public static String getWechatImgPath(String mediaId,HttpServletRequest request){
		return HttpUtil.download(menu_create_url + AccessTokenUtil.getAccessToken().getAccess_token() + "&media_id=" + mediaId, "user/headimages", "png",request);
	}
}
