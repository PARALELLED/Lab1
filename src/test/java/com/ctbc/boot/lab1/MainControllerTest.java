package com.ctbc.boot.lab1;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
//----------------------------------------------------------------------------------------
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.ctbc.boot.lab1.controllers.InfoController;
import com.ctbc.boot.lab1.controllers.MainController;
import com.ctbc.boot.lab1.services.GreetingServices;

import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

// import static 
// ----------------------------------------------------------------------------------------
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
// 會自動import static，因為Editor -> Content Assist -> Favorites 已建立好
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.contains;
// 
import static org.mockito.Mockito.when;

//----------------------------------------------------------------------------------------
//@SpringBootTest
//@AutoConfigureMockMvc
@WebMvcTest({MainController.class,InfoController.class}) // 只會啟動Web的tier // MainControllerTest.testNotFoundPage:54 Status expected:<200> but was:<404>[m
public class MainControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private GreetingServices service;
	
	@Test
	public void testMockMVCanotNull() {
		assertThat(mockMvc).isNotNull(); // 檢查mockMvc是否為空
	}

	@Test
	// 測試網頁是否可以執行
	public void testHomePage() throws Exception {
		mockMvc.perform(get("/")) // MainControllerTest.testHomePage:28 Status expected:<200> but was:<404>
		.andExpect(status().isOk())
		.andExpect(view().name("home"))
		.andExpect(content()
				.string(Matchers.containsString("手刻"))); // not containing "程式生成"
	}
	
	@Test
	public void testNotFoundPage() throws Exception {
		mockMvc.perform(get("/info"))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	@Test
	public void testResponseBody() throws Exception {
		when(service.greet()).thenReturn("sample greeting message");
		mockMvc.perform(get("/greeting")) // mock bean
		.andDo(MockMvcResultHandlers.print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("sample")));
	}

}