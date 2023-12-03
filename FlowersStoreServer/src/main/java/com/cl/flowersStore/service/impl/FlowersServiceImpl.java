package com.cl.flowersStore.service.impl;

import com.cl.flowersStore.dao.FlowersDao;
import com.cl.flowersStore.entity.Flower;
import com.cl.flowersStore.service.FlowersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * datetime:2023/11/28 18:43
 **/
@Service
public class FlowersServiceImpl implements FlowersService {

    @Autowired
    FlowersDao flowersDao;
    @Override
    public int add(Flower flower) {
        return flowersDao.add(flower);
    }

    @Override
    public int delete(int id) {
        return flowersDao.delete(id);
    }

    @Override
    public int update(Flower flower) {
        return flowersDao.update(flower);
    }

    @Override
    public List<Flower> find(String searchKey,String searchType) {
        return flowersDao.find(searchKey,searchType);
    }

    @Override
    public List<Flower> findAll(String searchKey) {
        return flowersDao.findAll(searchKey);
    }

    @Override
    public int updateImg(String img_guid,Integer id) {
        return flowersDao.updateImg(img_guid,id);
    }
}
