package com.trip.service.test;

import com.alibaba.fastjson.JSON;
import com.trip.BaseTest;
import com.trip.service.CityService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by oushaku on 16/7/24.
 */
public class CityServiceTest extends BaseTest {

    @Autowired
    private CityService cityService;

    @Test
    public void testSelect(){
        System.out.println(JSON.toJSONString(cityService.getById(1)));
    }

}
