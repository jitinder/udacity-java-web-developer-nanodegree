package com.udacity.jwdnd.c1.review.service;

import com.udacity.jwdnd.c1.review.mapper.UserMapper;
import com.udacity.jwdnd.c1.review.model.User;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;

@Service
public class UserService {
    UserMapper userMapper;
    HashService hashService;

    public UserService(UserMapper userMapper, HashService hashService) {
        this.userMapper = userMapper;
        this.hashService = hashService;
    }

    public boolean isUsernameAvailable(String username){
        return userMapper.getUser(username) == null;
    }

    public int createUser(User user){
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);

        String encodedSalt = Base64.getEncoder().encodeToString(salt);
        String hashedPass = hashService.getHashedValue(user.getPassword(), encodedSalt);

        return userMapper.addUser(new User(0, user.getUsername(), encodedSalt, hashedPass, user.getFirstName(), user.getLastName()));
    }
}
