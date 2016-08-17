package com.tech.sayo.wechat.pay.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.sayo.base.config.SystemConfig;
import com.tech.sayo.base.dao.BaseDao;
import com.tech.sayo.base.entity.MyStatus;
import com.tech.sayo.base.util.HttpUtil;
import com.tech.sayo.base.util.MapToXmlUtil;
import com.tech.sayo.wechat.account.bean.AccountType;
import com.tech.sayo.wechat.account.bean.User;
import com.tech.sayo.wechat.account.bean.UserAccount;
import com.tech.sayo.wechat.clean.bean.CleOrder;
import com.tech.sayo.wechat.clean.bean.CleTipOrder;
import com.tech.sayo.wechat.clean.bean.DifOrder;
import com.tech.sayo.wechat.laundry.bean.LadOrder;
import com.tech.sayo.wechat.laundry.bean.RevOrder;
import com.tech.sayo.wechat.pay.bean.PayDetail;
import com.tech.sayo.wechat.pay.bean.Platform;
import com.tech.sayo.wechat.pay.entity.BaseOrder;
import com.tech.sayo.wechat.pay.entity.UnifiedWeChatOrder;
import com.tech.sayo.wechat.pay.service.PayService;
import com.tech.sayo.wechat.store.bean.StrOrder;
import com.tech.sayo.wechat.util.BrowserUtil;
import com.tech.sayo.wechat.util.SignatureUtil;

@Service
public class PayServiceImpl implements PayService{
	
	private static final String PLATFROM_NAMESPACE_INFOUSER = "com.tech.sayo.wechat.pay.dao.PlatformMapper.";
	private static final String ACCOUNT_NAMESPACE_INFOUSER = "com.tech.sayo.wechat.account.dao.UserAccountMapper.";
	private static final String ACCOUNT_TYPE_NAMESPACE_INFOUSER = "com.tech.sayo.wechat.account.dao.AccountTypeMapper.";
	private static final String STORE_ORDER_NAMESPACE_INFOUSER = "com.tech.sayo.wechat.store.dao.OrderMapper.";
	private static final String CLEAN_ORDER_NAMESPACE_INFOUSER = "com.tech.sayo.wechat.clean.dao.OrderMapper.";
	private static final String LAUNDRY_ORDER_NAMESPACE_INFOUSER = "com.tech.sayo.wechat.laundry.dao.OrderMapper.";
	private static final String DIFFERENCE_ORDER_NAMESPACE_INFOUSER = "com.tech.sayo.wechat.clean.dao.DifOrderMapper.";
	private static final String PAYDETAIL_NAMESPACE_INFOUSER = "com.tech.sayo.wechat.pay.dao.PayDetailMapper.";
	private static final String NAMESPACE_INFOUSER  = "com.tech.sayo.wechat.account.bean.mapper.UserMapper.";
	private static final String TIP_ORDER_NAMESPACE_INFOUSER = "com.ftc.wechat.account.dao.CleTipOrderMapper.";
	
	
	@Autowired
	private BaseDao baseDao;
	
	@Override
	public List<Platform> getPlatforms() {
		return baseDao.selectList(PLATFROM_NAMESPACE_INFOUSER + "selectAll");
	}

