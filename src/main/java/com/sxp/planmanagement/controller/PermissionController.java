package com.sxp.planmanagement.controller;

import com.sxp.planmanagement.entity.User;
import com.sxp.planmanagement.service.PermissionService;
import com.sxp.planmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author sxp
 * @create 2019-07-04 22:59
 **/
@Controller
public class PermissionController {

    @Autowired
    PermissionService permissionService;
    @Autowired
    UserService userService;

    @RequestMapping("/tologin")
    public String login(String userName, String password, HttpSession session){
        boolean success = permissionService.login(userName, password, session);
        if(!success){
            return "redirect:/login";
        }
        System.out.println(userName+" 登录成功");
        return "redirect:/";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.setAttribute("userName",null);
        session.invalidate();
        return "login";
    }

    @RequestMapping("/toRegister")
    public String register(User user){
        userService.saveUser(user);
        return "redirect:/login";
    }
}
