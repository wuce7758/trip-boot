package com.trip.common.collection;

/**
 * Queue过滤接口
 *
 * @param <T>
 */
public interface QueueFilter<T> {

    boolean filter(T t);

}