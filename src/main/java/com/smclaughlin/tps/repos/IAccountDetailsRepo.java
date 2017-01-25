package com.smclaughlin.tps.repos;

import com.smclaughlin.tps.entities.AccountDetails;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by sineadmclaughlin on 24/01/2017.
 */
public interface IAccountDetailsRepo extends CrudRepository<AccountDetails, Long> {

    AccountDetails findByUuid(String uuid);

}