	@Override
	public MyStatus PayStoreByAccount(Integer orderId, Integer accountUserid) {
		MyStatus status = new MyStatus();
		StrOrder order = baseDao.selectOne(STORE_ORDER_NAMESPACE_INFOUSER + "selectByPrimaryKey", orderId);
		if(order.getOrderStatus().getValue() == 2 || order.getOrderStatus().getValue() == 3 || order.getOrderStatus().getValue() == 6 ){
			status.setStatus(-1);
			status.setMessage("该订单已支付");
			return status;
		}else if(order.getOrderStatus().getValue() == 7){
			status.setStatus(-2);
			status.setMessage("该订单已取消");
			return status;
		}
		UserAccount account = baseDao.selectOne(ACCOUNT_NAMESPACE_INFOUSER + "selectAmount", accountUserid);
		if(account.getAccountAmounts() < order.getOrderRealpayamount()){
			status.setStatus(-3);
			status.setMessage("账户余额不足");
			return status;
		}
		
		AccountType type = baseDao.selectOne(ACCOUNT_TYPE_NAMESPACE_INFOUSER + "selectByCode","type_002");
		account.setAccountAmounts(order.getOrderRealpayamount() - order.getOrderRealpayamount() * 2);
		account.setAccountUserid(accountUserid);
		account.setAccountDatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		account.setAccountTypeid(type.getTypeId());
		account.setAccountOrderno(order.getOrderNo());
		order.setOrderStatusval(2);
		
		baseDao.insert(ACCOUNT_NAMESPACE_INFOUSER + "insertSelective", account);
		baseDao.modify(STORE_ORDER_NAMESPACE_INFOUSER + "updateByPrimaryKeySelective", order);
		
		status.MyStatusSuccess();
		return status;
	}

	@Override
	public MyStatus PayCleanByAccount(Integer orderId, Integer accountUserid) {
		MyStatus status = new MyStatus();
		CleOrder order = baseDao.selectOne(CLEAN_ORDER_NAMESPACE_INFOUSER + "selectByPrimaryKey", orderId);
		if(order.getOrderStatus().getValue() == 2 || order.getOrderStatus().getValue() == 3 || order.getOrderStatus().getValue() == 6 ){
			status.setStatus(-1);
			status.setMessage("该订单已支付");
			return status;
		}else if(order.getOrderStatus().getValue() == 7){
			status.setStatus(-2);
			status.setMessage("该订单已取消");
			return status;
		}
		UserAccount account = baseDao.selectOne(ACCOUNT_NAMESPACE_INFOUSER + "selectAmount", accountUserid);
		if(account.getAccountAmounts() < order.getOrderRealpayamount()){
			status.setStatus(-3);
			status.setMessage("账户余额不足");
			return status;
		}
		
		AccountType type = baseDao.selectOne(ACCOUNT_TYPE_NAMESPACE_INFOUSER + "selectByCode","type_002");
		account.setAccountAmounts(order.getOrderRealpayamount() - order.getOrderRealpayamount() * 2);
		account.setAccountUserid(accountUserid);
		account.setAccountDatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		account.setAccountTypeid(type.getTypeId());
		account.setAccountOrderno(order.getOrderNo());
		order.setOrderStatusval(2);
		
		baseDao.insert(ACCOUNT_NAMESPACE_INFOUSER + "insertSelective", account);
		baseDao.modify(CLEAN_ORDER_NAMESPACE_INFOUSER + "updateByPrimaryKeySelective", order);
		
		status.MyStatusSuccess();
		return status;
	}

	@Override
	public MyStatus PayLaundryByAccount(Integer orderId, Integer accountUserid) {
		MyStatus status = new MyStatus();
		LadOrder order = baseDao.selectOne(LAUNDRY_ORDER_NAMESPACE_INFOUSER + "selectByRevOrderid", orderId);
		if(order.getOrderStatus().getValue() == 2 || order.getOrderStatus().getValue() == 4 || order.getOrderStatus().getValue() == 6 ){
			status.setStatus(-1);
			status.setMessage("该订单已支付");
			return status;
		}else if(order.getOrderStatus().getValue() == 7){
			status.setStatus(-2);
			status.setMessage("该订单已取消");
			return status;
		}
		UserAccount account = baseDao.selectOne(ACCOUNT_NAMESPACE_INFOUSER + "selectAmount", accountUserid);
		if(account.getAccountAmounts() < order.getOrderAmount()){
			status.setStatus(-3);
			status.setMessage("账户余额不足");
			return status;
		}
		
		AccountType type = baseDao.selectOne(ACCOUNT_TYPE_NAMESPACE_INFOUSER + "selectByCode","type_002");
		account.setAccountAmounts(order.getOrderAmount() - order.getOrderAmount() * 2);
		account.setAccountUserid(accountUserid);
		account.setAccountDatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		account.setAccountTypeid(type.getTypeId());
		account.setAccountOrderno(order.getOrderNo());
		
		order.setOrderStatusval(2);
		order.setOrderPaytype(1);
		
		baseDao.insert(ACCOUNT_NAMESPACE_INFOUSER + "insertSelective", account);
		baseDao.modify(LAUNDRY_ORDER_NAMESPACE_INFOUSER + "updateByPrimaryKeySelective", order);
		
		status.MyStatusSuccess();
		return status;
	}

