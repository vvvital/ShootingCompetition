package com.vvvital.web;

import com.vvvital.model.User;
import com.vvvital.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

@Controller
public class MainController {

    private final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String root() {
        logger.info("************** / ***************");
        return "index";
    }

    @GetMapping("/login")
    public String login(@RequestParam(name = "login") String login, @RequestParam(name = "password") String password) {
        logger.info("login {} password  {}", login, password);
        return "login";
    }


    @PostMapping("/reg")
    public String reg(@RequestParam(name = "lastname") String lastname,
                      @RequestParam(name = "name") String name,
                      @RequestParam(name = "age") String age,
                      @RequestParam(name = "email") String email,
                      @RequestParam(name = "password") String password
    ) throws SQLException {
        logger.info("Lastname {}\n Name {}\n Age {}\n Email {}\n Password {}\n",
                lastname, name, age, email, password);
        User user = new User();
        user.setLastName(lastname);
        user.setName(name);
        user.setAge(Integer.parseInt(age));
        user.setEmail(email);
        user.setPassword(password);

        userRepository.save(user);
        return "index";
    }

    @GetMapping("/users")
    public String getAll(ModelMap model){
        logger.info(" method getAll ");
        List<User>users=userRepository.getAll();
        logger.info(Arrays.toString(users.toArray()));
        model.addAttribute("users",users);
        return "users";
    }

}
