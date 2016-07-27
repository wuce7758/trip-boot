package com.trip.component.aop;

import com.trip.component.datasource.DataSourceType;
import com.trip.component.datasource.DatabaseContextHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DataSourceAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataSourceAspect.class);

    /**
     * 对带有事务注解的方法开启writer数据源
     *
     * @param point
     */
    @Before("execution(* com.trip.mapper.*.*(..))")
    public void setDataSourceKey(JoinPoint point){

        String methodName = point.getSignature().getName();

        LOGGER.info("设置数据源 >>>>> :_)");

        if(methodName.startsWith("select")){
            DatabaseContextHolder.setDatabaseType(DataSourceType.slave);
        } else {
            DatabaseContextHolder.setDatabaseType(DataSourceType.master);
        }

    }

}