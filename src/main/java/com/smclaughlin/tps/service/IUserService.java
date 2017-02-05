package com.smclaughlin.tps.service;


import com.smclaughlin.tps.entities.User;
import com.smclaughlin.tps.pojos.UserPojo;

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

    /**
     * Returns a true or false if the username and password represent an existing users login details
     * @param username
     * @param password
     * @return
     */
    boolean checkLoginIsValid(String username, String password);

    /**
     * Returns a pojo containing details representing the logged in user
     * @param username
     * @return
     */
    UserPojo returnUserByUsername(String username);
}
