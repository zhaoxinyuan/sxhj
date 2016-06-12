package com.ftc.wechat.pay.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftc.background.sys.bean.Status;

import com.ftc.base.dao.BaseDao;
import com.ftc.base.entity.MyStatus;
import com.ftc.wechat.account.bean.AccountType;
import com.ftc.wechat.account.bean.UserAccount;
import com.ftc.wechat.pay.bean.Platform;
import com.ftc.wechat.pay.service.PayService;
import com.ftc.wechat.store.bean.StrOrder;
import com.ftc.wechat.clean.bean.CleOrder;

@Service
public class PayServiceImpl implements PayService{
	
	private static final String PLATFROM_NAMESPACE_INFOUSER = "com.ftc.wechat.pay.dao.PlatformMapper.";
	private static final String ACCOUNT_NAMESPACE_INFOUSER = "com.ftc.wechat.account.dao.UserAccountMapper.";
	private static final String ACCOUNT_TYPE_NAMESPACE_INFOUSER = "com.ftc.wechat.account.dao.AccountTypeMapper.";
	private static final String STORE_ORDER_NAMESPACE_INFOUSER = "com.ftc.wechat.store.dao.OrderMapper.";
	private static final String CLEAN_ORDER_NAMESPACE_INFOUSER = "com.ftc.wechat.clean.dao.OrderMapper.";
	private static final String LAUNDRY_ORDER_NAMESPACE_INFOUSER = "com.ftc.wechat.laundry.dao.LaundryMapper.";
	private static final String ORDER_STATUS_NAMESPACE_INFOUSER = "com.ftc.background.sys.bean.StatusMapper.";
	
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
		if(order.getOrderStatus().getStatusCode().equals("str_002") || order.getOrderStatus().getStatusCode().equals("str_003") || order.getOrderStatus().getStatusCode().equals("odr_001")){
			status.setStatus(-1);
			status.setMessage("该订单已支付");
			return status;
		}else if(order.getOrderStatus().getStatusCode().equals("odr_002")){
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
		account.setAccountUserid(orderId);
		account.setAccountDatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		account.setAccountTypeid(type.getTypeId());
		account.setAccountOrderno(order.getOrderNo());
		
		Status orderStatus = baseDao.selectOne(ORDER_STATUS_NAMESPACE_INFOUSER + "selectByStatusCode", "str_002");
		order.setOrderStatusid(orderStatus.getStatusId());
		
		baseDao.insert(ACCOUNT_NAMESPACE_INFOUSER + "insertSelective", account);
		baseDao.modify(STORE_ORDER_NAMESPACE_INFOUSER + "updateByPrimaryKeySelective", order);
		status.MyStatusSuccess();
		return status;
	}

	@Override
	public MyStatus PayCleanByAccount(Integer orderId, Integer accountUserid) {
		MyStatus status = new MyStatus();
		CleOrder order = baseDao.selectOne(CLEAN_ORDER_NAMESPACE_INFOUSER + "selectByPrimaryKey", orderId);
		if(order.getOrderStatus().getStatusCode().equals("cle_002") || order.getOrderStatus().getStatusCode().equals("cle_003") || order.getOrderStatus().getStatusCode().equals("odr_001")){
			status.setStatus(-1);
			status.setMessage("该订单已支付");
			return status;
		}else if(order.getOrderStatus().getStatusCode().equals("odr_002")){
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
		account.setAccountUserid(orderId);
		account.setAccountDatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		account.setAccountTypeid(type.getTypeId());
		account.setAccountOrderno(order.getOrderNo());
		
		Status orderStatus = baseDao.selectOne(ORDER_STATUS_NAMESPACE_INFOUSER + "selectByStatusCode", "cle_002");
		order.setOrderStatusid(orderStatus.getStatusId());
		
		baseDao.insert(ACCOUNT_NAMESPACE_INFOUSER + "insertSelective", account);
		baseDao.modify(CLEAN_ORDER_NAMESPACE_INFOUSER + "updateByPrimaryKeySelective", order);
		status.MyStatusSuccess();
		return status;
	}

	@Override
	public MyStatus PayLaundryByAccount(Integer orderId, Integer accountUserid) {
		MyStatus status = new MyStatus();
		CleOrder order = baseDao.selectOne(LAUNDRY_ORDER_NAMESPACE_INFOUSER + "selectByPrimaryKey", orderId);
		if(order.getOrderStatus().getStatusCode().equals("lad_003") || order.getOrderStatus().getStatusCode().equals("lad_004") || order.getOrderStatus().getStatusCode().equals("odr_001")){
			status.setStatus(-1);
			status.setMessage("该订单已支付");
			return status;
		}else if(order.getOrderStatus().getStatusCode().equals("odr_002")){
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
		account.setAccountUserid(orderId);
		account.setAccountDatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		account.setAccountTypeid(type.getTypeId());
		account.setAccountOrderno(order.getOrderNo());
		
		Status orderStatus = baseDao.selectOne(ORDER_STATUS_NAMESPACE_INFOUSER + "selectByStatusCode", "cle_002");
		order.setOrderStatusid(orderStatus.getStatusId());
		
		baseDao.insert(ACCOUNT_NAMESPACE_INFOUSER + "insertSelective", account);
		baseDao.modify(LAUNDRY_ORDER_NAMESPACE_INFOUSER + "updateByPrimaryKeySelective", order);
		status.MyStatusSuccess();
		return status;
	}

}
