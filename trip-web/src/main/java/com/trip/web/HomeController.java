package com.trip.web;

import com.google.common.collect.Lists;
import com.trip.common.SessionUtil;
import com.trip.model.SysResource;
import com.trip.service.ResourceService;
import com.trip.service.UserService;
import com.trip.utils.StringUtil;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

        String username = (String) SecurityUtils.getSubject().getPrincipal();
        if(StringUtil.isNotBlank(username)){
            Set<String> permissions = userService.findPermissions(username);
            List<SysResource> menus = resourceService.findMenus(permissions);
            SessionUtil.setMenu(menus);
        }

        return "index";
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
