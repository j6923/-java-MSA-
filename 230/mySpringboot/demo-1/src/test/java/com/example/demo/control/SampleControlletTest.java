package com.example.demo.control;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
@WebMvcTest(SampleController.class)
class SampleControlletTest {
	
	@Autowired
	private MockMvc mockMvc;  //모의 객체: "흉내"내는 "가짜"모듈 
	@Test
	void greetingTest() throws Exception {
		//sfail("Not yet implemented");
		//MockHttpServletRequestBuilder mockRequestBuilder = MockMvcRequestBuilders.get("/greating");
		//mockRequestBuilder.accept(org.springframework.http.MediaType.APPLICATION);
		MockHttpServletRequestBuilder  mockRequestBuilder = MockMvcRequestBuilders.get("/greeting")
                .accept(org.springframework.http.MediaType.APPLICATION_JSON);
		ResultActions resultActions = mockMvc.perform(mockRequestBuilder); 
		resultActions.andExpect(MockMvcResultMatchers.status().isOk());//응답이 성공 되었는지 비교 
		resultActions.andExpect(MockMvcResultMatchers.content().string("welcome"));


	}
	@Test
	void testFooter() throws Exception {
		MockHttpServletRequestBuilder  mockRequestBuilder =
				MockMvcRequestBuilders.get("/footer");
//		mockRequestBuilder.param("test", "요청전달데이터");
		ResultActions resultActions = mockMvc.perform(mockRequestBuilder);//요청함 
		String expectedViewName = "footer";
		ResultMatcher matcher = MockMvcResultMatchers.view().name(expectedViewName);
		resultActions.andExpect(matcher);

	}

}
