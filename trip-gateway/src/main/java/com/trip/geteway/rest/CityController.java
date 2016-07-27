package com.trip.geteway.rest;

import com.github.pagehelper.PageInfo;
import com.trip.base.RestError;
import com.trip.base.RestResponse;
import com.trip.exception.BusinessException;
import com.trip.model.City;
import com.trip.service.CityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("cities")
@Api(value = "cities", description = "城市信息api", produces= MediaType.APPLICATION_JSON_VALUE)
public class CityController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CityController.class);

    @Autowired
    private CityService cityService;

    @ApiOperation(value="获取城市列表", notes="")
    @RequestMapping(method = RequestMethod.GET)
    public RestResponse<PageInfo> getAll(City city) {
        List<City> countryList = cityService.getAll(city);
        PageInfo<City> pageInfo = new PageInfo<City>(countryList);
        return new RestResponse<PageInfo>(pageInfo);
    }

    @ApiOperation(value="查看城市详情", notes="")
    @RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
    public RestResponse<City> view(@PathVariable Integer id) {
        ModelAndView result = new ModelAndView();
        City city = cityService.getById(id);
        return new RestResponse<City>(city);
    }

    @ApiOperation(value="删除一个城市", notes="")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public RestResponse delete(@PathVariable Integer id) {
        cityService.deleteById(id);
        return new RestResponse(true);
    }

    @ApiOperation(value="新增一个城市", notes="")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public RestResponse<City> save(City city) {
        RestResponse<City> result = new RestResponse<City>();
        try {
            cityService.save(city);
            result.setPayload(city);
        } catch (BusinessException e) {
            LOGGER.error("保存城市失败", e);
            result.setError(RestError.me("保存城市失败"));
        }
        return result;
    }
}