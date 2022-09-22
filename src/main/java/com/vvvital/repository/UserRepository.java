package com.vvvital.repository;

import com.vvvital.model.User;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface UserRepository {
    public void save(User user
    ) throws SQLException;
    public User getId(Integer id);
    public List<User> getAll();
    public void delete(Integer id);
}
