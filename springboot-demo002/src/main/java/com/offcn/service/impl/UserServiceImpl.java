package com.offcn.service.impl;

import com.offcn.dao.UserDao;
import com.offcn.po.User;
import com.offcn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public void add(User user) {
        userDao.save(user);
    }

    @Override
    public User findOne(Long id) {
        return userDao.getOne(id);
    }

    @Override
    public void update(User user) {
        userDao.saveAndFlush(user);
    }

    @Override
    public void delete(Long id) {
        userDao.deleteById(id);
    }
}
