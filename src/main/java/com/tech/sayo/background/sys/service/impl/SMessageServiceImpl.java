package com.tech.sayo.background.sys.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.sayo.background.sys.bean.SMessage;
import com.tech.sayo.background.sys.bean.SUser;
import com.tech.sayo.background.sys.service.SMessageService;
import com.tech.sayo.base.dao.BaseDao;

@Service
public class SMessageServiceImpl implements SMessageService{
	
	private static final String S_USER_NAMESPACE_INFOUSER = "com.tech.sayo.background.sys.dao.SUserMapper.";
	private static final String S_MESSAGE_NAMESPACE_INFOUSER = "com.tech.sayo.background.sys.dao.SMessageMapper.";
	
	@Autowired
	private BaseDao baseDao;
	
	public void insertStoreOrderMessage(){
		SUser user = new SUser();
		user.setGroupName("便利店接单员");
		List<SUser> userList = baseDao.selectList(S_USER_NAMESPACE_INFOUSER + "selectByGroup", user);
		
		List<SMessage> messageList = new ArrayList<SMessage>();
		SMessage message;
		
		for (SUser u : userList) {
			message = new SMessage();
			message.setOrgId(1);
			message.setUserId(u.getId());
			message.setMessageType(2);
			message.setMessageLevel(1);
			message.setContent("您有新的便利店订单，请及时处理");
			message.setStatus(0);
			message.setUrl("store/str_order.html");
			message.setParams("second=Store&third=Store003");
			message.setCreatedDate(new Date());
			message.setCreatedBy("wechat");
			message.setUpdatedDate(new Date());
			message.setUpdatedBy("wechat");
			message.setDeleteFlag(0);
			message.setTitle("提示");
			messageList.add(message);
		}
		
		baseDao.insert(S_MESSAGE_NAMESPACE_INFOUSER + "insertByBatch", messageList);
	}
	
	public void insertCleanOrderMessage(){
		SUser user = new SUser();
		user.setGroupName("保洁接单员");
		List<SUser> userList = baseDao.selectList(S_USER_NAMESPACE_INFOUSER + "selectByGroup", user);
		
		List<SMessage> messageList = new ArrayList<SMessage>();
		SMessage message;
		
		for (SUser u : userList) {
			message = new SMessage();
			message.setOrgId(1);
			message.setUserId(u.getId());
			message.setMessageType(2);
			message.setMessageLevel(1);
			message.setContent("您有新的保洁订单，请及时处理");
			message.setStatus(0);
			message.setUrl("clean/cle_order.html");
			message.setParams("second=Market&third=Market003");
			message.setCreatedDate(new Date());
			message.setCreatedBy("wechat");
			message.setUpdatedDate(new Date());
			message.setUpdatedBy("wechat");
			message.setDeleteFlag(0);
			message.setTitle("提示");
			messageList.add(message);
		}
		
		baseDao.insert(S_MESSAGE_NAMESPACE_INFOUSER + "insertByBatch", messageList);
	}
	
	public void insertLaundryOrderMessage(){
		SUser user = new SUser();
		user.setGroupName("洗衣接单员");
		List<SUser> userList = baseDao.selectList(S_USER_NAMESPACE_INFOUSER + "selectByGroup", user);
		
		List<SMessage> messageList = new ArrayList<SMessage>();
		SMessage message;
		
		for (SUser u : userList) {
			message = new SMessage();
			message.setOrgId(1);
			message.setUserId(u.getId());
			message.setMessageType(2);
			message.setMessageLevel(1);
			message.setContent("您有新的洗衣订单，请及时处理");
			message.setStatus(0);
			message.setUrl("laundry/lad_rev_order.html");
			message.setParams("second=Sales&third=Sales001");
			message.setCreatedDate(new Date());
			message.setCreatedBy("wechat");
			message.setUpdatedDate(new Date());
			message.setUpdatedBy("wechat");
			message.setDeleteFlag(0);
			message.setTitle("提示");
			messageList.add(message);
		}
		
		baseDao.insert(S_MESSAGE_NAMESPACE_INFOUSER + "insertByBatch", messageList);
	}
	
	public void insertNannyOrderMessage(){
		SUser user = new SUser();
		user.setGroupName("洗衣接单员");
		List<SUser> userList = baseDao.selectList(S_USER_NAMESPACE_INFOUSER + "selectByGroup", user);
		
		List<SMessage> messageList = new ArrayList<SMessage>();
		SMessage message;
		
		for (SUser u : userList) {
			message = new SMessage();
			message.setOrgId(1);
			message.setUserId(u.getId());
			message.setMessageType(2);
			message.setMessageLevel(1);
			message.setContent("您有新的洗衣订单，请及时处理");
			message.setStatus(0);
			message.setUrl("laundry/lad_rev_order.html");
			message.setParams("second=Sales&third=Sales001");
			message.setCreatedDate(new Date());
			message.setCreatedBy("wechat");
			message.setUpdatedDate(new Date());
			message.setUpdatedBy("wechat");
			message.setDeleteFlag(0);
			message.setTitle("提示");
			messageList.add(message);
		}
		
		baseDao.insert(S_MESSAGE_NAMESPACE_INFOUSER + "insertByBatch", messageList);
	}
}
