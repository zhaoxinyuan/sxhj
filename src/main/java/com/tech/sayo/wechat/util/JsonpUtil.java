package com.tech.sayo.wechat.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonpUtil {
	private static Gson gson = new GsonBuilder().disableHtmlEscaping().create();
	
	public static String jsonpCllback(Object o,String callback){
		try {
			return callback + "('" + URLEncoder.encode(gson.toJson(o),"utf-8") + "')";
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
