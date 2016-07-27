package com.trip.common.collection;

/**
 * List过滤接口
 */
public interface ListFilter<T> {

    boolean filter(T t);

}