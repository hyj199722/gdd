package com.mju.band3.dao;

import com.mju.band3.entity.User;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    public User getUserByEmailAndPassword(String email, String password);

    List<User> selectAll();

    void insertUser(User user);

    void updateUser(User user);
}
