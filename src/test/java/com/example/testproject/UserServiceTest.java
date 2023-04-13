package com.example.testproject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.testproject.entities.UserEntity;
import com.example.testproject.modal.response.CommonResponse;
import com.example.testproject.repository.UserRepository;
import com.example.testproject.service.UserService;
import com.example.testproject.utils.Constants;
import com.example.testproject.utils.Messages;


@ExtendWith(MockitoExtension.class)
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserServiceTest {

	@MockBean
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	@Test
	public void saveUserTest() {

		UserEntity user = new UserEntity();;
		CommonResponse cmn = new CommonResponse();
		cmn.setMessage(Messages.SUCCESS_MSG);
		cmn.setStatusCode(Constants.SUCCESS_CD);
		user.setId(25);
		user.setFirstName(" Aayush");
		user.setLastName("Joshi");
		user.setMobileNumber("5123456231");
		user.setEmail("dgvcb45@gmail.com");
		user.setAbout("I am doctor");
		

		Mockito.when(userRepository.save(user)).thenReturn(user);
		Assert.assertEquals(Messages.SUCCESS_MSG,cmn.getMessage());
		Assert.assertEquals(Constants.SUCCESS_CD, cmn.getStatusCode());

	}

}
