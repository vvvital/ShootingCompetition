package com.vvvital;

import com.vvvital.model.User;
import com.vvvital.repository.UserRepositoryImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class Main {

    private static UserRepositoryImpl userRepository;

    public static void main(String[] args) throws SQLException {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("springConfig.xml");
        User bean= (User) context.getBean(User.class);
        userRepository=context.getBean(UserRepositoryImpl.class);
        /*bean.setName("Vitaliy");
        bean.setAge(44);
        bean.setLastName("Kovalenko");
        bean.setCategory(Categories.AMATEUR);
        bean.setEmail("vvvital@i.ua");
        bean.setPassword("52159");

         */

        User user = userRepository.getAll().get(0);
        System.out.println(user.toString());

        System.out.println(bean.toString());
        //UserRepository userRepository=context.getBean(UserRepositoryImpl.class);
        //userRepository.save();

    }
}
