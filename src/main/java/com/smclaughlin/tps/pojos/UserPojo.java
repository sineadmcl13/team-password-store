package com.smclaughlin.tps.pojos;

import com.smclaughlin.tps.entities.User;

/**
 * Created by sineadmclaughlin on 01/02/2017.
 */
public class UserPojo {

    private String forename;
    private String surname;
    private String department;
    private String email;

    public UserPojo() {}

    public UserPojo(User entity) {
        this.forename = entity.getForename();
        this.surname = entity.getSurname();
        this.department = entity.getDepartment();
        this.email = entity.getEmail();
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
