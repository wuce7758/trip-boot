package com.trip.service.impl;

import com.github.pagehelper.PageHelper;
import com.trip.exception.BusinessException;
import com.trip.mapper.CityMapper;
import com.trip.model.City;
import com.trip.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityMapper cityMapper;

    @Override
    public List<City> getAll(City city) {
        if (city.getPage() != null && city.getRows() != null) {
            PageHelper.startPage(city.getPage(), city.getRows(), "id");
        }
        return cityMapper.selectAll();
    }

    @Override
    public City getById(Integer id) {
        return cityMapper.selectByPrimaryKey(id);
    }

    @Transactional
    @Override
    public void deleteById(Integer id) throws BusinessException {
        try {
            cityMapper.deleteByPrimaryKey(id);
        } catch (Exception e) {
            throw new BusinessException(e);
        }
    }

    @Transactional
    @Override
    public void save(City country) throws BusinessException {
        try {
            if (country.getId() != null) {
                cityMapper.updateByPrimaryKey(country);
            } else {
                cityMapper.insert(country);
            }
        } catch (Exception e) {
            throw new BusinessException(e);
        }
    }

}