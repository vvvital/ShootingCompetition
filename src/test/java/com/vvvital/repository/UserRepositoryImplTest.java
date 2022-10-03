package com.vvvital.repository;

import com.vvvital.model.Role;
import com.vvvital.model.User;
import com.vvvital.repository.user.UserRepositoryImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@ContextConfiguration({
        "classpath:springConfig.xml"
})
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/initDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class UserRepositoryImplTest {

    Logger logger = LoggerFactory.getLogger("UserRepositoryImplTest.class");

    @Autowired
    private UserRepositoryImpl userRepository;

    @Test
    public void save() {
        List<User> users = userRepository.getAll();
        logger.info("expectedList until save" + Arrays.toString(users.toArray()));
        int lastId = 1000;
        for (User u : users
        ) {
            if (u.getId() > lastId) lastId = u.getId();
        }
        User userActual = new User("Ivan", "Ivanov", 20, "ioann@i.ua", "321", Role.ADMIN);
        userRepository.update(userActual);
        userActual.setId(lastId + 1);
        User userExpected = userRepository.getId(lastId + 1);
        logger.info("expectedList after save" + Arrays.toString(userRepository.getAll().toArray()));
        assertEquals(userExpected, userActual);
    }

    @Test
    public void getId() {
        User userExpected = new User(1000, "Vitaliy", "Kovalenko", 44, "vvvital@i.ua", "52159", Role.ADMIN);
        User userActual = userRepository.getId(1000);
        logger.info(userActual.toString());
        assertEquals(userExpected, userActual);
    }

    @Test
    public void getAll() {
        List<User> usersActual = userRepository.getAll();
        List<User> usersExpected = Arrays.asList(
                new User(1000, "Vitaliy", "Kovalenko", 44, "vvvital@i.ua", "52159", Role.ADMIN),
                new User(1001, "Sergey", "Kovalenko", 45, "serg@i.ua", "52159", Role.USER),
                new User(1002, "Alex", "Kovalenko", 46, "alex@i.ua", "52159", Role.USER));
        assertEquals(usersExpected, usersActual);
    }

    @Test
    public void delete() {
        List<User> usersExpected = userRepository.getAll();
        logger.info("from delete");
        logger.info("expectedList until delete\n" + Arrays.toString(usersExpected.toArray()));
        User userForDelete = usersExpected.get(0);
        userRepository.delete(userForDelete.getId());
        usersExpected.remove(0);
        logger.info("expectedList after delete\n" + Arrays.toString(usersExpected.toArray()));
        List<User> usersActual = userRepository.getAll();
        logger.info("actualList after delete\n" + Arrays.toString(usersExpected.toArray()));
        assertEquals(usersExpected, usersActual);
    }
}