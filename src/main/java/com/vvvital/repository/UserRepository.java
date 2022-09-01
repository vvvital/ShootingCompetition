package com.vvvital.repository;

import com.vvvital.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserRepository {

    public void update(User user) throws SQLException;

    public User getId(Integer id);

    public List<User> getAll();

    public void delete(Integer id);
}
