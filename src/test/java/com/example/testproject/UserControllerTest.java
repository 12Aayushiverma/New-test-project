package com.example.testproject;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.testproject.controller.UserController;
import com.example.testproject.entities.UserEntity;
import com.example.testproject.modal.response.CommonResponse;
import com.example.testproject.service.UserService;
import com.example.testproject.utils.Constants;
import com.example.testproject.utils.Messages;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserControllerTest {

	@Autowired
	private UserService userService;

	@Autowired
	private UserController userController;

	@Test
	@Order(1)
	public void createUserTest() {
		CommonResponse cmn = new CommonResponse();
		cmn.setMessage(Messages.SUCCESS_MSG);
		cmn.setStatusCode(Constants.SUCCESS_CD);
		UserEntity user = new UserEntity();
		user.setId(25);
		user.setFirstName(" Aayush");
		user.setLastName("Joshi");
		user.setMobileNumber("5123456231");
		user.setEmail("dgvcb45@gmail.com");
		user.setAbout("I am doctor");

		Mockito.when(userService.saveUser(user)).thenReturn(cmn);
		ResponseEntity<CommonResponse> responseEntity = userController.createUser(user);
		CommonResponse result = (CommonResponse) responseEntity.getBody();
		Assert.assertEquals(Constants.SUCCESS_CD, result.getStatusCode());

	}

	@Test
	@Order(2)
	public void getUserTest() {

		CommonResponse cmn = new CommonResponse();
	    List<UserEntity> list = new ArrayList();
		list.add(new UserEntity(4, "Aayushi", "Verma", "4512351262", "ajhbb@gmail.com", "I am user"));
		cmn.setData(list);
		cmn.setMessage(Messages.SUCCESS_MSG);
		cmn.setStatusCode(Constants.SUCCESS_CD);

		Mockito.when(userService.getUser(4)).thenReturn(cmn);
		ResponseEntity<CommonResponse> responseEntity = userController.getUser(4);
		CommonResponse result = (CommonResponse) responseEntity.getBody();
		Assert.assertEquals(Messages.SUCCESS_MSG, result.getMessage());

	}

	@Test
	@Order(3)
	public void getAllUserTest() {
		CommonResponse cmn = new CommonResponse();
		List<UserEntity> userList = new ArrayList<>();
		userList.add(new UserEntity(4, "Aayushi", "Verma", "4512351262", "ajhbb@gmail.com", "I am user"));
		userList.add(new UserEntity(5, "Aayush", "sharma", "6412351262", "dgfbb@gmail.com", "I am second user"));

		cmn.setData(userList);
		cmn.setMessage(Messages.SUCCESS_MSG);
		cmn.setStatusCode(Constants.SUCCESS_CD);
		Mockito.when(userService.getAllUsers()).thenReturn((List) cmn);
		ResponseEntity<CommonResponse> responseEntity = userController.getAllUsers();
		CommonResponse result = (CommonResponse) responseEntity.getBody();
		List<UserEntity> resultList = new ArrayList<>();
		resultList = (List) result.getData();
		Assert.assertEquals(Messages.SUCCESS_MSG, result.getMessage());

	}

}
