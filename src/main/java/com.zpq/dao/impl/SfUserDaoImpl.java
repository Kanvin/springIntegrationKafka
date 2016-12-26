package com.zpq.dao.impl;

import com.zpq.dao.UserDao;
import com.zpq.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;


public class SfUserDaoImpl implements UserDao {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void addUser(User user) {
        String sql = "INSERT INTO user (name, password)"
                + " VALUES (?, ?)";
        jdbcTemplate.update(sql, user.getName(), user.getPassword());
    }
}
