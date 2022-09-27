package ecnc.schedulesystembackend.service;

import ecnc.schedulesystembackend.bean.User;
import ecnc.schedulesystembackend.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    @Override
    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }

    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public User getUserByName(String name) {
        return userDao.getUserByName(name);
    }

    @Override
    public String updatePassword(String name, String password, String newpsw) {
        User user = userDao.getUserByName(name);
        if (null != user) {
            if (user.getPassword().equals(password)) {
                userDao.updatePassword(name, newpsw);
                return "Success";
            } else {
                return "Defeated";
            }
        } else {
            return "fail";
        }
    }

    @Override
    public int deleteUser(Integer id) {
        return userDao.deleteUser(id);
    }
}
