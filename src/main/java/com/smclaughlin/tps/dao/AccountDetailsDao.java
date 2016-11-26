package com.smclaughlin.tps.dao;

import com.smclaughlin.tps.entities.AccountDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by sineadmclaughlin on 25/11/2016.
 */
@Repository
public class AccountDetailsDao implements IAccountDetailsDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public AccountDetails getAccountDetailsById(Long id) {
        String selectQuery = "SELECT * FROM Account_Details WHERE id = ?";
        AccountDetails accountDetails =
                jdbcTemplate.queryForObject(selectQuery, BeanPropertyRowMapper.newInstance(AccountDetails.class), id);

        return accountDetails;
    }
}
