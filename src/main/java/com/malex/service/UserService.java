package com.malex.service;

import com.malex.model.User;

import java.util.List;

public interface UserService {
    void save(User user);

    List<User> list();
}
