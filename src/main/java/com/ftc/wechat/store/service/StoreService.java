package com.ftc.wechat.store.service;

import com.ftc.base.entity.MyPage;
import com.ftc.wechat.store.bean.Product;
import com.ftc.wechat.store.bean.Store;

public interface StoreService {

	public Store getStore(Integer storeId);
	
	@SuppressWarnings("rawtypes")
	public MyPage getProducts(MyPage page,Product product);
	
	public Product getProduct(Integer productId);

}
