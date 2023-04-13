package com.example.testproject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.testproject.entities.UserEntity;
import com.example.testproject.modal.HelperClass;
import com.example.testproject.modal.response.CommonResponse;
import com.example.testproject.service.UserService;
import com.example.testproject.utils.Constants;
import com.example.testproject.utils.Messages;



@RestController
@RequestMapping("/user")
public class UserController {

	
	@Autowired
    private UserService userService;
    

    private static  final Logger log = LoggerFactory.getLogger(UserController.class);


    @PostMapping
    public ResponseEntity<CommonResponse> createUser(@RequestBody UserEntity user) {
        log.info("UserController::createUser===START ");
        CommonResponse cmn = new CommonResponse();
        try {

            log.info("UserController::createUser::getUsers() ");
            cmn =  userService.saveUser(user);

            log.info("UserController::createUser===END ");
            return ResponseEntity.status(HttpStatus.OK).body(cmn);
        } catch (Exception e) {

            log.error("UserController::createUser===EXCEPTION= {} ", e.getStackTrace());
            cmn.setMessage(Messages.SOMETHING_WENT_WRONG);
            cmn.setStatusCode(Constants.ERROR_CD);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(cmn);}




    }

    @GetMapping("/{userId}")
    public ResponseEntity getUser(@PathVariable Integer userId) {
        log.info("UserController::getUser===START ");
        CommonResponse cmn = new CommonResponse();
        try {

            log.info("UserController::getUser::getUser() ");
            cmn = userService.getUser(userId);

            log.info("UserController::getUser===END ");
            return ResponseEntity.status(HttpStatus.OK).body(cmn);
        } catch (Exception e) {

            log.error("UserController::getUser===EXCEPTION= {} ", e.getStackTrace());
            cmn = HelperClass.getCommonExceptionResoponse();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body( cmn);
        }

    }


    @GetMapping
    public ResponseEntity<CommonResponse> getAllUsers(){
        log.info("UserController::getAllUsers===START ");
        CommonResponse cmn = new CommonResponse();
        try {

            log.info("UserController::getAllUsers::getUsers() ");
            cmn = (CommonResponse) userService.getAllUsers();

            log.info("UserController::getAllUser===END ");
            return  ResponseEntity.status(HttpStatus.OK).body(cmn);
        } catch (Exception e) {

            log.error("UserController::getAllUser===EXCEPTION= {} ", e.getStackTrace());
            cmn = HelperClass.getCommonExceptionResoponse();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(cmn);
        }

    }
}
