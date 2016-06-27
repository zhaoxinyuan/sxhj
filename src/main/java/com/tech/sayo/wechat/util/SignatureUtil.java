package com.tech.sayo.wechat.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import com.tech.sayo.base.config.SystemConfig;

public class SignatureUtil {

	private static String token = SystemConfig.token;
	
	/** 
	* @Title: checkSignature 
	* @Description: 验证签名是否合法
	* @param signature 微信加密签名
	* @param timestamp 时间戳
	* @param nonce 随机数
	* @return boolean 验证结果
	* @throws 
	*/
	public static boolean checkSignature(String signature, String timestamp, String nonce) {
		String[] arr = new String[] { token, timestamp, nonce };
		Arrays.sort(arr);
		StringBuffer content = new StringBuffer();
		for (int i = 0; i < arr.length; i++) {
			content.append(arr[i]);
		}
		String tmpStr = SignatureUtil.encryptionBySH1(content.toString(),"utf-8",false);
		content = null;
		return tmpStr != null ? tmpStr.equals(signature) : false;
	}
	
	/** 
	* @Title: createSign 
	* @Description: 根据key的字典排序后,以URL键值的形式拼接
	* @param params 参数 
	* @param encode 是否encode
	* @param @throws UnsupportedEncodingException
	* @param @throws NoSuchAlgorithmException 
	* @return String 拼接后的字符串
	* @throws 
	*/
	public static String createSign(Map<String, Object> params, boolean encode){
		try {
			Set<String> keysSet = params.keySet();
			Object[] keys = keysSet.toArray();
			Arrays.sort(keys);
			StringBuffer temp = new StringBuffer();
			boolean first = true;
			for (Object key : keys) {
				if (first) {
					first = false;
				} else {
					temp.append("&");
				}
				temp.append(key).append("=");
				String valueString = params.get(key) == null ? "" : params.get(key).toString(); 
				temp.append(encode ? URLEncoder.encode(valueString, "UTF-8") : valueString);
			}
			return temp.toString();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @throws UnsupportedEncodingException  
	* @Title: encryptionBySH1 
	* @Description: 使用SH1 方式加密字符串
	* @param sortStr 排序后的字符串
	* @return String 加密后的字符串
	* @throws 
	*/
	public static String encryptionBySH1(String sortStr,String charsetname,boolean toUpperCase){
		MessageDigest md = null;
		String tmpStr = null;
		char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			md = MessageDigest.getInstance("SHA-1");
			byte b[] = md.digest(sortStr.getBytes(charsetname));
			String strDigest = "";
			for (int i = 0; i < b.length; i++) {
				char[] tempArr = new char[2];
				tempArr[0] = hexDigits[(b[i] >>> 4) & 0X0F];
				tempArr[1] = hexDigits[b[i] & 0X0F];
				strDigest += new String(tempArr);
			}
			tmpStr = strDigest;
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return toUpperCase ? tmpStr.toUpperCase() : tmpStr;
	}
	
	/** 
	* @Title: encryptionByMD5 
	* @Description: 使用MD5 方式加密字符串
	* @param @param sortStr
	* @param @param charsetname
	* @param @param toUpperCase
	* @param @return 
	* @return String
	* @throws 
	*/
	public static String encryptionByMD5(String sortStr,String charsetname,boolean toUpperCase){
		MessageDigest md = null;
		String tmpStr = null;
		String hexDigits[] = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
		try {
			md = MessageDigest.getInstance("MD5");
			byte b[] = md.digest(sortStr.getBytes(charsetname));
		    StringBuffer resultSb = new StringBuffer();
			for (int i = 0; i < b.length; i++){
				int n = b[i];
				if (n < 0){
					n += 256;
				}
				resultSb.append(hexDigits[n / 16] + hexDigits[n % 16]);
			}
			tmpStr = resultSb.toString();
					
		} catch (Exception exception) {
		}
		return toUpperCase ? tmpStr.toUpperCase() : tmpStr;
	}
}
