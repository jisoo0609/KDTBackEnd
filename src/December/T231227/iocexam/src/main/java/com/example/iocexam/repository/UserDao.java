package December.T231227.iocexam.src.main.java.com.example.iocexam.repository;

import com.example.iocexam.domain.User;

import java.util.List;

public interface UserDao {
    public User getUser(String email);
    public List<User> getUsers();
    public void addUser(User user);
}
