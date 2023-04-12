package com.example.testproject.service;

import java.util.List;


import com.example.testproject.entities.UserEntity;
import com.example.testproject.modal.response.CommonResponse;

public interface UserService {

	CommonResponse saveUser(UserEntity user);

    List<UserEntity> getAllUsers();

    CommonResponse getUser(Integer userId);

    CommonResponse updateUser(UserEntity user);
}
