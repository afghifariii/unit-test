package com.spring.boot.unit.test.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


public class EmployeeControllerTest {
	private MockMvc mockMvc;
	
	@Before
	public void setup(){
		this.mockMvc = MockMvcBuilders
	            .standaloneSetup(new EmployeeController())
	            .build();
	}
	
	@Test
	public void postEmployee() throws Exception {
		this.mockMvc.perform(post("/employees")
				.content("{\"name\":\"andy\",\"gender\":\"shemale\"}")
				.contentType("application/json"))
		.andExpect(status().isOk());
	}
	
	@Test
	public void getMale() throws Exception {
		String result = "[{\"name\":\"ali\",\"gender\":\"male\"}]";
		
		this.mockMvc.perform(get("/employees?gender=male"))
		.andExpect(content().json(result));
	}
	
	@Test
	public void findByName() throws Exception {
		this.mockMvc.perform(get("/employees/anto"))
		.andExpect(status().isNotFound());
	}

}
