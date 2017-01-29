package com.smclaughlin.tps.entities;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by sineadmclaughlin on 24/11/2016.
 */

@Entity(name = "Account_Details")
public class AccountDetails extends AbstractEntity {

    private String accountName;
    private String accountWebsite;
    private String username;
    private String passwordSalt;
    private String passwordHash;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="group_id")
    private AccountGroup accountGroup;

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

    public AccountGroup getAccountGroup() {
        return accountGroup;
    }

    public void setAccountGroup(AccountGroup accountGroup) {
        this.accountGroup = accountGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null ||!(o instanceof AccountDetails)) return false;
        AccountDetails that = (AccountDetails) o;

        return Objects.equals(id, that.id) &&
                Objects.equals(uuid, that.uuid);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, uuid);
    }

}
