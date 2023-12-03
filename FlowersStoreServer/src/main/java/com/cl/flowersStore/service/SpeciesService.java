package com.cl.flowersStore.service;

import com.cl.flowersStore.entity.Species;

import java.util.List;

/**
 * datetime:2023/11/28 18:43
 **/
public interface SpeciesService {

    int add(Species species);
    int delete(int id);
    int update(Species species);
    List<Species> find(String searchKey);
    List<Species> findAll();
}
