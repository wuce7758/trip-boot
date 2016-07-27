package com.trip.common.collection;

/**
 * Set过滤接口
 *
 * @param <T>
 */
public interface SetFilter<T> {

    boolean filter(T t);

}