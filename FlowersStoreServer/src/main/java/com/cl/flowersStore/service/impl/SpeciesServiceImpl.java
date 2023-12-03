package com.cl.flowersStore.service.impl;

import com.cl.flowersStore.dao.SpeciesDao;
import com.cl.flowersStore.entity.Species;
import com.cl.flowersStore.service.SpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * datetime:2023/11/28 18:43
 **/
@Service
public class SpeciesServiceImpl implements SpeciesService {

    @Autowired
    SpeciesDao speciesDao;

    @Override
    public int add(Species species) {
        return speciesDao.add(species);
    }

    @Override
    public int delete(int uid) {
        return speciesDao.delete(uid);
    }

    @Override
    public int update(Species species) {
        return speciesDao.update(species);
    }

    @Override
    public List<Species> find(String searchKey) {
        return speciesDao.find(searchKey);
    }

    @Override
    public List<Species> findAll() {
        return speciesDao.findAll();
    }
}
