package com.tech.sayo.test;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;

import com.google.gson.GsonBuilder;
import com.tech.sayo.wechat.clean.bean.CleOrder;
import com.tech.sayo.wechat.clean.bean.CleOrderDetail;
import com.tech.sayo.wechat.clean.bean.NanOrder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
/**
 * @author zo
 * @date 2016-06-14 13:11:55
 * @Description 测试  controller CleanAction
 * */  
public class CleanActionTest extends BaseTest {
	/**
	 * @Description 测试 url cleanAction/categories 打印返回结果
	 * @annotations Test 被Junit 执行的测试方法
	 * */
	//@Test
	public void testCategories() {
		System.out.println("\n" + "************************************************* Test cleanAction/categories *************************************************");
		try {
			MvcResult result = super.mockMvc.perform((get("/cleanAction/categories").param("callback", "?").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))).andExpect(status().isOk()).andDo(print()).andReturn();
			super.PrintResponseBody(result);
		} catch (Exception e) {
			e.printStackTrace();
		}  
	}
	
	//@Test
	public void testCategory() {
		System.out.println("\n" + "************************************************* Test cleanAction/category *************************************************");
		try {
			MvcResult result = super.mockMvc.perform((get("/cleanAction/categories").param("categoryId", "1").param("callback", "?").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))).andExpect(status().isOk()).andDo(print()).andReturn();
			super.PrintResponseBody(result);
		} catch (Exception e) {
			e.printStackTrace();
		}  
	}
	
	//@Test
	public void testStaffs() {
		System.out.println("\n" + "************************************************* Test cleanAction/staffs *************************************************");
		try {
			MvcResult result = super.mockMvc.perform((get("/cleanAction/staffs").param("categoryId", "1").param("current", "1").param("rowCount", "10").param("callback", "?").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))).andExpect(status().isOk()).andDo(print()).andReturn();
			super.PrintResponseBody(result);
		} catch (Exception e) {
			e.printStackTrace();
		}  
	}
	
	//@Test
	public void testStaff() {
		System.out.println("\n" + "************************************************* Test cleanAction/staff *************************************************");
		try {
			MvcResult result = super.mockMvc.perform((get("/cleanAction/staff").param("staffId", "1").param("callback", "?").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))).andExpect(status().isOk()).andDo(print()).andReturn();
			super.PrintResponseBody(result);
		} catch (Exception e) {
			e.printStackTrace();
		}  
	}
	
	//@Test
	public void testCleordersubmit() {
		System.out.println("\n" + "************************************************* Test cleanAction/cleordersubmit *************************************************");
		CleOrder order = new CleOrder();
		order.setOrderCategoryId(1);
		order.setOrderRealpayamount(60D);
		order.setOrderPayableamount(60D);
		order.setOrderPaytype(0);
		order.setOrderUserid(1);
		order.setOrderAddressid(221);
		
		List<CleOrderDetail> list = new ArrayList<CleOrderDetail>();
		
		CleOrderDetail detail = new CleOrderDetail();
		detail.setDetaiAmount(60D);
		detail.setDetailServicePrice(30D);
		detail.setDetailServiceHours(2);
		detail.setDetailServiceFrom("2016-06-14 18:00");
		detail.setDetailServiceTo("2016-06-14 20:00");
		detail.setDetailType(0);
		
		list.add(detail);
		order.setOrderDetail(list);
		String jsonStr = new GsonBuilder().disableHtmlEscaping().create().toJson(order);
		try {
			MvcResult result = super.mockMvc.perform((get("/cleanAction/cleordersubmit").param("order", jsonStr).param("callback", "?").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))).andExpect(status().isOk()).andDo(print()).andReturn();
			super.PrintResponseBody(result);
		} catch (Exception e) {
			e.printStackTrace();
		}  
	}
	
	//@Test
	public void testNanordersubmit() {
		System.out.println("\n" + "************************************************* Test cleanAction/nanordersubmit *************************************************");
		
		NanOrder order = new NanOrder();
		order.setOrderCategoryid(4);
		//order.setOrderStaffid(4);
		order.setOrderInterviewtime("2016-06-14 18:00");
		order.setOrderUserid(1);
		order.setOrderUseraddressid(221);
		
		String jsonStr = new GsonBuilder().disableHtmlEscaping().create().toJson(order);
		try {
			MvcResult result = super.mockMvc.perform((get("/cleanAction/nanordersubmit").param("order", jsonStr).param("callback", "?").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))).andExpect(status().isOk()).andDo(print()).andReturn();
			super.PrintResponseBody(result);
		} catch (Exception e) {
			e.printStackTrace();
		}  
	}
	
	//@Test
	public void testCleorders() {
		System.out.println("\n" + "************************************************* Test cleanAction/cleorders *************************************************");
		try {
			MvcResult result = super.mockMvc.perform((get("/cleanAction/cleorders").param("orderUserid", "1").param("current", "1").param("rowCount", "10").param("callback", "?").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))).andExpect(status().isOk()).andDo(print()).andReturn();
			super.PrintResponseBody(result);
		} catch (Exception e) {
			e.printStackTrace();
		}  
	}
	
	//@Test
	public void tetsCleorder() {
		System.out.println("\n" + "************************************************* Test cleanAction/cleorder *************************************************");
		try {
			MvcResult result = super.mockMvc.perform((get("/cleanAction/cleorder").param("orderId", "93").param("callback", "?").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))).andExpect(status().isOk()).andDo(print()).andReturn();
			super.PrintResponseBody(result);
		} catch (Exception e) {
			e.printStackTrace();
		}  
	}
	
	//@Test
	public void testNanorders() {
		System.out.println("\n" + "************************************************* Test cleanAction/nanorders *************************************************");
		try {
			MvcResult result = super.mockMvc.perform((get("/cleanAction/nanorders").param("orderUserid", "1").param("current", "1").param("rowCount", "10").param("callback", "?").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))).andExpect(status().isOk()).andDo(print()).andReturn();
			super.PrintResponseBody(result);
		} catch (Exception e) {
			e.printStackTrace();
		}  
	}
	
	//@Test
	public void testNanorder() {
		System.out.println("\n" + "************************************************* Test cleanAction/nanorder *************************************************");
		try {
			MvcResult result = super.mockMvc.perform((get("/cleanAction/nanorder").param("orderId", "3").param("callback", "?").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))).andExpect(status().isOk()).andDo(print()).andReturn();
			super.PrintResponseBody(result);
		} catch (Exception e) {
			e.printStackTrace();
		}  
	}
	
	//@Test
	public void testStafftimes() {
		System.out.println("\n" + "************************************************* Test cleanAction/stafftimes *************************************************");
		try {
			MvcResult result = super.mockMvc.perform((get("/cleanAction/stafftimes").param("staffId", "1").param("callback", "?").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))).andExpect(status().isOk()).andDo(print()).andReturn();
			super.PrintResponseBody(result);
		} catch (Exception e) {
			e.printStackTrace();
		}  
	}
	
	@Test
	public void testCancleCleOrder() {
		System.out.println("\n" + "************************************************* Test cleanAction/stafftimes *************************************************");
		try {
			MvcResult result = super.mockMvc.perform((get("/cleanAction/canclecleorder").param("orderId", "93").param("callback", "?").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))).andExpect(status().isOk()).andDo(print()).andReturn();
			super.PrintResponseBody(result);
		} catch (Exception e) {
			e.printStackTrace();
		}  
	}
}
