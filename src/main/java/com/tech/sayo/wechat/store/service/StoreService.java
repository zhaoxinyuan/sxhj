package com.tech.sayo.wechat.store.service;

import java.util.List;

import com.tech.sayo.base.entity.MyPage;
import com.tech.sayo.wechat.store.bean.Product;
import com.tech.sayo.wechat.store.bean.Store;

public interface StoreService {

	public Store getStore(Integer storeId);
	
	@SuppressWarnings("rawtypes")
	public MyPage getProducts(MyPage page,Product product);
	
	public List<Product> getProducts(String productids);
	
	public Product getProduct(Integer productId);

}
