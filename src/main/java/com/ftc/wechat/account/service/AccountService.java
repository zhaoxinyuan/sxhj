package com.ftc.wechat.account.service;

import com.ftc.base.entity.MyPage;
import com.ftc.wechat.account.bean.UserAccount;

public interface AccountService {

	public UserAccount getUserAmount(Integer accountUserid);
	
	@SuppressWarnings("rawtypes")
	public MyPage getUserAccount(MyPage myPage, Integer accountUserid);
	
}
