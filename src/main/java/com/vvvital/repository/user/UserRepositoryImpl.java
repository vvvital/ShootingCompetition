package com.vvvital.repository.user;

import com.vvvital.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private Logger logger= LoggerFactory.getLogger(UserRepositoryImpl.class);
    private final RowMapper<User> ROW_MAPPER;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepositoryImpl(DataSource dataSource, UserMapper userMapper) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.ROW_MAPPER = userMapper;
    }

    @Override
    public void update(User user) {
        if (user.getId()==null) {
            logger.info("create user {}",user.toString());
            jdbcTemplate.update("INSERT INTO users VALUES (nextval('user_sequence'),?,?,?,?,?,?)"
                    , user.getName(), user.getLastName(), user.getAge(), user.getEmail(), user.getPassword(), user.getRole().toString());
        }else {
            logger.info("update user {}", user.toString());
            jdbcTemplate.update("UPDATE users set name=?,lastname=?,age=?,email=?,password=?,role=? where userid=?",
                    user.getName(),user.getLastName(),user.getAge(),user.getEmail(),user.getPassword(),user.getRole().toString(),user.getId());
        }

    }

    @Override
    public User getId(Integer id) {
        return DataAccessUtils.singleResult(jdbcTemplate.query("select * from users where userid=?",ROW_MAPPER,id));
    }

    public User getEmail(String email){
        return DataAccessUtils.singleResult(jdbcTemplate.query("select * from users where email=?",ROW_MAPPER,email));
    }

    @Override
    public List<User> getAll() {
        return jdbcTemplate.query("select * from users order by lastname",ROW_MAPPER);
    }

    @Override
    public void delete(Integer id) {
        logger.info("delete {}",id);
        jdbcTemplate.update("delete from users where userid=?",id);
    }
}
