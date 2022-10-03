package com.vvvital.repository.user;

import com.vvvital.model.User;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface UserRepository {
    void update(User user
    ) throws SQLException;
    User getId(Integer id);
    List<User> getAll();
    void delete(Integer id);
    User getEmail(String email);
}
