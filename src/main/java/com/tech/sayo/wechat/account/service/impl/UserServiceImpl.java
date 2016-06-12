package com.tech.sayo.wechat.account.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.tech.sayo.base.dao.BaseDao;
import com.tech.sayo.base.entity.MyPage;
import com.tech.sayo.base.entity.MySort;
import com.tech.sayo.wechat.account.bean.User;
import com.tech.sayo.wechat.account.service.UserService;


@Service 
public class UserServiceImpl implements UserService{
	
	private static final String NAMESPACE_INFOUSER  = "com.tech.sayo.wechat.account.bean.mapper.UserMapper.";
	
	@Autowired
    private  BaseDao baseDao;
	
	@SuppressWarnings({ "unchecked", "rawtypes", "static-access" })
	@Override
	public MyPage getUsers(User user,MyPage page,MySort sort){
		PageHelper.startPage(page.getCurrent(),page.getRowCount()).setOrderBy(sort.getSortSql(new User().orderBySql()));
		return new MyPage().init(baseDao.selectList(NAMESPACE_INFOUSER + "selectAll", user)); 
	}
	
	@Override
	public User getUserByWechatId(String wechatId) {
		return baseDao.selectOne(NAMESPACE_INFOUSER + "selectByWechatId", wechatId);
	}
	
	@Override
	public User getUser(Integer userId) {
		return baseDao.selectOne(NAMESPACE_INFOUSER + "selectByPrimaryKey", userId);
	}
	
	@Override
	public void saveUser(User user) {
		baseDao.insert(NAMESPACE_INFOUSER + "insertSelective", user);
	}
	
	@Override
	public void updateUser(User user) {
		baseDao.modify(NAMESPACE_INFOUSER + "updateByPrimaryKeySelective", user);
	}
	
	@Override
	public void deleteUser(Integer userId){
		baseDao.remove(NAMESPACE_INFOUSER + "deleteByPrimaryKey", userId);
	}

}
