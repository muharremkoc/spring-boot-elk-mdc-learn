package com.spring.userservice.service;

import com.spring.userservice.domain.User;
import com.spring.userservice.model.UserRequestDto;

import java.util.List;

public interface UserService {

    User createUser(UserRequestDto userRequestDto);

    List<User> getUsers();

    String setUserDummy(int userId);


}
