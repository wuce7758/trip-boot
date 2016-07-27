package com.trip.web;

import com.google.common.collect.Lists;
import com.trip.model.SysResource;
import com.trip.model.SysUser;
import com.trip.service.ResourceService;
import com.trip.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index(SysUser loginUser, Model model) {
        Set<String> permissions = userService.findPermissions(loginUser.getUsername());
        List<SysResource> menus = resourceService.findMenus(permissions);
        model.addAttribute("menus", menus);
        return "index";
    }

    @RequestMapping("/welcome")
    public String welcome() {
        return "welcome";
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


    /**
     * 登录后页面
     *
     * @return
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String indexPage(){
        return "index";
    }


    @RequestMapping("zeroException")
    public int zeroException(){
        return 10/0;
    }
}
