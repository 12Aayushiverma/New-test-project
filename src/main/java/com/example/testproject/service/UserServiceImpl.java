package com.example.testproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.testproject.entities.UserEntity;
import com.example.testproject.modal.HelperClass;
import com.example.testproject.modal.response.CommonResponse;
import com.example.testproject.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {

	   @Autowired
	    private UserRepository userRepository;

	   

	   
	    private  static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	    @Override
	    public CommonResponse saveUser(UserEntity user) {
	        log.info("UserServiceImpl::saveUser::Start");
	        CommonResponse cmn = new CommonResponse();
	        try {
	            log.info("UserServiceImpl::saveUser()::save()");
	            userRepository.save(user);
	            cmn.setMessage("User Sved Successfully");
	            cmn.setStatusCode(200);
	            log.info("UserServiceImpl::saveUser()::end");
	            return cmn;
	        }
	        catch (Exception e) {
	            log.error("UserServiceImpl::saveUser():: Exception={}", e.getStackTrace());
	            return HelperClass.getCommonExceptionResoponse();

	        }

	    }

	    @Override
	    public List<UserEntity> getAllUsers() {
	        log.info("UserServiceImpl::getAllUsers()=== START");
	        CommonResponse cmn = new CommonResponse();

	        try {


	            log.info("UserServiceImpl::getAllUsers()::findAll()");
	            List<UserEntity> users = userRepository.findAll();
	            cmn.setData(users);
	            log.info("UserServiceImpl::getUsers()=== END");
	            return (List<UserEntity>) cmn;
	        } catch (Exception e) {
	            log.error("UserServiceImpl::getUsers():: Exception={}", e.getStackTrace());
	            return (List<UserEntity>) HelperClass.getCommonExceptionResoponse();

	        }
	    }

	    @Override
	    public CommonResponse getUser(Integer userId) {
	        log.info("UserServiceImpl::getUser()=== START");
	        CommonResponse cmn = new CommonResponse();


	        try {

	            Optional<UserEntity> user = Optional.of(new UserEntity());
	            user = userRepository.findById(userId);
	            
	            cmn.setData(user);
	            cmn.setMessage("User found successfully");
	            cmn.setStatusCode(200);
	            return cmn;

	        }catch (Exception ex){
	            log.error("UserServiceImpl::getUsers():: Exception={}", ex.getStackTrace());
	            return (CommonResponse) HelperClass.getCommonExceptionResoponse();
	        }
	     

	    }

	    @Override
	    public CommonResponse updateUser(UserEntity user) {

	        log.info("UserServiceImpl::updateUser()=== START");
	        CommonResponse cmn = new CommonResponse();
	       cmn.setData(userRepository.save(user)); 
	       return cmn;
	    }
}
