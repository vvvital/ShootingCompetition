package com.vvvital.repository;

import com.vvvital.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Objects;

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
        return DataAccessUtils.singleResult(jdbcTemplate.query("select * from users where id=?",ROW_MAPPER,id));
    }

    @Override
    public List<User> getAll() {
        return jdbcTemplate.query("select * from users order by lastname",ROW_MAPPER);
    }

    @Override
    public void delete(Integer id) {
        jdbcTemplate.update("delete from users where id=?",id);
    }
}
