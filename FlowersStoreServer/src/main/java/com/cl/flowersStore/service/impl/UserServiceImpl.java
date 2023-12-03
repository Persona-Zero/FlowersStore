package com.cl.flowersStore.service.impl;

import com.cl.flowersStore.dao.UserDao;
import com.cl.flowersStore.entity.User;
import com.cl.flowersStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * datetime:2023/11/28 18:43
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userdao;

    @Override
    public int add(User user) {
        try {
            return userdao.add(user);
        }catch (Exception e){
            return 0;
        }
    }

    @Override
    public int delete(int uid) {
        return userdao.delete(uid);
    }

    @Override
    public int update(User user) {
        return userdao.update(user);
    }

    @Override
    public List<User> find(String searchKey) {
        return userdao.find(searchKey);
    }

    @Override
    public User queryInfo(String account) {
        return userdao.queryInfo(account);
    }
}
