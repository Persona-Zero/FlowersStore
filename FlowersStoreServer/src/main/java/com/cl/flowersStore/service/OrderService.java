package com.cl.flowersStore.service;

import com.cl.flowersStore.entity.Cart;
import com.cl.flowersStore.entity.Order;

import java.util.List;

/**
 * datetime:2023/11/28 18:43
 **/
public interface OrderService {

    int add(Cart cart);

    int delete(int uid);

    int update(Order order);

    List<Order> find(String searchKey, String account);

    List<Order> findAll(String searchKey);

    List<Order> queryByAccount(String account);

}
