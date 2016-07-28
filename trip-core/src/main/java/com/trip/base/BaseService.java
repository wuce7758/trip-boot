package com.trip.base;

import tk.mybatis.mapper.entity.Example;

import java.util.List;

public interface BaseService<T> {

    T selectByPrimaryKey(Object key);

    T selectOne(T t);

    int save(T entity);

    T insert(T entity);

    int delete(Object key);

    int updateAll(T entity);

    int updateNotNull(T entity);

    List<T> selectList(Object example);

    List<T> selectList(Example example);

    List<T> selectAll();
}