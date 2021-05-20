package com.example.login_i18n.service;

import com.example.login_i18n.model.User;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService {
    private static List<User> userList= Arrays.asList(
            new User("sangle","123456"),
            new User("admin","123456"),
            new User("linda","123456")
    );

    public UserService() {
    }



    public List<User> getUserList() {
        return userList;
    }

    public static void setUserList(List<User> userList) {
        UserService.userList = userList;
    }
}
