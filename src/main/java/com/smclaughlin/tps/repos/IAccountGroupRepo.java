package com.smclaughlin.tps.repos;

import com.smclaughlin.tps.entities.AccountGroup;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by sineadmclaughlin on 24/01/2017.
 */
public interface IAccountGroupRepo extends CrudRepository<AccountGroup, Long> {

    AccountGroup findByUuid(String uuid);
}
