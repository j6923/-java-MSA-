package com.example.demo.customer.control;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Controller;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
@SpringBootTest(webEnvironment  = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
//@Controller
class CustomerControllerTest {
	@Autowired
	private MockMvc mockMvc; //
	@Test
	void testLogin() throws Exception {
		//fail("Not yet implemented");
		MockHttpServletRequestBuilder mockRequestBuilder = 
				MockMvcRequestBuilders.post("/login");
			mockRequestBuilder.param("id", "id1");
			mockRequestBuilder.param("pwd", "pp1");
			ResultActions resultActions = mockMvc.perform(mockRequestBuilder);
			resultActions.andExpect(MockMvcResultMatchers.status().isOk());
			resultActions.andExpect(jsonPath("status",is(1)));
	}

}
