package com.vvvital.web;

import com.vvvital.Service.UserService;
import com.vvvital.model.Role;
import com.vvvital.model.User;
import com.vvvital.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

@Controller
public class MainController {

    private final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String root(@RequestHeader(name = "cookie", required = false) String cookie, Model model) {
        logger.info("************** / ***************");
        if (cookie == null) return "start";
        Integer userId = userService.getIdByCookie(cookie);
        if (userId < 0) {
            return "start";
        } else {
            model.addAttribute("user", userRepository.getId(userId));
            return "registered";
        }
    }

    @GetMapping("/login")
    public String login(@RequestParam(name = "email") String email, @RequestParam(name = "password") String password,
                        @RequestHeader(name = "Cookie") String cookie, Model model) {
        logger.info("email {} password  {} Cookie {}", email, password, cookie);
        User user = userRepository.getEmail(email);
        if (user != null && checkKey(email, user.getPassword())) {
            model.addAttribute("user", user);
            userService.addCookies(cookie, user.getId());
            return "user";
        } else {
            model.addAttribute("massage", "Not valid email or password");
            return "start";
        }
    }


    @GetMapping("registration")
    public String registration(@RequestParam(name = "id", required = false) Integer id,Model model) {
        if (id==null) {
            return "registration";
        }else {
            model.addAttribute("user",userRepository.getId(id));
            return "registration";
        }
    }

    @PostMapping("/update")
    public String update(
            @RequestParam(name = "id", required = false)Integer id,
            @RequestParam(name = "lastname") String lastname,
            @RequestParam(name = "name") String name,
            @RequestParam(name = "age") String age,
            @RequestParam(name = "email") String email,
            @RequestParam(name = "password") String password,
            @RequestParam(name = "role",defaultValue = "USER") Role role,
            Model model
    ) throws SQLException {
        logger.info("\nId={}\n Lastname {}\n Name {}\n Age {}\n Email {}\n Password {}\n Role {}",
                id,lastname, name, age, email, password,role);
        User user = new User();
        user.setId(id);
        user.setLastName(lastname);
        user.setName(name);
        user.setAge(Integer.parseInt(age));
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(role);

        userRepository.update(user);
        model.addAttribute("user", userRepository.getEmail(user.getEmail()));
        return "user";
    }

    @GetMapping("/users")
    public String getAll(ModelMap model) {
        logger.info(" method getAll ");
        List<User> users = userRepository.getAll();
        logger.info(Arrays.toString(users.toArray()));
        model.addAttribute("users", users);
        return "admin";
    }

    @GetMapping("delete")
    public String delete(@RequestParam(name = "id")Integer id) {
        logger.info("delete {}",id);
        userRepository.delete(id);
        return "redirect:users";
    }

    protected boolean checkKey(String email, String password) {
        User user = userRepository.getEmail(email);
        return user != null && user.getPassword().equals(password);
    }

}
