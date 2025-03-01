package com.aoding.dev.mapper;

import com.aoding.dev.pojo.User;
import java.util.List;

public interface UserMapper {
    List<User> getAllUsers();
    User getUserById(int id);
    void insertUser(User user);
    void updateUser(User user);
    void deleteUser(int id);
}