	@Override
	public MyStatus PayDifferenceByAccount(Integer orderId, Integer accountUserid) {
		MyStatus status = new MyStatus();
		DifOrder order = baseDao.selectOne(DIFFERENCE_ORDER_NAMESPACE_INFOUSER + "selectByPrimaryKey", orderId);
		if(order.getOrderStatus().getValue() == 2){
			status.setStatus(-1);
			status.setMessage("该订单已支付");
			return status;
		}
		UserAccount account = baseDao.selectOne(ACCOUNT_NAMESPACE_INFOUSER + "selectAmount", accountUserid);
		if(account.getAccountAmounts() < order.getOrderAmount()){
			status.setStatus(-3);
			status.setMessage("账户余额不足");
			return status;
		}
		
		AccountType type = baseDao.selectOne(ACCOUNT_TYPE_NAMESPACE_INFOUSER + "selectByCode","type_002");
		account.setAccountAmounts(order.getOrderAmount() - order.getOrderAmount() * 2);
		account.setAccountUserid(accountUserid);
		account.setAccountDatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		account.setAccountTypeid(type.getTypeId());
		account.setAccountOrderno(order.getOrderNo());
		
		order.setOrderStatusval(2);
		order.setOrderPaytype(1);
		
		baseDao.insert(ACCOUNT_NAMESPACE_INFOUSER + "insertSelective", account);
		baseDao.modify(DIFFERENCE_ORDER_NAMESPACE_INFOUSER + "updateByPrimaryKeySelective", order);
		status.MyStatusSuccess();
		return status;
	}
	
	@Override
	public MyStatus PayTipByAccount(Integer orderId, Integer accountUserid) {
		MyStatus status = new MyStatus();
		CleTipOrder order = baseDao.selectOne(TIP_ORDER_NAMESPACE_INFOUSER + "selectByPrimaryKey", orderId);
		if(order.getOrderStatus().getValue() == 2){
			status.setStatus(-1);
			status.setMessage("该订单已支付");
			return status;
		}
		UserAccount account = baseDao.selectOne(ACCOUNT_NAMESPACE_INFOUSER + "selectAmount", accountUserid);
		if(account.getAccountAmounts() < order.getOrderAmount()){
			status.setStatus(-3);
			status.setMessage("账户余额不足");
			return status;
		}
		
		AccountType type = baseDao.selectOne(ACCOUNT_TYPE_NAMESPACE_INFOUSER + "selectByCode","type_002");
		account.setAccountAmounts(order.getOrderAmount() - order.getOrderAmount() * 2);
		account.setAccountUserid(accountUserid);
		account.setAccountDatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		account.setAccountTypeid(type.getTypeId());
		account.setAccountOrderno(order.getOrderNo());
		
		order.setOrderStatusval(2);
		
		baseDao.insert(ACCOUNT_NAMESPACE_INFOUSER + "insertSelective", account);
		baseDao.modify(TIP_ORDER_NAMESPACE_INFOUSER + "updateByPrimaryKeySelective", order);
		status.MyStatusSuccess();
		return status;
	}

