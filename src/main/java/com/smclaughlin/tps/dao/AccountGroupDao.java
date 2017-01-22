package com.smclaughlin.tps.dao;

import com.smclaughlin.tps.entities.AccountGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 * Created by sineadmclaughlin on 22/01/2017.
 */
@Repository
public class AccountGroupDao implements IAccountGroupDao {

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public AccountGroup getAccountGroupByUUID(String uuid) {
        String selectQuery = "SELECT * FROM Account_Group WHERE uuid = ?";
        AccountGroup accountGroup =
                jdbcTemplate.queryForObject(selectQuery, BeanPropertyRowMapper.newInstance(AccountGroup.class), uuid);

        return accountGroup;
    }

    @Override
    public AccountGroup createAccountGroup(AccountGroup accountGroup) {
        String insertQuery = "INSERT INTO Account_Group (uuid, group_name) VALUES(?, ?)";

        GeneratedKeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement statement = con.prepareStatement( insertQuery , Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, accountGroup.getUuid());
            statement.setString(2, accountGroup.getGroupName());
            return statement;
        }, holder);

        accountGroup.setId(holder.getKey().longValue());
        return accountGroup;
    }

    @Override
    public AccountGroup saveAccountGroup(AccountGroup accountGroup) {
        String updateQuery = "UPDATE Account_Group set group_name=? WHERE id=?";

        jdbcTemplate.update(updateQuery, accountGroup.getGroupName(), accountGroup.getId());

        return accountGroup;
    }
}
