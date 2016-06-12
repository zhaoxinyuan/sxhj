package com.ftc.wechat.account.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftc.base.dao.BaseDao;
import com.ftc.base.entity.MyPage;
import com.ftc.wechat.account.bean.UserAccount;
import com.ftc.wechat.account.service.AccountService;
import com.github.pagehelper.PageHelper;

@Service
public class AccountServiceImpl implements AccountService{
	
	private static final String ACCOUNT_NAMESPACE_INFOUSER = "com.ftc.wechat.account.dao.UserAccountMapper.";
	
	@Autowired
	private BaseDao baseDao;

	@Override
	public UserAccount getUserAmount(Integer accountUserid) {
		return baseDao.selectOne(ACCOUNT_NAMESPACE_INFOUSER + "selectAmount", accountUserid);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public MyPage getUserAccount(MyPage myPage, Integer accountUserid) {
		PageHelper.startPage(myPage.getCurrent(), myPage.getRowCount()).setOrderBy("account_id desc");
		return new MyPage().init(baseDao.selectList(ACCOUNT_NAMESPACE_INFOUSER + "selectByUserId", accountUserid));
	}

}
