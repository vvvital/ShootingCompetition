package com.vvvital.repository;

import com.vvvital.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@Component
public class UserRepositoryImpl implements UserRepository {

    private RowMapper<User> ROW_MAPPER;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepositoryImpl(DataSource dataSource,UserMapper userMapper) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.ROW_MAPPER = userMapper;
    }

    @Override
    public void save() throws SQLException {
        jdbcTemplate.update("insert into users VALUES ('1000','Vitaliy','Kovalenko','44','vvvital@i.ua','52159');",ROW_MAPPER);
    }

    @Override
    public User getId(Integer id) {
        return jdbcTemplate.query("select User u from users where u.id:=id", ROW_MAPPER).get(0);
    }

    @Override
    public List<User> getAll() {
        return jdbcTemplate.query("select * from users",ROW_MAPPER);
    }

    @Override
    public void delete(Integer id) {
        jdbcTemplate.update("delete User u from users where u.id:=id");
    }
}
