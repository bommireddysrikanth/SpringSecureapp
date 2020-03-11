package com.portal.procucev.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.filters.CorsFilter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.portal.procucev.model.Rfq;
import com.portal.procucev.service.RFQService;

/**
 * Test Cases for RFQ Controller
 * 
 * @author Venu Gopal
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RFQControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;
	@Mock
	private RFQService rfqService;

	@InjectMocks
	private RFQController rfqController;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(rfqController).addFilters(new CorsFilter()).build();
	}

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void fetchRfqById() throws Exception {
		Rfq rfq = new Rfq();
		rfq.setId(1);
		List<Rfq> status = new ArrayList<Rfq>();

		when(rfqService.fetchRfqById(1)).thenReturn(status);
		mockMvc.perform(MockMvcRequestBuilders.post("/rest/fetchRfqById/{id}", 1)).andReturn();
	}

	/*
	 * private String asJsonString(final Object obj) { try { return new
	 * ObjectMapper().writeValueAsString(obj); } catch (Exception e) { throw new
	 * RuntimeException(e); } }
	 */
}
