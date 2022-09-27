package ecnc.schedulesystembackend.service;

import ecnc.schedulesystembackend.bean.User;

import java.util.List;


public interface UserService {
    List<User> getAllUser();
    User getUserById(Integer id);
    int addUser(User user);
    User getUserByName(String name);
    String updatePassword(String name, String password, String newpsw);
    int deleteUser(Integer id);
}
