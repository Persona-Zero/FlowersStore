package com.cl.flowersStore.service.impl;

import com.cl.flowersStore.dao.OrderDao;
import com.cl.flowersStore.dao.UserDao;
import com.cl.flowersStore.entity.Cart;
import com.cl.flowersStore.entity.Order;
import com.cl.flowersStore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * datetime:2023/11/28 18:43
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao orderdao;
    @Autowired
    UserDao userDao;

    @Override
    public int add(Cart cart) {
        return orderdao.add(cart);
    }

    @Override
    public int delete(int uid) {
        return orderdao.delete(uid);
    }

    @Override
    public int update(Order order) {
        return orderdao.update(order);
    }

    @Override
    public List<Order> find(String searchKey,String account) {
        Integer uid = userDao.queryIdByAccount(account);
        return orderdao.find(searchKey,uid);
    }

    @Override
    public List<Order> findAll(String searchKey) {
        return orderdao.findAll(searchKey);
    }

    @Override
    public List<Order> queryByAccount(String account) {
        Integer uid = userDao.queryIdByAccount(account);
        return orderdao.queryByUid(uid);
    }


}
