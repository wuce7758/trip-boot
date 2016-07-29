package com.trip.web;

import com.trip.model.SysUser;
import org.apache.shiro.authc.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @RequestMapping(value = {"signin"}, method = RequestMethod.GET)
    public String signinPage() {
        return "signin";
    }

    @RequestMapping(value = "signin", method = RequestMethod.POST)
    public String showLoginForm(SysUser sysUser, HttpServletRequest request, Model model) {

        String exception = (String) request.getAttribute("shiroLoginFailure");

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
        model.addAttribute("error", msg);
        model.addAttribute("username", sysUser.getUsername());
        return "signin";
    }

    @RequestMapping("session")
    @ResponseBody
    public ModelMap testSession(HttpSession session, ModelMap model) {
        model.addAttribute("session_id", session.getId());
        return model;
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
