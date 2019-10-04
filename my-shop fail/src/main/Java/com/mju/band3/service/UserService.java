package com.mju.band3.service;

import com.mju.band3.entity.Staff;
import com.mju.band3.entity.User;
import com.mju.band3.utils.BaseResult;

import java.util.List;

public interface UserService {
    public User login(String email,String password);
    List<User> selectAll();

    BaseResult save(User user);

    List<User> search(String username);

    User findById(Integer id);


    void deleteById(Integer id);

    void deleteUsers(String[] split);


}
