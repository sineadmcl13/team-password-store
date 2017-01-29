package com.smclaughlin.tps.service;

import com.smclaughlin.tps.entities.User;
import com.smclaughlin.tps.repos.IUserRepo;
import com.smclaughlin.tps.service.security.IPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sineadmclaughlin on 29/01/2017.
 */
@Service
public class UserService implements IUserService {

    @Autowired
    IPasswordService passwordService;

    @Autowired
    IUserRepo userRepo;

    @Override
    public User createNewUser(User user) {
        user.setUsername(user.getEmail());
        securePasswordDetails(user);
        return userRepo.save(user);
    }

    private User securePasswordDetails(User user){
        String salt = passwordService.generatePasswordSalt();
        String hash = passwordService.generateHash(salt, user.getPasswordHash());
        user.setPasswordSalt(salt);
        user.setPasswordHash(hash);
        return user;
    }
}
