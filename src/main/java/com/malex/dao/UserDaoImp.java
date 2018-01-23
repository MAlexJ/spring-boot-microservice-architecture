package com.malex.dao;

import com.malex.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public List<User> list() {
//        @SuppressWarnings("unchecked")
//        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return new ArrayList<>();
    }
}
