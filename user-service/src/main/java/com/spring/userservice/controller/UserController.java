package com.spring.userservice.controller;

import com.spring.userservice.domain.User;
import com.spring.userservice.model.UserRequestDto;
import com.spring.userservice.service.UserService;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("")
    public User createUser(@RequestBody UserRequestDto userRequestDto){
        MDC.put("CREATE_USER_REQUEST_ID", UUID.randomUUID().toString());
        return userService.createUser(userRequestDto);
    }
    @GetMapping("")
    public List<User> getUsers(){
        MDC.put("GET_USERS_REQUEST_ID", UUID.randomUUID().toString());
        return userService.getUsers();
    }

    @PutMapping("/{userId}")
    public String setUser(@PathVariable("userId") int userId){
        MDC.put("SET_USER_REQUEST_ID", UUID.randomUUID().toString());
        MDC.put("SET_USER_ID", String.valueOf(userId));
        return userService.setUserDummy(userId);
    }
}
