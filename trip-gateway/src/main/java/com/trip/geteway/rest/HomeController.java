package com.trip.geteway.rest;

import com.trip.base.RestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping
    public RestResponse<String> home() {
        RestResponse<String> restResponse = new RestResponse<>(true);
        restResponse.setPayload("it`s ok!");
        return restResponse;
    }

}