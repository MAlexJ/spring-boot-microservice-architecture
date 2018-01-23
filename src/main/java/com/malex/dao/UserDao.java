package com.malex.dao;

import com.malex.model.User;

import java.util.List;

public interface UserDao
{
    void save(User user);

    List<User> list();
}
