package com.trip.web;

import com.google.common.collect.Lists;
import com.trip.base.RestResponse;
import com.trip.model.SysResource;
import com.trip.service.ResourceService;
import com.trip.service.UserService;
import com.trip.utils.StringUtil;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/", "index"})
    public String index() {
        return "index";
    }

    @RequestMapping(value = "menus.json")
    @ResponseBody
    public RestResponse<List<SysResource>> showMenus() {

        RestResponse<List<SysResource>> response = new RestResponse<List<SysResource>>(false);

        String username = (String) SecurityUtils.getSubject().getPrincipal();
        if(StringUtil.isNotBlank(username)){
            Set<String> permissions = userService.findPermissions(username);
            List<SysResource> menus = resourceService.findMenus(permissions);
            response.setPayload(menus);
        }

        return response;
    }

    @RequestMapping("hello")
    public String hello(Map<String, Object> model){

        List<String> l= Lists.newArrayList();
        l.add("哈喽，hadoop");
        l.add("哈喽，hbase");
        l.add("哈喽，hive");
        l.add("哈喽，pig");
        l.add("哈喽，zookeeper");
        l.add("哈喽，biezhi");
        //将数据存放map里面，可以直接在velocity页面，使用key访问
        model.put("data",l);

        return "hello";
    }

    @RequestMapping("zeroException")
    public int zeroException(){
        return 10/0;
    }
}
