package com.spring.userservice.service;

import com.spring.userservice.client.ApiFeignClient;
import com.spring.userservice.domain.User;
import com.spring.userservice.exception.BadRequestException;
import com.spring.userservice.model.UserRequestDto;
import com.spring.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    final ApiFeignClient apiFeignClient;


    public UserServiceImpl(UserRepository userRepository, @Qualifier("apiFeignFactory") ApiFeignClient apiFeignClient) {
        this.userRepository = userRepository;
        this.apiFeignClient = apiFeignClient;
    }

    @Override
    public User createUser(UserRequestDto userRequestDto) {
        log.info("Create Users service started");

        User newUser=new User();
        newUser.setName(userRequestDto.getName());
        return userRepository.save(newUser);
    }

    @Override
    public List<User> getUsers() {
        log.info("Get Users service started");
        return userRepository.findAll();
    }

    @Override
    public String setUserDummy(int userId) {
        log.info("Set User Dummy service started");

        User user=userRepository.findById(userId);
        if (user==null){
            log.error(String.format("User Not Found With id:%s",userId));
            throw new BadRequestException(String.format("User Not Found With Id:%s",userId));
        }
        if (!user.getDummy()){
            apiFeignClient.getDummy(userId);
            user.setDummy(true);
            log.info("User dummy Success");
            return "User dummy Success";
        }
        return "User was already dummy";

    }
}
