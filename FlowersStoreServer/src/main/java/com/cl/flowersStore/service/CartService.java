package com.cl.flowersStore.service;

import com.cl.flowersStore.entity.Cart;

import java.util.List;

/**
 * datetime:2023/11/28 18:43
 **/
public interface CartService {

    int add(Cart cart);
    int delete(int uid);
    int update(Cart cart);
    List<Cart> find(String searchKey,String account);
    List<Cart> queryByAccount(String account);
}
