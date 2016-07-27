package com.trip.common.collection;

/**
 * Map过滤接口
 * @param <T>
 */
public interface MapFilter<T> {

    boolean filter(T t);

}