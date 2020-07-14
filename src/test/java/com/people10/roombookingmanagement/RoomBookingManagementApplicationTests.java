package com.people10.roombookingmanagement;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(classes = { RoomBookingManagementApplication.class })
@AutoConfigureMockMvc
@RunWith(SpringJUnit4ClassRunner.class)
public class RoomBookingManagementApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testValidCustomer() throws Exception {
		this.mockMvc.perform(get("/api/customer/1")).andExpect(status().isOk());
	}

	@Test
	public void testInValidCustomer() throws Exception {
		this.mockMvc.perform(get("/api/customer/2")).andExpect(status().isNotFound());
	}
}
