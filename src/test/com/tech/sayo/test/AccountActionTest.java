package com.tech.sayo.test;
 
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;  
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;  
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
/**
 * @author zo
 * @date 2016-06-14 10:50:26
 * @Description ����  controller AccountAction
 * */
public class AccountActionTest extends BaseTest {
	/**
	 * @Description ���� url accountAction/amount ��ӡ���ؽ��
	 * @annotations Test ��Junit ִ�еĲ��Է���
	 * */
	@Test
	public void testAmount() {
		System.out.println();
		System.out.println("*************************************************Test accountAction/amount*************************************************");
		try {
			MvcResult result = super.mockMvc.perform((get("/accountAction/amount").param("accountUserid", "1").param("callback", "?").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))).andExpect(status().isOk()).andDo(print()).andReturn();
			super.PrintResponseBody(result);
		} catch (Exception e) {
			e.printStackTrace();
		}  
	}
	
	@Test
	public void testDetails() {
		System.out.println();
		System.out.println("*************************************************Test accountAction/details*************************************************");
		try {
			MvcResult result = super.mockMvc.perform((get("/accountAction/details").param("accountUserid", "1").param("callback", "?").param("current", "1")).param("rowCount", "10").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andDo(print()).andReturn();
			super.PrintResponseBody(result);
		} catch (Exception e) {
			e.printStackTrace();
		}  
	}
}
