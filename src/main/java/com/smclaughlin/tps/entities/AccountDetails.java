package com.smclaughlin.tps.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Objects;

/**
 * Created by sineadmclaughlin on 24/11/2016.
 */

@Entity(name = "Account_Details")
public class AccountDetails extends AbstractEntity{

    private String accountName;
    private String accountWebsite;
    private String username;
    private String passwordSalt;
    private String passwordHash;

    public AccountDetails() {
        this.accountName = "";
        this.accountWebsite = "";
        this.username = "";
        this.passwordSalt = "";
        this.passwordHash = "";
    }


    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountWebsite() {
        return accountWebsite;
    }

    public void setAccountWebsite(String accountWebsite) {
        this.accountWebsite = accountWebsite;
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
                Objects.equals(accountName, that.accountName) &&
                Objects.equals(accountWebsite, that.accountWebsite) &&
                Objects.equals(username, that.username) &&
                Objects.equals(passwordSalt, that.passwordSalt) &&
                Objects.equals(passwordHash, that.passwordHash) &&
                Objects.equals(uuid, that.uuid);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountName, accountWebsite, username, passwordSalt, passwordHash, uuid);
    }

}
