package com.cl.flowersStore.service.impl;

import com.cl.flowersStore.dao.CartDao;
import com.cl.flowersStore.dao.UserDao;
import com.cl.flowersStore.entity.Cart;
import com.cl.flowersStore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * datetime:2023/11/28 18:43
 **/
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartDao cartdao;
    @Autowired
    UserDao userDao;

    @Override
    public int add(Cart cart) {
        int uid = userDao.queryIdByAccount(cart.getAccount());
        cart.setUid(uid);
        Cart cart1 = cartdao.checkIsAdded(cart);
        if (cart1==null){
            return cartdao.add(cart);
        }else {
            return cartdao.addAmount(cart);
        }
    }

    @Override
    public int delete(int uid) {
        return cartdao.delete(uid);
    }

    @Override
    public int update(Cart cart) {
        return cartdao.update(cart);
    }

    @Override
    public List<Cart> find(String searchKey,String account) {
        return cartdao.find(searchKey,account);
    }

    @Override
    public List<Cart> queryByAccount(String account) {
        Integer uid = userDao.queryIdByAccount(account);
        return cartdao.queryByUid(uid);
    }


}
