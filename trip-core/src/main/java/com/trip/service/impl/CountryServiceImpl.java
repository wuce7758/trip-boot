package com.trip.service.impl;

import com.github.pagehelper.PageHelper;
import com.trip.mapper.CountryMapper;
import com.trip.model.Country;
import com.trip.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryMapper countryMapper;

    @Override
    public List<Country> getAll(Country country) {
        if (country.getPage() != null && country.getRows() != null) {
            PageHelper.startPage(country.getPage(), country.getRows(), "id");
        }
        return countryMapper.selectAll();
    }

    @Override
    public Country getById(Integer id) {
        return countryMapper.selectByPrimaryKey(id);
    }

    @Transactional
    @Override
    public void deleteById(Integer id) {
        countryMapper.deleteByPrimaryKey(id);
    }

    @Transactional
    @Override
    public void save(Country country) {
        if (country.getId() != null) {
            countryMapper.updateByPrimaryKey(country);
        } else {
            countryMapper.insert(country);
        }
    }
}
