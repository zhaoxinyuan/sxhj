package com.tech.sayo.test;
 
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
 
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 * @author zo
 * @date 2016-06-14 13:11:55
 * @Description ����  controller CleanAction
 * */
public class CleanActionTest extends BaseTest {
	/**
	 * @Description ���� url cleanAction/categories ��ӡ���ؽ��
	 * @annotations Test ��Junit ִ�еĲ��Է���
	 * */
	@Test
	public void testAmount() {
		System.out.println("\n" + "************************************************* Test cleanAction/categories *************************************************");
		try {
			MvcResult result = super.mockMvc.perform((get("/cleanAction/categories").param("callback", "?").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))).andExpect(status().isOk()).andDo(print()).andReturn();
			super.PrintResponseBody(result);
		} catch (Exception e) {
			e.printStackTrace();
		}  
	}
	
	
}
