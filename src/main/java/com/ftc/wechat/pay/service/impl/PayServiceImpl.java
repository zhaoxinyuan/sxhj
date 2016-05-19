package com.ftc.wechat.pay.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftc.base.dao.BaseDao;
import com.ftc.wechat.pay.bean.Platform;
import com.ftc.wechat.pay.service.PayService;

@Service
public class PayServiceImpl implements PayService{
	
	private static final String PLATFROM_NAMESPACE_INFOUSER = "com.ftc.wechat.pay.dao.PlatformMapper.";
	
	@Autowired
	private BaseDao baseDao;
	
	@Override
	public List<Platform> getPlatforms() {
		return baseDao.selectList(PLATFROM_NAMESPACE_INFOUSER + "selectAll");
	}

}
