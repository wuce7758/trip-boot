package com.trip.service;


import com.trip.exception.BusinessException;
import com.trip.model.City;

import java.util.List;

public interface CityService {

    List<City> getAll(City city);

    City getById(Integer id);

    void deleteById(Integer id) throws BusinessException;

    void save(City country) throws BusinessException;

}
