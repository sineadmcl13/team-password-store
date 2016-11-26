package com.smclaughlin.tps.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

/**
 * Created by sineadmclaughlin on 24/11/2016.
 */

@Entity(name = "Account_Details")
public class AccountDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String passwordSalt;
    private String passwordHash;

    public AccountDetails() {
    }

    public AccountDetails(Long id, String username, String passwordSalt, String passwordHash) {
        this.id = id;
        this.username = username;
        this.passwordSalt = passwordSalt;
        this.passwordHash = passwordHash;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null ||!(o instanceof AccountDetails)) return false;
        AccountDetails that = (AccountDetails) o;

        return Objects.equals(id, that.id) &&
                Objects.equals(username, that.username) &&
                Objects.equals(passwordSalt, that.passwordSalt) &&
                Objects.equals(passwordHash, that.passwordHash);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, passwordSalt, passwordHash);
    }

}
