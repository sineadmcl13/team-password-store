package com.smclaughlin.tps.web.user;

import com.smclaughlin.tps.entities.User;
import com.smclaughlin.tps.web.AbstractModel;

import java.io.Serializable;

/**
 * Created by sineadmclaughlin on 29/01/2017.
 */
public class AddUserModel extends AbstractModel implements Serializable{


    public final static String KEY = "addUserModel";
    private static final long serialVersionUID = -7970713730568707448L;

    private User user;

    @Override
    public void reset() {
        this.user = new User();
    }

    @Override
    public String getKey() {
        return KEY;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
