package com.tech.sayo.wechat.account.service;

import com.tech.sayo.base.entity.MyPage;
import com.tech.sayo.wechat.account.bean.UserAccount;

public interface AccountService {

	public UserAccount getUserAmount(Integer accountUserid);
	
	@SuppressWarnings("rawtypes")
	public MyPage getUserAccount(MyPage myPage, UserAccount account);
	
}
