package com.tech.sayo.wechat.pay.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.sayo.background.sys.bean.Status;
import com.tech.sayo.base.dao.BaseDao;
import com.tech.sayo.base.entity.MyStatus;
import com.tech.sayo.wechat.account.bean.AccountType;
import com.tech.sayo.wechat.account.bean.UserAccount;
import com.tech.sayo.wechat.clean.bean.CleOrder;
import com.tech.sayo.wechat.clean.bean.DifOrder;
import com.tech.sayo.wechat.laundry.bean.LadOrder;
import com.tech.sayo.wechat.pay.bean.Platform;
import com.tech.sayo.wechat.pay.service.PayService;
import com.tech.sayo.wechat.store.bean.StrOrder;

@Service
public class PayServiceImpl implements PayService{
	
	private static final String PLATFROM_NAMESPACE_INFOUSER = "com.tech.sayo.wechat.pay.dao.PlatformMapper.";
	private static final String ACCOUNT_NAMESPACE_INFOUSER = "com.tech.sayo.wechat.account.dao.UserAccountMapper.";
	private static final String ACCOUNT_TYPE_NAMESPACE_INFOUSER = "com.tech.sayo.wechat.account.dao.AccountTypeMapper.";
	private static final String STORE_ORDER_NAMESPACE_INFOUSER = "com.tech.sayo.wechat.store.dao.OrderMapper.";
	private static final String CLEAN_ORDER_NAMESPACE_INFOUSER = "com.tech.sayo.wechat.clean.dao.OrderMapper.";
	private static final String LAUNDRY_ORDER_NAMESPACE_INFOUSER = "com.tech.sayo.wechat.laundry.dao.OrderMapper.";
	private static final String DIFFERENCE_ORDER_NAMESPACE_INFOUSER = "com.tech.sayo.wechat.clean.dao.DifOrderMapper.";
	private static final String ORDER_STATUS_NAMESPACE_INFOUSER = "com.tech.sayo.background.sys.bean.StatusMapper.";
	
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
		account.setAccountUserid(accountUserid);
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
		account.setAccountUserid(accountUserid);
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
		LadOrder order = baseDao.selectOne(LAUNDRY_ORDER_NAMESPACE_INFOUSER + "selectByRevOrderid", orderId);
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
		
		Status orderStatus = baseDao.selectOne(ORDER_STATUS_NAMESPACE_INFOUSER + "selectByStatusCode", "lad_003");
		order.setOrderStatusid(orderStatus.getStatusId());
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
		if(order.getOrderStatus().getStatusCode().equals("dif_002")){
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
		
		Status orderStatus = baseDao.selectOne(ORDER_STATUS_NAMESPACE_INFOUSER + "selectByStatusCode", "dif_002");
		order.setOrderStatusid(orderStatus.getStatusId());
		order.setOrderPaytype(1);
		
		baseDao.insert(ACCOUNT_NAMESPACE_INFOUSER + "insertSelective", account);
		baseDao.modify(DIFFERENCE_ORDER_NAMESPACE_INFOUSER + "updateByPrimaryKeySelective", order);
		status.MyStatusSuccess();
		return status;
	}

}