	@Override
	public UnifiedWeChatOrder PayTipByWechat(HttpServletRequest request, HttpServletResponse response,CleTipOrder order,String wechatId) {
		BaseOrder base = new BaseOrder();
		MyStatus status = new MyStatus();
		if(order.getOrderStatus().getValue() == 2 || order.getOrderStatus().getValue() == 3 || order. getOrderStatus().getValue() == 6 ){
			status.setStatus(-1);
			status.setMessage("该订单已支付");
		}else if(order.getOrderStatus().getValue() == 7){
			status.setStatus(-2);
			status.setMessage("该订单已取消");
		}else{
			status.setStatus(0);
			status.setMessage("SUCCESS");
			base.setBody("舒心汇佳-订单号:" + order.getOrderNo());
			base.setOrderBusiness("store");
			base.setOrderId(order.getOrderId());
			base.setOrderNo(order.getOrderNo());
			base.setTotal((int)(order.getOrderAmount() * 100));
			base.setCallback("/tipordercallbackwechat");
		}
		base.setStatus(status);
		return createWechatOrder(base, request, response, wechatId) ;
	}
	

	@Override
	public UnifiedWeChatOrder createWechatOrder(BaseOrder order, HttpServletRequest request,HttpServletResponse response, String wechatId) {
		UnifiedWeChatOrder unifiedOrder = new UnifiedWeChatOrder();
		unifiedOrder.setStatus(order.getStatus() == null ? null : order.getStatus().getStatus());
		if(order.getStatus() == null || order.getStatus().getStatus() == 0){
			try {
				
				Map<String, Object> params = new HashMap<String, Object>();

				params.put("appid", SystemConfig.appId);
				params.put("mch_id", SystemConfig.wechatPayMchId);
				params.put("nonce_str",RandomStringUtils.random(8, "123456789"));
				params.put("body", order.getBody());
				params.put("total_fee",  order.getTotal());
				params.put("out_trade_no", order.getOrderNo());
				params.put("spbill_create_ip", BrowserUtil.getIp(request));
				params.put("notify_url", SystemConfig.wechatPayNotifyUrl + "payAction" + order.getCallback());
				params.put("trade_type", "JSAPI");
				params.put("openid", wechatId);
				params.put("sign", SignatureUtil.encryptionByMD5(SignatureUtil.createSign(params, false) + "&key=" + SystemConfig.wechatPayPaternerKey, "utf-8", false));
				
				Map<String,Object> result = MapToXmlUtil.xmltoMap(HttpUtil.sendPost("https://api.mch.weixin.qq.com/pay/unifiedorder",new String(MapToXmlUtil.maptoXml(params).getBytes("utf-8"),"utf-8"),"xml"));
				
				String timeStamp =  System.currentTimeMillis() + "";
				String nonceStr = RandomStringUtils.random(8, "123456789");
				
				Map<String, Object> payInfo = new HashMap<String, Object>();
				payInfo.put("appId", SystemConfig.appId);
				payInfo.put("timeStamp", timeStamp);
				payInfo.put("nonceStr",nonceStr);
				payInfo.put("package", "prepay_id=" + (String)result.get("prepay_id"));
				payInfo.put("signType", "MD5");
				
				unifiedOrder.setOrderNo(order.getOrderNo());
				unifiedOrder.setAppid(SystemConfig.appId);
				unifiedOrder.setNonceStr(nonceStr);
				unifiedOrder.setPaySign(SignatureUtil.encryptionByMD5(SignatureUtil.createSign(payInfo, false) + "&key=" + SystemConfig.wechatPayPaternerKey, "utf-8", false));
				unifiedOrder.setPrepayId("prepay_id=" + (String)result.get("prepay_id"));
				unifiedOrder.setSignType("MD5");
				unifiedOrder.setTimeStamp(timeStamp);
				
				return unifiedOrder;

			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Map<String, Object> wechatPayCallback(HttpServletRequest request, HttpServletResponse response) {
		try {
			PrintWriter out = response.getWriter();
			StringBuffer sb = new StringBuffer();
			BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
			String s = "";
			while ((s = br.readLine()) != null) {
				sb.append(s);
			}
			
			Map<String, Object> params = MapToXmlUtil.xmltoMap(sb.toString());
			
			if(params.get("return_code").toString().equals("SUCCESS") && params.get("result_code").toString().equals("SUCCESS")){
				out.print(createWechatPayCallbackXml("SUCCESS", "OK"));
				return params;
			}else{
				out.print(createWechatPayCallbackXml("FAIL", "交易失败"));
				return null;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UnifiedWeChatOrder PayStoreByWechat(HttpServletRequest request, HttpServletResponse response,StrOrder order,String wechatId) {
		BaseOrder base = new BaseOrder();
		MyStatus status = new MyStatus();
		if(order.getOrderStatus().getValue() == 2 || order.getOrderStatus().getValue() == 3 || order.getOrderStatus().getValue() == 6 ){
			status.setStatus(-1);
			status.setMessage("该订单已支付");
		}else if(order.getOrderStatus().getValue() == 7){
			status.setStatus(-2);
			status.setMessage("该订单已取消");
		}else{
			status.setStatus(0);
			status.setMessage("SUCCESS");
			base.setBody("舒心汇佳-订单号:" + order.getOrderNo());
			base.setOrderBusiness("store");
			base.setOrderId(order.getOrderId());
			base.setOrderNo(order.getOrderNo());
			base.setTotal((int)(order.getOrderRealpayamount() * 100));
			base.setCallback("/storeordercallbackwechat");
		}
		base.setStatus(status);
		return createWechatOrder(base, request, response, wechatId) ;
	}

	@Override
	public UnifiedWeChatOrder PayCleanByWechat(HttpServletRequest request, HttpServletResponse response,CleOrder order,String wechatId) {
		BaseOrder base = new BaseOrder();
		MyStatus status = new MyStatus();
		if(order.getOrderStatus().getValue() == 2 || order.getOrderStatus().getValue() == 3 || order.getOrderStatus().getValue() == 6 ){
			status.setStatus(-1);
			status.setMessage("该订单已支付");
		}else if(order.getOrderStatus().getValue() == 7){
			status.setStatus(-2);
			status.setMessage("该订单已取消");
		}else{
			status.setStatus(0);
			status.setMessage("SUCCESS");
			base.setBody("舒心汇佳-订单号:" + order.getOrderNo());
			base.setOrderBusiness("clean");
			base.setOrderId(order.getOrderId());
			base.setOrderNo(order.getOrderNo());
			base.setTotal((int)(order.getOrderRealpayamount() * 100));
			base.setCallback("/cleanordercallbackwechat");
		}
		base.setStatus(status);
		return createWechatOrder(base, request, response, wechatId) ;
	}

	@Override
	public UnifiedWeChatOrder PayLaundryByWechat(HttpServletRequest request, HttpServletResponse response,RevOrder order,String wechatId) {
		BaseOrder base = new BaseOrder();
		MyStatus status = new MyStatus();
		if(order.getOrderStatus().getValue() == 2 || order.getOrderStatus().getValue() == 4 || order.getOrderStatus().getValue() == 6 ){
			status.setStatus(-1);
			status.setMessage("该订单已支付");
		}else if(order.getOrderStatus().getValue() == 7){
			status.setStatus(-2);
			status.setMessage("该订单已取消");
		}else{
			status.setStatus(0);
			status.setMessage("SUCCESS");
			base.setBody("舒心汇佳-订单号:" + order.getOrderNo());
			base.setOrderBusiness("store");
			base.setOrderId(order.getOrderId());
			base.setOrderNo(order.getOrderNo());
			base.setTotal((int)(order.getOrder().getOrderAmount() * 100));
			base.setCallback("/laundryordercallbackwechat");
			
			
			LadOrder ladorder = baseDao.selectOne(LAUNDRY_ORDER_NAMESPACE_INFOUSER + "selectByRevOrderid", order.getOrderId());
			ladorder.setOrderPaytype(0);
			baseDao.modify(LAUNDRY_ORDER_NAMESPACE_INFOUSER + "updateByPrimaryKeySelective", ladorder);
		}
		base.setStatus(status);
		return createWechatOrder(base, request, response, wechatId) ;
	}

	@Override
	public UnifiedWeChatOrder PayDifferenceByWechat(HttpServletRequest request, HttpServletResponse response,DifOrder order,String wechatId) {
		BaseOrder base = new BaseOrder();
		MyStatus status = new MyStatus();
		if(order.getOrderStatus().getValue() == 2){
			status.setStatus(-1);
			status.setMessage("该订单已支付");
		}else{
			status.setStatus(0);
			status.setMessage("SUCCESS");
			base.setBody("舒心汇佳-订单号:" + order.getOrderNo());
			base.setOrderBusiness("dif");
			base.setOrderId(order.getOrderId());
			base.setOrderNo(order.getOrderNo());
			base.setTotal((int)(order.getOrderAmount() * 100));
			base.setCallback("/difordercallbackwechat");
		}
		base.setStatus(status);
		return createWechatOrder(base, request, response, wechatId) ;
	}

	public String createWechatPayCallbackXml(String returnCode,String returnMsg){
		return "<xml><return_code><![CDATA[" + returnCode + "]]></return_code><return_msg><![CDATA[" + returnMsg + "]]></return_msg></xml>";
	}

	@Override
	public boolean insertPayDetailForWechat(Map<String, Object> map,Integer orderId) {
		PayDetail detail = baseDao.selectOne(PAYDETAIL_NAMESPACE_INFOUSER + "selectByOrderNo", map.get("out_trade_no").toString());
		if(detail == null){
			detail = new  PayDetail();
			detail.setPayAmount(Double.parseDouble(map.get("total_fee").toString()) / 100);
			detail.setPayDatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			detail.setPayOrderid(orderId);
			detail.setPayOrderno(map.get("out_trade_no").toString());
			detail.setPayPlatformid(((Platform)(baseDao.selectOne(PLATFROM_NAMESPACE_INFOUSER + "selectByCode", "wechatpay"))).getPlatformId());
			detail.setPayPlatformTradeno(map.get("transaction_id").toString());
			baseDao.insert(PAYDETAIL_NAMESPACE_INFOUSER + "insertSelective", detail);
			return true;
		}else{
			return false;
		}
	}

	@Override
	public UnifiedWeChatOrder refillAccountWechat(HttpServletRequest request, HttpServletResponse response,double amount,String wechatId) {
		BaseOrder base = new BaseOrder();
		String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");    
		base.setBody("舒心汇佳-订单号:" + uuid.toString());
		base.setOrderBusiness("dif");
		base.setOrderNo(uuid.toString());
		base.setTotal((int)(amount * 100));
		base.setCallback("/accountcallbackwechat");
		return createWechatOrder(base, request, response, wechatId) ;
	}

	@Override
	public void insertAccountForWechat(Map<String, Object> map) {
		UserAccount account = baseDao.selectOne(ACCOUNT_NAMESPACE_INFOUSER + "selectOrderNo", map.get("out_trade_no").toString());
		if(account == null){
			PayDetail detail = baseDao.selectOne(PAYDETAIL_NAMESPACE_INFOUSER + "selectByOrderNo", map.get("out_trade_no").toString());
			AccountType type = baseDao.selectOne(ACCOUNT_TYPE_NAMESPACE_INFOUSER + "selectByCode","type_001");
			User user = baseDao.selectOne(NAMESPACE_INFOUSER + "selectByWechatId", map.get("openid").toString());
			account = new UserAccount();
			account.setAccountAmounts(Double.parseDouble(map.get("total_fee").toString()) / 100);
			account.setAccountDatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			account.setAccountOrderno(map.get("out_trade_no").toString());
			account.setAccountPayid(detail.getPayId());
			account.setAccountTypeid(type.getTypeId());
			account.setAccountUserid(user.getUserId());
			baseDao.insert(ACCOUNT_NAMESPACE_INFOUSER + "insertSelective", account);
		}
	}
}
