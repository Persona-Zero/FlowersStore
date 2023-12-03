package com.cl.flowersStore.service;

import com.cl.flowersStore.entity.Flower;

import java.util.List;

/**
 * datetime:2023/11/28 18:43
 **/
public interface FlowersService {

    int add(Flower flower);
    int delete(int id);
    int update(Flower flower);
    List<Flower> find(String searchKey,String searchType);
    List<Flower> findAll(String searchKey);
    int updateImg(String img_guid,Integer id);
}
