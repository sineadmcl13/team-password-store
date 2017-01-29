package com.smclaughlin.tps.service;


import com.smclaughlin.tps.entities.User;

/**
 * Created by sineadmclaughlin on 29/01/2017.
 */
public interface IUserService {

    /**
     * Saves a new user and generates a temporary username and password
     * @param user
     * @return
     */
    User createNewUser(User user);
}
