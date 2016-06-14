package com.tech.sayo.test;
 
import org.junit.Test;   
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;  
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;  
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;  
/**
 * @author zo
 * @date 2016-06-14 10:50:26
 * @Description 测试  controller AccountAction
 * */
public class AccountActionTest extends BaseTest {
	/**
	 * @Description 测试 url accountAction/amount 打印返回结果
	 * @annotations Test 被Junit 执行的测试方法
	 * */
	@Test
	public void testAmount() {
		System.out.println();
		System.out.println("*************************************************Test accountAction/amount*************************************************");
		try {
			super.mockMvc.perform((get("/accountAction/amount").param("accountUserid", "1").param("callback", "?"))).andExpect(status().isOk()).andDo(print());
		} catch (Exception e) {
			e.printStackTrace();
		}  
	}
	
	@Test
	public void testDetails() {
		System.out.println();
		System.out.println("*************************************************Test accountAction/details*************************************************");
		try {
			super.mockMvc.perform((get("/accountAction/details").param("accountUserid", "1").param("callback", "?").param("current", "1")).param("rowCount", "10")).andExpect(status().isOk()).andDo(print());
		} catch (Exception e) {
			e.printStackTrace();
		}  
	}
}
