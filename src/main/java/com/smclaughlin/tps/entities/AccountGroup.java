package com.smclaughlin.tps.entities;

import javax.persistence.Entity;
import java.util.Objects;

/**
 * Created by sineadmclaughlin on 22/01/2017.
 */
@Entity(name = "Account_Group")
public class AccountGroup extends AbstractEntity {

    private String groupName;

    public AccountGroup() {
        this.groupName = "";
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
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
