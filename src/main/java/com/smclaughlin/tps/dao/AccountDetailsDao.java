package com.smclaughlin.tps.dao;

import com.smclaughlin.tps.entities.AccountDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;

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

    @Override
    public AccountDetails createNewAccountDetails(AccountDetails ad) {
        String insertQuery = "INSERT INTO Account_Details (account_name, account_website, " +
                "username, password_salt, password_hash) VALUES(?, ?, ?, ?, ?)";

        GeneratedKeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement statement = con.prepareStatement( insertQuery , Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, ad.getAccountName());
            statement.setString(2, ad.getAccountWebsite());
            statement.setString(3, ad.getUsername());
            statement.setString(4, ad.getPasswordSalt());
            statement.setString(5, ad.getPasswordHash());
            return statement;
        }, holder);

        ad.setId(holder.getKey().longValue());
        return ad;
    }

    @Override
    public AccountDetails saveAccountDetails(AccountDetails ad) {
        String updateQuery = "UPDATE Account_Details set account_name=?, account_website=?, " +
                "username=?, password_salt=?, password_hash=? WHERE id=?";

        jdbcTemplate.update(updateQuery, ad.getAccountName(),ad.getAccountWebsite(),
                ad.getUsername(), ad.getPasswordSalt(), ad.getPasswordHash(), ad.getId());
        return ad;

    }
}
