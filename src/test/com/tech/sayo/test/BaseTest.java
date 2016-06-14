package com.tech.sayo.test;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author zo
 * @date 2016-06-14 10:28:33
 * @Description Spring Junit 测试基类,所有的测试类，都应继承该类
 * @annotations RunWith 以spring环境运行Junit,WebAppConfiguration 使用测试环境的ApplicationContext,ContextConfiguration 加载配置文件
 * */

@RunWith(SpringJUnit4ClassRunner.class) 
@WebAppConfiguration 
@ContextConfiguration({
	"file:src/main/resources/spring-mvc.xml",
	"file:src/main/resources/spring-mybatis.xml"  
})
public class BaseTest {

	@Autowired
	private WebApplicationContext wac;  
	public MockMvc mockMvc;  

	/**
	 * @Description 初始化和模拟request,response
	 * @annotations @Before 在@test方法前执行
	 * */
	@Before
	public void setUp() {
		this.mockMvc = webAppContextSetup(this.wac).build();  
	}
}
