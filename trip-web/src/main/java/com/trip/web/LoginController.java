package com.trip.web;

import org.apache.shiro.authc.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class LoginController {

    @RequestMapping(value = {"signin"}, method = RequestMethod.GET)
    public String signinPage() {
        return "signin";
    }

    /**
     * 登录页面
     *
     * @return
     */
    @RequestMapping(value = {"login", "toLogin"}, method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = {"/login", "toLogin"}, method = RequestMethod.POST)
    public String showLoginForm(HttpServletRequest request, Map<String, Object> map) {
        System.out.println("HomeController.login()");
        // 登录失败从request中获取shiro处理的异常信息。
        // shiroLoginFailure:就是shiro异常类的全类名.
        String exception = (String) request.getAttribute("shiroLoginFailure");

        System.out.println("exception=" + exception);
        String msg = "";
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                msg = "账号不存在";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                msg = "密码不正确";
            } else if (LockedAccountException.class.getName().equals(exception)) {
                msg = "账户已锁定";
            } else if (ExcessiveAttemptsException.class.getName().equals(exception)) {
                msg = "用户名或密码错误次数过多";
            } else if ("kaptchaValidateFailed".equals(exception)) {
                msg = "验证码错误";
            } else {
                msg = exception;
            }
        }
        map.put("error", msg);
        return "login";
    }

    /**
     * 未授权页面
     *
     * @return
     */
    @RequestMapping(value = "403", method = RequestMethod.GET)
    public String error403() {
        return "unauthorized";
    }

}
