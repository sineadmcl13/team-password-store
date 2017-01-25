package com.smclaughlin.tps.entities;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Objects;

/**
 * Created by sineadmclaughlin on 22/01/2017.
 */
@Entity(name = "Account_Group")
public class AccountGroup extends AbstractEntity {

    private String groupName;

    @OneToMany(mappedBy="accountGroup")
    private List<AccountDetails> accountDetailsList;

    public AccountGroup() {
        this.groupName = "";
        this.accountDetailsList = null;
    }

    public AccountGroup(Long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<AccountDetails> getAccountDetailsList() {
        return accountDetailsList;
    }

    public void setAccountDetailsList(List<AccountDetails> accountDetailsList) {
        this.accountDetailsList = accountDetailsList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null ||!(o instanceof AccountGroup)) return false;
        AccountGroup that = (AccountGroup) o;

        return Objects.equals(id, that.id) &&
                Objects.equals(uuid, that.uuid);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, uuid);
    }
}
