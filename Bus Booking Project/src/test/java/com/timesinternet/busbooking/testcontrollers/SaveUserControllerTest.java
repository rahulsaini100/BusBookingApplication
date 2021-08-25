package com.timesinternet.busbooking.testcontrollers;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.timesinternet.busbooking.controllers.SaveUserController;
import com.timesinternet.busbooking.entities.Users;
import com.timesinternet.busbooking.services.ServiceLayer;

/**
 * Codes for testing of SaveUserController class
 * @author Rahul.Saini
 *
 */
@WebMvcTest(value = SaveUserController.class)
@WebAppConfiguration
class SaveUserControllerTest {

	@Autowired
	private MockMvc mockMvc;
	/**
	 * Mocking the ServiceLayer
	 */
	@MockBean
	private ServiceLayer undertest;
	/**
	 * Testing for already registered number
	 * @throws Exception
	 */
	@Test
	void NumberAlreadyregistered_BadRequest_Test() throws Exception{
		
		Users testobj=new  Users();
		testobj.setUserAddress("8814056123");
		Optional<Users> objOptional=Optional.of(testobj);
		Mockito.when(undertest.findUsersByUserPhoneNumber("8814056123")).thenReturn(objOptional);
		MvcResult mvcResult = mockMvc.perform(post("/saveuser?userName=Vikas&userPhoneNumber=8814056123&userAddress=Delhi,NCR")).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(400, status);
		String message = mvcResult.getResponse().getErrorMessage();
		assertEquals("Number already Registered. Use a different number", message);
		
	}
	/**
	 * Testing for valid userName
	 * @throws Exception
	 */
	@Test
	void IFuserNameNotContainsAlphabatOrSpacesOnly_BadRequest_Test() throws Exception{
		
		MvcResult mvcResult = mockMvc.perform(post("/saveuser?userName=Vikas123&userPhoneNumber=8814056123&userAddress=Delhi,NCR")).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(400, status);
		String message = mvcResult.getResponse().getErrorMessage();
		assertEquals("User Name should contain letters a-z , A-Z and spaces only", message);
		
	}
	/**
	 * Testing for valid userPhoneNumber
	 * @throws Exception
	 */
	@Test
	void IfuserNumberNotContainDigitsOnly_BadRequest_Test() throws Exception{
		
		MvcResult mvcResult = mockMvc.perform(post("/saveuser?userName=Vikas&userPhoneNumber=8814056abc&userAddress=Delhi,NCR")).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(400, status);
		String message = mvcResult.getResponse().getErrorMessage();
		assertEquals("Phone number should contain digits 0-9 only", message);
		
	}
	/**
	 * Testing the size of userPhoneNumber
	 * @throws Exception
	 */
	@Test
	void IfuserNumberGreaterThan10Digits_BadRequest_Test() throws Exception{
		
		MvcResult mvcResult = mockMvc.perform(post("/saveuser?userName=Vikas&userPhoneNumber=88140562345&userAddress=Delhi,NCR")).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(400, status);
		String message = mvcResult.getResponse().getErrorMessage();
		assertEquals("Phone number should be of 10 digits", message);
		
	}
	/**
	 * Testing the method which adds user and returns userId
	 * @throws Exception
	 */
	@Test
	void AddnewUserAndReturnUserIdTest() throws Exception{
		
		Users u = new Users("Vikas","8814056234", "Delhi,NCR");
		Long userId=20L;
		Mockito.when(undertest.addNewUser(u)).thenReturn(userId);
		mockMvc.perform(post("/saveuser?userName=Vikas&userPhoneNumber=8814056234&userAddress=Delhi,NCR"))
	    .andExpect(status().isOk()).andReturn();
		
	}
}
