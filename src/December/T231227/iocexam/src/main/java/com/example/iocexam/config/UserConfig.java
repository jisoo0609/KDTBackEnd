package December.T231227.iocexam.src.main.java.com.example.iocexam.config;

import December.T231227.iocexam.src.main.java.com.example.iocexam.controller.UserController;
import December.T231227.iocexam.src.main.java.com.example.iocexam.repository.UserDao;
import December.T231227.iocexam.src.main.java.com.example.iocexam.repository.UserDaoCaramiImpl;
import December.T231227.iocexam.src.main.java.com.example.iocexam.repository.UserDaoImpl;
import December.T231227.iocexam.src.main.java.com.example.iocexam.service.UserService;
import December.T231227.iocexam.src.main.java.com.example.iocexam.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@Configuration
//@ComponentScan(basePackages = "com.example.iocexam")
public class UserConfig {
//    @Bean
//    public UserDao userDao(){
//        UserDao dao = new UserDaoCaramiImpl();
//
//        return dao;
//    }
//
//    @Bean
//    public UserService userService(UserDao userDao){
//        return new UserServiceImpl(userDao);
//    }
//
//    @Bean
//    public UserController userController(UserService userService){
//        return new UserController(userService);
//    }
}
