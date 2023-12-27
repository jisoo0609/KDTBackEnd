package December.T231227.iocexam.src.main.java.com.example.iocexam.repository;

import com.example.iocexam.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UserDaoImpl implements UserDao{
    @Override
    public User getUser(String email) {
        return null;
    }

    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public void addUser(User user) {
        System.out.println(user + "정보가 잘 저장되었습니다.");
    }
}
