package com.cl.flowersStore.controller;

import com.cl.flowersStore.config.Constant;
import com.cl.flowersStore.config.HttpMsg;
import com.cl.flowersStore.dao.FlowersDao;
import com.cl.flowersStore.dao.OrderDao;
import com.cl.flowersStore.dao.UserDao;
import com.cl.flowersStore.entity.Order;
import com.cl.flowersStore.entity.OrderVo;
import com.cl.flowersStore.entity.R;
import com.cl.flowersStore.entity.User;
import com.cl.flowersStore.service.OrderService;
import com.cl.flowersStore.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.util.StringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户
 **/
@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    UserDao userDao;
    @Autowired
    OrderDao orderDao;
    @Autowired
    FlowersDao flowersDao;

    @RequestMapping("/test")
    R test() {
        R r = new R();
        return r.setCode(4000).setMsg(Constant.IMG_PATH).setData(orderDao.findAll(null));
    }

    @RequestMapping("/queryByAccount")
    R queryByAccount(@RequestParam("account") String account) {
        R r = new R();
        if (StringUtil.isEmpty(account)) {
            return r.setCode(4000).setMsg(HttpMsg.INVALID_PARAM);
        }
        List<Order> orders = orderService.queryByAccount(account);
        return r.setCode(2000).setData(orders);
    }

    @RequestMapping("/find")
    R find(@RequestParam("page") int page, @RequestParam("searchKey") String searchKey, @RequestParam("account") String account) {
        R r = new R();
        Map<String, Object> map = new HashMap<>();
        List<Order> orders = orderService.find(searchKey, account);
        if (orders == null) {
            return r.setCode(2000);
        }
        map.put("items", orders);
        map.put("len", orders.size());
        return r.setCode(2000).setData(map);
    }

    @RequestMapping("/findAll")
    R findAll(@RequestParam("page") int page, @RequestParam("searchKey") String searchKey) {
        R r = new R();
        Map<String, Object> map = new HashMap<>();
        List<Order> orders = orderService.findAll(searchKey);
        if (orders == null) {
            return r.setCode(2000);
        }
        List<Order> items = orders.size() >= page * Constant.PAGE_SIZE ?
                orders.subList((page - 1) * Constant.PAGE_SIZE, page * Constant.PAGE_SIZE)
                : orders.subList((page - 1) * Constant.PAGE_SIZE, orders.size());
        int len = orders.size() % Constant.PAGE_SIZE == 0 ? orders.size() / Constant.PAGE_SIZE
                : (orders.size() / Constant.PAGE_SIZE + 1);
        List<OrderVo> vos = new ArrayList<>();
        for (Order item : items) {
            User user = userDao.queryById(item.getUid());
            OrderVo vo = new OrderVo();
            vo.setAddress(user.getAddress()).setPhone(user.getPhone()).setUsername(user.getName())
                    .setAmount(item.getAmount()).setFlower(item.getFlower()).setId(item.getId())
                    .setUid(item.getUid()).setOrder_guid(item.getOrder_guid()).setPrice(item.getPrice())
                    .setState(item.getState());
            vos.add(vo);
        }
        map.put("items", vos);
        map.put("len", len);
        return r.setCode(2000).setData(map);
    }

    @RequestMapping("/update")
    R update(@RequestBody Order order) {
        R r = new R();
        int ans = orderService.update(order);
        if (ans >= 0) {
            return r.setCode(2000).setMsg(HttpMsg.UPDATE_USER_OK);
        }
        return r.setCode(4000).setMsg(HttpMsg.UPDATE_USER_FAILED);
    }

    @RequestMapping("/changeState")
    R changeState(@RequestBody Order order) {
        orderDao.changeState(order);
        return new R().setCode(2000).setMsg(HttpMsg.UPDATE_ORDER_OK);
    }

    @DeleteMapping("/delete")
    R delete(@RequestParam("id") int id) {
        R r = new R();
        int ans = orderService.delete(id);
        if (ans == 1) {
            return r.setCode(2000).setMsg(HttpMsg.DELETE_USER_OK);
        }
        return r.setCode(4000).setMsg(HttpMsg.DELETE_USER_FAILED);
    }
}

