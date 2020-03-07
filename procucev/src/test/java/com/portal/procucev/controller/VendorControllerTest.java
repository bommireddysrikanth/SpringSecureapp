package com.portal.procucev.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

import com.portal.procucev.model.Organization;
import com.portal.procucev.service.VendorService;

/**
 * Test Cases for Vendor Controller
 * 
 * @author venu gopal
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class VendorControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;
	@Mock
	private VendorService vendorService;

	@InjectMocks
	private VendorController vendorController;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(vendorController).addFilters(new CorsFilter()).build();
	}

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void userRegistration() throws Exception {
		Organization newVendor = new Organization();
		newVendor.setOrganizationId(1);
		boolean status = true;
		when(vendorService.userRegistration(newVendor)).thenReturn(status);
		/*
		 * mockMvc.perform(MockMvcRequestBuilders.post("/rest/newVendorRegistration"))
		 * 
		 * .andExpect(status().isOk()).andReturn();
		 */
		String params = "{\r\n" + "\r\n" + " \"gstin\":\"1234df\",\r\n" + "  \"organizationName\":\"procucev\",\r\n"
				+ "  \"orgBankDetails\":[\r\n" + "    {\r\n" + "      \"accountNumber\":\"123435\",\r\n"
				+ "      \"bankName\":\"hdfc\"\r\n" + "    },\r\n" + "      {\r\n"
				+ "      \"accountNumber\":\"3434\",\r\n" + "      \"bankName\":\"hdfc\"\r\n" + "    }\r\n" + "  ],\r\n"
				+ "  \"poc\":[\r\n" + "    {\r\n" + "      \"email\":\"venugopal@gmail.com\"\r\n" + "    },\r\n"
				+ "     {\r\n" + "      \"email\":\"gadevenu@gmail.com\"\r\n" + "    }\r\n" + "  \r\n" + "  ]\r\n"
				+ "}";
		mockMvc.perform(MockMvcRequestBuilders.post("/rest/newVendorRegistration").param("model", params)
				.contentType(MediaType.MULTIPART_FORM_DATA)).andExpect(status().isOk()).andReturn();
	}

	/*
	 * private String asJsonString(final Object obj) { try { return new
	 * ObjectMapper().writeValueAsString(obj); } catch (Exception e) { throw new
	 * RuntimeException(e); } }
	 */
}
