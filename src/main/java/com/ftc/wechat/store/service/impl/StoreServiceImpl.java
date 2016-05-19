package com.ftc.wechat.store.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftc.base.dao.BaseDao;
import com.ftc.base.entity.MyPage;
import com.ftc.wechat.store.bean.Product;
import com.ftc.wechat.store.bean.Store;
import com.ftc.wechat.store.service.StoreService;
import com.github.pagehelper.PageHelper;

@Service
public class StoreServiceImpl implements StoreService {
	private static final String STORE_NAMESPACE_INFOUSER = "com.ftc.wechat.store.dao.StoreMapper.";
	private static final String PRODUCT_NAMESPACE_INFOUSER = "com.ftc.wechat.store.dao.ProductMapper.";

	@Autowired
	private BaseDao baseDao;

	@Override
	public Store getStore(Integer storeId) {
		return baseDao.selectOne(STORE_NAMESPACE_INFOUSER + "selectByPrimaryKey", storeId);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public MyPage getProducts(MyPage page, Product product) {
		PageHelper.startPage(page.getCurrent(),page.getRowCount());
		return new MyPage().init(baseDao.selectList(PRODUCT_NAMESPACE_INFOUSER + "selectByStore", product));
	}

	@Override
	public Product getProduct(Integer productId) {
		return baseDao.selectOne(PRODUCT_NAMESPACE_INFOUSER + "selectByPrimaryKey", productId);
	}

}
