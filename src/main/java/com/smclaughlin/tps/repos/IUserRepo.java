package com.smclaughlin.tps.repos;

import com.smclaughlin.tps.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by sineadmclaughlin on 29/01/2017.
 */
public interface IUserRepo extends CrudRepository<User, Long> {

    User findByUsername(@Param("username") String username);

}
