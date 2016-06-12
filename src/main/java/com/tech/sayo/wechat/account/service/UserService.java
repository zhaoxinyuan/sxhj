package com.tech.sayo.wechat.account.service;

import com.tech.sayo.base.entity.MyPage;
import com.tech.sayo.base.entity.MySort;
import com.tech.sayo.wechat.account.bean.User;

public interface UserService {
	@SuppressWarnings("rawtypes")
	public MyPage getUsers(User user,MyPage page,MySort sort);
	
	public User getUserByWechatId(String wechatId);
	
	public User getUser(Integer userId);
	
	public void saveUser(User user);
	
	public void updateUser(User user);
	
	public void deleteUser(Integer userId);
}
