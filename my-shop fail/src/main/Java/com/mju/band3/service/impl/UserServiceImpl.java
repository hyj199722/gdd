package com.mju.band3.service.impl;

import com.mju.band3.dao.UserDao;
import com.mju.band3.entity.User;
import com.mju.band3.service.UserService;
import com.mju.band3.utils.BaseResult;
import com.mju.band3.utils.RegexpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public User login(String email, String password) {
        return userDao.getUserByEmailAndPassword(email,password);
    }

    @Override
    public List<User> selectAll() {
        return userDao.selectAll();
    }

    @Override
    public BaseResult save(User user) {
        BaseResult baseResult = checkUser(user);
        if (baseResult.getStatus()==BaseResult.STATUS_SUCCESS){
            if (user.getId()==null){
                userDao.insertUser(user);
            }
            if (user.getId()!=null){
                userDao.updateUser(user);
            }
            baseResult.setMessage("保存用户信息成功");
        }

        return baseResult;


    }


    public BaseResult checkUser(User user){
        BaseResult baseResult=BaseResult.success();
        if (StringUtils.isEmpty(user.getUsername())){
             baseResult = BaseResult.fail("姓名不能为空，请重新输入");
        }
        if (StringUtils.isEmpty(user.getPassword())){
            baseResult = BaseResult.fail("密码不能为空，请重新输入");
        }
        if (!RegexpUtils.checkEmail(user.getEmail())){

            baseResult = BaseResult.fail("邮箱格式不正确，请重新输入");
        }
        if (StringUtils.isEmpty(user.getEmail())){
            baseResult = BaseResult.fail("邮箱不能为空，请重新输入");
        }
        return baseResult;



    }

}
