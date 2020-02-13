package com.offcn.service;

import com.offcn.po.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();
    public void add(User user);
    public User findOne(Long id);
    public void update(User user);
    public void delete(Long id);

}
