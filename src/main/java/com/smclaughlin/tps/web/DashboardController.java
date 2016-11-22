package com.smclaughlin.tps.web;

import com.smclaughlin.tps.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sineadmclaughlin on 20/11/2016.
 */
@Controller
public class DashboardController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private static String DASHBOARD = "home/dashboard";

    @RequestMapping("/home")
    public String getDashboard(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return DASHBOARD;
    }


    @RequestMapping("/testdb")
    public String testDbConnection(Model model) {


        System.out.println("Creating tables");

        jdbcTemplate.execute("DROP TABLE IF EXISTS user");
        jdbcTemplate.execute("CREATE TABLE user(" +
                "id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");

        // Split up the array of whole names into an array of first/last names
        List<Object[]> splitUpNames = Arrays.asList("John Woo", "Jeff Dean", "Josh Bloch", "Josh Long").stream()
                .map(name -> name.split(" "))
                .collect(Collectors.toList());

        // Use a Java 8 stream to print out each tuple of the list
        splitUpNames.forEach(name -> System.out.println(String.format("Inserting customer record for %s %s", name[0], name[1])));

        // Uses JdbcTemplate's batchUpdate operation to bulk load data
        jdbcTemplate.batchUpdate("INSERT INTO user(first_name, last_name) VALUES (?,?)", splitUpNames);

        System.out.println("Querying for customer records where first_name = 'Josh':");
        jdbcTemplate.query(
                "SELECT id, first_name, last_name FROM user WHERE first_name = ?", new Object[] { "Josh" },
                (rs, rowNum) -> new User(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"))
        ).forEach(customer -> System.out.println(customer.getFirst_name()));

        return DASHBOARD;
    }



}
