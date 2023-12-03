package com.cl.flowersStore.service;

import com.cl.flowersStore.entity.User;

import java.util.List;

/**
 * datetime:2023/11/28 18:43
 **/
public interface UserService {

    int add(User user);
    int delete(int uid);
    int update(User user);
    List<User> find(String searchKey);
    User queryInfo(String account);
}
