package com.nobroker.service;

import com.nobroker.entity.User;
import com.nobroker.payload.UserDto;
import com.nobroker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public long createUser(UserDto userDto);


    public User registerUser(User user) ;




    User getUserByEmail(String email);

    void verifyEmail(User user);

    boolean isEmailVerified(String email);

}
