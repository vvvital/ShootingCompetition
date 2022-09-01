package com.vvvital.web;

import com.vvvital.model.User;
import com.vvvital.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.SQLException;
import java.util.List;

@Controller
public class MainController {

    private final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private UserRepository repository;

    @GetMapping("/")
    public String root(){
        return "redirect:index";
    }


    public void update(User user) throws SQLException {
        repository.update(user);
    }

    public User getId(int id) {
        return repository.getId(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    @GetMapping("/")
    public List<User> getAll() {
        logger.info("method getAll");
        return null;
    }

}
