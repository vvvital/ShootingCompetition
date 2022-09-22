package com.vvvital.repository;

import com.vvvital.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final RowMapper<User> ROW_MAPPER;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepositoryImpl(DataSource dataSource,UserMapper userMapper) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.ROW_MAPPER = userMapper;
    }

    @Override
    public void save(User user) {
        jdbcTemplate.update("INSERT INTO users VALUES (nextval('serial'),?,?,?,?,?)"
                , user.getName(), user.getLastName(), user.getAge(), user.getEmail(), user.getPassword());

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
